package client; 

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import client.jaxws.*;
import java.io.StringReader;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory; 
import javax.xml.transform.stream.StreamResult; 
import javax.xml.transform.stream.StreamSource; 
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;


public class Client
{

	public static void main(String[] args) throws MalformedURLException
	{
		String request = "<ns2:getTime xmlns:ns2='http://myws/'/>" ;
		//MysrvService service = new MysrvService(); 
		//client.jaxws.Mysrv port = service.getMysrvPort();
		//System.out.println("\nTime was: " + port.getTime());
		
		//service = new MysrvService(
		//		new URL("https://localhost:8787/getTime?wsdl"),
		//		new QName("http://myws/", "MysrvService"));
		
		System.setProperty("javax.net.ssl.keyStore", "keyStores/dupont.jks");
		System.setProperty("javax.net.ssl.keyStorePassword", "dupont");
		
		try 
		{
			StringReader reader = new StringReader(request); 
			StreamSource strmSrc = new StreamSource(reader);
			
			QName serviceQName =new QName("http://myws/","MysrvService");
			
			QName portQName =new QName("http://myws/", "MysrvPort");
			Service service = Service.create(new URL("file:/D:/Dev%20Workspace/role- ID/role-ID3/MysrvService.wsdl"),serviceQName);
			Dispatch<Source> dispatch = service.createDispatch(portQName, Source.class, Service.Mode.PAYLOAD);
			
			Source response = dispatch.invoke(strmSrc);
			TransformerFactory transFactory = TransformerFactory.newInstance();
			
			Transformer transformer = transFactory.newTransformer();
			transformer.transform(response, new StreamResult(System.out));
		}
		catch (Exception e) 
		{
		e.printStackTrace();
		}
			
		
		
	} 
}