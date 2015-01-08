package toucan.model.animation;

import toucan.model.Constante;
import toucan.model.Modele;
import toucan.model.cases.Case;
import toucan.model.cases.ICase;

public class ComparaisonVariableVariable extends IComparaison {

	public ComparaisonVariableVariable(Modele m){
		super(m);
	}
	
	@Override
	public void executer(int num1, int num2) {
		int decalage = 60;
		int tempsTot = 0;
		ICase case1 = model.getVariable(num1);
		ICase case2 = model.getVariable(num2);
		case1.monter(decalage, Constante.COULEUR_COMP);
		case2.monter(decalage, Constante.COULEUR_COMP);
		tempsTot += decalage;
		int distance = Math.abs(case1.getPositionX()-case2.getPositionX());
		int parcours = (distance-50)/2;
		if(parcours > 0){
			if(case1.getPositionX()<case2.getPositionX()){//case1 a gauche de case2
				case1.droite(parcours, Constante.COULEUR_COMP);
				case2.gauche(parcours, Constante.COULEUR_COMP);
				tempsTot += parcours;
				tempsTot += comparer(case1, case2);
				case1.gauche(parcours, Constante.COULEUR_COMP);
				case2.droite(parcours, Constante.COULEUR_COMP);
				tempsTot += parcours;
			}else{
				case1.gauche(parcours, Constante.COULEUR_COMP);
				case2.droite(parcours, Constante.COULEUR_COMP);
				tempsTot += parcours;
				tempsTot += comparer(case2, case1);
				case1.droite(parcours, Constante.COULEUR_COMP);
				case2.gauche(parcours, Constante.COULEUR_COMP);
				tempsTot += parcours;
			}
		}else{
			tempsTot += comparer(case1, case2);
		}
		case1.descendre(decalage, Constante.COULEUR_COMP);
		case2.descendre(decalage, Constante.COULEUR_COMP);
		tempsTot += decalage;
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
