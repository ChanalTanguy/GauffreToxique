import javax.swing.SwingUtilities;


public class Main implements Runnable {

	public void run()
	{
		//boolean [][]tab = new boolean[5][5];
		Plateau plateau = new Plateau(5,5);
		Graphique g = new Graphique(plateau);
    }

    public static void main(String [] args) {
        SwingUtilities.invokeLater(new Main());
    }
}
