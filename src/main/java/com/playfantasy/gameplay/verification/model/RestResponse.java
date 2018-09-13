package com.playfantasy.gameplay.verification.model;

public class RestResponse {
	
	private int statusCode;
	private String responseBody;
	
	
	public RestResponse(int statusCode, String responseBody) {
		super();
		this.statusCode = statusCode;
		this.responseBody = responseBody;
	}


	public int getStatusCode() {
		return statusCode;
	}


	public String getResponseBody() {
		return responseBody;
	}


	@Override
	public String toString() {
		return "statusCode = " + statusCode  + "\n" +  " responseBody = " + responseBody ;
	} 


	


	
	

}
