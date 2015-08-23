package com.sarsjits.proj001;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public class XMLMerge {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		GetXMLRemote remote = new GetXMLRemote();
		//remote.getResponse();
		remote.writeToFile();
	}
}
