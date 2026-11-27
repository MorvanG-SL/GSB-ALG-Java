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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class statsParVisiteurView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> comboRegion;
	private JComboBox<String> comboMois;
	private JTable tableStats;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					statsParVisiteurView frame = new statsParVisiteurView();
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
	public statsParVisiteurView() {
		setTitle("GSB - Statistiques par visiteur");
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

		JLabel lblTitre = new JLabel("GSB – Statistiques");
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

		// Filtres : Région et Mois
		JLabel lblRegion = new JLabel("Région");
		lblRegion.setForeground(new Color(80, 90, 100));
		lblRegion.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblRegion.setBounds(16, 18, 120, 16);
		panelMain.add(lblRegion);

		comboRegion = new JComboBox<String>();
		comboRegion.setBackground(Color.WHITE);
		comboRegion.setFont(new Font("SansSerif", Font.PLAIN, 12));
		comboRegion.setModel(new DefaultComboBoxModel<String>(new String[] {
			"Bretagne", "Normandie", "Île-de-France", "Auvergne-Rhône-Alpes", "Occitanie"
		}));
		comboRegion.setBounds(16, 36, 220, 32);
		panelMain.add(comboRegion);

		JLabel lblMois = new JLabel("Mois");
		lblMois.setForeground(new Color(80, 90, 100));
		lblMois.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblMois.setBounds(252, 18, 120, 16);
		panelMain.add(lblMois);

		comboMois = new JComboBox<String>();
		comboMois.setBackground(Color.WHITE);
		comboMois.setFont(new Font("SansSerif", Font.PLAIN, 12));
		comboMois.setModel(new DefaultComboBoxModel<String>(new String[] {
			"Octobre 2026", "Septembre 2026", "Août 2026", "Juillet 2026"
		}));
		comboMois.setBounds(252, 36, 220, 32);
		panelMain.add(comboMois);

		// Tableau des statistiques
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 86, 582, 125);
		panelMain.add(scrollPane);

		tableStats = new JTable();
		tableStats.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableStats.setRowHeight(28);
		tableStats.setFont(new Font("SansSerif", Font.PLAIN, 12));
		tableStats.setSelectionBackground(new Color(224, 235, 248));
		tableStats.setSelectionForeground(Color.BLACK);
		tableStats.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
		tableStats.getTableHeader().setBackground(new Color(217, 225, 232));
		tableStats.setModel(new DefaultTableModel(
			new Object[][] {
				{"Garnier", "Hugo", 2, "148,00 €", "812,50 €"},
				{"Lemoine", "Camille", 0, "0,00 €", "756,00 €"},
				{"Roussel", "Inès", 4, "352,40 €", "904,25 €"},
			},
			new String[] {
				"Nom", "Prénom", "Nb hors forfait", "Hors forfait", "Forfait"
			}
		) {
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});

		// Alignement à droite des colonnes numériques (colonnes 2, 3 et 4)
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
		for (int i = 2; i < tableStats.getColumnCount(); i++) {
			tableStats.getColumnModel().getColumn(i).setCellRenderer(rightRenderer);
		}

		scrollPane.setViewportView(tableStats);

		// Mention d'information
		JLabel lblInfoMois = new JLabel("Le mois en cours n'est pas proposé.");
		lblInfoMois.setForeground(new Color(70, 80, 90));
		lblInfoMois.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblInfoMois.setBounds(16, 265, 350, 20);
		panelMain.add(lblInfoMois);

		// --- Barre de navigation en bas ---
		JPanel panelFooter = new JPanel();
		panelFooter.setBorder(new LineBorder(new Color(140, 150, 160)));
		panelFooter.setBackground(new Color(235, 239, 243));
		panelFooter.setBounds(10, 402, 614, 52);
		contentPane.add(panelFooter);
		panelFooter.setLayout(null);

		JButton btnParVisiteur = new JButton("Par visiteur");
		btnParVisiteur.setForeground(Color.WHITE);
		btnParVisiteur.setBackground(new Color(29, 91, 158));
		btnParVisiteur.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnParVisiteur.setFocusPainted(false);
		btnParVisiteur.setBounds(16, 10, 175, 32);
		panelFooter.add(btnParVisiteur);

		JButton btnParRegion = new JButton("Par région");
		btnParRegion.setForeground(new Color(30, 40, 50));
		btnParRegion.setBackground(new Color(245, 247, 249));
		btnParRegion.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnParRegion.setFocusPainted(false);
		btnParRegion.setBounds(202, 10, 175, 32);
		panelFooter.add(btnParRegion);
	}
}