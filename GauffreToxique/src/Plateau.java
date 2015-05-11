import java.awt.Point;

public class Plateau {
	boolean gauffre[][];
	
	public Plateau (int hauteur, int largeur){
		gauffre = new boolean[hauteur][largeur];
		for (int i = 0; i < hauteur; i++){
			for (int j = 0; j < largeur; j++){
				gauffre[i][j] = false;
			}
		}
	}
	
	boolean verifClick (Point position){
		int ligne = position.x, colonne = position.y;
		return gauffre[ligne][colonne];
	}
	
	void updatePlateau (Point position){
		int ligne = position.x, colonne = position.y;
		for (int i = ligne; i < gauffre.length; i++){
			for (int j = colonne; j < gauffre[0].length; j++){
				gauffre[i][j] = true;
			}
		}
	}
}