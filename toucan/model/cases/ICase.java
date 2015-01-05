package toucan.model.cases;

import java.awt.Color;

import toucan.model.mouvements.LesMouvements;
import toucan.model.mouvements.Mouvement;
import toucan.model.mouvements.MouvementBas;
import toucan.model.mouvements.MouvementDroite;
import toucan.model.mouvements.MouvementGauche;
import toucan.model.mouvements.MouvementHaut;
import toucan.model.mouvements.MouvementRester;

public abstract class ICase {
	protected LesMouvements mouvements;
    protected Color couleur ;
    protected Coordonnee c;
    protected String valeur ;
    
    public ICase(String v, int x, int y, Color coul){
        valeur = v ;
        c = new Coordonnee(x, y);
        couleur = coul ;
        mouvements = new LesMouvements();
    }
    
    /**
     * fonction qui renvoiee vrai si la case est une variable
     * @return
     */
    public abstract boolean isVariable();
    
    /**
     * fonction qui renvoie les mouvements de la case
     * @return
     */
    public LesMouvements getMouvements(){
    	return mouvements;
    }
    
    /**
     * fonction qui renvoie le ieme mouvement de la case
     * @return
     */
    public Mouvement getMouvement(int i){
    	return mouvements.getMouvement(i);
    }
    
    /**
     * accesseur en lecture sur la couleur
     * @return
     */
	public Color getCouleur() {
		return couleur;
	}
	
	 /**
     * accesseur en ecriture sur la couleur
     * @return
     */
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

    /**
     * accesseur en lecture sur la position en X
     * @return
     */
	public int getPositionX() {
		return c.getX();
	}
	
	/**
     * accesseur en ecriture sur la position en X
     * @return
     */
	public void setPositionX(int positionX) {
		c.setX(positionX);
	}
	
	/**
     * accesseur en lecture sur la position en Y
     * @return
     */
	public int getPositionY() {
		return c.getY();
	}
	
	/**
     * accesseur e
     * n ecriture sur la position en Y
     * @return
     */
	public void setPositionY(int positionY) {
		c.setY(positionY);
	}
	
	/**
     * accesseur en lecture sur la valeur de la case
     * @return
     */
	public String getValeur() {
		return valeur;
	}
	
	/**
     * accesseur en ecriture sur la valeur de la case
     * @return
     */
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	
	/**
     * Fonction qui ajoute un MouvementHaut a la case
     * @return
     */
	public void monter(int duree, Color col){
		Coordonnee depart = c;
		int temps = 0;
		if(mouvements.size() != 0){
			Mouvement dernier = mouvements.getMouvement(mouvements.size()-1);
			depart = dernier.getArrive();
			temps = dernier.getTemps()+dernier.getDuree();
		}
		mouvements.addMouvement(new MouvementHaut(depart,duree,temps,valeur,col));
	}
	
	/**
     * Fonction qui ajoute un MouvementBas a la case
     * @return
     */
	public void descendre(int duree, Color col){
		Coordonnee depart = c;
		int temps = 0;
		if(mouvements.size() != 0){
			Mouvement dernier = mouvements.getMouvement(mouvements.size()-1);
			depart = dernier.getArrive();
			temps = dernier.getTemps()+dernier.getDuree();
		}
		mouvements.addMouvement(new MouvementBas(depart,duree,temps,valeur,col));
	}
	
	/**
     * Fonction qui ajoute un MouvementDroite a la case
     * @return
     */
	public void droite(int duree, Color col){
		Coordonnee depart = c;
		int temps = 0;
		if(mouvements.size() != 0){
			Mouvement dernier = mouvements.getMouvement(mouvements.size()-1);
			depart = dernier.getArrive();
			temps = dernier.getTemps()+dernier.getDuree();
		}
		mouvements.addMouvement(new MouvementDroite(depart,duree,temps,valeur,col));
	}
	
	/**
     * Fonction qui ajoute un MouvementGauche a la case
     * @return
     */
	public void gauche(int duree, Color col){
		Coordonnee depart = c;
		int temps = 0;
		if(mouvements.size() != 0){
			Mouvement dernier = mouvements.getMouvement(mouvements.size()-1);
			depart = dernier.getArrive();
			temps = dernier.getTemps()+dernier.getDuree();
		}
		mouvements.addMouvement(new MouvementGauche(depart,duree,temps,valeur,col));
	}
	
	/**
     * Fonction qui ajoute un MouvementRester a la case
     * @return
     */
	public void rester(int duree, Color col){
		Coordonnee depart = c;
		int temps = 0;
		if(mouvements.size() != 0){
			Mouvement dernier = mouvements.getMouvement(mouvements.size()-1);
			depart = dernier.getArrive();
			temps = dernier.getTemps()+dernier.getDuree();
		}
		mouvements.addMouvement(new MouvementRester(depart,duree,temps,valeur,col));
	}
	
	/**
	 * fonction qui renvoie les coordonn�es de la case a un temps t
	 * @param temps
	 * @return
	 */
	public Coordonnee getCoordonneeForTemps(int temps){
		if(mouvements.size()==0){
			return c;
		}else{
			return mouvements.getCoordonneeForTemps(temps);
		}
	}
	
	/**
	 * fonction qui renvoie la valeur de la case a un temps t
	 * @param temps
	 * @return
	 */
	public String getValeurForTemps(int temps){
		if(mouvements.size()==0){
			return valeur;
		}else{
			return mouvements.getValeurForTemps(temps);
		}
	}
	
	/**
	 * fonction qui renvoie la couleur de la case a un temps t
	 * @param temps
	 * @return
	 */
	public Color getCouleurForTemps(int temps){
		if(mouvements.size()==0){
			return couleur;
		}else{
			return mouvements.getCouleurForTemps(temps);
		}
	}
	
	/**
	 * fonction qui renvoie le temps de fin du dernier mouvement
	 * @param temps
	 * @return
	 */
	public int getTempsMax(){
		int rep = 0;
		if(mouvements.size()!=0){
			Mouvement dernier = mouvements.getMouvement(mouvements.size()-1);
			rep = dernier.getTemps()+dernier.getDuree();
		}
		return rep;
	}
	
	public String toString(){
		String repS = "\n Case : "
				+"\n   x : "+this.getPositionX()
				+"\n   y : "+this.getPositionY()
				+"\n   valeur : "+this.getValeur()
				+"\n   variable : "+this.isVariable();
		StringBuilder rep = new StringBuilder(repS);
		for(Mouvement m : mouvements){
			rep.append(m);
		}
		return rep.toString();
				
	}
}
