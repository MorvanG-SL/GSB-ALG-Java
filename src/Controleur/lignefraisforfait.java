package Controleur;

public class lignefraisforfait {
	String idFiche;
	String idFraisForfait;
	int quantite;
	public String getIdFiche() {
		return idFiche;
	}
	public void setIdFiche(String idFiche) {
		this.idFiche = idFiche;
	}
	public String getIdFraisForfait() {
		return idFraisForfait;
	}
	public void setIdFraisForfait(String idFraisForfait) {
		this.idFraisForfait = idFraisForfait;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public lignefraisforfait(String idFiche, String idFraisForfait, int quantite) {
		super();
		this.idFiche = idFiche;
		this.idFraisForfait = idFraisForfait;
		this.quantite = quantite;
	}
	@Override
	public String toString() {
		return "lignefraisforfait [idFiche=" + idFiche + ", idFraisForfait=" + idFraisForfait + ", quantite=" + quantite
				+ "]";
	}
}
