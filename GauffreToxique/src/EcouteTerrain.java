import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class EcouteTerrain implements MouseListener {
	Jeu moteur;
	Dessin aireGraphique;
	
	// Ecouteur de souris a besoin de connaitre l'aire de dessin car elle doit
	// changer le message que celle ci affiche
	public EcouteTerrain(Jeu referenceMoteur, Dessin referenceGraphique) {
		moteur = referenceMoteur;
		aireGraphique = referenceGraphique;
	}

	// Lors d'une pression de bouton, on change de message
	public void mousePressed(MouseEvent e) {
		
		int x = e.getX()/Constantes.tailleCase;
		int y = e.getY()/Constantes.tailleCase;
		
		System.out.println("x : " + x + " et y = " + y);
    	
    	//On met à faux toutes les cases en dessous de celle cliquée
		moteur.getGauffre().updatePlateau(new Point(x, y));
    	aireGraphique.repaint();
    }

    // Il faut aussi une implementation pour les autres methodes de l'interface
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
}