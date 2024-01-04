//* Nom et prénom: LE Tran Dang Quang
// * Numéro d'étudiant: 21107520
// * Groupe 9

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestSimulation {
    public static void main(String[] args) throws CoordonneesIncorrectesException, IOException {
        Grille t = new Grille(10,10);
        Agent9 agent = new Agent9(0, 0,t);
		Simulation simu = new Simulation(40,agent);

        t.affiche(4); 

        System.out.println("Informations sur la grille:\n"+t);

        // On créé un Contenu en donnant son nom et sa quantité
		Contenu e1 = new Contenu("Cepe",5);
		// tentative de mauvais placement:
		try {
			t.setCase(7,41,e1);
			System.out.println("Ajout de " +e1+" valide !");
		}
		catch (CoordonneesIncorrectesException e) {
			System.out.println("Erreur: "+e.getMessage());
		}


		simu.lance(100);

		File f = new File("description1.docx");
		File fSortie = new File("description.odt");
		FileInputStream in = null;
		FileOutputStream out = null;

		try {
			in = new FileInputStream(f);
			out = new FileOutputStream(fSortie);
			int c = in.read();
			while (c != -1) {
				out.write(c);
				c = in.read();
			}
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		finally{
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
        
    }   
}