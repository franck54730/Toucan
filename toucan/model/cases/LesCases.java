package toucan.model.cases;

import java.util.ArrayList;
import java.util.Iterator;

import toucan.model.Constante;

public class LesCases implements Iterable<ICase>{
	protected ArrayList<ICase> cases;
	
	public LesCases(){
		cases = new ArrayList<ICase>();
	}
	
	public Case getCaseForValeur(String val){
		Case rep = null;
		int i = 0;
		boolean trouv = false;
		while(!trouv && i < this.nbCase()){
			Case c = (Case) getCase(i);
			if(c.getValeur().equals(val)){
				rep = c;
				trouv = true;
			}
			i++;
		}
		return rep;
	}

	public LesCases(LesCases lc, ArrayList<Integer> tab){
		cases = new ArrayList<ICase>();
		int nbVar = 0;
		int nbCase = 0;
		for(int i = 0; i < tab.size();i++){
			Case newC = new Case(tab.get(i)+"", 50*(nbCase+1), 100, Constante.COULEUR_BASE);
			this.addCase(newC);
			nbCase++;
		}
		for(int j = 0; j < lc.nbVariable(); j++){
			Variable oldC = (Variable) lc.getVariable(j);
			Variable newC = new Variable(oldC.getValeur(), 50*nbVar, Constante.Y_VARIABLE, Constante.COULEUR_VAR, ((Variable)oldC).getLabel());
			this.addCase(newC);
			nbVar++;
		}
	}
	
	public Iterator<ICase> iterator() {
		return cases.iterator();
	}
	
	public void addCase(ICase c){
		cases.add(c);
	}
	
	public void vider(){
		cases.clear();
	}
	
	/**
	 * renvoie vrai si il n'y a plus de mouvement a faire au temps t
	 * @param temps
	 * @return
	 */
	public boolean estFini(int temps){
		int max = 0;
		for(ICase c : cases){
			if(max < c.getTempsMax())
				max = c.getTempsMax();
		}
		return temps > max;
	}

	/**
	 * renvoie la nieme case 
	 * @param num
	 * @return
	 */
	public ICase getCase(int num){
		int nbCase = 0;
		ICase rep = null;
		int i = 0;
		boolean trouv = false;
		while(!trouv && i < cases.size()){
			ICase c = cases.get(i);
			if(!c.isVariable()){
				if(nbCase == num){
					rep = c;
					trouv = true;
				}
				nbCase++;
			}
			i++;
		}
		return rep;
	}
	
	/**
	 * renvoie le nombre de case du tableau 
	 * @return
	 */
	public int nbCase(){
		int rep = 0;
		for(ICase c : cases){
			if(!c.isVariable())
				rep++;
		}
		return rep;
	}
	
	/**
	 * renvoie le nombre de variable
	 * @return
	 */
	public int nbVariable(){
		int rep = 0;
		for(ICase c : cases){
			if(c.isVariable())
				rep++;
		}
		return rep;
	}
	
	/**
	 * renvoie la nieme variable
	 * @param num
	 * @return
	 */
	public ICase getVariable(int num){
		int nbVar = 0;
		ICase rep = null;
		int i = 0;
		boolean trouv = false;
		while(!trouv && i < cases.size()){
			ICase c = cases.get(i);
			if(c.isVariable()){
				if(nbVar == num){
					rep = c;
					trouv = true;
				}
				nbVar++;
			}
			i++;
		}
		return rep;
	}
	
	/**
	 * fonction qui renvoie la indice d'un variable
	 * @param name
	 * @return la nieme variable
	 */
	public int getVariableIndice(String name){
		int rep = -1;
		int i = 0;
		int nb = 0;
		boolean trouv = false;
		while(!trouv && i < cases.size()){
			ICase c = cases.get(i);
			if(c.isVariable()){
				if(((Variable)c).getLabel().equals(name)){
					rep = nb;
					trouv = true;
				}
				nb++;
			}
			i++;
		}
		return rep;
	}
	
	/**
	 * renvoie la nieme variable
	 * @param num
	 * @return
	 */
	public ICase getVariable(String var){
		ICase rep = null;
		int i = 0;
		boolean trouv = false;
		while(!trouv && i < cases.size()){
			ICase c = cases.get(i);
			if(c.isVariable()){
				if(((Variable)c).getLabel().equals(var)){
					rep = c;
					trouv = true;
				}
			}
			i++;
		}
		return rep;
	}
	
	public void viderVariable(){
		ArrayList<ICase> newAl = new ArrayList<ICase>();
		for(ICase c : cases){
			if(!c.isVariable())
				newAl.add(c);
		}
		cases = newAl;
	}
}
