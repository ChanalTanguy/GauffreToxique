import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Graphique {

	int tailleCase = 50;
	
	public Graphique(Plateau gaufre) {
        JFrame frame = new JFrame("Blue Waffle");
        Dessin d = new Dessin(gaufre);
        
        //Test mouse
        d.addMouseListener(new EcouteTerrain(d, gaufre));
        
        frame.add(d);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // On fixe la taille et on demarre
        frame.setSize(gaufre.getWidth()*tailleCase+200, gaufre.getHeight()*tailleCase+25+25+100);
        frame.setResizable(false);
        frame.setVisible(true);
    }

}
