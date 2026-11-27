package Interface;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class loginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginView frame = new loginView();
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
	public loginView() {
		setTitle("Connexion");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 360);
		setLocationRelativeTo(null); // Centre la fenêtre sur l'écran

		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 247, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Titre principal
		JLabel lblTitle = new JLabel("Bienvenue");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblTitle.setForeground(new Color(33, 37, 41));
		lblTitle.setBounds(50, 25, 300, 35);
		contentPane.add(lblTitle);

		JLabel lblSubtitle = new JLabel("Connectez-vous à votre compte");
		lblSubtitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtitle.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblSubtitle.setForeground(new Color(108, 117, 125));
		lblSubtitle.setBounds(50, 60, 300, 20);
		contentPane.add(lblSubtitle);

		// Champ Identifiant / Email
		JLabel lblUser = new JLabel("Nom d'utilisateur");
		lblUser.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblUser.setForeground(new Color(52, 58, 64));
		lblUser.setBounds(50, 95, 300, 20);
		contentPane.add(lblUser);

		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtUsername.setBorder(new LineBorder(new Color(206, 212, 218), 1, true));
		txtUsername.setBounds(50, 118, 300, 35);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);

		// Champ Mot de passe
		JLabel lblPass = new JLabel("Mot de passe");
		lblPass.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblPass.setForeground(new Color(52, 58, 64));
		lblPass.setBounds(50, 165, 300, 20);
		contentPane.add(lblPass);

		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtPassword.setBorder(new LineBorder(new Color(206, 212, 218), 1, true));
		txtPassword.setBounds(50, 188, 300, 35);
		contentPane.add(txtPassword);

		// Case à cocher pour afficher le mot de passe
		JCheckBox chkShowPassword = new JCheckBox("Afficher le mot de passe");
		chkShowPassword.setBackground(new Color(245, 247, 250));
		chkShowPassword.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		chkShowPassword.setForeground(new Color(73, 80, 87));
		chkShowPassword.setBounds(50, 230, 180, 23);
		chkShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkShowPassword.isSelected()) {
					txtPassword.setEchoChar((char) 0); // Affiche le texte
				} else {
					txtPassword.setEchoChar('•'); // Masque le texte
				}
			}
		});
		contentPane.add(chkShowPassword);

		// Bouton Se connecter
		JButton btnLogin = new JButton("Se connecter");
		btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(new Color(13, 110, 253));
		btnLogin.setFocusPainted(false);
		btnLogin.setBorderPainted(false);
		btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnLogin.setBounds(50, 268, 300, 38);
		
		// Permet de valider avec la touche Entrée
		getRootPane().setDefaultButton(btnLogin);

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				authentifier();
			}
		});
		contentPane.add(btnLogin);
	}

	/**
	 * Méthode de vérification des identifiants
	 */
	private void authentifier() {
		String user = txtUsername.getText().trim();
		String pass = new String(txtPassword.getPassword());

		if (user.isEmpty() || pass.isEmpty()) {
			JOptionPane.showMessageDialog(this, 
				"Veuillez remplir tous les champs.", 
				"Champs manquants", 
				JOptionPane.WARNING_MESSAGE);
			return;
		}

		// Exemple de vérification (à remplacer par ta requête SQL / DAO)
		if (user.equals("admin") && pass.equals("1234")) {
			JOptionPane.showMessageDialog(this, 
				"Connexion réussie !", 
				"Succès", 
				JOptionPane.INFORMATION_MESSAGE);
			// Exemple pour ouvrir la fenêtre suivante :
			// new DashboardView().setVisible(true);
			// this.dispose();
		} else {
			JOptionPane.showMessageDialog(this, 
				"Identifiant ou mot de passe incorrect.", 
				"Erreur de connexion", 
				JOptionPane.ERROR_MESSAGE);
		}
	}
}