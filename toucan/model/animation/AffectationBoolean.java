package toucan.model.animation;

import java.awt.Color;

import toucan.model.Constante;
import toucan.model.Modele;
import toucan.model.cases.Case;
import toucan.model.cases.ICase;

public class AffectationBoolean extends IAnimation {

	public AffectationBoolean(Modele m){
		super(m);
	}
	
	@Override
	public void executer(int num1) {
	
	}

	@Override
	public void executer(int num1, int val) {
		int temps = 15;
		ICase var= model.getVariable(num1);
		var.rester(temps, Constante.COULEUR_MVT);
		var.setValeur(val == 1 ? "true" : "false");
		var.rester(temps, Constante.COULEUR_MVT);
		//ajout d'un mouvement rester au autre
		for(int i = 0; i < model.getLesCases().nbCase();i++){
			ICase cas = model.getCase(i);
			cas.rester(2*temps, Constante.COULEUR_BASE);
		}
		for(int i = 0; i < model.getLesCases().nbVariable();i++){
			if(i != num1){
				ICase cas = model.getVariable(i);
				cas.rester(2*temps, Constante.COULEUR_VAR);
			}
		}
		reinit();
	}

}
