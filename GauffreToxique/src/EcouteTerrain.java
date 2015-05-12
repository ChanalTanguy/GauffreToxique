import java.awt.Point;
import java.awt.event.*;

class EcouteTerrain implements MouseListener {
    Dessin aire;
    Plateau gaufre;
    
    // Ecouteur de souris a besoin de connaitre l'aire de dessin car elle doit
    // changer le message que celle ci affiche
    public EcouteTerrain(Dessin a, Plateau p) {
        aire = a;
        gaufre = p;
    }

    // Lors d'une pression de bouton, on change de message
    public void mousePressed(MouseEvent e) {
    	
    	int x = (e.getX()/50)-1;
    	int y = (e.getY()/50)-1;

    	if(x < 0 || y < 0){} //En dehors des limites
    	else if(gaufre.verifCaseEmpoisonnee(new Point(x,y)))
    	{
    		aire.mess = aire.player + " a perdu";
    		aire.the_game = false;
    	}
    	else if(x<gaufre.getWidth() && y <gaufre.getHeight()) //On peut cliquer en dehors de la gauffre
    	{
	    	//On met à faux toutes les cases en dessous de celle cliquée
	       	if(gaufre.verifClick(new Point(x,y))) //Non cliqué
	    	{
	       		gaufre.updatePlateau(new Point(x,y));
		    	
		    	aire.player = (aire.player%2)+1;
		    	aire.mess = "To the player " + aire.player;
		    	aire.tour++;
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