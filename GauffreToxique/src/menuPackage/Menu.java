package menuPackage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

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
		file.addSeparator();
		JMenuItem quit = new JMenuItem("Quitter");
		ActionQuit actionQuit = new ActionQuit(frame);
		quit.addActionListener(actionQuit);
		file.add(quit);

		JMenu edit = new JMenu("Édition");

		JMenuItem undo = new JMenuItem("Annuler");
		ActionUndo actionUndo = new ActionUndo();
		undo.addActionListener(actionUndo);
		edit.add(undo);
		JMenuItem redo = new JMenuItem("Rétablir");
		ActionRedo actionRedo = new ActionRedo();
		redo.addActionListener(actionRedo);
		edit.add(redo);

		/*JMenu opt = new JMenu("Options");
        JMenu j1 = new JMenu("Joueur 1");
        JMenu j2 = new JMenu("Joueur 2");

        ActionNiv1 niv1 = new ActionNiv1();
        ActionNiv2 niv2 = new ActionNiv2();

        j1 = nivMenu(j1, niv1);
        j2 = nivMenu(j2, niv2);

        opt.add(j1); opt.add(j2);*/

		bar.add(file);
		bar.add(edit);

		return bar;
	}

	public static JPanel newUndoRedo(){
		JButton undo = new JButton("Annuler");
		JButton redo = new JButton("Rétablir");
		JPanel control = new JPanel();
		ActionUndo actionUndo = new ActionUndo();
		undo.addActionListener(actionUndo);
		ActionRedo actionRedo = new ActionRedo();
		redo.addActionListener(actionRedo);
		control.add(undo);
		control.add(redo);
		return control;
	}

}
