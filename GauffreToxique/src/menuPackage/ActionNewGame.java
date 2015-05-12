package menuPackage;

import java.awt.event.*;
import javax.swing.*;

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
		
		if (dif1 == "Humain"){
			System.out.println("Le joueur 1 est "+dif1+" !");
		} else {
			System.out.println("Le joueur 1 est en mode "+dif1+" !");
		}
		
		if (dif2 == "Humain"){
			System.out.println("Le joueur 2 est "+dif2+" !");
		} else {
			System.out.println("Le joueur 2 est en mode "+dif2+" !");
		}
		
		this.window.setVisible(false);
	}
}
