package toucan.model;

import java.awt.Color;

public class Constante {
	public static int tempoForVitesse(int i){
		int rep = 0;
		switch(i){
			case 1 : rep = 40; break;
			case 2 : rep = 30; break;
			case 3 : rep = 20; break;
			case 4 : rep = 5; break;
			case 5 : rep = 1; break;
		}
		return rep;
	}
	
	public static Color COULEUR_BASE = Color.blue;
	public static Color COULEUR_MVT = Color.red;
	public static Color COULEUR_COMP = Color.yellow;
	public static Color COULEUR_COMP_MOINS = Color.green;
	public static Color COULEUR_COMP_PLUS = Color.magenta;
	public static Color COULEUR_VAR = Color.cyan;
	
	public static String TEXT_TIP_MENUFICHIER = "Menu fichier permettant de :";
	public static String TEXT_TIP_MENUALGO = "Menu algo permettant de choisir l'algorithme � executer";
	public static String TEXT_TIP_ITEMBULLE = "Choisir algorithme de tri à bulle";
	
	public static int Y_CASE = 100;
	public static int Y_LABEL = 350;
	public static int Y_VARIABLE = 300;
	
	public static int ETAT_DEPART = 0;
	public static int ETAT_RUN = 1;
	public static int ETAT_PAUSE = 2;
	
}
