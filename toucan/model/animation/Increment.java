package toucan.model.animation;

import java.awt.Color;

import toucan.model.Constante;
import toucan.model.Modele;
import toucan.model.cases.Case;
import toucan.model.cases.ICase;

public class Increment extends IAnimation {

	public Increment(Modele m){
		super(m);
	}
	
	@Override
	public void executer(int num1) {
		int temps = 10;
		ICase case1 = model.getVariable(num1);
		case1.monter(temps, Constante.COULEUR_MVT);
		case1.descendre(temps, Constante.COULEUR_MVT);
		case1.monter(temps, Constante.COULEUR_MVT);
		case1.setValeur((Integer.parseInt(case1.getValeur())+1)+"");
		case1.descendre(temps, Constante.COULEUR_MVT);
		case1.monter(temps, Constante.COULEUR_MVT);
		case1.descendre(temps, Constante.COULEUR_MVT);
		//ajout d'un mouvement rester au autre
		for(int i = 0; i < model.getLesCases().nbCase();i++){
			ICase cas = model.getCase(i);
			cas.rester(6*temps, Constante.COULEUR_BASE);
		}
		for(int i = 0; i < model.getLesCases().nbVariable();i++){
			if(i != num1){
				ICase cas = model.getVariable(i);
				cas.rester(6*temps, Constante.COULEUR_VAR);
			}
		}
		reinit();
	}

	@Override
	public void executer(int num1, int num2) {
	}

}
