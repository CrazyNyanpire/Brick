package acetecsemi.com.brick.infra.testdata;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.net.ftp.*;

public class FTPApche {
	private static FTPClient ftpClient = new FTPClient();
	private static String encoding = System.getProperty("file.encoding");
	
	private static String USERNAME = "admin";
	
	private static String PASSWORD = "admin123";

	/**
	 * Description: 向FTP服务器上传文件
	 *
	 * @Version1.0
	 * @param url
	 *            FTP服务器hostname
	 * @param port
	 *            FTP服务器端口
	 * @param username
	 *            FTP登录账号
	 * @param password
	 *            FTP登录密码
	 * @param path
	 *            FTP服务器保存目录,如果是根目录则为“/”
	 * @param filename
	 *            上传到FTP服务器上的文件名
	 * @param input
	 *            本地文件输入流
	 * @return 成功返回true，否则返回false
	 */
	public static boolean uploadFile(String url, int port, String username,
			String password, String path, String filename, InputStream input) {
		boolean result = false;

		try {
			int reply;
			// 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			ftpClient.connect(url);
			// ftp.connect(url, port);// 连接FTP服务器
			// 登录
			if(username == null){
				username = USERNAME;
			}
			if(password == null){
				password = PASSWORD;
			}
			ftpClient.login(username, password);
			ftpClient.setControlEncoding(encoding);
			// 检验是否连接成功
			reply = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				System.out.println("连接失败");
				ftpClient.disconnect();
				return result;
			}

			// 转移工作目录至指定目录下
			boolean change = ftpClient.changeWorkingDirectory(path);
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			if (change) {
				result = ftpClient
						.storeFile(new String(filename.getBytes(encoding),
								"utf-8"), input);
				if (result) {
					System.out.println("上传成功!");
				}
			}
			input.close();
			ftpClient.logout();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return result;
	}

	/**
	 * Description: 从FTP服务器下载文件
	 *
	 * @Version1.0
	 * @param url
	 *            FTP服务器hostname
	 * @param port
	 *            FTP服务器端口
	 * @param username
	 *            FTP登录账号
	 * @param password
	 *            FTP登录密码
	 * @param remotePath
	 *            FTP服务器上的相对路径
	 * @param fileName
	 *            要下载的文件名
	 * @param localPath
	 *            下载后保存到本地的路径
	 * @return
	 */
	public static List<String> downFileList(String url, int port,
			String username, String password, String remotePath,
			String fileName, String localPath) {
		List<String> list = new ArrayList<String>();
		try {
			int reply;
			ftpClient.setControlEncoding(encoding);

			/*
			 * 为了上传和下载中文文件，有些地方建议使用以下两句代替 new
			 * String(remotePath.getBytes(encoding),"iso-8859-1")转码。 经过测试，通不过。
			 */
			// FTPClientConfig conf = new
			// FTPClientConfig(FTPClientConfig.SYST_NT);
			// conf.setServerLanguageCode("zh");

			ftpClient.connect(url, port);
			if(username == null){
				username = USERNAME;
			}
			if(password == null){
				password = PASSWORD;
			}
			// 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			ftpClient.login(username, password);// 登录
			// 设置文件传输类型为二进制
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			// 获取ftp登录应答代码
			reply = ftpClient.getReplyCode();
			// 验证是否登陆成功
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftpClient.disconnect();
				System.err.println("FTP server refused connection.");
				return list;
			}
			// 转移到FTP服务器目录至指定的目录下
			ftpClient.changeWorkingDirectory(new String(remotePath
					.getBytes(encoding), "utf-8"));
			// 获取文件列表
			FTPFile[] fs = ftpClient.listFiles();
			File file = new File(localPath);
			if (!file.exists() && !file.isDirectory()) {
				file.mkdirs();
			}
			for (FTPFile ff : fs) {
				if (fileName != null && ff.getName().equals(fileName)
						|| fileName == null && ff.isFile()) {
					File localFile = new File(localPath + "/" + ff.getName());
					OutputStream is = new FileOutputStream(localFile);
					ftpClient.retrieveFile(ff.getName(), is);
					is.close();
					list.add(localPath + "/" + ff.getName());
				}
			}
			ftpClient.logout();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return list;
	}

	public static boolean downFile(String url, int port, String username,
			String password, String remotePath, String fileName,
			String localPath) {
		return FTPApche.downFileList(url, port, username, password, remotePath,
				fileName, localPath).size() > 0 ? true : false;
	}
	
	
	public static List<String> getFolderList(String url, int port,
			String username, String password, String remotePath) {
		List<String> list = new ArrayList<String>();
		try {
			int reply;
			ftpClient.setControlEncoding(encoding);

			/*
			 * 为了上传和下载中文文件，有些地方建议使用以下两句代替 new
			 * String(remotePath.getBytes(encoding),"iso-8859-1")转码。 经过测试，通不过。
			 */
			// FTPClientConfig conf = new
			// FTPClientConfig(FTPClientConfig.SYST_NT);
			// conf.setServerLanguageCode("zh");

			ftpClient.connect(url, port);
			if(username == null){
				username = USERNAME;
			}
			if(password == null){
				password = PASSWORD;
			}
			// 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			ftpClient.login(username, password);// 登录
			// 设置文件传输类型为二进制
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			// 获取ftp登录应答代码
			reply = ftpClient.getReplyCode();
			// 验证是否登陆成功
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftpClient.disconnect();
				System.err.println("FTP server refused connection.");
				return list;
			}
			// 转移到FTP服务器目录至指定的目录下
			ftpClient.changeWorkingDirectory(new String(remotePath
					.getBytes(encoding), "utf-8"));
			// 获取文件列表
			FTPFile[] fs = ftpClient.listFiles();
			for (FTPFile ff : fs) {
				if ( ff.isDirectory()) {
					list.add(ff.getName());
				}
			}
			ftpClient.logout();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return list;
	}

	/**
	 * Description: 从FTP服务器下载文件
	 *
	 * @Version1.0
	 * @param url
	 *            FTP服务器hostname
	 * @param port
	 *            FTP服务器端口
	 * @param username
	 *            FTP登录账号
	 * @param password
	 *            FTP登录密码
	 * @param remotePath
	 *            FTP服务器上的相对路径
	 * @param localPath
	 *            下载后保存到本地的路径
	 * @return
	 */
	public static List<String> downFiles(String url, int port, String username,
			String password, String remotePath, String localPath) {
		return FTPApche.downFileList(url, port, username, password, remotePath,
				null, localPath);
	}
	
	

	/**
	 * Description: 从FTP服务器下载文件
	 *
	 * @Version1.0
	 * @param url
	 *            FTP服务器hostname
	 * @param port
	 *            FTP服务器端口
	 * @param username
	 *            FTP登录账号
	 * @param password
	 *            FTP登录密码
	 * @param remotePath
	 *            FTP服务器上的相对路径
	 * @param fileName
	 *            要下载的文件名
	 * @param localPath
	 *            下载后保存到本地的路径
	 * @return
	 */
	public static FTPFile[] downFileList(String url, int port, String username,
			String password, String remotePath) {
		try {
			int reply;
			ftpClient.setControlEncoding(encoding);

			/*
			 * 为了上传和下载中文文件，有些地方建议使用以下两句代替 new
			 * String(remotePath.getBytes(encoding),"iso-8859-1")转码。 经过测试，通不过。
			 */
			// FTPClientConfig conf = new
			// FTPClientConfig(FTPClientConfig.SYST_NT);
			// conf.setServerLanguageCode("zh");

			ftpClient.connect(url, port);
			// 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			ftpClient.login(username, password);// 登录
			// 设置文件传输类型为二进制
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			// 获取ftp登录应答代码
			reply = ftpClient.getReplyCode();
			// 验证是否登陆成功
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftpClient.disconnect();
				System.err.println("FTP server refused connection.");
				return null;
			}
			// 转移到FTP服务器目录至指定的目录下
			ftpClient.changeWorkingDirectory(new String(remotePath
					.getBytes(encoding), "utf-8"));
			// 获取文件列表
			FTPFile[] fs = ftpClient.listFiles();
			if (fs != null && fs.length > 0) {
				return fs;
			}
			ftpClient.logout();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return null;
	}
	
    /**
     * 递归删除目录下的所有文件及子目录下所有文件
     * @param dir 将要删除的文件目录
     * @return boolean Returns "true" if all deletions were successful.
     *                 If a deletion fails, the method stops attempting to
     *                 delete and returns "false".
     */
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //递归删除目录中的子目录下
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }
}