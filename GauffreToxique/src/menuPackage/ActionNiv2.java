package menuPackage;

import java.awt.event.*;

import javax.swing.*;

public class ActionNiv2 implements ActionListener {
		String dif;
		ActionReset a;
		
	public ActionNiv2(ActionReset a){
		this.a = a;
	}
	
	public void actionPerformed(ActionEvent e) {
		dif = ((JRadioButton)e.getSource()).getText();
		a.selected2 = dif;
		//System.out.println(dif);
		//System.out.println(a.selected1);
	}
	
}
