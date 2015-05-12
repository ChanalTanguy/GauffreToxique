package menuPackage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class ActionCancel implements ActionListener  {
	JFrame window;
	
	public ActionCancel(JFrame window, ActionReset a){
		this.window = window;
	}
	
	public void actionPerformed(ActionEvent e) {
		this.window.setVisible(false);
	}

}
