package toucan.graphique;

import java.util.ArrayList;
import java.util.Iterator;


public class LesCasesGraphiques implements Iterable<CaseGraphique>{

	protected ArrayList<CaseGraphique> casesGraphiques;
	
	public LesCasesGraphiques(){
		casesGraphiques = new ArrayList<CaseGraphique>();
	}
	
	/**
	 * ajoute une case graphique à la liste
	 * @param c CaseGraphique a ajouter
	 */
	public void ajouter(CaseGraphique c){
		casesGraphiques.add(c);
	}


	/**
	 * retourne un iterator sur la liste des cases graphiques
	 */
	@Override
	public Iterator<CaseGraphique> iterator() {
		return casesGraphiques.iterator();
	}
}
