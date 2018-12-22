package org.upec.master;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Medecin {


		int NoMedecin;
		String Nom;
		String Prenom;
		
	public Medecin ()
	{
			this.NoMedecin = NoMedecin;
			this.Prenom = Prenom;
			this.Nom = Nom;
	}
		
		public int getNoMedecin() {
			return NoMedecin;
		}
		public void setNoMedecin(int med) {
			NoMedecin = med;
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
	}

