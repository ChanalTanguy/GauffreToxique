import java.awt.Point;

public class TestIA {
	
		public static void main (String[] args){
			int lignes = 6;
			int colonnes = 6;

			Plateau p = new Plateau(lignes, colonnes);
			InterfaceEntree IA[]= {new IAMoyenne(p),new IADifficile(p)};
			Point coup;
			int x = 0;
			boolean[][] b;
			
			while (p.getTab()[0][0]) {
				System.out.println("--------------------------- "+ x);
				coup = IA[x].jouer();
				x = 1-x;
				p.updatePlateau(coup);
				b = p.getTab();
				for (int i = 0; i<p.getHeight();i++) {
					for (int j = 0; j<p.getWidth();j++) {
						if (b[j][i])
							System.out.print("O");
					}
					System.out.println();
				}
			}
	}
}

