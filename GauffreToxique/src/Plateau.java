import java.awt.Point;

public class Plateau {
	private boolean gauffre[][];
	private String message;
	
	public Plateau (int hauteur, int largeur){
		message = "";
		gauffre = new boolean[hauteur][largeur];
		for (int i = 0; i < hauteur; i++){
			for (int j = 0; j < largeur; j++){
				gauffre[i][j] = true;
			}
		}
	}
	
	boolean[][] getTab() {
		return gauffre;
	}
	
	int getWidth() {
		return gauffre[0].length; // /!\ Possible inversion
	}
	
	int getHeight() {
		return gauffre.length; // /!\ Possible inversion
	}
	
	private void setGauffreAt(int x, int y, boolean b) {
		gauffre[x][y] = b;
	}
	
	boolean verifClick (Point position){
		int ligne = position.x, colonne = position.y;
		return gauffre[ligne][colonne];
	}
	
	void updatePlateau (Point position){
		int ligne = position.x, colonne = position.y;
		for (int i = ligne; i < gauffre.length; i++){
			for (int j = colonne; j < gauffre[0].length; j++){
				gauffre[i][j] = false;
			}
		}
	}
	
	void updateMessage (String newMessage){
		message = newMessage;
	} 
	
	boolean verifCaseEmpoisonnee (Point position){
		return (position.x == 0 && position.y == 0);
	}
	
	protected Plateau clone() {
		Plateau p = new Plateau(getHeight(), getWidth());
		p.updateMessage(message);
		for (int i = 0; i < getHeight(); i++){
			for (int j = 0; j < getWidth(); j++){
				p.setGauffreAt(i, j, gauffre[i][j]);
			}
		}
		return p;
		
	}
	
}
