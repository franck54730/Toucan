package toucan.model.cases;

import java.util.ArrayList;
import java.util.Iterator;

public class LesCases implements Iterable<ICase>{
	protected ArrayList<ICase> cases;
	
	public LesCases(){
		cases = new ArrayList<ICase>();
	}

	public Iterator<ICase> iterator() {
		return cases.iterator();
	}
	
	public void addCase(ICase c){
		cases.add(c);
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
}
