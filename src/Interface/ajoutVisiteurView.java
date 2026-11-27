package Interface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class ajoutVisiteurView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtDateEmbauche;
	private JComboBox<String> comboRegion;
	private JTextField txtAdresse;
	private JTextField txtTelephone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ajoutVisiteurView frame = new ajoutVisiteurView();
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
	public ajoutVisiteurView() {
		setTitle("GSB - Enregistrer un nouveau visiteur");
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

		JLabel lblTitre = new JLabel("GSB – Nouveau visiteur");
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

		// Ligne 1 : Nom / Prénom
		JLabel lblNom = new JLabel("Nom");
		lblNom.setForeground(new Color(80, 90, 100));
		lblNom.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblNom.setBounds(18, 18, 120, 16);
		panelMain.add(lblNom);

		txtNom = new JTextField();
		txtNom.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtNom.setBounds(18, 36, 275, 32);
		panelMain.add(txtNom);
		txtNom.setColumns(10);

		JLabel lblPrenom = new JLabel("Prénom");
		lblPrenom.setForeground(new Color(80, 90, 100));
		lblPrenom.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblPrenom.setBounds(321, 18, 120, 16);
		panelMain.add(lblPrenom);

		txtPrenom = new JTextField();
		txtPrenom.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtPrenom.setBounds(321, 36, 275, 32);
		panelMain.add(txtPrenom);
		txtPrenom.setColumns(10);

		// Ligne 2 : Date d'embauche / Région
		JLabel lblDateEmbauche = new JLabel("Date d'embauche");
		lblDateEmbauche.setForeground(new Color(80, 90, 100));
		lblDateEmbauche.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblDateEmbauche.setBounds(18, 82, 150, 16);
		panelMain.add(lblDateEmbauche);

		txtDateEmbauche = new JTextField();
		txtDateEmbauche.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtDateEmbauche.setBounds(18, 100, 275, 32);
		panelMain.add(txtDateEmbauche);
		txtDateEmbauche.setColumns(10);

		JLabel lblRegion = new JLabel("Région");
		lblRegion.setForeground(new Color(80, 90, 100));
		lblRegion.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblRegion.setBounds(321, 82, 120, 16);
		panelMain.add(lblRegion);

		comboRegion = new JComboBox<String>();
		comboRegion.setBackground(Color.WHITE);
		comboRegion.setFont(new Font("SansSerif", Font.PLAIN, 12));
		comboRegion.setModel(new DefaultComboBoxModel<String>(new String[] {
			"Bretagne", "Normandie", "Île-de-France", "Auvergne-Rhône-Alpes", "Occitanie"
		}));
		comboRegion.setBounds(321, 100, 275, 32);
		panelMain.add(comboRegion);

		// Ligne 3 : Adresse / Téléphone
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setForeground(new Color(80, 90, 100));
		lblAdresse.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblAdresse.setBounds(18, 146, 120, 16);
		panelMain.add(lblAdresse);

		txtAdresse = new JTextField();
		txtAdresse.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtAdresse.setBounds(18, 164, 275, 32);
		panelMain.add(txtAdresse);
		txtAdresse.setColumns(10);

		JLabel lblTelephone = new JLabel("Téléphone");
		lblTelephone.setForeground(new Color(80, 90, 100));
		lblTelephone.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblTelephone.setBounds(321, 146, 120, 16);
		panelMain.add(lblTelephone);

		txtTelephone = new JTextField();
		txtTelephone.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtTelephone.setBounds(321, 164, 275, 32);
		panelMain.add(txtTelephone);
		txtTelephone.setColumns(10);

		// Mention génération automatique
		JLabel lblInfoAuto = new JLabel("Login, mot de passe et mail (nom.prenom@gsb.fr) générés automatiquement.");
		lblInfoAuto.setForeground(new Color(70, 80, 90));
		lblInfoAuto.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblInfoAuto.setBounds(18, 222, 550, 20);
		panelMain.add(lblInfoAuto);

		// Boutons du formulaire (Effacer / Enregistrer)
		JButton btnEffacer = new JButton("Effacer");
		btnEffacer.setForeground(new Color(30, 40, 50));
		btnEffacer.setBackground(new Color(245, 247, 249));
		btnEffacer.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnEffacer.setFocusPainted(false);
		btnEffacer.setBounds(368, 308, 108, 34);
		panelMain.add(btnEffacer);

		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.setForeground(Color.WHITE);
		btnEnregistrer.setBackground(new Color(29, 91, 158));
		btnEnregistrer.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnEnregistrer.setFocusPainted(false);
		btnEnregistrer.setBounds(488, 308, 108, 34);
		panelMain.add(btnEnregistrer);

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
		btnNouveau.setForeground(Color.WHITE);
		btnNouveau.setBackground(new Color(29, 91, 158));
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
	}
}