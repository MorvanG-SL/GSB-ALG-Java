package Controleur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class utilisateur {

	String idUtilisateur;
	String nom;
	String prenom;
	String login;
	String mdp;
	String adresse;
	int cp;
	String ville;
	LocalDate dateEmbauche;
	String idRole; // a changer en type Role après
	public utilisateur(String idUtilisateur, String nom, String prenom, String login, String mdp, String adresse,
			int cp, String ville, LocalDate dateEmbauche, String idRole) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.mdp = mdp;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		this.dateEmbauche = dateEmbauche;
		this.idRole = idRole;
	}
	public String getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(String idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public LocalDate getDateEmbauche() {
		return dateEmbauche;
	}
	public void setDateEmbauche(LocalDate dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	public String getIdRole() {
		return idRole;
	}
	public void setIdRole(String idRole) {
		this.idRole = idRole;
	}
	@Override
	public String toString() {
		return "utilisateur [idUtilisateur=" + idUtilisateur + ", nom=" + nom + ", prenom=" + prenom + ", login="
				+ login + ", mdp=" + mdp + ", adresse=" + adresse + ", cp=" + cp + ", ville=" + ville
				+ ", dateEmbauche=" + dateEmbauche + ", idRole=" + idRole + "]";
	}
	public static String roleConnecte = null;
	public static String verifConnexion(String login, String mdp)
	{
		try {
			Connection con = AccesBd.getInstance();
			String query = "SELECT login, mdp, utilisateur.idrole, role.libelle FROM utilisateur INNER JOIN role ON utilisateur.idrole = role.idrole WHERE utilisateur.login = ? AND utilisateur.mdp = ?;";
			PreparedStatement requete = con.prepareStatement(query);
            requete.setString(1, login);
            requete.setString(2, mdp);
            ResultSet resultat = requete.executeQuery();
            
            if (resultat.next()) {
                roleConnecte = resultat.getString("libelle"); // On le sauvegarde ici !
                return roleConnecte;
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
