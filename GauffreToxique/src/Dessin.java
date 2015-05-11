import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;


public class Dessin extends JComponent {
    boolean tab[][];
    int xT, yT;
    
    //Constructeur de base
    public Dessin() 
    {   	
    	//Initialisation de la taille du tableau de booleen  	
    	xT = 10;
    	yT = 10;
    	
        tab = new boolean[10][10];
        for(int i = 0; i<10;i++)
        {
        	for(int j = 0;j<10;j++)
        	{
        		tab[i][j] = true;
        	}
        }
    }
    
    //Constructeur avec choix des tailles
    public Dessin(int x, int y)
    {
    	xT = x;
    	yT = y;
    	
    	tab = new boolean[x][y];
        for(int i = 0; i<x;i++)
        {
        	for(int j = 0;j<y;j++)
        	{
        		tab[i][j] = true;
        	}
        }
    }
    
    //Accesseur de X
    public int sizeX() { return xT; }
    
    //Accesseur de Y
    public int sizeY() { return yT; }

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
			for(int i = 0; i <tab.length;i++)
		    {
		    	for(int j = 0; j<tab[0].length;j++)
		    	{
		    		if(tab[i][j])
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
