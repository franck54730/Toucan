package toucan.model.animation;

import java.awt.Color;

import toucan.model.Constante;
import toucan.model.Modele;
import toucan.model.cases.Case;
import toucan.model.cases.ICase;

public class AffectationCase extends IAnimation {

	public AffectationCase(Modele m){
		super(m);
	}
	
	@Override
	public void executer(int num1, int val) {
		int temps = 15;
		ICase case1 = model.getCase(num1);
		case1.rester(temps, Constante.COULEUR_MVT);
		case1.setValeur(val+"");
		case1.rester(temps, Constante.COULEUR_MVT);
		//ajout d'un mouvement rester au autre
		for(int i = 0; i < model.getLesCases().nbCase();i++){
			if(i != num1){
				ICase cas = model.getCase(i);
				cas.rester(2*temps, Constante.COULEUR_BASE);
			}
		}
		for(int i = 0; i < model.getLesCases().nbVariable();i++){
			ICase cas = model.getVariable(i);
			cas.rester(2*temps, Constante.COULEUR_VAR);
		}
		reinit();
	}

	@Override
	public void executer(int num1) {
		// TODO Stub de la mï¿½thode gï¿½nï¿½rï¿½ automatiquement
		
	}

	@Override
	public void executer(String var, String val) {
		// TODO Stub de la méthode généré automatiquement
		
	}

}
