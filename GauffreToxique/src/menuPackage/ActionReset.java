package menuPackage;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

// Action effectuée lors du clic sur "Nouvelle partie"

public class ActionReset implements ActionListener  {
	String selected1 = "Humain";
	String selected2 = "Humain";
	JTextField width;
	JTextField height;
	JFrame currentWindow;
	
	public ActionReset(JFrame f) {
		currentWindow = f;
	}
	
	public void actionPerformed(ActionEvent e) {
		JFrame window = newGameWindow();
		window.setVisible(true);
	}

	private JPanel newGameChoice(){
	    
		ActionNiv1 actionNiv1 = new ActionNiv1(this);
		ActionNiv2 actionNiv2 = new ActionNiv2(this);
		JPanel size = sizePanel();
		JPanel j1 = nivPanel("Joueur 1", selected1, actionNiv1);
		JPanel j2 = nivPanel("Joueur 2", selected2, actionNiv2);
		
	    JPanel newGame = new JPanel();
	    newGame.add(size); newGame.add(j1); newGame.add(j2);
	    
	    return newGame;
	}
	
	private JFrame newGameWindow(){
		JFrame window = new JFrame();
		JPanel niv = newGameChoice();
		window.setTitle("Nouvelle partie");
		window.setSize(475, 275);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);  
		window.getContentPane().add(niv);
		
		JButton okButton = new JButton("OK");
		JButton cancelButton = new JButton("Cancel");
		ActionNewGame actionOK = new ActionNewGame(window, this, currentWindow);
		okButton.addActionListener(actionOK);
		ActionCancel actionCancel = new ActionCancel(window, this);
		cancelButton.addActionListener(actionCancel);
		JPanel control = new JPanel();
		control.add(okButton);
		control.add(cancelButton);
		window.getContentPane().add(control, BorderLayout.SOUTH);
		
		return window;
	}
	
	private JPanel nivPanel(String joueur, String selected, ActionListener actionNiv) {
		JPanel niv = new JPanel();
		niv.setBorder(BorderFactory.createTitledBorder(joueur));
		niv.setPreferredSize(new Dimension(440, 60));
	    JRadioButton human = new JRadioButton("Humain");
	    JRadioButton easy = new JRadioButton("Facile");
	    JRadioButton medium = new JRadioButton("Moyen");
	    JRadioButton hard = new JRadioButton("Difficile");
	    selectButton(selected, human, easy, medium, hard);
	    human.addActionListener(actionNiv);
        easy.addActionListener(actionNiv);
        medium.addActionListener(actionNiv);
        hard.addActionListener(actionNiv);
	    ButtonGroup bg1 = new ButtonGroup();
	    bg1.add(human);
	    bg1.add(easy);
	    bg1.add(medium);
	    bg1.add(hard);
	    niv.add(human);
	    niv.add(easy);
	    niv.add(medium);
	    niv.add(hard);
	    return niv;
	}
	
	private JPanel sizePanel(){
		JPanel size = new JPanel();
		size.setBorder(BorderFactory.createTitledBorder("Grille de jeu"));
		size.setPreferredSize(new Dimension(440, 60));
		JLabel labelW = new JLabel("Largeur : ");
		JLabel labelH = new JLabel("Hauteur : ");
		width = new JTextField("5");
		width.setPreferredSize(new Dimension(30, 25));
		height = new JTextField("5");
		height.setPreferredSize(new Dimension(30, 25));
		size.add(labelW); size.add(width); size.add(labelH); size.add(height); 
		return size;
	}
	
	private void selectButton(String select, JRadioButton human, JRadioButton easy, JRadioButton medium, JRadioButton hard){
		switch (select) {
		case "Humain" : human.setSelected(true);
		case "Facile" : easy.setSelected(true);
		case "Moyen" : medium.setSelected(true);
		case "Difficile" : hard.setSelected(true);
		}
	}
	
}
