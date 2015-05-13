package menuPackage;
import java.awt.event.*;

import javax.swing.JFrame;


public class ActionQuit implements ActionListener  {
	JFrame window;
	
	public ActionQuit(JFrame window) {
		this.window = window; 
	}

	public void actionPerformed(ActionEvent e) {
		window.dispose();
	}

}
