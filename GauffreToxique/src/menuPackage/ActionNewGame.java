package menuPackage;

// Action effectuée lors de l'appui sur le bouton "OK" du menu "Nouvelle partie"

import java.awt.event.*;

import javax.swing.*;

import mainPackage.Plateau;

public class ActionNewGame implements ActionListener {
	String dif1, dif2;
	ActionReset a;
	JFrame window;
	
	public ActionNewGame(JFrame window, ActionReset a){
		this.a = a;
		this.window = window;
	}
	
	public ActionNewGame(String selected1, String selected2){
		dif1 = selected1;
		dif2 = selected2;
	}
	
	public void actionPerformed(ActionEvent e) {
		dif1 = a.selected1;
		dif2 = a.selected2;
		
		Plateau plateau = new Plateau(5,5);
		
		if (dif1 == "Humain" && dif2 == "Humain"){

			Graphique g = new Graphique(plateau);
		else if (dif1 == "Humain") {
			
		} else if (dif2 == "Humain") {
			
		}
		
		this.window.setVisible(false);
	}
}
