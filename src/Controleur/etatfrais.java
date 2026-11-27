package Controleur;

public class etatfrais {

	String idEtat;
	String libelle;
	public etatfrais(String idEtat, String libelle) {
		super();
		this.idEtat = idEtat;
		this.libelle = libelle;
	}
	public String getIdEtat() {
		return idEtat;
	}
	public void setIdEtat(String idEtat) {
		this.idEtat = idEtat;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	@Override
	public String toString() {
		return "etatfrais [idEtat=" + idEtat + ", libelle=" + libelle + "]";
	}
	
	
}
