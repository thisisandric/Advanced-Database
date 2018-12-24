package myws;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.crypto.dsig.spec.XPathType.Filter;
import com.sun.net.httpserver.HttpContext;

import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory; 
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource; 
import javax.xml.ws.Provider;
import javax.xml.ws.WebServiceProvider;


@WebServiceProvider(wsdlLocation="MysrvService.wsdl")
public class Mysrv implements Provider<Source>
{
	
	public Source invoke(Source payload)
	{
		try 
		{
			TransformerFactory transFactory = TransformerFactory.newInstance();
			Transformer transformer = transFactory.newTransformer();
			transformer.transform(payload, new StreamResult(System.out));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		Calendar cal = Calendar.getInstance(); 
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String response =
				"<ns2:getTimeResponse xmlns:ns2='http://myws/'>" + "<return>" +
				sdf.format(cal.getTime()) + "</return>" +
				"</ns2:getTimeResponse>";
		return new StreamSource(new StringReader(response)); 
		}
	}

//	@WebMethod
//	public String getTime()
//	{
//		Calendar cal = Calendar.getInstance();
//		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//		return sdf.format(cal.getTime());
//	}

