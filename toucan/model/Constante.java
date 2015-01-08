package toucan.model;

import java.awt.Color;

public class Constante {
	public static int tempoForVitesse(int i){
		int rep = 0;
		switch(i){
			case 1 : rep = 80; break;
			case 2 : rep = 40; break;
			case 3 : rep = 20; break;
			case 4 : rep = 5; break;
			case 5 : rep = 0; break;
		}
		return rep;
	}
	
	public static final Color COULEUR_BASE = Color.blue;
	public static final Color COULEUR_MVT = Color.red;
	public static final Color COULEUR_COMP = Color.DARK_GRAY;
	public static final Color COULEUR_COMP_MOINS = Color.green;
	public static final Color COULEUR_COMP_PLUS = Color.magenta;
	public static final Color COULEUR_VAR = Color.cyan;
	
	public static final String TEXT_TIP_MENUFICHIER = "Menu fichier permettant de :";
	public static final String TEXT_TIP_MENUALGO = "Menu algo permettant de choisir l'algorithme à executer";
	public static final String TEXT_TIP_ITEMBULLE = "Choisir algorithme de tri à bulle";
	public static final String TEXT_TIP_ITEMPERSO = "Choisir algorithme de tri personnaliser";
	public static final String TEXT_TIP_ITEMDEMARRER = "Demarrer l'algorithme de tri";
	public static final String TEXT_TIP_ITEMREINIT = "Générer un nouveau tableau";
	
	
	public static final int ID_ALGO_BULLE = 1;
	public static final int ID_ALGO_INSERTION = 2;
	public static final int ID_ALGO_PERSO = 3;
	
	public static final int Y_CASE = 100;
	public static final int Y_LABEL = 350;
	public static final int Y_VARIABLE = 300;
	
	public static final int ETAT_DEPART = 0;
	public static final int ETAT_RUN = 1;
	public static final int ETAT_PAUSE = 2;
	
	public static final int  NB_CASES = 4;
}
