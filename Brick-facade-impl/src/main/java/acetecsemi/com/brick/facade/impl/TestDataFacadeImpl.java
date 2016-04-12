package acetecsemi.com.brick.facade.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.openkoala.koala.commons.InvokeResult;
import org.springframework.transaction.annotation.Transactional;

import acetecsemi.com.brick.facade.PlatformOptionLogFacade;
import acetecsemi.com.brick.facade.TestDataFacade;
import acetecsemi.com.brick.facade.WaferIdOrderFacade;
import acetecsemi.com.brick.facade.dto.CPGetTestDataDTO;
import acetecsemi.com.brick.facade.dto.FTGetTestDataDTO;
import acetecsemi.com.brick.facade.dto.PlatformDTO;
import acetecsemi.com.brick.facade.dto.PlatformOptionLogDTO;
import acetecsemi.com.brick.facade.dto.WaferIdOrderDTO;
import acetecsemi.com.brick.infra.MesTimeClient;
import acetecsemi.com.brick.infra.impl.MaintenanceEquipmentSendNoticeImpl;
import acetecsemi.com.brick.infra.testdata.CPGetTestData;
import acetecsemi.com.brick.infra.testdata.FTGetTestData;
import acetecsemi.com.brick.application.PlatformApplication;
import acetecsemi.com.brick.application.TestDataLogApplication;
import acetecsemi.com.brick.core.domain.*;

@Named
@Transactional
public class TestDataFacadeImpl implements TestDataFacade {

	private static Logger LOGGER = Logger.getLogger(TestDataFacadeImpl.class);
	@Inject
	private MesTimeClient mesTimeClient;

	@Inject
	private PlatformApplication platformApplication;

	@Inject
	private PlatformOptionLogFacade platformOptionLogFacade;

	@Inject
	private TestDataLogApplication testDataLogApplication;

	@Inject
	private WaferIdOrderFacade waferIdOrderFacade;

	public static String NO_TEST_LOT = "当前平台没有在测批次！";

	public static String NO_AUTO_DATA = "当前平台不能自动获取测试数据！";

	public static String NO_IP = "当前平台Tester系统中没有设置IP地址！";

	public static String FILE_READ_ERROR = "读取远程文件异常,请手动输入当前测试数！";

	public static String NO_TEST_STATUS = "状态没有产出！";

	public static String NO_TEST = "空跑进编带";

	public static String NO_TESTER = "此平台没有Tester！";

	public InvokeResult getFTTestData(PlatformDTO platformDTO) {
		LOGGER.info("platformDTO.getId()" + platformDTO.getId());
		Platform platform = platformApplication
				.getPlatform(platformDTO.getId());
		if (platform.getTester() == null) {
			this.saveTestDataLog(platform, platformDTO, NO_TESTER);
			return InvokeResult.failure(NO_TESTER);
		}
		if (platform.getTester().getIsAuto() != null
				&& !platform.getTester().getIsAuto()) {
			this.saveTestDataLog(platform, platformDTO, NO_AUTO_DATA);
			return InvokeResult.failure("NO_AUTO_DATA");
		}
		if (platform.getNowLot() == null || "".equals(platform.getNowLot())
				|| "NA".equals(platform.getNowLot())) {
			this.saveTestDataLog(platform, platformDTO, NO_TEST_LOT);
			return InvokeResult.failure(NO_TEST_LOT);
		}
		if (platform.getTester().getIp() == null
				|| "".equals(platform.getTester().getIp())) {
			this.saveTestDataLog(platform, platformDTO, NO_IP);
			return InvokeResult.failure(NO_IP);
		}
		if (FTGetTestData.map.get(platform.getStatus()) == null) {
			this.saveTestDataLog(platform, platformDTO, NO_TEST_STATUS);
			return InvokeResult.failure(platform.getStatus() + NO_TEST_STATUS);
		}
		if (platform.getSubSstatus() != null
				&& NO_TEST.equals(platform.getSubSstatus())) {
			this.saveTestDataLog(platform, platformDTO, NO_TEST_STATUS);
			return InvokeResult.failure(platform.getSubSstatus()
					+ NO_TEST_STATUS);
		}
		String acetecLot = platform.getNowLot();
		String info = mesTimeClient.getLotInfo(acetecLot, "FT");
		PlatformOptionLogDTO platformOptionLogDTO = platformOptionLogFacade
				.getLastPlatformOptionLog(platformDTO.getId());
		// "{\"productModel\":\"120730_12\",\"grossDie\":\"\",\"nowStation\":\"Shipping\",\"team\":\"白/D\",\"touchdown\":\"0\",\"standardWorkHours\":\"0\"}";
		String jsonString = info;
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		List<FTGetTestDataDTO> list = FTGetTestData.getFTTestDataFTP(platform
				.getTester().getIp(), jsonObject.getString("customerCode"),
				jsonObject.getString("productModel"), acetecLot, platform
						.getStatus());
		if (list == null || list.size() <= 0) {
			this.saveTestDataLog(platform, platformDTO, FILE_READ_ERROR);
			return InvokeResult.failure(FILE_READ_ERROR);
		}

		FTGetTestDataDTO result = new FTGetTestDataDTO();
		int tested = 0;
		int site0 = 0;
		int site1 = 0;
		int site2 = 0;
		int site3 = 0;
		for (FTGetTestDataDTO ftGetTestDataDTO : list) {
			TestDataLog testDataLog = new TestDataLog();
			testDataLog.setAcetecLot(acetecLot);
			testDataLog.setIp(platform.getTester().getIp());
			testDataLog.setProductModel(jsonObject.getString("productModel"));
			testDataLog.setEquipmentNo(platform.getTester().getEquipmentNo());
			testDataLog.setCustomerNo(jsonObject.getString("customerCode"));
			testDataLog.setCreateEmployNo(platformDTO.getLastModifyEmployNo());
			testDataLog.setLastModifyEmployNo(platformDTO
					.getLastModifyEmployNo());
			testDataLog.setRemark(platformOptionLogDTO.getPcNo().concat("|")
					.concat(ftGetTestDataDTO.getSite0()).concat(",")
					.concat(ftGetTestDataDTO.getSite1()).concat(",")
					.concat(ftGetTestDataDTO.getSite2()).concat(",")
					.concat(ftGetTestDataDTO.getSite3()));
			testDataLog.setStatus(platform.getStatus());
			tested += Integer.valueOf(ftGetTestDataDTO.getTested());
			site0 += Integer.valueOf(ftGetTestDataDTO.getSite0());
			site1 += Integer.valueOf(ftGetTestDataDTO.getSite1());
			site2 += Integer.valueOf(ftGetTestDataDTO.getSite2());
			site3 += Integer.valueOf(ftGetTestDataDTO.getSite3());
			testDataLogApplication.creatTestDataLog(testDataLog);
			// return InvokeResult.success(ftGetTestDataDTO);
		}
		result.setTested(String.valueOf(tested));
		result.setSite0(String.valueOf(site0));
		result.setSite1(String.valueOf(site1));
		result.setSite2(String.valueOf(site2));
		result.setSite3(String.valueOf(site3));
		return InvokeResult.success(result);

	}

	public InvokeResult getFTTestData(String ip, String customerNo,
			String device, String acetecLot, String status) {
		InvokeResult.success(FTGetTestData.getFTTestDataFTP(ip, customerNo,
				device, acetecLot, status));
		return InvokeResult.failure(FILE_READ_ERROR);
	}

	@Override
	public InvokeResult getCPTestData(PlatformDTO platformDTO) {
		Platform platform = platformApplication
				.getPlatform(platformDTO.getId());
		if (platform.getTester().getIsAuto() != null
				&& !platform.getTester().getIsAuto()) {
			this.saveTestDataLog(platform, platformDTO, NO_AUTO_DATA);
			return InvokeResult.failure("NO_AUTO_DATA");
		}
		if (platform.getNowLot() == null || "".equals(platform.getNowLot())
				|| "NA".equals(platform.getNowLot())) {
			TestDataLog testDataLog = new TestDataLog();
			testDataLog.setIp(platform.getTester().getIp());
			testDataLog.setEquipmentNo(platform.getTester().getEquipmentNo());
			testDataLog.setCreateEmployNo(platformDTO.getLastModifyEmployNo());
			testDataLog.setLastModifyEmployNo(platformDTO
					.getLastModifyEmployNo());
			testDataLog.setRemark(NO_TEST_LOT);
			testDataLogApplication.creatTestDataLog(testDataLog);
			return InvokeResult.failure(NO_TEST_LOT);
		}
		if (platform.getTester().getIp() == null
				|| "".equals(platform.getTester().getIp())) {
			this.saveTestDataLog(platform, platformDTO, NO_IP);
			return InvokeResult.failure(NO_IP);
		}
		if (CPGetTestData.map.get(platform.getStatus()) == null) {
			this.saveTestDataLog(platform, platformDTO, NO_TEST_STATUS);
			return InvokeResult.failure(platform.getStatus() + NO_TEST_STATUS);
		}
		String acetecLot = platform.getNowLot();
		String info = mesTimeClient.getLotInfo(acetecLot, "CP");
		PlatformOptionLogDTO platformOptionLogDTO = platformOptionLogFacade
				.getLastPlatformOptionLog(platformDTO.getId());
		// "{\"productModel\":\"120730_12\",\"grossDie\":\"\",\"nowStation\":\"Shipping\",\"team\":\"白/D\",\"touchdown\":\"0\",\"standardWorkHours\":\"0\"}";
		String jsonString = info;
		JSONObject jsonObject = JSONObject.fromObject(jsonString);

		List<CPGetTestDataDTO> list = CPGetTestData.getCPTestDataFTP(platform
				.getTester().getIp(), jsonObject.getString("customerCode"),
				jsonObject.getString("productModel"), acetecLot, jsonObject
						.getString("programName"), platform.getStatus());

		// List<CPGetTestDataDTO> list = CPGetTestData.getCPTestData();
		List<CPGetTestDataDTO> result = new ArrayList<CPGetTestDataDTO>();
		TestDataLog testDataLogWaferInfo = new TestDataLog();
		testDataLogWaferInfo.setAcetecLot(acetecLot);
		testDataLogWaferInfo.setIp(platform.getTester().getIp());
		testDataLogWaferInfo.setProductModel(jsonObject
				.getString("productModel"));
		testDataLogWaferInfo.setEquipmentNo(platform.getTester()
				.getEquipmentNo());
		testDataLogWaferInfo
				.setCustomerNo(jsonObject.getString("customerCode"));
		testDataLogWaferInfo.setCreateEmployNo(platformDTO
				.getLastModifyEmployNo());
		testDataLogWaferInfo.setLastModifyEmployNo(platformDTO
				.getLastModifyEmployNo());
		JSONArray jsonRemark = new JSONArray();
		for (CPGetTestDataDTO cpGetTestDataDTO : list) {
			int grossDie = "".equals(jsonObject.get("grossDie")) ? 0 : Integer
					.valueOf(jsonObject.get("grossDie").toString());
			int tested = "".equals(cpGetTestDataDTO.getTested()) ? 0 : Integer
					.valueOf(cpGetTestDataDTO.getTested());
			if (grossDie > tested) {
				cpGetTestDataDTO.setIsFinish(false);
			} else {
				cpGetTestDataDTO.setIsFinish(true);
			}
			JSONObject json = new JSONObject();
			json.put("pcNo", platformOptionLogDTO.getPcNo());
			json.put("waferId", cpGetTestDataDTO.getWaferId());
			json.put("tested", cpGetTestDataDTO.getTested());
			json.put("touchDown", cpGetTestDataDTO.getTouchDown());
			json.put("isFinish", cpGetTestDataDTO.getIsFinish());
			jsonRemark.add(json);
			if (platform.getStatus().equals("REWORK")) {
				result = this
						.checkMaxCreateDate(list, result, cpGetTestDataDTO);
			} else {
				result = this.checkMaxCreateDate(result, cpGetTestDataDTO);
			}
		}
		testDataLogWaferInfo.setRemark(jsonRemark.toString());
		testDataLogApplication.creatTestDataLog(testDataLogWaferInfo);
		if (result == null || result.size() <= 0) {
			TestDataLog testDataLog = new TestDataLog();
			testDataLog.setAcetecLot(acetecLot);
			testDataLog.setIp(platform.getTester().getIp());
			testDataLog.setProductModel(jsonObject.getString("productModel"));
			testDataLog.setEquipmentNo(platform.getTester().getEquipmentNo());
			testDataLog.setCustomerNo(jsonObject.getString("customerCode"));
			testDataLog.setCreateEmployNo(platformDTO.getLastModifyEmployNo());
			testDataLog.setLastModifyEmployNo(platformDTO
					.getLastModifyEmployNo());
			testDataLog.setRemark(FILE_READ_ERROR);
			testDataLogApplication.creatTestDataLog(testDataLog);
			return InvokeResult.failure(FILE_READ_ERROR);
		}
		return InvokeResult.success(this.getCPWaferIdOrder(result, acetecLot));
	}

	private List<CPGetTestDataDTO> checkMaxCreateDate(
			List<CPGetTestDataDTO> list, List<CPGetTestDataDTO> result,
			CPGetTestDataDTO nowCPGetTestDataDTO) {
		if (!this.checkMoreTwo(list, nowCPGetTestDataDTO)) {
			return result;
		}
		if (result.size() > 0) {
			for (int i = 0; i < result.size(); i++) {
				CPGetTestDataDTO cpGetTestDataDTO = result.get(i);
				if (cpGetTestDataDTO.getWaferId().equals(
						nowCPGetTestDataDTO.getWaferId())
						&& cpGetTestDataDTO.getCreateDate().compareTo(
								nowCPGetTestDataDTO.getCreateDate()) > 0) {
					// 不是最迟创建的
					return result;
				} else {
					// 是最迟创建的
					result.remove(i);
					result.add(nowCPGetTestDataDTO);
				}
			}
		} else {
			result.add(nowCPGetTestDataDTO);
		}
		return result;
	}

	private List<CPGetTestDataDTO> checkMaxCreateDate(
			List<CPGetTestDataDTO> result, CPGetTestDataDTO nowCPGetTestDataDTO) {
		if (result.size() > 0) {
			int size = result.size();
			for (int i = 0; i < size; i++) {
				CPGetTestDataDTO cpGetTestDataDTO = result.get(i);
				if (cpGetTestDataDTO.getWaferId().equals(
						nowCPGetTestDataDTO.getWaferId())) {
					int tested = cpGetTestDataDTO.getTested() == null ? 0
							: Integer.valueOf(cpGetTestDataDTO.getTested());
					int nowTested = nowCPGetTestDataDTO.getTested() == null ? 0
							: Integer.valueOf(nowCPGetTestDataDTO.getTested());
					int touchDown = cpGetTestDataDTO.getTouchDown() == null ? 0
							: Integer.valueOf(cpGetTestDataDTO.getTouchDown());
					int nowTouchDown = nowCPGetTestDataDTO.getTouchDown() == null ? 0
							: Integer.valueOf(nowCPGetTestDataDTO
									.getTouchDown());
					cpGetTestDataDTO.setTested(String.valueOf(tested
							+ nowTested));
					cpGetTestDataDTO.setTouchDown(String.valueOf(touchDown
							+ nowTouchDown));
					// 不是最迟创建的
					result.remove(i);
					result.add(nowCPGetTestDataDTO);
					return result;
				}
			}
			result.add(nowCPGetTestDataDTO);
		} else {
			result.add(nowCPGetTestDataDTO);
		}
		return result;
	}

	/**
	 * 是否有2个测试文件
	 * 
	 * @param list
	 * @param nowCPGetTestDataDTO
	 * @return
	 */
	private boolean checkMoreTwo(List<CPGetTestDataDTO> list,
			CPGetTestDataDTO nowCPGetTestDataDTO) {
		int i = 0;
		for (CPGetTestDataDTO cpGetTestDataDTO : list) {
			if (nowCPGetTestDataDTO.getWaferId().equals(
					cpGetTestDataDTO.getWaferId())) {
				i++;
			}
		}
		if (i > 1) {
			return true;
		} else {
			return false;
		}
	}

	private void saveTestDataLog(Platform platform, PlatformDTO platformDTO,
			String remark) {
		TestDataLog testDataLog = new TestDataLog();
		testDataLog.setIp(platform.getTester().getIp());
		testDataLog.setEquipmentNo(platform.getTester().getEquipmentNo());
		testDataLog.setCreateEmployNo(platformDTO.getLastModifyEmployNo());
		testDataLog.setLastModifyEmployNo(platformDTO.getLastModifyEmployNo());
		testDataLog.setAcetecLot(platform.getNowLot());
		testDataLog.setRemark(remark);
		testDataLog.setStatus(platform.getStatus());
		testDataLogApplication.creatTestDataLog(testDataLog);
	}

	/**
	 * 在结果集中增加wafer的片号
	 * 
	 * @param list
	 * @param nowCPGetTestDataDTO
	 * @return
	 */
	private List<CPGetTestDataDTO> getCPWaferIdOrder(
			List<CPGetTestDataDTO> result, String acetecLot) {
		List<CPGetTestDataDTO> orderList = new ArrayList<CPGetTestDataDTO>();
		WaferIdOrderDTO queryVo = new WaferIdOrderDTO();
		queryVo.setAcetecLot(acetecLot);
		// 通过acetecLot查询WaferId的顺序
		List<WaferIdOrderDTO> wio = waferIdOrderFacade
				.queryWaferIdOrder(queryVo);
		Map<String, Integer> lotWaferIdMap = waferIdOrderFacade
				.getWaferIdOrderMap(wio);
		int maxOrder = this.cpWaferIdOrderMax(lotWaferIdMap);
		for (CPGetTestDataDTO cpTD : result) {
			Integer order = lotWaferIdMap.get(cpTD.getWaferId());
			if (order == null) {
				maxOrder++;
				order = maxOrder;
				lotWaferIdMap.put(cpTD.getWaferId(), maxOrder);
				WaferIdOrderDTO waferIdOrderDTO = new WaferIdOrderDTO();
				waferIdOrderDTO.setAcetecLot(acetecLot);
				waferIdOrderDTO.setWaferIndex(order);
				waferIdOrderDTO.setWaferId(cpTD.getWaferId());
				waferIdOrderFacade.creatWaferIdOrder(waferIdOrderDTO);
			}
			cpTD.setWaferId(String.valueOf(order));
			cpTD.setOrder(order);
			orderList.add(cpTD);
		}
		return orderList;
	}

	private Integer cpWaferIdOrderMax(Map<String, Integer> lotWaferIdMap) {
		int maxOrder = 0;
		for (Integer order : lotWaferIdMap.values()) {
			if (order > maxOrder) {
				maxOrder = Integer.valueOf(order);
			}
		}
		return Integer.valueOf(maxOrder);
	}
}
