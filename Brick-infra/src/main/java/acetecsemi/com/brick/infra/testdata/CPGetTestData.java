package acetecsemi.com.brick.infra.testdata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import acetecsemi.com.brick.facade.dto.CPGetTestDataDTO;
import acetecsemi.com.brick.facade.dto.FTGetTestDataDTO;

public class CPGetTestData {

	public static Map<String, String> map = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put("RUN", "");
			put("REWORK", "");
		}
	};

	public static String splitStr = "__";

	/**
	 * 将FTP服务器上文件下载到本地
	 *
	 */
	public void testDownFile() {
		try {
			boolean flag = FTPApche.downFile("192.168.1.83", 21, "ems", "123",
					"/testdata", "file.txt", "C:/");
			System.out.println(flag);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String filepath[] = { "1409-SMI-SH/5915J-40/XX/INFO/" };
		String localfilepath[] = { "C:\\client\\TestData\\" };
		System.out.println(System.currentTimeMillis());
		List<String> list = FTPApche.downFiles("192.168.1.221", 21, null, null,
				"/" + filepath[0], localfilepath[0] + filepath[0]);
		CPGetTestData.readTxtFile(list.toArray(localfilepath), null, null);
		System.out.println(System.currentTimeMillis());
	}

	/**
	 * 
	 * @param ip
	 * @param path
	 *            =1409-SMI-SH/5915C-01/E5J067.21/INFO CustomerNo\Device\Acetec
	 *            Lot\FileName.txt
	 * @return
	 */
	public static List<CPGetTestDataDTO> getCPTestData() {
		String localfilepath[] = { "C:\\client\\TestData\\" };
		String ip = "192.168.1.221";
		String path = "1409-SMI-SH/5915J-40/XX/INFO/";
		List<String> list = FTPApche.downFiles(ip, 21, null, null, "/" + path,
				localfilepath[0] + path);
		return CPGetTestData.readTxtFile(list.toArray(localfilepath), null,
				null);
	}

	public static List<CPGetTestDataDTO> getCPTestDataFTP(String ip,
			String customerNo, String device, String acetecLot, String program,
			String status) {
		String localfilepath[] = { "C:\\client\\TestData\\" };
		StringBuffer path = new StringBuffer(customerNo).append("/")
				.append(device).append("/");
		// 为了处理TDE生成的批次路径不对遍历产品目录获取到正确路径
		List<String> pathList = FTPApche.getFolderList(ip, 21, "admin",
				"admin123", path.toString());
		boolean sign = false;
		for (String ftpPath : pathList) {
			if (ftpPath.indexOf(acetecLot) > -1) {
				path.append(ftpPath).append("/INFO/");
				sign = true;
				break;
			}
		}
		if (!sign) {
			path.append(acetecLot).append("/").append("INFO").append("/");
		}
		List<String> list = FTPApche.downFiles(ip, 21, "admin", "admin123", "/"
				+ path, localfilepath[0] + path);
		String[] filterNames = { program };
		List<CPGetTestDataDTO> tdList = CPGetTestData.readTxtFile(
				list.toArray(localfilepath), filterNames, acetecLot);
		if (localfilepath[0] != null) {
			File file = new File(localfilepath[0]);
			FTPApche.deleteDir(file);
		}
		return tdList;
	}

	/**
	 * @description 功能：Java读取txt文件的内容 步骤： 1：先获得文件句柄
	 *              2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取 3：读取到输入流后，需要读取生成字节流
	 *              4：一行一行的输出。readline()。 备注：需要考虑的是异常情况
	 * @param fileNames
	 */
	public static List<CPGetTestDataDTO> readTxtFile(String[] fileNames,
			String[] filterNames, String acetecLot) {
		try {
			String encoding = "UTF-8";
			List<CPGetTestDataDTO> list = new ArrayList<CPGetTestDataDTO>();
			for (String fileName : fileNames) {
				if (fileName == null || "".equals(fileName)) {
					continue;
				}
				File file = new File(fileName);
				boolean isContinue = false;
				for (String filterName : filterNames) {
					if (filterName != null && !"".equals(filterName)
							&& file.getName().indexOf(filterName) < 0
							|| file.isDirectory()) {
						isContinue = true;
						break;
					}
				}
				if (isContinue) {
					continue;
				}
				if (file.isFile() && file.exists()) { // 判断文件是否存在
					InputStreamReader read = new InputStreamReader(
							new FileInputStream(file), encoding);// 考虑到编码格式
					BufferedReader bufferedReader = new BufferedReader(read);
					String lineTxt = null;
					while ((lineTxt = bufferedReader.readLine()) != null) {
						CPGetTestDataDTO cpGetTestDataDTO = new CPGetTestDataDTO();
						lineTxt = bufferedReader.readLine();
						if (lineTxt != null && !"".equals(lineTxt)) {
							String[] arr = lineTxt.split(" ");
							String[] paths = fileName.split("/");
							String[] items = paths[paths.length - 1]
									.split(splitStr);
							cpGetTestDataDTO.setWaferId(items[1]);
							cpGetTestDataDTO.setTested(arr[0]);
							cpGetTestDataDTO.setTouchDown(arr[1]);
							cpGetTestDataDTO
									.setFileName(paths[paths.length - 1]);
							cpGetTestDataDTO
									.setCreateDate(items[items.length - 2]);
							list.add(cpGetTestDataDTO);
							System.out.println(lineTxt);
						}
						System.out.println(cpGetTestDataDTO);
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
}
