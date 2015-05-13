package mainPackage;
import java.awt.BorderLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import menuPackage.Menu;

public class Graphique {
	JFrame frame = new JFrame("Blue Waffle");
	JMenuBar bar = Menu.newMenu(frame);
    Image img = null;
    JPanel p = Menu.newUndoRedo();
    
	
	//Cas deux joueurs humains
	public Graphique(Plateau gaufre) {
        Dessin d = new Dessin(gaufre);

   
        d.addMouseListener(new EcouteTerrain(d, gaufre));
        frame.addKeyListener(new Konami(d,gaufre));
        
        frame.add(d);
        frame.getContentPane().add(p,BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // On fixe la taille et on demarre
        frame.setSize(gaufre.getWidth()*Constantes.tailleCase+200, gaufre.getHeight()*Constantes.tailleCase+25+25+100);
        frame.setJMenuBar(bar);
        
        //Icone
        try
        {
        	img = ImageIO.read(new File("icone.png"));
        	frame.setIconImage(img);

        }
        catch (IOException e) { e.printStackTrace();}

        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
	
	//Cas 1 humain + 1 IA
	public Graphique(Plateau gaufre, InterfaceEntree IA) {
		Dessin d = new Dessin(gaufre, IA);
		//Test mouse
		d.addMouseListener(new EcouteTerrain(d, gaufre));
		frame.addKeyListener(new Konami(d,gaufre));
		
		frame.add(d);
        frame.getContentPane().add(p,BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// On fixe la taille et on demarre
		frame.setSize(gaufre.getWidth()*Constantes.tailleCase+200, gaufre.getHeight()*Constantes.tailleCase+25+25+100);
		frame.setJMenuBar(bar);
		
        //Icone
        try
        {
        	img = ImageIO.read(new File("icone.png"));
        	frame.setIconImage(img);

        }
        catch (IOException e) { e.printStackTrace();}
        
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
	}

	//Cas 2 IA
	public Graphique(Plateau gaufre, InterfaceEntree IA1, InterfaceEntree IA2)
	{
		 
		Dessin d = new Dessin(gaufre, IA1, IA2);
		
		//Test mouse
		d.addMouseListener(new EcouteTerrain(d, gaufre));
		frame.addKeyListener(new Konami(d,gaufre));
		
		frame.add(d);
        frame.getContentPane().add(p,BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// On fixe la taille et on demarre
		frame.setSize(gaufre.getWidth()*Constantes.tailleCase+200, gaufre.getHeight()*Constantes.tailleCase+25+25+100);
		frame.setJMenuBar(bar);
		
        //Icone
        try
        {
        	img = ImageIO.read(new File("icone.png"));
        	frame.setIconImage(img);

        }
        catch (IOException e) { e.printStackTrace();}
		
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
}
