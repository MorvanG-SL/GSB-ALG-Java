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

public class modifVisiteurView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtRechercheNom;
	private JTextField txtRecherchePrenom;
	private JTextField txtAdresse;
	private JTextField txtTelephone;
	private JComboBox<String> comboRegion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modifVisiteurView frame = new modifVisiteurView();
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
	public modifVisiteurView() {
		setTitle("GSB - Modifier un visiteur");
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

		JLabel lblTitre = new JLabel("GSB – Modification");
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

		// Barre de recherche (Nom + Prénom + Rechercher)
		JLabel lblNom = new JLabel("Nom");
		lblNom.setForeground(new Color(80, 90, 100));
		lblNom.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblNom.setBounds(16, 16, 120, 16);
		panelMain.add(lblNom);

		txtRechercheNom = new JTextField();
		txtRechercheNom.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtRechercheNom.setBounds(16, 34, 195, 32);
		panelMain.add(txtRechercheNom);
		txtRechercheNom.setColumns(10);

		JLabel lblPrenom = new JLabel("Prénom");
		lblPrenom.setForeground(new Color(80, 90, 100));
		lblPrenom.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblPrenom.setBounds(226, 16, 120, 16);
		panelMain.add(lblPrenom);

		txtRecherchePrenom = new JTextField();
		txtRecherchePrenom.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtRecherchePrenom.setBounds(226, 34, 195, 32);
		panelMain.add(txtRecherchePrenom);
		txtRecherchePrenom.setColumns(10);

		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.setForeground(Color.WHITE);
		btnRechercher.setBackground(new Color(29, 91, 158));
		btnRechercher.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnRechercher.setFocusPainted(false);
		btnRechercher.setBounds(438, 34, 140, 32);
		panelMain.add(btnRechercher);

		// Encadré des champs modifiables
		JPanel panelEdition = new JPanel();
		panelEdition.setBorder(new LineBorder(new Color(180, 190, 200)));
		panelEdition.setBackground(new Color(245, 247, 249));
		panelEdition.setBounds(16, 86, 582, 185);
		panelMain.add(panelEdition);
		panelEdition.setLayout(null);

		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setForeground(new Color(80, 90, 100));
		lblAdresse.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblAdresse.setBounds(16, 16, 120, 16);
		panelEdition.add(lblAdresse);

		txtAdresse = new JTextField();
		txtAdresse.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtAdresse.setBounds(16, 34, 265, 32);
		panelEdition.add(txtAdresse);
		txtAdresse.setColumns(10);

		JLabel lblTelephone = new JLabel("Téléphone");
		lblTelephone.setForeground(new Color(80, 90, 100));
		lblTelephone.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblTelephone.setBounds(300, 16, 120, 16);
		panelEdition.add(lblTelephone);

		txtTelephone = new JTextField();
		txtTelephone.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtTelephone.setBounds(300, 34, 265, 32);
		panelEdition.add(txtTelephone);
		txtTelephone.setColumns(10);

		JLabel lblRegion = new JLabel("Région d'affectation");
		lblRegion.setForeground(new Color(80, 90, 100));
		lblRegion.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblRegion.setBounds(16, 86, 160, 16);
		panelEdition.add(lblRegion);

		comboRegion = new JComboBox<String>();
		comboRegion.setBackground(Color.WHITE);
		comboRegion.setFont(new Font("SansSerif", Font.PLAIN, 12));
		comboRegion.setModel(new DefaultComboBoxModel<String>(new String[] {
			"Bretagne", "Normandie", "Île-de-France", "Auvergne-Rhône-Alpes", "Occitanie"
		}));
		comboRegion.setBounds(16, 104, 265, 32);
		panelEdition.add(comboRegion);

		// Bouton Valider
		JButton btnValider = new JButton("Valider");
		btnValider.setForeground(Color.WHITE);
		btnValider.setBackground(new Color(29, 91, 158));
		btnValider.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnValider.setFocusPainted(false);
		btnValider.setBounds(480, 308, 118, 34);
		panelMain.add(btnValider);

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
		btnModifier.setForeground(Color.WHITE);
		btnModifier.setBackground(new Color(29, 91, 158));
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