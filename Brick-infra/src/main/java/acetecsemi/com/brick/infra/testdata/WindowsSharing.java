package acetecsemi.com.brick.infra.testdata;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileOutputStream;

public class WindowsSharing {

	public void getTestData() {
		InputStream in = null;
		OutputStream out = null;
		try {
			// 获取图片
			File localFile = new File("C:/test.jpg");
			String remotePhotoUrl = "smb://share:admin@192.168.135.11/sharedFolder/"; // 存放图片的共享目录
			SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSS_");
			SmbFile remoteFile = new SmbFile(remotePhotoUrl + "/"
					+ fmt.format(new Date()) + localFile.getName());
			remoteFile.connect(); // 尝试连接

			in = new BufferedInputStream(new FileInputStream(localFile));
			out = new BufferedOutputStream(new SmbFileOutputStream(remoteFile));

			byte[] buffer = new byte[4096];
			int len = 0; // 读取长度
			while ((len = in.read(buffer, 0, buffer.length)) != -1) {
				out.write(buffer, 0, len);
			}
			out.flush(); // 刷新缓冲的输出流
		} catch (Exception e) {
			String msg = "发生错误：" + e.getLocalizedMessage();
			System.out.println(msg);
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (Exception e) {
			}
		}
	}
}
