//package org.upec.master;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.websocket.server.PathParam;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//
//@Path("/testing")
//public class MyRessources {
//	
//
//    private Connection connect = null;
//    private Statement statement = null;
//    private PreparedStatement preparedStatement = null;
//    private ResultSet resultSet = null;
//    
//      // JDBC driver name and database URL
//      final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
//      final String DB_URL="jdbc:mysql://localhost/TpClinique";
//
//      //  Database credentials
//      final String USER = "root";
//      final String PASS = "mysql";
//	
//	static Connection con = null;
//
//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	public String getRandom() {
//
//		String s = "salut andric";
//		return s;
//	}
//	
//	
//	@POST
//	@Produces(MediaType.TEXT_PLAIN)
//	public void setRandom()
//	{
//	}
//	
//	
//	@Path("/patients")
//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	
//	public String Getname() throws Exception
//	{
//		TestDB t = new TestDB();
//		System.out.println(t.getPatients());
//		return t.getPatients();
//			 
//	}
//
//}
