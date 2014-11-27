package toucan.model.animation;

import toucan.model.Constante;
import toucan.model.Modele;
import toucan.model.cases.Case;
import toucan.model.cases.ICase;

public abstract class IComparaison extends IAnimation {
	
	public IComparaison(Modele m){
		super(m);
	}
	/**
	 * fonction qui execute une annimation entre deux cases
	 * @param num1
	 * @param num2
	 */
	public abstract void executer(int num1, int num2);
	
	/**
	 * fonction qui execute une annimation sur une case
	 * @param num1
	 */
	public abstract void executer(int num1);
	
	/**
	 * fonction qui execute l'annimation de la comparaison des deux cases
	 * @param num1
	 */
	public int comparer(ICase caseG, ICase caseD){
		int duree = 8;
		if(Integer.valueOf(caseG.getValeur())<Integer.valueOf(caseD.getValeur())){//si caseG < caseD
			caseG.descendre(duree, Constante.COULEUR_COMP_MOINS);
			caseD.monter(duree, Constante.COULEUR_COMP_PLUS);
			caseG.rester(duree, Constante.COULEUR_COMP_MOINS);
			caseD.rester(duree, Constante.COULEUR_COMP_PLUS);
			caseG.monter(duree, Constante.COULEUR_COMP_MOINS);
			caseD.descendre(duree, Constante.COULEUR_COMP_PLUS);
		}else if(Integer.valueOf(caseG.getValeur())>Integer.valueOf(caseD.getValeur())){//si caseG > caseD
			caseD.descendre(duree, Constante.COULEUR_COMP_MOINS);
			caseG.monter(duree, Constante.COULEUR_COMP_PLUS);
			caseD.rester(duree, Constante.COULEUR_COMP_MOINS);
			caseG.rester(duree, Constante.COULEUR_COMP_PLUS);
			caseD.monter(duree, Constante.COULEUR_COMP_MOINS);
			caseG.descendre(duree, Constante.COULEUR_COMP_PLUS);
		}else{
			caseD.gauche(duree, Constante.COULEUR_COMP);
			caseG.droite(duree, Constante.COULEUR_COMP);
			caseD.rester(duree, Constante.COULEUR_COMP);
			caseG.rester(duree, Constante.COULEUR_COMP);
			caseD.droite(duree, Constante.COULEUR_COMP);
			caseG.gauche(duree, Constante.COULEUR_COMP);
		}
		return duree *3;
	}
}
