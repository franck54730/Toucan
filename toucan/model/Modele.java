package toucan.model;

import java.awt.Color;
import java.util.Observable;
import java.util.Random;

import toucan.model.algo.AlgoBulle;
import toucan.model.algo.AlgoInsertion;
import toucan.model.algo.AlgoTest;
import toucan.model.animation.AffectationCaseCase;
import toucan.model.animation.AffectationCaseVariable;
import toucan.model.animation.AffectationVariableCase;
import toucan.model.animation.ComparaisonCaseCase;
import toucan.model.animation.ComparaisonVariableCase;
import toucan.model.cases.Case;
import toucan.model.cases.ICase;
import toucan.model.cases.LesCases;
import toucan.model.cases.Variable;

public class Modele extends Observable implements Runnable {
	protected LesCases cases;
	protected int position;
	protected int vitesse;
	protected int temps;
	protected boolean run;
	protected String code;
	
	public Modele(int n){
		run = false;
		position = 0;
		temps = 0;
		vitesse = 2;
		cases = new LesCases();
		genererTableau(n);
		initialiserTableau();
		creeVariable("", "trier");
		creeVariable("", "n");
		creeVariable("", "n-1");
		creeVariable("", "i");
		creeVariable("", "tmp");	
	}
	
	public void setCode(String s){
		code = s;
	}
	
	public String getCode(){
		return code;
	}
	
	/**
	 * 
	 * @return si l'algo est en cours d'éxécution
	 */
	public boolean isRun(){
		return run;
	}
	
	public void goStop(){
		run = ! run;
		setChanged();
		notifyObservers();
	}
	
	/**
	 * methode qui genere un tableau de n case, n'efface pas un ancien tableau eventuelle
	 * @param n nombre de case du tableau
	 */
	public void genererTableau(int n){
		for(int i = 0; i < n; i++){
			Case c = new Case("", 50*(i+1), 100, Constante.COULEUR_BASE);
			cases.addCase(c);
		}
	}
	
	/**
	 * methode qui met des valeurs dans les cases du tableau
	 */
	public void initialiserTableau(){
		Random r = new Random();
		for(ICase c : cases){
			if(!c.isVariable())
				c.setValeur(r.nextInt(101)+"");
		}
		setChanged();
		notifyObservers();
	}
	
	/**
	 * methode qui execute l'algorithme de trie à bulle
	 */
	public void run(){
		run = true;
		AlgoBulle algoB = new AlgoBulle(this);
		algoB.trier();
	}
	
	/**
	 * methode qui rafraichie la vue a la fin de l'execution de l'algorithme
	 */
	public void mettreAJour(){
		setChanged();
		notifyObservers();
	}
	
	/**
	 * accesseur en lecture sur lesCases 
	 * @return les cases
	 */
	public LesCases getLesCases(){
		return cases;
	}
	
	/**
	 * fonction qui retourne vrai si l'execution de l'algorithme est fini
	 * @return si il y a encore des mouvement a faire
	 */
	public boolean estFini(){
		return cases.estFini(temps);
	}
	
	/**
	 * fonction qui renvoie la nieme case du tableau
	 * @param num
	 * @return la nieme case du tableau
	 */
	public Case getCase(int num){
		return (Case) cases.getCase(num);
	}
	

	/**
	 * fonction qui renvoie la nieme variable
	 * @param num
	 * @return la nieme variable
	 */
	public Variable getVariable(int num){
		return (Variable) cases.getVariable(num);
	}

	/**
	 * accesseur en lecture sur la vitesse
	 * @return la vitesse
	 */
	public int getVitesse() {
		return vitesse;
	}

	/**
	 * affecte la vitesse et previent les vues
	 */
	public void setVitesse(int v) {
		vitesse = v;
		setChanged();
		notifyObservers();
	}
	
	/**
	 * fonction qui cr�e une case de variable
	 * @param val
	 */
	public void creeVariable(String val, String label){
		Variable c = new Variable(val, 50*cases.nbVariable(), Constante.Y_VARIABLE, Constante.COULEUR_VAR, label);
		cases.addCase(c);
	}
	
	/**
	 * fonction qui renvoie le tableau contenant les valeurs 
	 * @return tableau contenant les valeurs 
	 */
	public int[] getTab(){
		int[] rep = new int[cases.nbCase()];
		for(int i = 0; i < cases.nbCase(); i++){
			rep[i] = Integer.parseInt(cases.getCase(i).getValeur());
		}
		return rep;
	}

	/**
	 * accesseur en lecture sur le temps
	 * @return temps
	 */
	public int getTemps() {
		return temps;
	}

	/**
	 * incremente le temps de 1
	 */
	public void incTemps() {
		temps++;
	}
}

