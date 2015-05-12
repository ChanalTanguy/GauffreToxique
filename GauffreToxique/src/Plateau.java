import java.awt.Point;

public class Plateau {
	private boolean gaufre[][];
	private String message;
	
	public Plateau (int hauteur, int largeur){
		message = "";
		gaufre = new boolean[hauteur][largeur];
		for (int i = 0; i < hauteur; i++){
			for (int j = 0; j < largeur; j++){
				gaufre[i][j] = true;
			}
		}
	}
	
	boolean[][] getTab() {
		return gaufre;
	}
	
	int getWidth() {
		return gaufre.length; // /!\ Possible inversion
	}
	
	int getHeight() {
		return gaufre[0].length; // /!\ Possible inversion
	}
	
	private void setgaufreAt(int x, int y, boolean b) {
		gaufre[x][y] = b;
	}
	
	boolean verifClick (Point position){
		int ligne = position.x, colonne = position.y;
		return gaufre[ligne][colonne];
	}
	
	void updatePlateau (Point position){
		int ligne = position.x, colonne = position.y;
		for (int i = ligne; i < gaufre.length; i++){
			for (int j = colonne; j < gaufre[0].length; j++){
				gaufre[i][j] = false;
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
		Plateau p = new Plateau(getWidth(), getHeight());
		p.updateMessage(message);
		for (int i = 0; i < getWidth(); i++){
			for (int j = 0; j < getHeight(); j++){
				p.setgaufreAt(i, j, gaufre[i][j]);
			}
		}
		return p;
		
	}
	
}
