import javax.sound.midi.Sequence;


public class Configuration {
int joueur_courant;
Plateau plat;

//on charge le plateau depuis la configuration
Plateau Charger_Plateau(){
	return plat; 
}

//on charge le joueur courant depuis la configuration
int Charger_Joueur(){
	return joueur_courant;
}

//on sauvegarde le plateau dans la configuration
void Sauvegarder_Plateau(Plateau p){
	plat=p.clone();
}

//on sauvegarde le joueur courant dans la configuration
void Sauvegarder_Joueur(int i){
	joueur_courant=i;
}
}
