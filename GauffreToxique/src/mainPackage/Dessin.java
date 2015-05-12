package mainPackage;
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
    
	boolean the_game = true; //Indicateur de defaite
	String mess; //Message en cours
	 
    Plateau gaufre; //Plateau de jeu
      
    int tour = 1;  //Tout actif
    int xT, yT;
        
    Random r = new Random();
    int player = (r.nextInt(2))+1; //Choix du joueur qui commence
    
    boolean intel = false; //Il y a une IA
    boolean intel2 = false; //Il y a deux IA
    
    InterfaceEntree myIA;
    InterfaceEntree myIA2;

    //Constructeur avec plateau
    public Dessin(Plateau p)
    {
    	gaufre = p;
    	mess = "To the player " + player ;
    }

    //Constructeur avec plateau + 1 IA
    public Dessin(Plateau p, InterfaceEntree IA)
    {
    	gaufre = p;
    	mess = "To the player " + player ;
    	intel = true;
    	myIA = IA;
    }

    //Constructeur avec plateau + 1 IA
    public Dessin(Plateau p, InterfaceEntree IA1, InterfaceEntree IA2)
    {
    	gaufre = p;
    	mess = "To the player " + player ;
    	intel = true;
    	intel2 = true;
    	myIA = IA1;
    	myIA2 = IA2;
    }

    //Nettoyage de l'écran
    public void cleanPanel(Graphics2D drawable)
    { 
        int width = getSize().width;
        int height = getSize().height;
        
	    drawable.setPaint(Color.white);
	    drawable.fillRect(0, 0, width, height);
    }
    
    //Affichage
    public void paintComponent(Graphics g)
    {
        Graphics2D drawable = (Graphics2D) g;

        //Nettoyage du plateau
        cleanPanel(drawable);

	    //Images de base
	    Image img, poison, fond, vide;
	    
	    if(the_game)
	    {
			try {
				
				//Chargement des images
				img = ImageIO.read(new File("gauffre.png"));
				poison = ImageIO.read(new File("gauffre_e.png"));
				fond = ImageIO.read(new File("texture.png"));
				vide = ImageIO.read(new File("texture_m.png"));
				
				drawable.drawImage(fond, null, this);
				
				//Affichage de la gauffre
				for(int i = 0; i <gaufre.getWidth();i++)
			    {
			    	for(int j = 0; j<gaufre.getHeight();j++)
			    	{
			    		if(gaufre.verifClick(new Point(i,j)))
			    		{
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
	    
			int t = Constantes.tailleCase;
			
		    //Affichage du joueur actif
	    	drawable.setColor(Color.white);
	    	drawable.fillRect(t+(gaufre.getWidth()*t)+25, 62, 2*t, 38);
	    	drawable.setColor(Color.RED);
	    	drawable.drawRect(t+(gaufre.getWidth()*t)+25, 62, 2*t, 38);
	    	
	    	//Type de font
	    	drawable.setPaint(Color.black);
	    	Font font = new Font("Helvetica", Font.BOLD, 11);
	    	drawable.setFont(font);
	    	drawable.drawString(mess,50+(gaufre.getWidth()*Constantes.tailleCase)+27 , 86);
		    
		    //Affichage du numéro du tour
	    	drawable.setColor(Color.white);
	    	drawable.fillRect(t+(gaufre.getWidth()*t)+25, 112, 2*t, 38);
	    	drawable.setColor(Color.RED);
	    	drawable.drawRect(t+(gaufre.getWidth()*t)+25, 112, 2*t, 38);
	    	drawable.setPaint(Color.black);
	    	drawable.setFont(font);
	    	drawable.drawString("Tour " + tour,t+(gaufre.getWidth()*t)+38 , 136);
	    	
	    }
	    else //Partie finie
	    {
			Font font = new Font("Courier", Font.BOLD, 30);
			drawable.setFont(font);
			drawable.setPaint(Color.red);
		    drawable.drawString(mess+" en "+(tour)+" tour(s).", getWidth()/16, getHeight()/2);
	    }    
    }
}
