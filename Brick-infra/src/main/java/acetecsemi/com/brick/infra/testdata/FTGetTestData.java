package acetecsemi.com.brick.infra.testdata;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import acetecsemi.com.brick.facade.dto.CPGetTestDataDTO;
import acetecsemi.com.brick.facade.dto.FTGetTestDataDTO;
import acetecsemi.com.brick.infra.impl.MaintenanceEquipmentSendNoticeImpl;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;

public class FTGetTestData {

	private static Logger LOGGER = Logger.getLogger(FTGetTestData.class);
	private static String VC = "VC";
	private static String HS8684 = "HS8684";
	private static String HS8692 = "HS8692";

	/**
	 * 将FTP服务器上文件下载到本地
	 *
	 */
	public void testDownFile() {
		try {
			boolean flag = FTPApche.downFile("127.0.0.1", 21, "koala", "123",
					"/testdata", "file.txt", "T:/");
			System.out.println(flag);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Map<String, String> map = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put("RUN", "-P");
			put("R/T_RUN", "-R,-Q");
			put("M/F_RUN", "-P");
			put("LAT_RUN", "LAT");
			put("REWORK", "");
		}
	};

	public static Map<String, String> lotMap = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put("RUN", "");
			put("R/T_RUN", "");
			put("LAT_RUN", "LAT");
			put("REWORK", ",LAT");
		}
	};

	public static Map<String, String> customerNoMap = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put("VC", "1201-VCP-BJ");
			put("HS8684", "1303-HUN-BJ");
			put("HS8692", "1303-HUN-BJ");
		}
	};

	public static void main(String[] args) {
		try {
			// 、、\\192.168.1.83\TestData\1415-FJT-NT\120730_12\ZFJ120730_12523C14
			System.out.println(System.currentTimeMillis());
			FTGetTestData.getFTTestDataSharing("192.168.1.83", "1415-FJT-NT",
					"120730_12", "ZFJ120730_12527C12", "RUN");
			System.out.println(System.currentTimeMillis());
			FTGetTestData.getFTTestDataFTP("192.168.1.83", "1415-FJT-NT",
					"120730_12", "ZFJ120730_12527C12", "RUN");
			System.out.println(System.currentTimeMillis());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param ip
	 * @param path
	 *            =1409-SMI-SH/5915C-01/E5J067.21/INFO
	 *            CustomerNo\Device\AcetecLot\FileName.txt
	 * @return
	 * @throws IOException
	 */
	public static List<FTGetTestDataDTO> getFTTestDataSharing(String ip,
			String customerNo, String device, String acetecLot, String status)
			throws IOException {
		if (map.get(status) == null) {
			return null;
		}
		// String localfilepath[] = { "T:\\client\\TestData\\" };
		// List<String> list = FTPApche.downFiles("127.0.0.1", 21, "koala",
		// "123",
		// "/testdata/" + path, localfilepath[0] + path);
		StringBuffer path = new StringBuffer(customerNo).append("/")
				.append(device).append("/").append(acetecLot).append("/")
				.append("INFO").append("/");
		String remotePhotoUrl = "smb://EMS:123@" + ip + "/TestData/"
				+ path.toString();
		SmbFile remoteFile = new SmbFile(remotePhotoUrl);
		remoteFile.connect(); // 尝试连接
		if (remoteFile.isDirectory()) {
			return FTGetTestData.readSharingFile(remoteFile, map.get(status));
		}
		return null;
	}

	public static List<FTGetTestDataDTO> readSharingFile(SmbFile remoteFile,
			String filterName) {
		try {
			List<FTGetTestDataDTO> list = new ArrayList<FTGetTestDataDTO>();
			for (SmbFile file : remoteFile.listFiles()) {
				if (filterName != null && !"".equals(filterName)
						&& file.getName().indexOf(filterName) < 0
						|| file.isDirectory()) {
					continue;
				}
				remoteFile.connect(); // 尝试连接
				if (file.isFile() && file.exists()) { // 判断文件是否存在
					// InputStreamReader read = new InputStreamReader(
					// new FileInputStream(file), encoding);// 考虑到编码格式
					// 创建文件流
					InputStream in = new BufferedInputStream(
							new SmbFileInputStream(file));
					InputStreamReader read = new InputStreamReader(in);
					BufferedReader bufferedReader = new BufferedReader(read);
					String lineTxt = null;
					while ((lineTxt = bufferedReader.readLine()) != null) {
						FTGetTestDataDTO ftGetTestDataDTO = new FTGetTestDataDTO();
						lineTxt = bufferedReader.readLine();
						if (lineTxt != null && !"".equals(lineTxt)) {
							String[] arr = lineTxt.split(" ");
							ftGetTestDataDTO.setTested(arr[0]);
							ftGetTestDataDTO.setSite1(arr[1]);
							ftGetTestDataDTO.setSite1(arr[2]);
							ftGetTestDataDTO.setSite2(arr[3]);
							ftGetTestDataDTO.setSite3(arr[4]);
							System.out.println(ftGetTestDataDTO.getTested());
							System.out.println(lineTxt);
							System.out.println(ftGetTestDataDTO);
							list.add(ftGetTestDataDTO);
						}
					}
					read.close();
				} else {
					System.out.println("找不到指定的文件");
				}
			}
			return list;
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * @param ip
	 * @param path
	 *            =1409-SMI-SH/5915C-01/E5J067.21/INFO CustomerNo\Device\Acetec
	 *            Lot\FileName.txt
	 * @return
	 */
	public static List<FTGetTestDataDTO> getFTTestDataFTP(String ip,
			String customerNo, String device, String acetecLot, String status) {
		String localfilepath[] = { "C:\\client\\TestData\\" };
		List<FTGetTestDataDTO> tdList = new ArrayList<FTGetTestDataDTO>();
		for (String pathChildren : lotMap.get(status).split(",", -1)) {
			StringBuffer path = new StringBuffer(getCustomerNoVC(device,
					customerNo)).append("/").append(device).append("/")
					.append(acetecLot.trim()).append(pathChildren).append("/")
					.append("INFO").append("/");
			LOGGER.info(path.toString());
			List<String> list = FTPApche.downFiles(ip, 21, null, null, "/"
					+ path, localfilepath[0] + path);
			tdList.addAll(FTGetTestData.readTxtFile(
					list.toArray(localfilepath), acetecLot, map.get(status)));
			File file = new File(localfilepath[0]
					+ getCustomerNoVC(device, customerNo));
			FTPApche.deleteDir(file);
		}
		return tdList;
	}

	public static String getCustomerNoVC(String device, String customerNo) {
		if (device != null && device.startsWith(VC)) {
			return customerNoMap.get(VC);
		}
		if (device != null && device.startsWith(HS8684)) {
			return customerNoMap.get(HS8684);
		}
		if (device != null && device.startsWith(HS8692)) {
			return customerNoMap.get(HS8692);
		}
		return customerNo;
	}

	public static boolean check(File file, String acetecLot, String filterNames) {
		if (filterNames == null || "".equals(filterNames)) {
			return false;
		}
		for (String filterName : filterNames.split(",", -1)) {
			if (file.getName().indexOf(acetecLot.concat(filterName)) > -1
					&& !file.isDirectory()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @description 功能：Java读取txt文件的内容 步骤： 1：先获得文件句柄
	 *              2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取 3：读取到输入流后，需要读取生成字节流
	 *              4：一行一行的输出。readline()。 备注：需要考虑的是异常情况
	 * @param fileNames
	 */
	public static List<FTGetTestDataDTO> readTxtFile(String[] fileNames,
			String acetecLot, String filterName) {
		try {
			String encoding = "UTF-8";
			List<FTGetTestDataDTO> list = new ArrayList<FTGetTestDataDTO>();
			for (String fileName : fileNames) {
				if (fileName == null) {
					return list;
				}
				File file = new File(fileName);
				if (check(file, acetecLot, filterName)) {
					continue;
				}
				if (file.isFile() && file.exists()) { // 判断文件是否存在
					InputStreamReader read = new InputStreamReader(
							new FileInputStream(file), encoding);// 考虑到编码格式
					BufferedReader bufferedReader = new BufferedReader(read);
					String lineTxt = null;
					while ((lineTxt = bufferedReader.readLine()) != null) {
						FTGetTestDataDTO ftGetTestDataDTO = new FTGetTestDataDTO();
						lineTxt = bufferedReader.readLine();
						if (lineTxt != null && !"".equals(lineTxt)) {
							String[] arr = lineTxt.split(" ");
							ftGetTestDataDTO.setTested(arr[0]);
							ftGetTestDataDTO.setSite0(arr[1]);
							ftGetTestDataDTO.setSite1("0");
							ftGetTestDataDTO.setSite2("0");
							ftGetTestDataDTO.setSite3("0");
							for(int i = 1 ; i < arr.length ; i ++ ){
								switch (i) {
								case 2:
									ftGetTestDataDTO
									.setSite1(arr[2] ==null ||"".equals(arr[2]) ? "0"
											: arr[2]);
									break;
								case 3:
									ftGetTestDataDTO
									.setSite2(arr[3] ==null ||"".equals(arr[3]) ? "0"
											: arr[3]);
									break;
								case 4:
									ftGetTestDataDTO
									.setSite3(arr[4] ==null ||"".equals(arr[4]) ? "0"
											: arr[4]);
									break;
								default:
									break;
								} 
							}
							LOGGER.info(lineTxt);
							list.add(ftGetTestDataDTO);
						}
					}
					read.close();
				} else {
					LOGGER.info("找不到指定的文件");
				}
			}
			return list;
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
			return null;
		}
	}
}
