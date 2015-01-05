package toucan.model.cases;

import java.awt.Color;

import toucan.model.mouvements.LesMouvements;
import toucan.model.mouvements.Mouvement;
import toucan.model.mouvements.MouvementBas;
import toucan.model.mouvements.MouvementDroite;
import toucan.model.mouvements.MouvementGauche;
import toucan.model.mouvements.MouvementHaut;
import toucan.model.mouvements.MouvementRester;

public class Case extends ICase {

    public Case(String v, int x, int y, Color coul) {
		super(v, x, y, coul);
	}

	/**
     * fonction qui renvoiee vrai si la case est une variable
     * @return
     */
    public boolean isVariable(){
    	return false;
    }
}
