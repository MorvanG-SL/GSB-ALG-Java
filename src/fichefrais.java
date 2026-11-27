import java.time.LocalDate;

public class fichefrais {

	int idFiche;
	String idVisiteur;
	int annee;
	int mois;
	int nbJustificatifs;
	double montantValide;
	LocalDate dateModif;
	String idEtat; // a changer en type Etat après
	public fichefrais(int idFiche, String idVisiteur, int annee, int mois, int nbJustificatifs, double montantValide,
			LocalDate dateModif, String idEtat) {
		super();
		this.idFiche = idFiche;
		this.idVisiteur = idVisiteur;
		this.annee = annee;
		this.mois = mois;
		this.nbJustificatifs = nbJustificatifs;
		this.montantValide = montantValide;
		this.dateModif = dateModif;
		this.idEtat = idEtat;
	}
	public int getIdFiche() {
		return idFiche;
	}
	public void setIdFiche(int idFiche) {
		this.idFiche = idFiche;
	}
	public String getIdVisiteur() {
		return idVisiteur;
	}
	public void setIdVisiteur(String idVisiteur) {
		this.idVisiteur = idVisiteur;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public int getMois() {
		return mois;
	}
	public void setMois(int mois) {
		this.mois = mois;
	}
	public int getNbJustificatifs() {
		return nbJustificatifs;
	}
	public void setNbJustificatifs(int nbJustificatifs) {
		this.nbJustificatifs = nbJustificatifs;
	}
	public double getMontantValide() {
		return montantValide;
	}
	public void setMontantValide(double montantValide) {
		this.montantValide = montantValide;
	}
	public LocalDate getDateModif() {
		return dateModif;
	}
	public void setDateModif(LocalDate dateModif) {
		this.dateModif = dateModif;
	}
	public String getIdEtat() {
		return idEtat;
	}
	public void setIdEtat(String idEtat) {
		this.idEtat = idEtat;
	}
	@Override
	public String toString() {
		return "fichefrais [idFiche=" + idFiche + ", idVisiteur=" + idVisiteur + ", annee=" + annee + ", mois=" + mois
				+ ", nbJustificatifs=" + nbJustificatifs + ", montantValide=" + montantValide + ", dateModif="
				+ dateModif + ", idEtat=" + idEtat + "]";
	}
	
	
}
