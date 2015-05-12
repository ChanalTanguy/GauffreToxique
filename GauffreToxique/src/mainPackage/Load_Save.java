package mainPackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

//les fichier de sauvegarde sont des .wfl
public class Load_Save {
	String fichier;
	
	//le fichier de sauvegarde par defaut est save001.wfl
	public Load_Save(){
		fichier  = "save001.wfl";
	}
	
	//fichier de sauvegarde nom
	public Load_Save(String nom){
		fichier = nom;
	}
	
	//sauvegarde un fichier
	public void Sauvegarder_partie(Historique h){
		String a_ecrire = h.toString();
		try{
			FileWriter fw = new FileWriter(fichier,false);
			BufferedWriter output = new  BufferedWriter(fw);
			output.write(a_ecrire);
			output.flush();
			output.close();
		}
		catch(IOException ioe){
			
		}
	}
	
}
