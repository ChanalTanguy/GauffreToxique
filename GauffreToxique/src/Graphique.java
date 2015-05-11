import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Graphique implements Runnable {

	public void run() {
        // Creation d'une fenetre
        JFrame frame = new JFrame("Fenetre1");
        
        // Creation du composant de dessin et ajout de l'objet de traitement
        // des evenements provenant de la souris
        Dessin mon_dessin = new Dessin(5,5);
        mon_dessin.addMouseListener(new EcouteTerrain(mon_dessin));
        
        //Recupération de la taille du tableau
        int x = mon_dessin.sizeX(); 
        int y = mon_dessin.sizeY();
        
        // Ajout de notre composant de dessin dans la fenetre
        frame.add(mon_dessin);

        // Un clic sur le bouton de fermeture clos l'application
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // On fixe la taille et on demarre
        frame.setSize(x*50, y*50+25);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String [] args) {
        SwingUtilities.invokeLater(new Graphique());
    }
}
