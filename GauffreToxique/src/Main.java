import javax.swing.JFrame;


public class Main {
	public static void main (String[] args){
		int lignes = Integer.parseInt(args[0]);
		int colonnes = Integer.parseInt(args[1]);
		
		Jeu moteur = new Jeu (lignes, colonnes);
		Dessin zoneGraphique = new Dessin (moteur.getGauffre());
		zoneGraphique.addMouseListener( new EcouteTerrain (moteur, zoneGraphique) );
		
		// Creation d'une fenetre
		JFrame frame = new JFrame("Blue Waffle");
		
		// Ajout de notre composant de dessin dans la fenetre
		frame.add(zoneGraphique);
		
		// Un clic sur le bouton de fermeture clos l'application
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int tailleBordure = 25;
		
		// On fixe la taille et on demarre
		frame.setSize(lignes*Constantes.tailleCase, colonnes*Constantes.tailleCase + tailleBordure );
		frame.setResizable(false);
		frame.setVisible(true);
		
	}
}
