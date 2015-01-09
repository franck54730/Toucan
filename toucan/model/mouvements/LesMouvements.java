package toucan.model.mouvements;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import toucan.model.cases.Coordonnee;
import toucan.model.mouvements.Mouvement;

public class LesMouvements implements Iterable<Mouvement>{
	protected ArrayList<Mouvement> mouvements;
	
	public LesMouvements(){
		mouvements = new ArrayList<Mouvement>();
	}

	public Iterator<Mouvement> iterator() {
		return mouvements.iterator();
	}
	
	/**
	 * ajoute un mouvement
	 * @param m
	 */
	public void addMouvement(Mouvement m){
    	mouvements.add(m);
    }
	
	/**
	 * recupere le ieme mouvement 
	 * @param i
	 * @return
	 */
	public Mouvement getMouvement(int i){
		return mouvements.get(i);
	}
	
	/**
	 * retourne le nombre de mouvement
	 * @return
	 */
	public int size(){
		return mouvements.size();
	}
	
	/**
	 * donne les coordonnée pour un temps
	 * @param temps
	 * @return
	 */
	public Coordonnee getCoordonneeForTemps(int temps){
		Mouvement mvt = getMouvementForTemps(temps);
		return mvt.getCoordonneeForTemps(temps);
	}

	/**
	 * donne la valeur pour un temps
	 * @param temps
	 * @return
	 */
	public String getValeurForTemps(int temps){
		Mouvement mvt = getMouvementForTemps(temps);
		return mvt.getValeur();
	}

	/**
	 * donne la couleur pour un temps
	 * @param temps
	 * @return
	 */
	public Color getCouleurForTemps(int temps){
		Mouvement mvt = getMouvementForTemps(temps);
		return mvt.getCouleur();
	}
	
	/**
	 * donne tout le mouvement pour un temps
	 * @param temps
	 * @return
	 */
	public Mouvement getMouvementForTemps(int temps){
		Mouvement mvt = null;
		boolean trouv = false;
		int i = 0;
		while(!trouv && i < mouvements.size()){
			mvt = mouvements.get(i);
			
			if(temps >= mvt.getTemps() && temps < mvt.getTemps()+mvt.getDuree()){
				trouv = true;
			}
			i++;
		}
		return mvt;
	}
}
