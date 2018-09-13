package com.playfantasy.gameplay.verification.service;

import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Repository;

import com.playfantasy.gameplay.verification.model.RestResponse;

@Repository
public class UserActionsDAOService {

	
	    //*****POST METHOD*****//
	
	
	    public RestResponse blockUserId(int user_id) {
	    	
	    	
		String sta = "{ \"context\": {}, \"status\":\"BLOCKED\"}";
        RequestBuilder build_post = RequestBuilder
				.post("http://192.168.6.18:8080/ups/api/userprofileservice/users/" + user_id + "/status")
				.setHeader("Content-Type", "application/json").setHeader("Accept", "application/json");
		HttpUriRequest post = build_post.setEntity(new StringEntity(sta, ContentType.APPLICATION_JSON)).build();

		String userpass4 = "admin" + ":" + "secret";

		byte[] encodedAuth4 = Base64.encodeBase64(userpass4.getBytes(Charset.forName("US-ASCII")));
		String authHeader4 = "Basic " + new String(encodedAuth4);
		post.setHeader("AUTHORIZATION", authHeader4);
		post.setHeader("Content-Type", "application/json");
		RestResponse restresponse4 = null;
		try (CloseableHttpClient client4 = HttpClientBuilder.create().build();
				CloseableHttpResponse response4 = client4.execute(post)) {
			restresponse4 = new RestResponse(response4.getStatusLine().getStatusCode(), null);
			if (restresponse4.getStatusCode() == 204) {
				System.out.println(" ID : " + user_id + " Status : BLOCKED");
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return restresponse4;

	}

	
	
	
	
	
	
	
	

}