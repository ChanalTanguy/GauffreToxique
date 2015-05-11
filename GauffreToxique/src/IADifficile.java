import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class IADifficile implements InterfaceEntree {

	private Plateau gauffre;

	public IADifficile(Plateau gauffre) {
		this.gauffre = gauffre;
	}
	
	public Point jouer() {
		
		ArrayList<Point> list = new ArrayList<Point>();
		double chance = Integer.MIN_VALUE;
		boolean [][] g = gauffre.getTab();
		Point p; double x;
		for (int i = 0; i < gauffre.getHeigth(); i++) {
			for (int j = 0; j < gauffre.getLength(); j++) {
				if (g[i][j] && (i != 1 || j != 1)) {
					p = new Point(i,j);
					x = probaGagne(p, Constantes.HEURISTIQUE, this.gauffre);
					if (x > chance) {
						list.clear();
						list.add(p);
						chance = x;
					} else if (x == chance) {
						list.add(p);
					}
				}
			}
		}
		
		if (list.size() == 0) 
			return new Point(1,1);
		
		Random r = new Random();
		return list.get(r.nextInt(list.size()));
	}

	private double probaGagne(Point p, int heuristique, Plateau gauffre) {
		if (coupPerdant(p)) {
			return 0;
		}
		if (heuristique == 0) {
			return 0.5;
		}
		Plateau gauf = gauffre.clone();
		gauf.updatePlateau(p);
		
		boolean[][] g = gauf.getTab();
		double x = 0;
		
		for (int i = 0; i < gauffre.getHeigth(); i++) {
			for (int j = 0; j < gauffre.getLength(); j++) {
				if (g[i][j] && (i != 1 || j != 1)) {
					x = max(x,(1.0-probaGagne(new Point(i,j),heuristique-1,gauf)));
				}
			}
		}
		return x;
	}
	
	private boolean coupPerdant(Point p) {
		return (p.x == 0 && p.y == 1 || p.x == 1 && p.y == 0);
	}
	
	private double max(double f1, double f2) {
		if (f1 > f2)
			return f1;
		return f2;
	}
}
