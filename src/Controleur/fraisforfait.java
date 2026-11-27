package Controleur;

public class fraisforfait {
	String idfraisforfait;
	String libelle;
	double montant;
	public String getIdfraisforfait() {
		return idfraisforfait;
	}
	public void setIdfraisforfait(String idfraisforfait) {
		this.idfraisforfait = idfraisforfait;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public fraisforfait(String idfraisforfait, String libelle, double montant) {
		super();
		this.idfraisforfait = idfraisforfait;
		this.libelle = libelle;
		this.montant = montant;
	}
	@Override
	public String toString() {
		return "fraisforfait [idfraisforfait=" + idfraisforfait + ", libelle=" + libelle + ", montant=" + montant + "]";
	}
}
