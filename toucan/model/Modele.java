package toucan.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

import toucan.model.algo.AlgoBulle;
import toucan.model.algo.AlgoFacade;
import toucan.model.algo.AlgoInsertion;
import toucan.model.algo.AbstractAlgo;
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
	protected ArrayList<Integer> saveTab;
	protected int vitesse;
	protected int temps;
	protected int run;
	protected String code;
	protected AbstractAlgo algo;
	
	public void setAlgo(int i){
		//run = Constante.ETAT_DEPART;
		switch(i){
			case Constante.ID_ALGO_BULLE : 
				algo = new AlgoBulle(this);
				break;
			case Constante.ID_ALGO_INSERTION :
				algo = new AlgoInsertion(this);
				break;
			case Constante.ID_ALGO_PERSO :
				algo = new AlgoFacade(this);
				break;
		}
	}
	
	public Modele(int n){
		algo = new AlgoBulle(this);
		run = Constante.ETAT_DEPART;
		temps = 0;
		vitesse = 2;
		code = "";
		cases = new LesCases();
		saveTab = new ArrayList<Integer>();
		genererTableau(n);
		initialiserTableau();	
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
		return run == Constante.ETAT_RUN;
	}
	
	/**
	 * 
	 * @return si l'algo est en cours d'éxécution
	 */
	public boolean isDepart(){
		return run == Constante.ETAT_DEPART;
	}
	
	
	public void goStop(){
		if(run == Constante.ETAT_DEPART){
			Thread t = new Thread((Runnable) this, "Toucan");
			t.start();
		}else if(run == Constante.ETAT_PAUSE){
			run = Constante.ETAT_RUN;
		}else{
			run = Constante.ETAT_PAUSE;
		}
		setChanged();
		notifyObservers();
	}
	
	/**
	 * methode qui genere un tableau de n case, efface un ancien tableau eventuelle
	 * @param n nombre de case du tableau
	 */
	public void genererTableau(int n){
		cases.vider();
		saveTab.clear();
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
			if(!c.isVariable()){
				int val = r.nextInt(101);
				c.setValeur(val+"");
				saveTab.add(val);
			}
		}
		setChanged();
		notifyObservers();
	}
	
	/**
	 * methode qui execute l'algorithme de trie à bulle
	 */
	public void run(){
		run = Constante.ETAT_RUN;
		algo.trier();
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
	
	public int getNbCases(){
		return cases.nbCase();
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
	 * fonction qui renvoie la nieme variable
	 * @param num
	 * @return la nieme variable
	 */
	public Variable getVariable(String name){
		return (Variable) cases.getVariable(name);
	}
	
	/**
	 * fonction qui renvoie l'indice d'une variable variable
	 * @param name 
	 * @return la nieme variable
	 */
	public int getVariableIndice(String name){
		return cases.getVariableIndice(name);
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
		boolean trouv = false;
		int nb = cases.nbVariable();
		for(int i = 0; i < nb;i++){
			if(((Variable)cases.getVariable(i)).getLabel().equals(label))
				trouv = true;
			else
				i++;
		}
		if(!trouv){
			Variable c = new Variable(val, 50*cases.nbVariable(), Constante.Y_VARIABLE, Constante.COULEUR_VAR, label);
			c.rester(tempsMax(), Constante.COULEUR_VAR);
			cases.addCase(c);
		}
	}
	
	public int tempsMax(){
		int rep = 0;
		for(ICase c : cases){
			int t = c.getTempsMax();
			if(rep<t){
				rep = t;
			}
		}
		return rep;
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
	
	public String getRunBoutonText(){
		String rep = "";
		if(run == Constante.ETAT_RUN){
			rep = "Pause";
		}else if(run == Constante.ETAT_DEPART){
			rep = "Commencer";
		}else{
			rep = "Continuer";
		}
		return rep;
	}
	
	public void reinit(){
		algo = new AlgoBulle(this);
		run = Constante.ETAT_DEPART;
		temps = 0;
		code = "";
		genererTableau(Constante.NB_CASES);
		initialiserTableau();
		setChanged();
		notifyObservers();
	}
	
	public void viderVariable(){
		cases.viderVariable();
	}
	
	public void arret(){
		LesCases nLC = new LesCases(cases, saveTab);
		cases = nLC;
		run = Constante.ETAT_DEPART;
		temps = 0;
		setChanged();
		notifyObservers();
	}
}

