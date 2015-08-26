package com.sarsjits.proj001;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.client.ClientProtocolException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLMerge {
	public static void main(String[] args) throws ClientProtocolException, IOException, ParserConfigurationException, SAXException {
		GetXMLRemote remote = new GetXMLRemote();

		/* Reads the file from URL and put it in local directory */
		remote.writeToFile();
		
		/* Get Document Builder */
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		DocumentBuilderFactory factory1 = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder1 = factory1.newDocumentBuilder();
		
		/* Build Document */
		Document document = builder.parse(new File("C:/Users/jitendra.sarswat/Desktop/test1.xml"));
		
		Document document1 = builder1.parse(new File("C:/Users/jitendra.sarswat/Desktop/test2.xml"));
		
		/* Normalize the XML structure */
		document.getDocumentElement().normalize();
		document1.getDocumentElement().normalize();
		
		/* Getting the root node */
		Element root = document.getDocumentElement();
		System.out.println(root.getNodeName());
		
		Element root1 = document1.getDocumentElement();
		System.out.println(root1.getNodeName());
	}
}
