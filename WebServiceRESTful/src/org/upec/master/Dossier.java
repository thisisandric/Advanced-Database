package org.upec.master;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Dossier {
	
	
	int NoDossier;
	int NoPatient;
	int NoMedecin;
	int DateVisite;
	int NoTraitement;
	int NoDiagnostic;
	
	public Dossier ()
	{
		this.NoDossier = NoDossier;
		this.NoPatient = NoPatient;
		this.NoMedecin = NoMedecin;
		this.DateVisite = DateVisite;
		this.NoTraitement = NoTraitement;
		this.NoDiagnostic = NoDiagnostic;
		
	}
	
	public int getNoDossier() {
		return NoDossier;
	}
	public void setNoDossier(int noDossier) {
		NoDossier = noDossier;
	}
	public int getPatient() {
		return NoPatient;
	}
	public void setPatient(int pat) {
		NoPatient = pat;
	}
	public int getMedecin() {
		return NoMedecin;
	}
	public void setMedecin(int med) {
		NoMedecin = med;
	}
	public int getDateVisite() {
		return DateVisite;
	}
	public void setDateVisite(int Dv) {
		DateVisite = Dv;
	}
	public int getNoTraitement() {
		return NoTraitement;
	}
	public void setNoTraitement(int NoT) {
		NoTraitement = NoT;
	}
	public int getNoDiagnostic() {
		return NoDiagnostic;
	}
	public void setNoDiagnostic(int NoDiag) {
		NoDiagnostic = NoDiag;
	}	

}
