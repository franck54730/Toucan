package toucan.model.animation;

import java.awt.Color;

import toucan.model.Constante;
import toucan.model.Modele;
import toucan.model.cases.Case;
import toucan.model.cases.ICase;

public class AffectationCaseVariable extends IAnimation {

	public AffectationCaseVariable(Modele m){
		super(m);
	}
	
	@Override
	public void executer(int numCase, int numVar) {
		int decalage = 100;
		int tempsTot = 0;
		int deplacement;
		ICase laCase = model.getCase(numCase);
		ICase laVar = model.getVariable(numVar);
		boolean varAGauche = laVar.getPositionX()<laCase.getPositionX();
		deplacement = Math.abs(laVar.getPositionX()-laCase.getPositionX());
		laCase.descendre(decalage, Constante.COULEUR_MVT);
		laVar.rester(decalage, Constante.COULEUR_VAR);
		tempsTot += decalage;
		
		if(!varAGauche){
			laCase.droite(deplacement, Constante.COULEUR_MVT);
		}else{
			laCase.gauche(deplacement, Constante.COULEUR_MVT);
		}
		laVar.rester(deplacement, Constante.COULEUR_VAR);
		tempsTot += deplacement;
		
		laCase.descendre(decalage, Constante.COULEUR_MVT);
		laVar.rester(decalage, Constante.COULEUR_MVT);
		tempsTot += decalage;
		
		laVar.setValeur(laCase.getValeur());
		
		laCase.monter(decalage, Constante.COULEUR_MVT);
		laVar.rester(decalage, Constante.COULEUR_MVT);
		tempsTot += decalage;

		if(varAGauche)
			laCase.droite(deplacement, Constante.COULEUR_MVT);
		else
			laCase.gauche(deplacement, Constante.COULEUR_MVT);
		laVar.rester(deplacement, Constante.COULEUR_VAR);
		tempsTot += deplacement;
		
		laCase.monter(decalage, Constante.COULEUR_MVT);
		laVar.rester(decalage, Constante.COULEUR_VAR);
		tempsTot += decalage;
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
		// TODO Stub de la m�thode g�n�r� automatiquement
		
	}

}
