package acetecsemi.com.brick.infra.impl;


import org.apache.commons.httpclient.NameValuePair;

import acetecsemi.com.brick.infra.OAClient;
import acetecsemi.com.brick.infra.httpclient.HttpClientUtil;
import acetecsemi.com.brick.infra.httpclient.Node;

public class OAClientImpl implements OAClient {

	private String address = "http://192.168.1.35/webservice/Json/login.php";

	private HttpClientUtil httpClientUtil = new HttpClientUtil();

	private Node node = new Node();

	@Override
	public String login(String userNumber, String password, String resultType) {
		NameValuePair nvpUserNumber = new NameValuePair("UserNumber",
				userNumber);
		NameValuePair nvpPassword = new NameValuePair("Password", password);
		NameValuePair nvpResultType = new NameValuePair("resultType",
				resultType);
		String res = httpClientUtil.getPost(address, new NameValuePair[] {
				nvpUserNumber, nvpPassword, nvpResultType });
		return res;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
