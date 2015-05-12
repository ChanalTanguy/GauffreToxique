import java.awt.Point;
import java.util.Stack;

public class Jeu {
	
	Plateau gauffre;
	int joueur;
	Stack<Plateau> plateauPrec;
	Stack<Plateau> plateauSuiv;
	
	public Jeu (int largeur, int hauteur){
		gauffre = new Plateau(largeur, hauteur);
		joueur = 0;
		plateauPrec = new Stack<Plateau>();
		plateauSuiv = new Stack<Plateau>();
	}
	
	Plateau getGauffre (){
		return gauffre;
	}
	
	void boucle (){
		
	}
	
	void jouer (Point position) {
		if (gauffre.verifClick(position) ){
			gauffre.updatePlateau(position);
			if (!gauffre.verifCaseEmpoisonnee(position)){
				joueur = 1 - joueur;
			}
			else {
				gauffre.updateMessage(Constantes.partieTerminee + (joueur + 1));
			}
		}
		else {
			gauffre.updateMessage(Constantes.clicInvalide);
		}
	}
	
	void save() {}
	void load() {}
	
	void undo (){
		plateauSuiv.push(gauffre);
		gauffre = plateauPrec.pop();
	}
	
	void redo (){
		plateauPrec.push(gauffre);
		gauffre = plateauSuiv.pop();
	}
	
	private Point recupClick (){
		return null;
	}
	
	private boolean partieFinie (){
		return false;
	}

}
