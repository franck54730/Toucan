package toucan.model.animation;

import java.awt.Color;

import toucan.model.Constante;
import toucan.model.Modele;
import toucan.model.cases.Case;
import toucan.model.cases.ICase;

public class AffectationCaseCase extends IAnimation {

	public AffectationCaseCase(Modele m){
		super(m);
	}
	
	public void executer(int num1, int num2) {
		int decalage = 60;
		int deplacement;
		ICase case1 = model.getCase(num1);
		ICase case2 = model.getCase(num2);
		deplacement = case2.getPositionX()-case1.getPositionX();
		case1.monter(decalage, Constante.COULEUR_MVT);
		case2.rester(decalage, Constante.COULEUR_BASE);
		if(deplacement > 0){//mvt droite
			case1.droite(deplacement, Color.red);
		}else if(deplacement < 0){//mvt gauche
			case1.gauche(Math.abs(deplacement), Constante.COULEUR_MVT);
		}
		case2.rester(Math.abs(deplacement), Constante.COULEUR_BASE);
		case1.descendre(decalage, Constante.COULEUR_MVT);
		case2.rester(decalage, Constante.COULEUR_MVT);
		case2.setValeur(case1.getValeur());
		case1.monter(decalage, Constante.COULEUR_MVT);
		case2.rester(decalage, Constante.COULEUR_MVT);
		if(deplacement > 0){//mvt gauche
			case1.gauche(deplacement, Constante.COULEUR_MVT);
		}else if(deplacement < 0){//mvt droite;
			case1.droite(Math.abs(deplacement), Constante.COULEUR_MVT);
		}
		case1.descendre(decalage, Constante.COULEUR_MVT);
		case2.rester(decalage+Math.abs(deplacement), Constante.COULEUR_BASE);

		int tempsTot = 4*decalage+2*Math.abs(deplacement);
		//ajout d'un mouvement rester au autre
		for(int i = 0; i < model.getLesCases().nbCase();i++){
			if(i != num1 && i != num2){
				ICase cas = model.getCase(i);
				cas.rester(tempsTot, Constante.COULEUR_BASE);
			}
		}
		for(int i = 0; i < model.getLesCases().nbVariable();i++){
			ICase cas = model.getVariable(i);
			cas.rester(tempsTot, Constante.COULEUR_VAR);
		}
		reinit();
	}
}
