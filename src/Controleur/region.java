package Controleur;

public class region {
	String idregion;
	String libelle;
	public String getIdregion() {
		return idregion;
	}
	public void setIdregion(String idregion) {
		this.idregion = idregion;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public region(String idregion, String libelle) {
		super();
		this.idregion = idregion;
		this.libelle = libelle;
	}
	@Override
	public String toString() {
		return "region [idregion=" + idregion + ", libelle=" + libelle + "]";
	}
}
