package toucan.graphique;

import java.util.ArrayList;
import java.util.Iterator;


public class LesLabelGraphiques implements Iterable<LabelGraphic>{

	protected ArrayList<LabelGraphic> casesGraphiques;
	
	public LesLabelGraphiques(){
		casesGraphiques = new ArrayList<LabelGraphic>();
	}
	
	/**
	 * ajoute une case graphique � la liste
	 * @param c CaseGraphique a ajouter
	 */
	public void ajouter(LabelGraphic c){
		casesGraphiques.add(c);
	}


	/**
	 * retourne un iterator sur la liste des cases graphiques
	 */
	public Iterator<LabelGraphic> iterator() {
		return casesGraphiques.iterator();
	}
}
