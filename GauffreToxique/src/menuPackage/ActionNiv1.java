package menuPackage;

// Action effectuée lors de l'appui sur un bouton du panel "Joueur 1" du menu "Nouvelle partie"

import java.awt.event.*;

import javax.swing.*;

public class ActionNiv1 implements ActionListener {
		String dif;
		ActionReset a;
		
	public ActionNiv1(ActionReset a){
		this.a = a;
	}
	
	public void actionPerformed(ActionEvent e) {
		dif = ((JRadioButton)e.getSource()).getText();
		a.selected1 = dif;
		//System.out.println(dif);
		//System.out.println(a.selected1);
	}
	
}
