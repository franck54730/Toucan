package toucan.model.cases;

import java.awt.Color;

import toucan.model.mouvements.LesMouvements;
import toucan.model.mouvements.Mouvement;
import toucan.model.mouvements.MouvementBas;
import toucan.model.mouvements.MouvementDroite;
import toucan.model.mouvements.MouvementGauche;
import toucan.model.mouvements.MouvementHaut;
import toucan.model.mouvements.MouvementRester;

public class Variable extends ICase {
	
	protected String label;
	
    public Variable(String v, int x, int y, Color coul, String l) {
		super(v, x, y, coul);
		label = l;
		
	}

	/**
     * fonction qui renvoiee vrai si la case est une variable
     * @return
     */
    public boolean isVariable(){
    	return true;
    }
    
    /**
     * retourne le label de la case
     * @return
     */
    public String getLabel(){
    	return label;
    }
}
