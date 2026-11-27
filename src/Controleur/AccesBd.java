package Controleur;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesBd {



	//classe permettant l'ouverture, la fermeture de la base 
		
		public static void main(String[] args) {
			
		}
		
		// description des propriétés
		protected  static Connection con=null;
		public static Connection  getInstance() {
					
			if (con==null)
			{
				try
				{// chargement du driver, librairie mysql connector liée au projet
					Class.forName("com.mysql.jdbc.Driver");
					// connexion utilisateur root ou changer avec votre code utilisateur
					con=DriverManager.getConnection(Parametre.getUrl(),"root","");
					
				
				}
				// ouverture de la connexion
				catch (ClassNotFoundException e)
				{
					System.out.println(e.getMessage());
					System.out.println("échec driver");
				}
				catch (SQLException e)
				{
					System.out.println(e.getMessage());
					System.out.println("échec de connexion bd ");
				}
			}
			return con;
		}
		//	 fermeture de la connexion
		public static void close(){
			try { 
				con.close();
			}
			catch(Exception e) {e.printStackTrace();
			System.out.println("problème lors de la fermeture");}
		}
}
