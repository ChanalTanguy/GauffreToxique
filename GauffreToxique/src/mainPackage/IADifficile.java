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
		double chance = 0;
		boolean [][] g = gauffre.getTab();
		Point p; double x;
		for (int i = 0; i < gauffre.getWidth(); i++) {
			for (int j = 0; j < gauffre.getHeight(); j++) {
				if (g[i][j]) {
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
			return new Point(0,0);
		
		Random r = new Random();
		return list.get(r.nextInt(list.size()));
	}

	private double probaGagne(Point p, int heuristique, Plateau gauffre) {
		
		
		
		if (coupPerdant(p, gauffre)) {
			return 0; 
		}
		if (coupGagnant(p, gauffre)) {
			return 1; 
		}
		if (heuristique == 0) {
			return 0.5;
		}
		Plateau gauf = gauffre.clone();
		gauf.updatePlateau(p);
		
		boolean[][] g = gauf.getTab();
		double x = 0;
		int y = 0;
		double c;
		
		for (int i = 0; i < gauffre.getWidth(); i++) {
			for (int j = 0; j < gauffre.getHeight(); j++) {
				if (g[i][j]) {
					c = probaGagne(new Point(i,j),heuristique-1,gauf);
					if (c == 1) {
						return 0;
					}
					x += 1-c;
					y++;
				}
			}
		}
		
		x = (x/y);
		
		return (x);
	}
	
	private boolean coupGagnant(Point p, Plateau g) {
		boolean b[][] = g.getTab();
		return ((p.x == 1 && p.y == 0 && !b[0][1]) || (p.x == 0 && p.y == 1 && !b[1][0]) || (p.x == 1 && p.y == 1 && !b[2][0] && !b[0][2]));
	}
	
	private boolean coupPerdant(Point p, Plateau g) {
		boolean b[][] = g.getTab();
		return ((p.x == 0 && p.y == 0) || (p.x == 1 && p.y == 0 && b[0][1]) || (p.x == 0 && p.y == 1 && b[1][0]));
	}
}
