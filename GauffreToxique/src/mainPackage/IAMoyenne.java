package mainPackage;
import java.awt.Point;
import java.util.Random;

public class IAMoyenne implements InterfaceEntree {

	private Plateau gauffre;

	public IAMoyenne(Plateau gauffre) {
		this.gauffre = gauffre;
	}
	
	public Point jouer() {
		
		// Vérifier qu'il y a un coup gagnant
		boolean [][] g = gauffre.getTab();
		if (!g[0][1] && !g[1][0])
			return new Point(0,0);
		if (!g[0][1])
			return new Point(1,0);
		if (!g[1][0])
			return new Point(0,1);
		// Générer une position valide qui ne perd pas (donne une position qui perd après 5 essai)
		Random r = new Random();
		int i = 0;
		Point p;
		do { 
			i++;
			do {
				p = new Point(r.nextInt(gauffre.getWidth()),r.nextInt(gauffre.getHeight())); 
			} while (!g[p.x][p.y]);
		} while (i < 25 && coupPerdant(p));
		
		return p;
	}

	private boolean coupPerdant(Point p) {
		return ((p.x == 0 && p.y == 1) || (p.x == 1 && p.y == 0) || (p.x == 0 && p.y == 0));
	}
	
}
