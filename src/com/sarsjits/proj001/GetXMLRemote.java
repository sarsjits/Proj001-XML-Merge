package com.sarsjits.proj001;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class GetXMLRemote {
	private CloseableHttpClient httpclient;
	private HttpGet httpget;
	private CloseableHttpResponse response;
	
	public GetXMLRemote() throws ClientProtocolException, IOException {
		httpclient = HttpClients.createDefault();
		httpget = new HttpGet("http://appvigil.co/test1.xml");
		response = httpclient.execute(httpget);
	}
	
	public void getResponse() throws ParseException, IOException {
		String responseAsString = EntityUtils.toString(response.getEntity());
		System.out.println(responseAsString);
	}
	
	public void writeToFile() throws UnsupportedOperationException, IOException {
		HttpEntity entity = response.getEntity();
		InputStream is = entity.getContent();
		String filePath = "C:/Users/jitendra.sarswat/Desktop/test2.xml";
		FileOutputStream fos = new FileOutputStream(new File(filePath));
		int inByte;
		while((inByte = is.read()) != -1)
			fos.write(inByte);
		is.close();
		fos.close();
	}
}
