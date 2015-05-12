import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JComponent;


public class Dessin extends JComponent {
    boolean tab[][];
    Plateau gaufre;
    String mess;
    boolean the_game = true;
    int tour = 0;  
    int xT, yT;
    Random r = new Random();
    int player = (r.nextInt(2))+1;
    
    //Constructeur de base
    public Dessin() 
    {   	
    	xT = 10;
    	yT = 10;
    	
        tab = new boolean[10][10];     
        initTab(tab, 10, 10);   
        mess = "To the player " + player ;
        
    }
    
    //Constructeur avec choix des tailles
    public Dessin(int x, int y)
    {
    	xT = x;
    	yT = y;
    	
    	tab = new boolean[x][y];
    	initTab(tab, x, y);  
        mess = "To the player " + player ;
    }
    
    //Constructeur avec tableau de booleen
    public Dessin(boolean[][]t)
    {
    	xT = t.length;
    	yT = t[0].length;
    	
    	tab = t;
        
        mess = "To the player " + player ;
    }
    
    //Constructeur avec plateau
    public Dessin(Plateau p)
    {
    	gaufre = p;
    	mess = "To the player " + player ;
    }

    //Initialisation à vrai de toutes les cases
    public void initTab(boolean[][] tab, int x, int y)
    {
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

    //Affichage
    public void paintComponent(Graphics g)
    {
        Graphics2D drawable = (Graphics2D) g;

        int width = getSize().width;
        int height = getSize().height;
        
        //Clean du terrain 
	    drawable.setPaint(Color.white);
	    drawable.fillRect(0, 0, width, height);
	    
	    //Images de base
	    Image img, poison, fond, vide;
	    if(the_game)
	    {
			try {
				
				img = ImageIO.read(new File("gauffre.png"));
				poison = ImageIO.read(new File("gauffre_e.png"));
				fond = ImageIO.read(new File("texture.png"));
				vide = ImageIO.read(new File("texture_m.png"));
				
				drawable.drawImage(fond, null, this);
				
				//Boucle d'affichage en fonction du tableau de booleen
				/*
				for(int i = 0; i <gaufre.getWidth();i++)
			    {
			    	for(int j = 0; j<tab[0].length;j++)
			    	{
			    		if(tab[i][j])
			    		{
			    			//On peut faire un draw Image ici meme
							drawable.drawImage(img, (i+1)*50, (j+1)*50, 50, 50, Color.black, this);
			    		}
			    		else
			    		{
			    			drawable.drawImage(vide, (i+1)*50, (j+1)*50, 50, 50, Color.black, this);
			    		}
			    	}
			    }*/
				for(int i = 0; i <gaufre.getWidth();i++)
			    {
			    	for(int j = 0; j<gaufre.getHeight();j++)
			    	{
			    		if(gaufre.verifClick(new Point(i,j)))
			    		{
			    			//On peut faire un draw Image ici meme
							drawable.drawImage(img, (i+1)*50, (j+1)*50, 50, 50, Color.black, this);
			    		}
			    		else
			    		{
			    			drawable.drawImage(vide, (i+1)*50, (j+1)*50, 50, 50, Color.black, this);
			    		}
			    	}
			    }
				
				
				
				//Dans tous les cas, le poison reste
				drawable.drawImage(poison, 50, 50, 50, 50, Color.black, this);
		
			} 
			catch (IOException e) { e.printStackTrace();}
	    
		
		    //Affichage du joueur actif
	    	drawable.setColor(Color.white);
	    	drawable.fillRect(50+(gaufre.getWidth()*50)+25, 62, 100, 38);
	    	drawable.setColor(Color.RED);
	    	drawable.drawRect(50+(gaufre.getWidth()*50)+25, 62, 100, 38);
	    	drawable.setPaint(Color.black);
	    	Font font = new Font("Helvetica", Font.BOLD, 11);
	    	drawable.setFont(font);
	    	drawable.drawString(mess,50+(gaufre.getWidth()*50)+27 , 86);
		    
		    //Affichage du numéro du tour
	    	
	    	drawable.setColor(Color.white);
	    	drawable.fillRect(50+(gaufre.getWidth()*50)+25, 112, 100, 38);
	    	drawable.setColor(Color.RED);
	    	drawable.drawRect(50+(gaufre.getWidth()*50)+25, 112, 100, 38);
	    	drawable.setPaint(Color.black);
	    	drawable.setFont(font);
	    	drawable.drawString("Tour " + tour,50+(gaufre.getWidth()*50)+38 , 136);
	    	

	    }
	    else
	    {
			Font font = new Font("Courier", Font.BOLD, 30);
			drawable.setFont(font);
			drawable.setPaint(Color.red);
		    drawable.drawString(mess+" en "+(tour+1)+" tour(s).", getWidth()/16, getHeight()/2);
	    }
	    
    }
}
