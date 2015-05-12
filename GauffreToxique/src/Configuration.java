import javax.sound.midi.Sequence;


public class Configuration {
int joueur_courant;
Plateau plat;

Plateau Charger_Plateau(){
	return plat; 
}

int Charger_Joueur(){
	return joueur_courant;
}

void Sauvegarder_Plateau(Plateau p){
	plat=p.clone();
}

void Sauvegarder_Joueur(int i){
	joueur_courant=i;
}
}
