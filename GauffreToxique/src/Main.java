import javax.swing.SwingUtilities;


public class Main implements Runnable {

	public void run()
	{
		//boolean [][]tab = new boolean[5][5];
		Plateau plateau = new Plateau(5,5);
		
		//Pour deux joueurs simplement
		//Graphique g = new Graphique(plateau);
		
		//Pour 1 joueur + une IA facile
		//Graphique g = new Graphique(plateau, new IAFacile(plateau));
		
		//Pour 1 joueur + une IA moyenne
		//Graphique g = new Graphique(plateau, new IAMoyenne(plateau));
		
		//Pour 1 joueur + une IA difficile
		//Graphique g = new Graphique(plateau, new IADifficile(plateau));
		
		//Pour 2 IA
		Graphique g = new Graphique(plateau, new IAMoyenne(plateau), new IAFacile(plateau));
    }

    public static void main(String [] args) {
        SwingUtilities.invokeLater(new Main());
    }
}
