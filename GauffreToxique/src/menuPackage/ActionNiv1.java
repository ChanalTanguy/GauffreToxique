package menuPackage;

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
