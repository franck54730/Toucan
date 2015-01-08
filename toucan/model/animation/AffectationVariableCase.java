package toucan.model.animation;

import java.awt.Color;

import toucan.model.Constante;
import toucan.model.Modele;
import toucan.model.cases.Case;
import toucan.model.cases.ICase;

public class AffectationVariableCase extends IAnimation {

	public AffectationVariableCase(Modele m){
		super(m);
	}
	
	@Override
	public void executer(int numCase, int numVar) {
		int decalage = 100;
		ICase laCase = model.getCase(numCase);
		ICase laVar = model.getVariable(numVar);
		boolean varAGauche = laVar.getPositionX()<laCase.getPositionX();
		int deplacement = Math.abs(laVar.getPositionX()-laCase.getPositionX());
		int tempsTot = 4*decalage+2*deplacement;
		laVar.monter(decalage, Constante.COULEUR_MVT);
		laCase.rester(decalage, Constante.COULEUR_BASE);

		if(varAGauche){
			laVar.droite(deplacement, Constante.COULEUR_MVT);
		}else{
			laVar.gauche(deplacement, Constante.COULEUR_MVT);
		}
		laCase.rester(deplacement, Constante.COULEUR_BASE);
		
		laVar.monter(decalage, Constante.COULEUR_MVT);
		laCase.rester(decalage, Constante.COULEUR_MVT);
		laCase.setValeur(laVar.getValeur());
		laVar.descendre(decalage, Constante.COULEUR_MVT);
		laCase.rester(decalage, Constante.COULEUR_MVT);

		if(varAGauche){
			laVar.gauche(deplacement, Constante.COULEUR_MVT);
		}else{
			laVar.droite(deplacement, Constante.COULEUR_MVT);
		}
		laCase.rester(deplacement, Constante.COULEUR_BASE);
		laVar.descendre(decalage, Constante.COULEUR_MVT);
		laCase.rester(decalage, Constante.COULEUR_BASE);
		//ajout d'un mouvement rester au autre
		for(int i = 0; i < model.getLesCases().nbCase();i++){
			if(i != numCase){
				ICase cas = model.getCase(i);
				cas.rester(tempsTot, Constante.COULEUR_BASE);
			}
		}
		for(int i = 0; i < model.getLesCases().nbVariable();i++){
			if(i != numVar){
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
