package acetecsemi.com.brick.infra.impl;

import org.apache.commons.httpclient.NameValuePair;

import acetecsemi.com.brick.infra.MesTimeClient;
import acetecsemi.com.brick.infra.httpclient.HttpClientUtil;
import acetecsemi.com.brick.infra.httpclient.Node;

public class MesTimeClientImpl implements MesTimeClient{

	private String address = "http://192.168.1.37:8080/Time.asmx/";
	
	private HttpClientUtil httpClientUtil =new HttpClientUtil();
	
	private Node node =new Node();
	
	@Override
	public String GetServerTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLotInfo(String lot, String category) {
		NameValuePair nvplot = new NameValuePair("lot", lot);
		NameValuePair nvpcategory = new NameValuePair("category", category);
		byte[] res = httpClientUtil.getPostByte(address + "GetLotInfo", new NameValuePair[] {nvplot,nvpcategory});
		return node.getNodeText(res, "string");
	}

	@Override
	public String getTouchDown(String productModel) {
		NameValuePair nvplot = new NameValuePair("productmodel", productModel);
		byte[] res = httpClientUtil.getPostByte(address + "GetTouchdown", new NameValuePair[] {nvplot});
		return node.getNodeText(res, "string");
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
}
