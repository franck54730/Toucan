package toucan.model.animation;

import java.awt.Color;

import toucan.model.Constante;
import toucan.model.Modele;
import toucan.model.cases.Case;
import toucan.model.cases.ICase;

public class AffectationVariableVariable extends IAnimation {
	
	public AffectationVariableVariable(Modele m){
		super(m);
	}
	
	@Override
	public void executer(int num1, int num2) {
		int decalage = 100;
		ICase var1 = model.getVariable(num1);
		ICase var2 = model.getVariable(num2);
		boolean var1AGauche = var1.getPositionX()<var2.getPositionX();
		int deplacement = Math.abs(var1.getPositionX()-var2.getPositionX());
		int tempsTot = 4*decalage+2*deplacement;
		var1.monter(decalage, Constante.COULEUR_MVT);
		var2.rester(decalage, Constante.COULEUR_VAR);

		if(var1AGauche){
			var1.droite(deplacement, Constante.COULEUR_MVT);
		}else{
			var1.gauche(deplacement, Constante.COULEUR_MVT);
		}
		var2.rester(deplacement, Constante.COULEUR_VAR);
		
		var1.descendre(decalage, Constante.COULEUR_MVT);
		var2.rester(decalage, Constante.COULEUR_MVT);
		var2.setValeur(var1.getValeur());
		var1.monter(decalage, Constante.COULEUR_MVT);
		var2.rester(decalage, Constante.COULEUR_MVT);

		if(var1AGauche){
			var1.gauche(deplacement, Constante.COULEUR_MVT);
		}else{
			var1.droite(deplacement, Constante.COULEUR_MVT);
		}
		var2.rester(deplacement, Constante.COULEUR_VAR);
		var1.descendre(decalage, Constante.COULEUR_MVT);
		var2.rester(decalage, Constante.COULEUR_VAR);
		//ajout d'un mouvement rester au autre
		for(int i = 0; i < model.getLesCases().nbCase();i++){
			ICase cas = model.getCase(i);
			cas.rester(tempsTot, Constante.COULEUR_BASE);
		}
		for(int i = 0; i < model.getLesCases().nbVariable();i++){
			if(i != num1 && i != num2){
				ICase cas = model.getVariable(i);
				cas.rester(tempsTot, Constante.COULEUR_VAR);
			}
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
