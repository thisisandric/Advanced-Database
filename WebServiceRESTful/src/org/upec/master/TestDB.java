package org.upec.master;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;



import javax.xml.bind.annotation.XmlRootElement;

import com.mysql.jdbc.PreparedStatement;

@XmlRootElement
public class TestDB {
	
	Connection con = null;
	
	 public TestDB() {
		 try {	
				
				Class.forName("com.mysql.jdbc.Driver");
			    con = DriverManager.getConnection("jdbc:mysql://localhost/tpClinique", "root", "mysql");
				java.sql.PreparedStatement Statement = con.prepareStatement("SELECT * FROM patient");                              
				ResultSet result=Statement.executeQuery();
				System.out.println("connexion succes");
	 }
		 catch(Exception e)
			{
			System.out.println(e);
			}

	 }
	 
	 
	 
	 public Patients unePersonne (int NoPatient) throws Exception
		{
			String req = "SELECT * FROM patient where NoPatient= "+NoPatient ;
			

	        Patients newPP = new Patients();
	  
	    	try 
	    	    {
	    		Class.forName("com.mysql.jdbc.Driver");
			    con = DriverManager.getConnection("jdbc:mysql://localhost/tpClinique", "root", "mysql");
				java.sql.PreparedStatement Statement = con.prepareStatement(req);                              
				ResultSet result=Statement.executeQuery();
				System.out.println("connexion succes");
				
				if(result.next()) 
				{
					newPP.setNoPatient(result.getInt("NoPatient"));
					newPP.setNom(result.getString("Nom"));
					newPP.setPrenom(result.getString("Prenom"));
					newPP.setNotelephone(result.getInt("NoTelephone"));
					newPP.setNoAssSociale(result.getInt("NoAssSociale"));
					newPP.setDataNaissance(result.getInt("DateNaissance"));
				}
			}
			catch (Exception e)
	    	{
				System.out.println("Impossible d'executer la requete -> "+ e);
			}	
	    	// on retourn seulement une personne à la fois
			return newPP;
		}
	 
	 
	 public List<Patients> personeEnregistre() throws Exception
		{
			String req = "SELECT * FROM patient";
			System.out.println(req + " tentative - >");
			
	        List<Patients> arrayP = new ArrayList<>();
	  
	    	try 
	    	    {
	    		String url = "jdbc:mysql://localhost/tpClinique";
	            String user = "root";
	            String passwd = "mysql";
	    		Class.forName("com.mysql.jdbc.Driver"); 
	    		Connection con = DriverManager.getConnection(url, user, passwd);
	    		java.sql.Statement state = con.createStatement();
				ResultSet result = ((java.sql.Statement)state).executeQuery(req);
				System.out.println(" EXECUTION REUSSI");
			
				while (result.next()) 
				{
					Patients newPP = new Patients();
					
					newPP.setDataNaissance(result.getInt("DateNaissance"));
					newPP.setNoPatient(result.getInt("NoPatient"));
					newPP.setNom(result.getString("Nom"));
					newPP.setPrenom(result.getString("Prenom"));
					newPP.setNotelephone(result.getInt("NoTelephone"));
					newPP.setNoAssSociale(result.getInt("NoAssSociale"));
			
					arrayP.add(newPP); 
				}
			}
			catch (Exception e) {
				System.out.println("Impossible d'executer la requete -> "+ e);
			}		
			return arrayP;
		}
	 
	  
	 public void newPer(Patients Pers) throws Exception
		{
			String req = "insert into patient values (?,?,?,?,?,?)";
			System.out.println(req + " en cour ==== >");
	    	try 
	    	    {
	    		String url = "jdbc:mysql://localhost/tpClinique";
	            String user = "root"; 
	            String passwd = "mysql";
	    		Class.forName("com.mysql.jdbc.Driver"); 
	    		
	    		Connection con = DriverManager.getConnection(url, user, passwd);
	    		java.sql.PreparedStatement state = con.prepareStatement(req);
	    		
	    		state.setInt(1, Pers.getNoPatient());
	    		state.setInt(2, Pers.getNoAssSociale());
	    		state.setString(3, Pers.getNom());
	    		state.setString(4, Pers.getPrenom());
	    		state.setInt(5, Pers.getNotelephone());
	    		state.setInt(6, Pers.getDataNaissance());
 		 
	    		state.executeUpdate();
				System.out.println("Succès");
			}
			catch (Exception e)
	    	{
				System.out.println("Erreur === > "+ e);
			}	
	  	    	
		}
	 
	 
	 public  List<Medecin> medRec() throws Exception
	 {
	 				String req = "SELECT * FROM medecin";
	 				System.out.println(req + " tentative - >");
	 				
	 		        List<Medecin> arrayM = new ArrayList<>();
	 		  
	 		    	try 
	 		    	    {
	 		    		String url = "jdbc:mysql://localhost/tpClinique";
	 		            String user = "root";
	 		            String passwd = "mysql";
	 		    		Class.forName("com.mysql.jdbc.Driver"); 
	 		    		Connection con = DriverManager.getConnection(url, user, passwd);
	 		    		java.sql.Statement state = con.createStatement();
	 					ResultSet result = ((java.sql.Statement)state).executeQuery(req);
	 					System.out.println(" EXECUTION REUSSI");
	 				
	 					while (result.next()) 
	 					{
	 						Medecin newMed = new Medecin();
	 						newMed.setNoMedecin(result.getInt("NoMedecin"));
	 						newMed.setNom(result.getString("Nom"));
	 						newMed.setPrenom(result.getString("Prenom"));
	 						
	 						arrayM.add(newMed); 
	 					}
	 				}
	 				catch (Exception e) {
	 					System.out.println("Impossible d'executer la requete -> "+ e);
	 				}		
	 				return arrayM;
	 			}
	 
	 
	 public Medecin unMedecin (int noMed) throws Exception
		{
			String req = "SELECT * FROM medecin where NoMedecin= "+noMed ;
			

	        Medecin newMM = new Medecin();
	  
	    	try 
	    	    {
	    		Class.forName("com.mysql.jdbc.Driver");
			    con = DriverManager.getConnection("jdbc:mysql://localhost/tpClinique", "root", "mysql");
				java.sql.PreparedStatement Statement = con.prepareStatement(req);                              
				ResultSet result=Statement.executeQuery();
				System.out.println("connexion succes");
				
				if(result.next()) 
				{
					newMM.setNoMedecin(result.getInt("NoMedecin"));
					newMM.setNom(result.getString("Nom"));
					newMM.setPrenom(result.getString("Prenom"));
			
					System.out.println(result.getInt("NoMedecin")+ result.getString("Prenom"));
				}
			}
			catch (Exception e)
	    	{
				System.out.println("Impossible d'executer la requete -> "+ e);
			}	
	    	// on retourn seulement une personne à la fois
			return newMM;
		}
	 
	 
	 public void newMed(Medecin Md) throws Exception
		{
			String req = "INSERT INTO patient Values (?,?,?,?,?,?)";
			System.out.println(req + " en cour ==== >");
	    	try 
	    	    {
	    		String url = "jdbc:mysql://localhost/tpClinique";
	            String user = "root"; 
	            String passwd = "mysql";
	    		Class.forName("com.mysql.jdbc.Driver"); 
	    		
	    		Connection con = DriverManager.getConnection(url, user, passwd);
	    		java.sql.PreparedStatement state = con.prepareStatement(req);
	    		
	    		state.setInt(1, Md.getNoMedecin());
	    		state.setString(2, Md.getNom());
	    		state.setString(3, Md.getPrenom());
	  
	    		state.executeUpdate();
				System.out.println("Succès");
			}
			catch (Exception e)
	    	{
				System.out.println("Erreur === > "+ e);
			}	
	  	    	
		}
	 
	 
	 
	 public Dossier getMededinPatientDossier (int noMed,int noPat) throws Exception
		{
			String req = "SELECT * FROM entree_dossier WHERE NoPatient = ? AND NoMedecin = ?";

	        //List array = new ArrayList<>();
	        Dossier newDossier = new Dossier();
	  
	    	try 
	    	    {
	    		Class.forName("com.mysql.jdbc.Driver");
			    con = DriverManager.getConnection("jdbc:mysql://localhost/tpClinique", "root", "mysql");
				java.sql.PreparedStatement Statement = con.prepareStatement(req);                              
				ResultSet result=Statement.executeQuery();
				Statement.setInt(1, result.getInt(noPat));
				Statement.setInt(2, result.getInt(noMed));
				
				System.out.println("connexion succes");
				
				while(result.next()) 
				{	
					newDossier.setNoDossier(result.getInt("NoDossier"));
					newDossier.setMedecin(result.getInt("NoMedecin"));
					newDossier.setPatient(result.getInt("NoPatient"));
					newDossier.setNoTraitement(result.getInt("NoTraitement"));
					newDossier.setDateVisite(result.getInt("DateVisite"));
					newDossier.setNoDiagnostic(result.getInt("NoDiagnostic"));
					//array.add(newDossier);					
				}
			}
			catch (Exception e)
	    	{
				System.out.println("Impossible d'executer la requete -> "+ e);
			}	
	    	// on retourn seulement une personne à la fois
			return newDossier;
		}
	 
	 

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 		 
	 
	 

}
