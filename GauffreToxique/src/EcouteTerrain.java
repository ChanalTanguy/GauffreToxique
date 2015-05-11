import java.awt.event.*;

class EcouteTerrain implements MouseListener {
    Dessin aire;
    
    // Ecouteur de souris a besoin de connaitre l'aire de dessin car elle doit
    // changer le message que celle ci affiche
    public EcouteTerrain(Dessin a) {
        aire = a;
    }

    // Lors d'une pression de bouton, on change de message
    public void mousePressed(MouseEvent e) {
    	
    	int x = e.getX()/50;
    	int y = e.getY()/50;
    	
    	//Test
    	//System.out.println("X : " + x + " Y : " + y );
    	
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