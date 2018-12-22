package org.upec.master;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Patients {

	int NoPatient;
	String Nom;
	String Prenom;
	int NoAssSociale;
	int NoTelephone;
	int dataNaissance;
	
	public Patients ()
	{
		this.NoPatient = NoPatient;
		this.Prenom = Prenom;
		this.Nom = Nom;
		this.NoAssSociale = NoAssSociale;
		this.NoTelephone = NoTelephone;
		this.dataNaissance = dataNaissance;
		
	}
	
	public int getNoPatient() {
		return NoPatient;
	}
	public void setNoPatient(int noPatient) {
		NoPatient = noPatient;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public int getNoAssSociale() {
		return NoAssSociale;
	}
	public void setNoAssSociale(int noAssSociale) {
		NoAssSociale = noAssSociale;
	}
	public int getNotelephone() {
		return NoTelephone;
	}
	public void setNotelephone(int tel) {
		NoTelephone = tel;
	}
	public int getDataNaissance() {
		return dataNaissance;
	}
	public void setDataNaissance(int dataNaissance) {
		this.dataNaissance = dataNaissance;
	}
	
	
	
}
	