package org.upec.master;



import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.upec.master.TestDB;

@Path("/clinique")
public class RessourcesRest {
	
	TestDB res = new TestDB();

	
	@Path("/patients")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Patients> getPersonnes()
	{
		
		try {
			return res.personeEnregistre();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
   }
	
	// Retourner la liste de medecin
	@Path("/medecins")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Medecin> getMedecin()
	{
		
		try {
			return res.medRec();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
   }
	
	// Retourne un medecin seulement
	@Path("medecin/{noMed}")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Medecin unMedecin(@PathParam("noMed") int noMed) throws Exception
	{
		
		return res.unMedecin(noMed);
   }
	
	
	// Retourne le patient traité par le medecin avec le numero 12345
	@Path("medecin/{noMed}/patient/{noPat}")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Dossier medecinPatientDossier(@PathParam("noMed") int noMed, @PathParam("noPat") int noPat) throws Exception
	{
		
		return res.getMededinPatientDossier(noMed,noPat);
   }
	

	//post method
	@Path("patient/addpat")
	@POST 
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Patients addpat(Patients post1) throws Exception
	{
		System.out.println(post1);
		res.newPer(post1);
	return post1;	
	}
	
	
	
	
	
	
}
