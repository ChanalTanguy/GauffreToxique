package mainPackage;
import javax.sound.midi.Sequence;

public class Configuration {
int joueur_courant;
Plateau plat;

	//constructeur d'une configuration vide
	public Configuration(){
		Plateau p = new Plateau(0,0);
		joueur_courant = 0;
		plat=p.clone();
	}

	//constructeur d'une configuration
	public Configuration(int joueur, Plateau p){
		joueur_courant = joueur;
		plat=p.clone();
	}

	//on charge le plateau depuis la configuration
	protected Plateau Charger_Plateau(){
		return plat; 
	}	

	//on charge le joueur courant depuis la configuration
	protected int Charger_Joueur(){
		return joueur_courant;
	}

	//on sauvegarde le plateau dans la configuration
	protected void Sauvegarder_Plateau(Plateau p){
		plat=p.clone();
	}

	//on sauvegarde le joueur courant dans la configuration
	protected void Sauvegarder_Joueur(int i){
		joueur_courant=i;
	}
	
	//creation d'un string pour l'affichage
	public String toString(){
		String resultat = joueur_courant + plat.toString();
		return null;
	}
}
