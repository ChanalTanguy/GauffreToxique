package menuPackage;

import mainPackage.*;

import java.awt.event.*;

import javax.swing.*;

import mainPackage.Plateau;

public class ActionNewGame implements ActionListener {
	String dif1, dif2;
	ActionReset a;
	JFrame window;
	JFrame currentWindow;
	int width, height;

	public ActionNewGame(JFrame window, ActionReset a, JFrame currentWindow){
		this.a = a;
		this.window = window;
		this.currentWindow = currentWindow;
	}

	/*public ActionNewGame(String selected1, String selected2){
		dif1 = selected1;
		dif2 = selected2;
	}*/

	public void actionPerformed(ActionEvent e) {
		dif1 = a.selected1;
		dif2 = a.selected2;
		try {
			width = Integer.parseInt(a.width.getText());
			height = Integer.parseInt(a.height.getText());
		} catch (NumberFormatException err){
			width = 0;
			height = 0;
		}

		if ((2 < width) && (width < 16) && (2 < height) && (height < 16)){

			Plateau plateau = new Plateau(width,height);

			if (dif1 == "Humain" && dif2 == "Humain"){
				new Graphique(plateau);
			}
			else if (dif1.equals("Humain")) {
				uneIA(dif2,plateau);
			} else if (dif2.equals("Humain")) {
				uneIA(dif1,plateau);
			} else {
				switch (dif1+" "+dif2) {
				case "Facile Facile" : new Graphique(plateau, new IAFacile(plateau), new IAFacile(plateau)); break;
				case "Facile Moyen" : new Graphique(plateau, new IAFacile(plateau), new IAMoyenne(plateau)); break;
				case "Facile Difficile" : new Graphique(plateau, new IAFacile(plateau), new IADifficile(plateau)); break;
				case "Moyen Facile" : new Graphique(plateau, new IAMoyenne(plateau), new IAFacile(plateau)); break;
				case "Moyen Moyen" : new Graphique(plateau, new IAMoyenne(plateau), new IAMoyenne(plateau)); break;
				case "Moyen Difficile" : new Graphique(plateau, new IAMoyenne(plateau), new IADifficile(plateau)); break;
				case "Difficile Facile" : new Graphique(plateau, new IADifficile(plateau), new IAFacile(plateau)); break;
				case "Difficile Moyen" : new Graphique(plateau, new IADifficile(plateau), new IAMoyenne(plateau)); break;
				case "Difficile Difficile" : new Graphique(plateau, new IADifficile(plateau), new IADifficile(plateau)); break;
				default:
				}
			}

			window.dispose();
			currentWindow.dispose();} 
		else if ((width == 20) && (height == 07)){
				ImageIcon cyber = new ImageIcon("cyber.png");
				JOptionPane.showMessageDialog(null, "This broadcast is for humankind. Cybermen now occupy every landmass on this planet.\n But you need not fear. Cybermen will remove fear.\n Cybermen will remove sex, and class, and colour, and creed.\n You will become identical. You will become like us.", "DELETE", JOptionPane.WARNING_MESSAGE, cyber);
		} else if ((width == 21) && (height == 64)){
			ImageIcon dalek = new ImageIcon("dalek.png");
			JOptionPane.showMessageDialog(null, "Rebels of London! This is our last warning! Our final offer!\n Show yourselves in the open streets. You will be fed and watered, but work is needed from you.\n The Daleks offer you life! Rebel against us and the Daleks shall destroy London completely.\n Rebels of London, come out of your hiding places. The Daleks offer you life!", "EXTERMINATE", JOptionPane.WARNING_MESSAGE, dalek);
		} else if ((width == 23) && (height == 81)){
			ImageIcon borg = new ImageIcon("borg.png");
			JOptionPane.showMessageDialog(null, "We are the Borg. You will be annihilated.\n Your biological and technological distinctiveness have become irrelevant.\n Resistance is futile... but welcome.", "RESISTANCE IS FUTILE", JOptionPane.WARNING_MESSAGE, borg);
		} else {
			JOptionPane.showMessageDialog(null, "La taille doit être comprise entre 3 et 15.", "I AM ERROR", JOptionPane.WARNING_MESSAGE);
		}
	}

	private void uneIA(String s, Plateau p) {
		switch (s) {
		case "Facile" : new Graphique(p, new IAFacile(p)); break;
		case "Moyen" : new Graphique(p, new IAMoyenne(p)); break;
		case "Difficile" : new Graphique(p, new IADifficile(p)); break;
		default:
		}
	}
}
