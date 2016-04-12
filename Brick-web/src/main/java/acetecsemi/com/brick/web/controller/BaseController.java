package acetecsemi.com.brick.web.controller;

import org.openkoala.koala.commons.InvokeResult;

public class BaseController {
	public InvokeResult createInvokeResult(Boolean sign){
		if(sign){
			return InvokeResult.success();
		}else{
			return InvokeResult.failure("");
		}
	}
	
	public InvokeResult createInvokeResult(String message){
		if(message == null){
			return InvokeResult.success();
		}else{
			return InvokeResult.failure(message);
		}
	}
}
