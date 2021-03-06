package toucan.model.animation;

import java.awt.Color;

import toucan.model.Constante;
import toucan.model.Modele;
import toucan.model.cases.Case;
import toucan.model.cases.ICase;

public class AffectationVariable extends IAnimation {

	public AffectationVariable(Modele m){
		super(m);
	}
	
	public void executer(String name, String val) {
		int temps = 15;
		ICase var= model.getVariable(name);
		var.rester(temps, Constante.COULEUR_MVT);
		var.setValeur(val+"");
		var.rester(temps, Constante.COULEUR_MVT);
		//ajout d'un mouvement rester au autre
		for(int i = 0; i < model.getLesCases().nbCase();i++){
			ICase cas = model.getCase(i);
			cas.rester(2*temps, Constante.COULEUR_BASE);
		}
		int num = model.getVariableIndice(name);
		for(int i = 0; i < model.getLesCases().nbVariable();i++){
			if(i != num){
				ICase cas = model.getVariable(i);
				cas.rester(2*temps, Constante.COULEUR_VAR);
			}
		}
		reinit();
	}

	public void executer(int num1, String val) {
		int temps = 15;
		ICase var= model.getVariable(num1);
		var.rester(temps, Constante.COULEUR_MVT);
		var.setValeur(val+"");
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

	public void executer(int num, int val) {
		int temps = 15;
		ICase var= model.getVariable(num);
		var.rester(temps, Constante.COULEUR_MVT);
		var.setValeur(val+"");
		var.rester(temps, Constante.COULEUR_MVT);
		//ajout d'un mouvement rester au autre
		for(int i = 0; i < model.getLesCases().nbCase();i++){
			ICase cas = model.getCase(i);
			cas.rester(2*temps, Constante.COULEUR_BASE);
		}
		for(int i = 0; i < model.getLesCases().nbVariable();i++){
			if(i != num){
				ICase cas = model.getVariable(i);
				cas.rester(2*temps, Constante.COULEUR_VAR);
			}
		}
		reinit();
	}

}
