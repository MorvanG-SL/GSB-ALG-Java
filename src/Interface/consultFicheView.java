package Interface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Controleur.utilisateur;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class consultFicheView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable tableVisiteurs;

	private JRadioButton rdbtnParRegion;
	private JRadioButton rdbtnParNomPrenom;
	private JRadioButton rdbtnParIdentifiant;

	// 2 champs réutilisables (aucune superposition dans WindowBuilder)
	private JLabel lblCritere1;
	private JTextField txtCritere1;
	private JLabel lblCritere2;
	private JTextField txtCritere2;

	private JLabel lblValNom;
	private JLabel lblValPrenom;
	private JLabel lblValRegion;
	private JLabel lblValAdresse;
	private JLabel lblValTelephone;
	private JLabel lblValMail;

	private ArrayList<utilisateur> lesVisiteurs = new ArrayList<utilisateur>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					consultFicheView frame = new consultFicheView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public consultFicheView() {
		setTitle("GSB - Consulter une fiche visiteur");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 505);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// --- Barre d'en-tête ---
		JPanel panelHeader = new JPanel();
		panelHeader.setBorder(new LineBorder(new Color(140, 150, 160)));
		panelHeader.setBackground(new Color(217, 225, 232));
		panelHeader.setBounds(10, 10, 614, 34);
		contentPane.add(panelHeader);
		panelHeader.setLayout(null);

		JLabel lblTitre = new JLabel("GSB – Consultation");
		lblTitre.setForeground(new Color(30, 40, 50));
		lblTitre.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblTitre.setBounds(12, 7, 250, 20);
		panelHeader.add(lblTitre);

		// --- Zone principale ---
		JPanel panelMain = new JPanel();
		panelMain.setBorder(new LineBorder(new Color(140, 150, 160)));
		panelMain.setBackground(Color.WHITE);
		panelMain.setBounds(10, 43, 614, 360);
		contentPane.add(panelMain);
		panelMain.setLayout(null);

		// Boutons radio
		rdbtnParRegion = new JRadioButton("Par région");
		rdbtnParRegion.setSelected(true);
		rdbtnParRegion.setBackground(Color.WHITE);
		rdbtnParRegion.setFont(new Font("SansSerif", Font.PLAIN, 12));
		buttonGroup.add(rdbtnParRegion);
		rdbtnParRegion.setBounds(15, 12, 110, 23);
		panelMain.add(rdbtnParRegion);

		rdbtnParNomPrenom = new JRadioButton("Par nom et prénom");
		rdbtnParNomPrenom.setBackground(Color.WHITE);
		rdbtnParNomPrenom.setFont(new Font("SansSerif", Font.PLAIN, 12));
		buttonGroup.add(rdbtnParNomPrenom);
		rdbtnParNomPrenom.setBounds(160, 12, 150, 23);
		panelMain.add(rdbtnParNomPrenom);

		rdbtnParIdentifiant = new JRadioButton("Par identifiant");
		rdbtnParIdentifiant.setBackground(Color.WHITE);
		rdbtnParIdentifiant.setFont(new Font("SansSerif", Font.PLAIN, 12));
		buttonGroup.add(rdbtnParIdentifiant);
		rdbtnParIdentifiant.setBounds(350, 12, 130, 23);
		panelMain.add(rdbtnParIdentifiant);

		// Champ principal (Région / Nom / Identifiant)
		lblCritere1 = new JLabel("Région");
		lblCritere1.setForeground(new Color(80, 90, 100));
		lblCritere1.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblCritere1.setBounds(15, 42, 100, 16);
		panelMain.add(lblCritere1);

		txtCritere1 = new JTextField();
		txtCritere1.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtCritere1.setBounds(15, 60, 235, 30);
		panelMain.add(txtCritere1);

		// Second champ (uniquement utilisé pour Prénom en mode Nom + Prénom)
		lblCritere2 = new JLabel("Prénom");
		lblCritere2.setForeground(new Color(80, 90, 100));
		lblCritere2.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblCritere2.setBounds(138, 42, 100, 16);
		lblCritere2.setVisible(false);
		panelMain.add(lblCritere2);

		txtCritere2 = new JTextField();
		txtCritere2.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtCritere2.setBounds(138, 60, 112, 30);
		txtCritere2.setVisible(false);
		panelMain.add(txtCritere2);

		// Bouton Rechercher
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.setForeground(Color.WHITE);
		btnRechercher.setBackground(new Color(29, 91, 158));
		btnRechercher.setOpaque(true);
		btnRechercher.setBorderPainted(false);
		btnRechercher.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnRechercher.setFocusPainted(false);
		btnRechercher.setBounds(265, 60, 135, 30);
		panelMain.add(btnRechercher);

		// Tableau des visiteurs
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 102, 584, 112);
		panelMain.add(scrollPane);

		tableVisiteurs = new JTable();
		tableVisiteurs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableVisiteurs.setRowHeight(26);
		tableVisiteurs.setFont(new Font("SansSerif", Font.PLAIN, 12));
		tableVisiteurs.setSelectionBackground(new Color(224, 235, 248));
		tableVisiteurs.setSelectionForeground(Color.BLACK);
		tableVisiteurs.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
		tableVisiteurs.getTableHeader().setBackground(new Color(217, 225, 232));
		tableVisiteurs.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] { "Identifiant", "Nom", "Prénom" }
		) {
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		scrollPane.setViewportView(tableVisiteurs);

		// Encadré "Fiche visiteur"
		JPanel panelFiche = new JPanel();
		panelFiche.setBorder(new LineBorder(new Color(180, 190, 200)));
		panelFiche.setBackground(new Color(245, 247, 249));
		panelFiche.setBounds(15, 225, 584, 123);
		panelMain.add(panelFiche);
		panelFiche.setLayout(null);

		JLabel lblFicheTitre = new JLabel("Fiche visiteur");
		lblFicheTitre.setForeground(new Color(30, 40, 50));
		lblFicheTitre.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblFicheTitre.setBounds(14, 10, 150, 16);
		panelFiche.add(lblFicheTitre);

		JLabel lblTitreNom = new JLabel("Nom");
		lblTitreNom.setForeground(new Color(100, 110, 120));
		lblTitreNom.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblTitreNom.setBounds(14, 34, 100, 14);
		panelFiche.add(lblTitreNom);

		lblValNom = new JLabel("-");
		lblValNom.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblValNom.setBounds(14, 50, 160, 16);
		panelFiche.add(lblValNom);

		JLabel lblTitrePrenom = new JLabel("Prénom");
		lblTitrePrenom.setForeground(new Color(100, 110, 120));
		lblTitrePrenom.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblTitrePrenom.setBounds(200, 34, 100, 14);
		panelFiche.add(lblTitrePrenom);

		lblValPrenom = new JLabel("-");
		lblValPrenom.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblValPrenom.setBounds(200, 50, 160, 16);
		panelFiche.add(lblValPrenom);

		JLabel lblTitreRegion = new JLabel("Région");
		lblTitreRegion.setForeground(new Color(100, 110, 120));
		lblTitreRegion.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblTitreRegion.setBounds(390, 34, 100, 14);
		panelFiche.add(lblTitreRegion);

		lblValRegion = new JLabel("-");
		lblValRegion.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblValRegion.setBounds(390, 50, 170, 16);
		panelFiche.add(lblValRegion);

		JLabel lblTitreAdresse = new JLabel("Adresse");
		lblTitreAdresse.setForeground(new Color(100, 110, 120));
		lblTitreAdresse.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblTitreAdresse.setBounds(14, 76, 100, 14);
		panelFiche.add(lblTitreAdresse);

		lblValAdresse = new JLabel("-");
		lblValAdresse.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblValAdresse.setBounds(14, 92, 175, 16);
		panelFiche.add(lblValAdresse);

		JLabel lblTitreTelephone = new JLabel("Téléphone");
		lblTitreTelephone.setForeground(new Color(100, 110, 120));
		lblTitreTelephone.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblTitreTelephone.setBounds(200, 76, 100, 14);
		panelFiche.add(lblTitreTelephone);

		lblValTelephone = new JLabel("-");
		lblValTelephone.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblValTelephone.setBounds(200, 92, 160, 16);
		panelFiche.add(lblValTelephone);

		JLabel lblTitreMail = new JLabel("Mail");
		lblTitreMail.setForeground(new Color(100, 110, 120));
		lblTitreMail.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblTitreMail.setBounds(390, 76, 100, 14);
		panelFiche.add(lblTitreMail);

		lblValMail = new JLabel("-");
		lblValMail.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblValMail.setBounds(390, 92, 180, 16);
		panelFiche.add(lblValMail);

		// --- Barre d'actions en bas ---
		JPanel panelFooter = new JPanel();
		panelFooter.setBorder(new LineBorder(new Color(140, 150, 160)));
		panelFooter.setBackground(new Color(235, 239, 243));
		panelFooter.setBounds(10, 402, 614, 52);
		contentPane.add(panelFooter);
		panelFooter.setLayout(null);

		JButton btnConsulter = new JButton("Consulter");
		btnConsulter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
			}
		});
		btnConsulter.setForeground(Color.WHITE);
		btnConsulter.setBackground(new Color(29, 91, 158));
		btnConsulter.setOpaque(true);
		btnConsulter.setBorderPainted(false);
		btnConsulter.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnConsulter.setFocusPainted(false);
		btnConsulter.setBounds(14, 10, 138, 32);
		panelFooter.add(btnConsulter);

		JButton btnNouveau = new JButton("Nouveau visiteur");
		btnNouveau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajoutVisiteurView.main(null);
			}
		});
		btnNouveau.setForeground(new Color(30, 40, 50));
		btnNouveau.setBackground(new Color(245, 247, 249));
		btnNouveau.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNouveau.setFocusPainted(false);
		btnNouveau.setBounds(163, 10, 138, 32);
		panelFooter.add(btnNouveau);

		JButton btnModifier = new JButton("Modifier");
		btnModifier.setForeground(new Color(30, 40, 50));
		btnModifier.setBackground(new Color(245, 247, 249));
		btnModifier.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnModifier.setFocusPainted(false);
		btnModifier.setBounds(312, 10, 138, 32);
		panelFooter.add(btnModifier);

		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setForeground(new Color(30, 40, 50));
		btnSupprimer.setBackground(new Color(245, 247, 249));
		btnSupprimer.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnSupprimer.setFocusPainted(false);
		btnSupprimer.setBounds(461, 10, 138, 32);
		panelFooter.add(btnSupprimer);

		// =========================================================================
		// ÉVÉNEMENTS ET DROITS D'ACCÈS
		// =========================================================================

		if (utilisateur.roleConnecte != null
				&& !utilisateur.roleConnecte.equalsIgnoreCase("secrétaire")
				&& !utilisateur.roleConnecte.equalsIgnoreCase("secretaire")) {
			btnNouveau.setVisible(false);
			btnModifier.setVisible(false);
			btnSupprimer.setVisible(false);
		}

		rdbtnParRegion.addActionListener(e -> basculerModeRecherche("REGION"));
		rdbtnParNomPrenom.addActionListener(e -> basculerModeRecherche("NOM"));
		rdbtnParIdentifiant.addActionListener(e -> basculerModeRecherche("ID"));

		btnRechercher.addActionListener(e -> lancerRecherche());

		tableVisiteurs.getSelectionModel().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				int row = tableVisiteurs.getSelectedRow();
				if (row >= 0 && row < lesVisiteurs.size()) {
					afficherDetailsVisiteur(lesVisiteurs.get(row));
				}
			}
		});
	}

	private void basculerModeRecherche(String mode) {
		txtCritere1.setText("");
		txtCritere2.setText("");

		if (mode.equals("REGION")) {
			lblCritere1.setText("Région");
			txtCritere1.setBounds(15, 60, 235, 30);
			lblCritere2.setVisible(false);
			txtCritere2.setVisible(false);
		} else if (mode.equals("NOM")) {
			lblCritere1.setText("Nom");
			txtCritere1.setBounds(15, 60, 112, 30);
			lblCritere2.setVisible(true);
			txtCritere2.setVisible(true);
		} else if (mode.equals("ID")) {
			lblCritere1.setText("Identifiant");
			txtCritere1.setBounds(15, 60, 235, 30);
			lblCritere2.setVisible(false);
			txtCritere2.setVisible(false);
		}
	}

	private void lancerRecherche() {
		lesVisiteurs.clear();

		if (rdbtnParRegion.isSelected()) {
			String regionSaisie = txtCritere1.getText().trim();
			if (regionSaisie.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Veuillez saisir une région.");
				return;
			}
			lesVisiteurs = utilisateur.rechercherParRegion(regionSaisie);

		} else if (rdbtnParNomPrenom.isSelected()) {
			String nom = txtCritere1.getText().trim();
			String prenom = txtCritere2.getText().trim();
			if (nom.isEmpty() && prenom.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Veuillez saisir un nom ou un prénom.");
				return;
			}
			lesVisiteurs = utilisateur.rechercherParNomPrenom(nom, prenom);

		} else if (rdbtnParIdentifiant.isSelected()) {
			String id = txtCritere1.getText().trim();
			if (id.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Veuillez saisir un identifiant.");
				return;
			}
			utilisateur u = utilisateur.rechercherParId(id);
			if (u != null) {
				lesVisiteurs.add(u);
			}
		}

		DefaultTableModel model = (DefaultTableModel) tableVisiteurs.getModel();
		model.setRowCount(0);

		for (utilisateur u : lesVisiteurs) {
			model.addRow(new Object[] { u.getIdUtilisateur(), u.getNom(), u.getPrenom() });
		}

		if (lesVisiteurs.isEmpty()) {
			viderFicheVisiteur();
			JOptionPane.showMessageDialog(this, "Aucun visiteur trouvé.");
		} else {
			tableVisiteurs.setRowSelectionInterval(0, 0);
			afficherDetailsVisiteur(lesVisiteurs.get(0));
		}
	}

	private void afficherDetailsVisiteur(utilisateur u) {
		lblValNom.setText(u.getNom());
		lblValPrenom.setText(u.getPrenom());
		lblValRegion.setText(utilisateur.getLibelleRegion(u.getIdRegion()));
		lblValAdresse.setText(u.getAdresse() + ", " + u.getVille());

		int numTel = (u.getTelPortable() != 0) ? u.getTelPortable() : u.getTelFixe();
		lblValTelephone.setText(numTel != 0 ? String.format("%010d", numTel) : "-");
		lblValMail.setText(u.getMailPro() != null ? u.getMailPro() : "-");
	}

	private void viderFicheVisiteur() {
		lblValNom.setText("-");
		lblValPrenom.setText("-");
		lblValRegion.setText("-");
		lblValAdresse.setText("-");
		lblValTelephone.setText("-");
		lblValMail.setText("-");
	}
}