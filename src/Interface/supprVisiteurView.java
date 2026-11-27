package Interface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class supprVisiteurView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIdentifiant;
	private JLabel lblValNom;
	private JLabel lblValPrenom;
	private JLabel lblValRegion;
	private JLabel lblValVille;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					supprVisiteurView frame = new supprVisiteurView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public supprVisiteurView() {
		setTitle("GSB - Supprimer un visiteur");
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

		JLabel lblTitre = new JLabel("GSB – Suppression");
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

		// Recherche par identifiant
		JLabel lblIdentifiant = new JLabel("Identifiant");
		lblIdentifiant.setForeground(new Color(80, 90, 100));
		lblIdentifiant.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblIdentifiant.setBounds(16, 16, 120, 16);
		panelMain.add(lblIdentifiant);

		txtIdentifiant = new JTextField();
		txtIdentifiant.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtIdentifiant.setBounds(16, 34, 245, 32);
		panelMain.add(txtIdentifiant);
		txtIdentifiant.setColumns(10);

		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.setForeground(Color.WHITE);
		btnRechercher.setBackground(new Color(29, 91, 158));
		btnRechercher.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnRechercher.setFocusPainted(false);
		btnRechercher.setBounds(276, 34, 135, 32);
		panelMain.add(btnRechercher);

		// Encadré récapitulatif du visiteur trouvé
		JPanel panelInfos = new JPanel();
		panelInfos.setBorder(new LineBorder(new Color(180, 190, 200)));
		panelInfos.setBackground(new Color(245, 247, 249));
		panelInfos.setBounds(16, 86, 582, 125);
		panelMain.add(panelInfos);
		panelInfos.setLayout(null);

		// Ligne 1 : Nom / Prénom / Région
		JLabel lblTitreNom = new JLabel("Nom");
		lblTitreNom.setForeground(new Color(100, 110, 120));
		lblTitreNom.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblTitreNom.setBounds(16, 14, 100, 14);
		panelInfos.add(lblTitreNom);

		lblValNom = new JLabel("");
		lblValNom.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblValNom.setBounds(16, 32, 160, 16);
		panelInfos.add(lblValNom);

		JLabel lblTitrePrenom = new JLabel("Prénom");
		lblTitrePrenom.setForeground(new Color(100, 110, 120));
		lblTitrePrenom.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblTitrePrenom.setBounds(205, 14, 100, 14);
		panelInfos.add(lblTitrePrenom);

		lblValPrenom = new JLabel("");
		lblValPrenom.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblValPrenom.setBounds(205, 32, 160, 16);
		panelInfos.add(lblValPrenom);

		JLabel lblTitreRegion = new JLabel("Région");
		lblTitreRegion.setForeground(new Color(100, 110, 120));
		lblTitreRegion.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblTitreRegion.setBounds(395, 14, 100, 14);
		panelInfos.add(lblTitreRegion);

		lblValRegion = new JLabel("");
		lblValRegion.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblValRegion.setBounds(395, 32, 170, 16);
		panelInfos.add(lblValRegion);

		// Ligne 2 : Ville
		JLabel lblTitreVille = new JLabel("Ville");
		lblTitreVille.setForeground(new Color(100, 110, 120));
		lblTitreVille.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblTitreVille.setBounds(16, 66, 100, 14);
		panelInfos.add(lblTitreVille);

		lblValVille = new JLabel("");
		lblValVille.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblValVille.setBounds(16, 84, 175, 16);
		panelInfos.add(lblValVille);

		// Mention règle de gestion
		JLabel lblCondition = new JLabel("Suppression possible uniquement si toutes les fiches de frais sont remboursées.");
		lblCondition.setForeground(new Color(70, 80, 90));
		lblCondition.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblCondition.setBounds(16, 228, 560, 20);
		panelMain.add(lblCondition);

		// Bouton de confirmation rouge
		JButton btnSupprimerAction = new JButton("Supprimer");
		btnSupprimerAction.setForeground(Color.WHITE);
		btnSupprimerAction.setBackground(new Color(176, 30, 22));
		btnSupprimerAction.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnSupprimerAction.setFocusPainted(false);
		btnSupprimerAction.setBounds(468, 308, 130, 34);
		panelMain.add(btnSupprimerAction);

		// --- Barre de navigation en bas ---
		JPanel panelFooter = new JPanel();
		panelFooter.setBorder(new LineBorder(new Color(140, 150, 160)));
		panelFooter.setBackground(new Color(235, 239, 243));
		panelFooter.setBounds(10, 402, 614, 52);
		contentPane.add(panelFooter);
		panelFooter.setLayout(null);

		JButton btnConsulter = new JButton("Consulter");
		btnConsulter.setForeground(new Color(30, 40, 50));
		btnConsulter.setBackground(new Color(245, 247, 249));
		btnConsulter.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnConsulter.setFocusPainted(false);
		btnConsulter.setBounds(14, 10, 138, 32);
		panelFooter.add(btnConsulter);

		JButton btnNouveau = new JButton("Nouveau visiteur");
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
		btnSupprimer.setForeground(Color.WHITE);
		btnSupprimer.setBackground(new Color(29, 91, 158));
		btnSupprimer.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnSupprimer.setFocusPainted(false);
		btnSupprimer.setBounds(461, 10, 138, 32);
		panelFooter.add(btnSupprimer);
	}
}