package acetecsemi.com.brick.facade.utils;

public class MyStringUtils {
	/**
	 * 
	 * @param oldStr
	 *            *,****,**,
	 * @param objs
	 *            ***
	 * @return *,****,**,***,
	 */
	public static String getReleaseInfo(String oldStr, String objs) {
		String[] objStr = objs.split(",");
		for (String str : objStr) {
			if (oldStr.indexOf(str) < 0) {
				oldStr += str + ",";
			}
		}
		return oldStr;
	}
}
