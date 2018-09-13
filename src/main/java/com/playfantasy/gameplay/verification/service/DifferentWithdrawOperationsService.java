package com.playfantasy.gameplay.verification.service;

import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
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
public class DifferentWithdrawOperationsService {

	final static String UNDER_PROCESSING = "{ \"context\": {}, \"status\":\"UNDER_PROCESSING\",\"type\":\"4\"}";
	final static String UNDER_REVIEW = "{ \"context\": {}, \"status\": \"UNDER_REVIEW\",\"type\":\"4\"}";
	final static String APPROVED = "{ \"context\": {}, \"status\": \"APPROVED\",\"type\":\"4\"}";
	final static String ON_HOLD = "{ \"context\": {}, \"status\": \"ON_HOLD\",\"type\":\"4\"}";
	final static String PROCESSED = "{ \"context\": {}, \"status\": \"PROCESSED\",\"type\":\"1\"}";
	final static String FAILED_ONLINE = "{ \"context\": {}, \"status\": \"FAILED_ONLINE\",\"type\":\"4\"}";
	final static String CREDITED_ONLINE = "{ \"context\": {}, \"status\": \"CREDITED_ONLINE\",\"type\":\"1\"}";

	public static RestResponse approvingAWithdrawRequest(long withdrawId) {

		RequestBuilder build_put = RequestBuilder
				.put("http://192.168.6.18:8080/ups/api/userprofileservice/withdraw/"+withdrawId)
			.setHeader("Accept", "application/json");
		HttpUriRequest put = build_put.setEntity(new StringEntity(UNDER_PROCESSING, ContentType.APPLICATION_JSON))
				.build();

		String userpass = "admin" + ":" + "secret";

		byte[] encodedAuth = Base64.encodeBase64(userpass.getBytes(Charset.forName("US-ASCII")));
		String authHeader = "Basic " + new String(encodedAuth);
		put.setHeader("AUTHORIZATION", authHeader);
		put.setHeader("Content-Type", "application/json");

		try (CloseableHttpClient client = HttpClientBuilder.create().build();
				CloseableHttpResponse response = client.execute(put)) {
			ResponseHandler<String> handler = new BasicResponseHandler();
			
			RestResponse restresponse = new RestResponse(response.getStatusLine().getStatusCode(),
					handler.handleResponse(response));
			System.out.println(restresponse.toString());
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		RequestBuilder build_put1 = RequestBuilder
				.put("http://192.168.6.18:8080/ups/api/userprofileservice/withdraw/"+withdrawId)
				.setHeader("Accept", "application/json");
		HttpUriRequest put1 = build_put1.setEntity(new StringEntity(UNDER_REVIEW, ContentType.APPLICATION_JSON))
				.build();

		String userpass1 = "admin" + ":" + "secret";

		byte[] encodedAuth1 = Base64.encodeBase64(userpass1.getBytes(Charset.forName("US-ASCII")));
		String authHeader1 = "Basic " + new String(encodedAuth1);
		put1.setHeader("AUTHORIZATION", authHeader1);
		put1.setHeader("Content-Type", "application/json");

		try (CloseableHttpClient client1 = HttpClientBuilder.create().build();
				CloseableHttpResponse response1 = client1.execute(put1)) {
			ResponseHandler<String> handler1 = new BasicResponseHandler();
			RestResponse restresponse1 = new RestResponse(response1.getStatusLine().getStatusCode(),
					handler1.handleResponse(response1));
			System.out.println(restresponse1.toString());
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		RequestBuilder build_put2 = RequestBuilder
				.put("http://192.168.6.18:8080/ups/api/userprofileservice/withdraw/"+withdrawId)
				.setHeader("Accept", "application/json");
		HttpUriRequest put2 = build_put2.setEntity(new StringEntity(APPROVED, ContentType.APPLICATION_JSON)).build();

		String userpass2 = "admin" + ":" + "secret";

		byte[] encodedAuth2 = Base64.encodeBase64(userpass2.getBytes(Charset.forName("US-ASCII")));
		String authHeader2 = "Basic " + new String(encodedAuth2);
		put2.setHeader("AUTHORIZATION", authHeader2);
		put2.setHeader("Content-Type", "application/json");
		RestResponse restresponse2 = null;
		try (CloseableHttpClient client1 = HttpClientBuilder.create().build();
				CloseableHttpResponse response2 = client1.execute(put2)) {
			ResponseHandler<String> handler2 = new BasicResponseHandler();
			restresponse2 = new RestResponse(response2.getStatusLine().getStatusCode(),
					handler2.handleResponse(response2));
			System.out.println(restresponse2.toString());
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
		return restresponse2;

	}

	public static RestResponse markingWithdrawReqCreditedOnline(long withdrawId) {
		RequestBuilder build_put = RequestBuilder
				.put("http://192.168.6.18:8080/ups/api/userprofileservice/withdraw/"+withdrawId)
				.setHeader("Content-Type", "application/json").setHeader("Accept", "application/json");
		HttpUriRequest put = build_put.setEntity(new StringEntity(PROCESSED, ContentType.APPLICATION_JSON)).build();

		String userpass = "admin" + ":" + "secret";

		byte[] encodedAuth = Base64.encodeBase64(userpass.getBytes(Charset.forName("US-ASCII")));
		String authHeader = "Basic " + new String(encodedAuth);
		put.setHeader("AUTHORIZATION", authHeader);
		put.setHeader("Content-Type", "application/json");

		try (CloseableHttpClient client = HttpClientBuilder.create().build();
				CloseableHttpResponse response = client.execute(put)) {
			ResponseHandler<String> handler = new BasicResponseHandler();
			RestResponse restresponse = new RestResponse(response.getStatusLine().getStatusCode(),
					handler.handleResponse(response));
			System.out.println(restresponse.toString());
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		RequestBuilder build_put1 = RequestBuilder
				.put("http://192.168.6.18:8080/ups/api/userprofileservice/withdraw/" + withdrawId)
				.setHeader("Content-Type", "application/json").setHeader("Accept", "application/json");
		HttpUriRequest put1 = build_put1.setEntity(new StringEntity(CREDITED_ONLINE, ContentType.APPLICATION_JSON))
				.build();

		String userpass1 = "admin" + ":" + "secret";

		byte[] encodedAuth1 = Base64.encodeBase64(userpass1.getBytes(Charset.forName("US-ASCII")));
		String authHeader1 = "Basic " + new String(encodedAuth1);
		put1.setHeader("AUTHORIZATION", authHeader1);
		put1.setHeader("Content-Type", "application/json");
		RestResponse restresponse1 = null;
		try (CloseableHttpClient client1 = HttpClientBuilder.create().build();
				CloseableHttpResponse response1 = client1.execute(put1)) {
			ResponseHandler<String> handler1 = new BasicResponseHandler();
			restresponse1 = new RestResponse(response1.getStatusLine().getStatusCode(),
					handler1.handleResponse(response1));
			System.out.println(restresponse1.toString());
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return restresponse1;

	}

	public static RestResponse markingWithdrawReqFailedOnline(long withdrawId) {

		RequestBuilder build_put = RequestBuilder
				.put("http://192.168.6.18:8080/ups/api/userprofileservice/withdraw/"+withdrawId)
				.setHeader("Content-Type", "application/json").setHeader("Accept", "application/json");
		HttpUriRequest put = build_put.setEntity(new StringEntity(PROCESSED, ContentType.APPLICATION_JSON)).build();

		String userpass = "admin" + ":" + "secret";

		byte[] encodedAuth = Base64.encodeBase64(userpass.getBytes(Charset.forName("US-ASCII")));
		String authHeader = "Basic " + new String(encodedAuth);
		put.setHeader("AUTHORIZATION", authHeader);
		put.setHeader("Content-Type", "application/json");

		try (CloseableHttpClient client = HttpClientBuilder.create().build();
				CloseableHttpResponse response = client.execute(put)) {
			ResponseHandler<String> handler = new BasicResponseHandler();
			RestResponse restresponse = new RestResponse(response.getStatusLine().getStatusCode(),
					handler.handleResponse(response));
			System.out.println(restresponse.toString());
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		RequestBuilder build_put1 = RequestBuilder
				.put("http://192.168.6.18:8080/ups/api/userprofileservice/withdraw/"+withdrawId)
				.setHeader("Content-Type", "application/json").setHeader("Accept", "application/json");
		HttpUriRequest put1 = build_put1.setEntity(new StringEntity(FAILED_ONLINE, ContentType.APPLICATION_JSON))
				.build();

		String userpass1 = "admin" + ":" + "secret";

		byte[] encodedAuth1 = Base64.encodeBase64(userpass1.getBytes(Charset.forName("US-ASCII")));
		String authHeader1 = "Basic " + new String(encodedAuth1);
		put1.setHeader("AUTHORIZATION", authHeader1);
		put1.setHeader("Content-Type", "application/json");
		RestResponse restresponse1 = null;
		try (CloseableHttpClient client1 = HttpClientBuilder.create().build();
				CloseableHttpResponse response1 = client1.execute(put1)) {
			ResponseHandler<String> handler1 = new BasicResponseHandler();
			restresponse1 = new RestResponse(response1.getStatusLine().getStatusCode(),
					handler1.handleResponse(response1));
			System.out.println(restresponse1.toString());
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return restresponse1;

	}

	public static RestResponse markingWithdrawReqON_Hold(long withdrawId) {

		RequestBuilder build_put = RequestBuilder
				.put("http://192.168.6.18:8080/ups/api/userprofileservice/withdraw/"+withdrawId)
				.setHeader("Content-Type", "application/json").setHeader("Accept", "application/json");
		HttpUriRequest put = build_put.setEntity(new StringEntity(UNDER_PROCESSING, ContentType.APPLICATION_JSON))
				.build();

		String userpass = "admin" + ":" + "secret";

		byte[] encodedAuth = Base64.encodeBase64(userpass.getBytes(Charset.forName("US-ASCII")));
		String authHeader = "Basic " + new String(encodedAuth);
		put.setHeader("AUTHORIZATION", authHeader);
		put.setHeader("Content-Type", "application/json");

		try (CloseableHttpClient client = HttpClientBuilder.create().build();
				CloseableHttpResponse response = client.execute(put)) {
			ResponseHandler<String> handler = new BasicResponseHandler();
			RestResponse restresponse = new RestResponse(response.getStatusLine().getStatusCode(),
					handler.handleResponse(response));
			System.out.println(restresponse.toString());
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		RequestBuilder build_put1 = RequestBuilder
				.put("http://192.168.6.18:8080/ups/api/userprofileservice/withdraw/"+withdrawId)
				.setHeader("Content-Type", "application/json").setHeader("Accept", "application/json");
		HttpUriRequest put1 = build_put1.setEntity(new StringEntity(ON_HOLD, ContentType.APPLICATION_JSON)).build();

		String userpass1 = "admin" + ":" + "secret";

		byte[] encodedAuth1 = Base64.encodeBase64(userpass1.getBytes(Charset.forName("US-ASCII")));
		String authHeader1 = "Basic " + new String(encodedAuth1);
		put1.setHeader("AUTHORIZATION", authHeader1);
		put1.setHeader("Content-Type", "application/json");
		RestResponse restresponse1 = null;
		try (CloseableHttpClient client1 = HttpClientBuilder.create().build();
				CloseableHttpResponse response1 = client1.execute(put1)) {
			ResponseHandler<String> handler1 = new BasicResponseHandler();
			restresponse1 = new RestResponse(response1.getStatusLine().getStatusCode(),
					handler1.handleResponse(response1));
			System.out.println(restresponse1.toString());
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return restresponse1;
	}

}
