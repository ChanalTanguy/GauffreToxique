package menuPackage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Action effectuée lors du clic sur "Sauvegarder"

public class ActionSave implements ActionListener  {

	public void actionPerformed(ActionEvent e) {
		System.out.println("Partie sauvegardée !");
	}

}
