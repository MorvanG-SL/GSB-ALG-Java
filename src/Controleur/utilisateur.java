package Controleur;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

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
	String idRole;
	int telFixe;
	int telPortable;
	String mailPro;
	int idRegion;

	public static String roleConnecte = null;

	public utilisateur(String idUtilisateur, String nom, String prenom, String login, String mdp, String adresse,
			int cp, String ville, LocalDate dateEmbauche, String idRole, int telFixe, int telPortable, String mailPro,
			int idRegion) {
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
		this.telFixe = telFixe;
		this.telPortable = telPortable;
		this.mailPro = mailPro;
		this.idRegion = idRegion;
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
	public int getTelFixe() {
		return telFixe;
	}
	public void setTelFixe(int telFixe) {
		this.telFixe = telFixe;
	}
	public int getTelPortable() {
		return telPortable;
	}
	public void setTelPortable(int telPortable) {
		this.telPortable = telPortable;
	}
	public String getMailPro() {
		return mailPro;
	}
	public void setMailPro(String mailPro) {
		this.mailPro = mailPro;
	}
	public int getIdRegion() {
		return idRegion;
	}
	public void setIdRegion(int idRegion) {
		this.idRegion = idRegion;
	}
	public static String getRoleConnecte() {
		return roleConnecte;
	}
	public static void setRoleConnecte(String roleConnecte) {
		utilisateur.roleConnecte = roleConnecte;
	}

	@Override
	public String toString() {
		return "utilisateur [idUtilisateur=" + idUtilisateur + ", nom=" + nom + ", prenom=" + prenom + ", login="
				+ login + ", mdp=" + mdp + ", adresse=" + adresse + ", cp=" + cp + ", ville=" + ville
				+ ", dateEmbauche=" + dateEmbauche + ", idRole=" + idRole + ", telFixe=" + telFixe + ", telPortable="
				+ telPortable + ", mailPro=" + mailPro + ", idRegion=" + idRegion + "]";
	}

	// Vérification des identifiants à la connexion
	public static String verifConnexion(String login, String mdp) {
		try {
			Connection con = AccesBd.getInstance();
			String query = "SELECT login, mdp, utilisateur.idrole, role.libelle FROM utilisateur "
					+ "INNER JOIN role ON utilisateur.idrole = role.idrole "
					+ "WHERE utilisateur.login = ? AND utilisateur.mdp = ?;";
			PreparedStatement requete = con.prepareStatement(query);
			requete.setString(1, login);
			requete.setString(2, mdp);
			ResultSet resultat = requete.executeQuery();
			
			if (resultat.next()) {
				roleConnecte = resultat.getString("idrole");
				return roleConnecte;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Récupère le libellé d'une région en base à partir de sa clé étrangère idRegion
	public static String getLibelleRegion(int idRegion) {
		if (idRegion <= 0) {
			return "-";
		}
		try {
			Connection con = AccesBd.getInstance();
			String query = "SELECT libelleRegion FROM region WHERE idRegion = ?;";
			PreparedStatement requete = con.prepareStatement(query);
			requete.setInt(1, idRegion);
			ResultSet resultat = requete.executeQuery();

			if (resultat.next()) {
				return resultat.getString("libelleRegion");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "-";
	}

	// Construit un objet utilisateur à partir d'une ligne SQL
	private static utilisateur creerVisiteur(ResultSet resultat) throws SQLException {
		Date sqlDate = resultat.getDate("dateEmbauche");
		LocalDate dateEmb = (sqlDate != null) ? sqlDate.toLocalDate() : null;

		return new utilisateur(
			resultat.getString("idutilisateur"),
			resultat.getString("nom"),
			resultat.getString("prenom"),
			resultat.getString("login"),
			resultat.getString("mdp"),
			resultat.getString("adresse"),
			resultat.getInt("cp"),
			resultat.getString("ville"),
			dateEmb,
			resultat.getString("idrole"),
			resultat.getInt("telfixe"),
			resultat.getInt("telportable"),
			resultat.getString("mailPro"),
			resultat.getInt("idRegion")
		);
	}

	// 1. Recherche par libellé de région saisi dans txtRegion
	public static ArrayList<utilisateur> rechercherParRegion(String libelleRegion) {
		ArrayList<utilisateur> lesVisiteurs = new ArrayList<utilisateur>();
		try {
			Connection con = AccesBd.getInstance();
			String query = "SELECT utilisateur.* FROM utilisateur "
					+ "INNER JOIN role ON utilisateur.idrole = role.idrole "
					+ "INNER JOIN region ON utilisateur.idRegion = region.idRegion "
					+ "WHERE region.libelleRegion LIKE ? AND LOWER(role.libelle) LIKE 'visiteur%' "
					+ "ORDER BY utilisateur.nom, utilisateur.prenom;";
			PreparedStatement requete = con.prepareStatement(query);
			requete.setString(1, libelleRegion + "%");
			ResultSet resultat = requete.executeQuery();

			while (resultat.next()) {
				lesVisiteurs.add(creerVisiteur(resultat));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lesVisiteurs;
	}

	// 2. Recherche par nom et/ou prénom saisis dans txtNom et txtPrenom
	public static ArrayList<utilisateur> rechercherParNomPrenom(String nom, String prenom) {
		ArrayList<utilisateur> lesVisiteurs = new ArrayList<utilisateur>();
		try {
			Connection con = AccesBd.getInstance();
			String query = "SELECT utilisateur.* FROM utilisateur "
					+ "INNER JOIN role ON utilisateur.idrole = role.idrole "
					+ "WHERE utilisateur.nom LIKE ? AND utilisateur.prenom LIKE ? AND LOWER(role.libelle) LIKE 'visiteur%' "
					+ "ORDER BY utilisateur.nom, utilisateur.prenom;";
			PreparedStatement requete = con.prepareStatement(query);
			requete.setString(1, nom + "%");
			requete.setString(2, prenom + "%");
			ResultSet resultat = requete.executeQuery();

			while (resultat.next()) {
				lesVisiteurs.add(creerVisiteur(resultat));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lesVisiteurs;
	}

	// 3. Recherche par identifiant saisi dans txtIdentifiant
	public static utilisateur rechercherParId(String id) {
		try {
			Connection con = AccesBd.getInstance();
			String query = "SELECT utilisateur.* FROM utilisateur "
					+ "INNER JOIN role ON utilisateur.idrole = role.idrole "
					+ "WHERE utilisateur.idutilisateur = ? AND LOWER(role.libelle) LIKE 'visiteur%';";
			PreparedStatement requete = con.prepareStatement(query);
			requete.setString(1, id);
			ResultSet resultat = requete.executeQuery();

			if (resultat.next()) {
				return creerVisiteur(resultat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}