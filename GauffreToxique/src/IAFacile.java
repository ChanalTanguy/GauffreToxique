import java.awt.Point;
import java.util.Random;

public class IAFacile implements InterfaceEntree {

	private Plateau gauffre;

	public IAFacile(Plateau gauffre) {
		this.gauffre = gauffre;
	}
	
	public Point jouer() {
		Random r = new Random();
		return new Point(r.nextInt(gauffre.getLength()),r.nextInt(gauffre.getHeigth())); 
	}

}
