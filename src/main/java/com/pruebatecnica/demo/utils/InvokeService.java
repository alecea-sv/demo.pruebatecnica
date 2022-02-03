package com.pruebatecnica.demo.utils;

import java.io.IOException;
import java.util.Map;

import org.springframework.util.DigestUtils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public abstract class InvokeService {

	protected String endpoint;
	protected String dateTimePattern;
	protected final String mediaType;

	protected String publicKey;
	protected String privateKey;

	public InvokeService() {
		this.mediaType = "application/json; Charset=UTF-8";
	}

	public String getDateTimePattern() {
		return dateTimePattern;
	}

	public void setDateTimePattern(String dateTimePattern) {
		this.dateTimePattern = dateTimePattern;
	}

	public String invokeGetMethod(String url) throws IOException, Exception {

		Request.Builder rb;
		rb = new Request.Builder();
		rb.url(url);
		rb.addHeader("Content-Type", this.mediaType);

		Request request = rb.build();

		OkHttpClient client = new OkHttpClient();
		Response response = client.newCall(request).execute();
		ResponseBody body = response.body();

		System.out.println("##### isSuccessful: " + response.isSuccessful());
		System.out.println("##### Message: " + response.toString());
		System.out.println("##### Body: " + body.toString());

		if (response.isSuccessful()) {
			return body.string();
		} else {
			throw new Exception();
		}

	}

	public String buildUri(String resource, Map<String, String> queryParams) {

		StringBuilder sbUri = new StringBuilder();

		sbUri.append(this.endpoint);
		sbUri.append(resource);

		if (queryParams != null) {
			sbUri.append("?");
			queryParams.entrySet().forEach((entry) -> {
				sbUri.append(entry.getKey());
				sbUri.append("=");
				sbUri.append(entry.getValue());
				sbUri.append("&");
			});
		}

		long ts = System.currentTimeMillis();
		sbUri.append("ts=").append(ts);
		sbUri.append("&apikey=").append(this.publicKey);
		sbUri.append("&hash=").append(DigestUtils.md5DigestAsHex(String.format("%s%s%s", ts, this.privateKey, this.publicKey).getBytes()));

		return sbUri.toString();
		
	}

}
