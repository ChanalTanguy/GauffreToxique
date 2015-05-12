package menuPackage;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu {

	public static JMenuBar newMenu(JFrame frame){
		JMenuBar bar = new JMenuBar();

		JMenu file = new JMenu("Fichier");

		JMenuItem reset = new JMenuItem("Nouvelle partie");
		ActionReset action_reset = new ActionReset(frame);
		reset.addActionListener(action_reset);
		file.add(reset);
		file.addSeparator();
		JMenuItem save = new JMenuItem("Sauvegarder");
		ActionSave action_save = new ActionSave();
		save.addActionListener(action_save);
		file.add(save);
		JMenuItem load = new JMenuItem("Charger");
		ActionLoad action_load = new ActionLoad();
		load.addActionListener(action_load);
		file.add(load);

		/*JMenu opt = new JMenu("Options");
        JMenu j1 = new JMenu("Joueur 1");
        JMenu j2 = new JMenu("Joueur 2");

        ActionNiv1 niv1 = new ActionNiv1();
        ActionNiv2 niv2 = new ActionNiv2();

        j1 = nivMenu(j1, niv1);
        j2 = nivMenu(j2, niv2);

        opt.add(j1); opt.add(j2);*/

		bar.add(file);
		
		return bar;
	}

}
