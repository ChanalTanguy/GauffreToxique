
public class Main {
	public static void main (String[] args){
		Jeu moteur = new Jeu ( Integer.parseInt(args[0]), Integer.parseInt(args[1]) );
		Dessin zoneGraphique = new Dessin (moteur.getGauffre());
		EcouteTerrain ecouteur = new EcouteTerrain (moteur);
		
	}
}
