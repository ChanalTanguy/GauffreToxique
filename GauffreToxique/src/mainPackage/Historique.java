package mainPackage;

public class Historique {
Configuration tab[];
int taille;

	//de base une taille de 20
	public Historique(){
		tab = new Configuration[20];
	}
	
	//taille variable
	public Historique(int i){
		tab = new Configuration[i];
	}
	
	//ajoute une configuration
	protected void Ajouter(Configuration c){
		tab[taille]= new Configuration(c.Charger_Joueur(),c.Charger_Plateau());
		taille++;
	}
	
	//renvoie la derniere configuration
	protected Configuration Recup(){
		return tab[taille];
	}
	
	//revoi le tour de la configuration
	protected int tour (int t){
		return t+1;
	}
	
	//toString
	public String toString(){
		String resultat = "";
		int i;
		for(i=0;i<taille;i++){
			resultat=resultat + "tour: " + tour(i) + "\n";
			resultat=resultat + tab[i].toString();
			resultat=resultat + "\n";
		}
		return resultat;
	}
}
