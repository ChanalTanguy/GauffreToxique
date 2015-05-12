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

			this.window.setVisible(false);
			currentWindow.setVisible(false);
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
