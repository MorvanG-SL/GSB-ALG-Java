package Controleur;
import java.time.LocalDate;

public class lignefraishorsforfait {
	
	int idLigneFHF;
	int idFiche;
	String libelle;
	LocalDate dateFrais;
	double montant;
	public lignefraishorsforfait(int idLigneFHF, int idFiche, String libelle, LocalDate dateFrais, double montant) {
		super();
		this.idLigneFHF = idLigneFHF;
		this.idFiche = idFiche;
		this.libelle = libelle;
		this.dateFrais = dateFrais;
		this.montant = montant;
	}
	public int getIdLigneFHF() {
		return idLigneFHF;
	}
	public void setIdLigneFHF(int idLigneFHF) {
		this.idLigneFHF = idLigneFHF;
	}
	public int getIdFiche() {
		return idFiche;
	}
	public void setIdFiche(int idFiche) {
		this.idFiche = idFiche;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public LocalDate getDateFrais() {
		return dateFrais;
	}
	public void setDateFrais(LocalDate dateFrais) {
		this.dateFrais = dateFrais;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	@Override
	public String toString() {
		return "lignefraishorsforfait [idLigneFHF=" + idLigneFHF + ", idFiche=" + idFiche + ", libelle=" + libelle
				+ ", dateFrais=" + dateFrais + ", montant=" + montant + "]";
	}
	
	

}
