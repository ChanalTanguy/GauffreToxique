import java.awt.event.*;

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
    	
    	//On met à faux toutes les cases en dessous de celle cliquée
    	for(int i = x; i<aire.tab.length; i++)
    	{
    		for(int j = y; j<aire.tab[0].length; j++)
    		{
    			aire.tab[i][j] = false;
    		}
    	}
    	    	
    	aire.repaint();
    }

    // Il faut aussi une implementation pour les autres methodes de l'interface
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
}