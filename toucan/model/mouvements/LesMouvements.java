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

	@Override
	public Iterator<Mouvement> iterator() {
		return mouvements.iterator();
	}
	
	public void addMouvement(Mouvement m){
    	mouvements.add(m);
    }
	
	public Mouvement getMouvement(int i){
		return mouvements.get(i);
	}
	
	public int size(){
		return mouvements.size();
	}
	
	public Coordonnee getCoordonneeForTemps(int temps){
		Mouvement mvt = getMouvementForTemps(temps);
		return mvt.getCoordonneeForTemps(temps);
	}
	
	public String getValeurForTemps(int temps){
		Mouvement mvt = getMouvementForTemps(temps);
		return mvt.getValeur();
	}
	
	public Color getCouleurForTemps(int temps){
		Mouvement mvt = getMouvementForTemps(temps);
		return mvt.getCouleur();
	}
	
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
