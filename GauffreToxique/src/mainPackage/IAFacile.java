package mainPackage;
import java.awt.Point;
import java.util.Random;

public class IAFacile implements InterfaceEntree {

	private Plateau gauffre;

	public IAFacile(Plateau gauffre) {
		this.gauffre = gauffre;
	}
	
	public Point jouer() {
		Random r = new Random();

		boolean [][] g = gauffre.getTab();
		Point p;
		
		do {
			p = new Point(r.nextInt(gauffre.getWidth()),r.nextInt(gauffre.getHeight())); 
		} while (!g[p.x][p.y]);
		
		return p; 
	}
}
