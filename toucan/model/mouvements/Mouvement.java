package toucan.model.mouvements;

import java.awt.Color;

import toucan.model.cases.Coordonnee;

public abstract class Mouvement {
	
	protected Coordonnee depart;
	//temps que dure le mouvements
	protected int duree;
	//temps a partir duquel le mouvement commence
	protected int temps;
    protected String valeur ;
    protected Color couleur ;
	
	public Mouvement(Coordonnee dep, int dur, int tps, String val, Color col){
		depart = dep;
		temps = tps;
		duree = dur;
		valeur = val;
		couleur = col;
	}

	/**
	 * accesseur lecture coordonnée de depart
	 * @return
	 */
	public Coordonnee getDepart() {
		return depart;
	}

	/**
	 * accesseur ecriture coordonnée de depart
	 * @return
	 */
	public void setDepart(Coordonnee depart) {
		this.depart = depart;
	}

	/**
	 * accesseur lecture durée
	 * @return
	 */
	public int getDuree() {
		return duree;
	}

	/**
	 * accesseur ecriture durée
	 * @return
	 */
	public void setDuree(int duree) {
		this.duree = duree;
	}

	/**
	 * accesseur lecture temps
	 * @return
	 */
	public int getTemps() {
		return temps;
	}

	/**
	 * accesseur ecriture temps
	 * @return
	 */
	public void setTemps(int temps) {
		this.temps = temps;
	}

	/**
	 * accesseur lecture valeur
	 * @return
	 */
	public String getValeur(){
		return valeur;
	}

	/**
	 * accesseur lecture couleur
	 * @return
	 */
	public Color getCouleur(){
		return couleur;
	}
	
	/**
	 * accesseur ecriture couleur
	 * @return
	 */
	public void setCouleur(Color c){
		couleur = c;
	}
	
	public abstract Coordonnee getCoordonneeForTemps(int temps);
	
	public abstract Coordonnee getArrive();
	
	public String toString(){
		return 	  "\n 		Mouvement : "+this.getClass().toString()
				+ "\n 		  tps : "+this.temps
				+ "\n 		  duree : "+this.duree
				+ "\n 		  temps :"+this.temps
				+ "\n 		  valeur : "+this.valeur
				+ "\n 		  couleur : "+this.couleur+"\n";
	}
}
