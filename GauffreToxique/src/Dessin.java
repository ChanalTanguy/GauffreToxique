import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;


public class Dessin extends JComponent {
    Plateau gauffre;
    String message;
    
    //Constructeur de base
    public Dessin() 
    {   	
    	
    }
    
    //Constructeur avec choix des tailles
    public Dessin(Plateau referenceGauffre)
    {
    	gauffre = referenceGauffre;
    }
    
    //Accesseur de X
    public int getHeight() { return gauffre.getHeight(); }
    
    //Accesseur de Y
    public int getWidth() { return gauffre.getWidth(); }

    public void paintComponent(Graphics g)
    {
        Graphics2D drawable = (Graphics2D) g;

        int width = getSize().width;
        int height = getSize().height;
        
        //Clean du terrain 
	    drawable.setPaint(Color.white);
	    drawable.fillRect(0, 0, width, height);
	    
	    //Images de base
	    Image img, poison;
	    
		try {
			
			img = ImageIO.read(new File("gauffre.png"));
			poison = ImageIO.read(new File("gauffre_e.png"));		
			
			//Boucle d'affichage en fonction du tableau de booleen
			for(int i = 0; i < gauffre.getHeight(); i++)
		    {
		    	for(int j = 0; j < gauffre.getWidth(); j++)
		    	{
		    		if ( gauffre.verifClick(new Point(i, j)) )
		    		{
		    			//On peut faire un draw Image ici meme
						drawable.drawImage(img, i*50, j*50, 50, 50, Color.black, this);
		    		}
		    	}
		    }
			
			//Dans tous les cas, le poison reste
			drawable.drawImage(poison, 0, 0, 50, 50, Color.black, this);
		
		} 
		catch (IOException e) { e.printStackTrace();}
    }
}
