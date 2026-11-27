import java.util.HashMap;
public class Parametre {
 	private static String nomFichier = "paramAppli.ini";
  	private static HashMap<String, String> listeChemin = null;
 	public static String getUrl(){  
 		lectureFichier();
 		String valeur = listeChemin.get("urlBD");
 		return valeur;
 	}
 	//public static String getCheminUsagerXML()  {}
 	
  	// chargement fichier texte dans un dictionnaire
  	// on le fera une seule fois
 	private static void lectureFichier() {
  	  // on vérifie la non-existence du dicltionnaire
        if (listeChemin == null) { // instanciation objet FichierTexte
            FichierTexte f = new FichierTexte(); // ouverture du fichier en lecture
            f.openFileReader(nomFichier); // instanciation dictionnaire de stockage
            listeChemin = new HashMap<String, String>();
            String ligne = null;
            // on charge le fichier en ne retenant que les lignes utiles dans un
            // dictionnaire
            while ((ligne = f.readLigne()) != null) {
                String elem[] = ligne.split("=");
                if (elem.length > 1) {
                    listeChemin.put(elem[0], elem[1]);
                }
            }
            f.closeFileReader();
        }
 	}
}
