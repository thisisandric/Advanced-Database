package myws;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.xml.crypto.dsig.spec.XPathType.Filter;
import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.spi.http.HttpContext;

import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.HttpsParameters;
import com.sun.net.httpserver.HttpsServer;
import javax.xml.ws.spi.http.HttpContext;

public class Server
{
	final static String location = "http://localhost:7878/getTime";
	public static void main(String[] args) throws KeyStoreException, 
										NoSuchAlgorithmException, 
										CertificateException, 
										FileNotFoundException, 
										IOException, 
										UnrecoverableKeyException,
										KeyManagementException
	{
		Endpoint endpoint = Endpoint.create(new Mysrv());
		QName serviceQName =new QName("http://myws/", "MysrvService"); 
		QName portQName =new QName("http://myws/", "MysrvPort"); 
		Map<String,Object> prop = new HashMap<String,Object>();
		prop.put(Endpoint.WSDL_SERVICE, serviceQName); 
		prop.put(Endpoint.WSDL_PORT, portQName);
		endpoint.setProperties(prop);
		endpoint.publish(location);
		System.out.println("Server listening at " + location);
		
		String serverKeyFile = "keyStores/mysrv.jks";
		char[] pass1 = "roleID".toCharArray();
		KeyStore serverKey = KeyStore.getInstance("JKS"); serverKey.load(new FileInputStream(serverKeyFile), pass1);
		
		KeyManagerFactory kmFactory = KeyManagerFactory. getInstance(KeyManagerFactory.getDefaultAlgorithm());
		kmFactory.init(serverKey, pass1);
		
		SSLContext ssl = SSLContext.getInstance("TLS"); ssl.init(kmFactory.getKeyManagers(), null, null);

		String location2Host = "localhost";
		int location2Port = 8787;
		String location2Path = "/getTime"; HttpsServer httpsServer = HttpsServer.create(
		new InetSocketAddress(location2Host, location2Port), 0);
		
		HttpsConfigurator config = new HttpsConfigurator(ssl) 
		{
			public void configure(HttpsParameters params)
			{
			SSLContext sslCtx = getSSLContext();
			SSLParameters sslparams = sslCtx.getDefaultSSLParameters();
			sslparams.setNeedClientAuth(true);
			params.setSSLParameters(sslparams); 
			}
		};

		httpsServer.setHttpsConfigurator(config); httpsServer.start();

		com.sun.net.httpserver.HttpContext httpContext = httpsServer.createContext(location2Path); 
		endpoint.publish(httpContext);
		System.out.println("Server listening at " + "https://" +
	    location2Host + ":" + location2Port + location2Path);
		
		System.setProperty("javax.net.ssl.trustStore", "keyStores/trustedHosts.jks");
		System.setProperty("javax.net.ssl.trustStorePassword", "sealpass");
		
		System.setProperty("javax.net.debug", "ssl");
	}	

	}	

