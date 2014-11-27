package toucan.model.animation;

import toucan.model.Constante;
import toucan.model.Modele;
import toucan.model.cases.Case;
import toucan.model.cases.ICase;

public class ComparaisonVariableCase extends IComparaison {

	public ComparaisonVariableCase(Modele m){
		super(m);
	}
	
	@Override
	public void executer(int num1, int num2) {
		//TODO gestion droite gauche
		int decalage = 100;
		int tempsCompare = 0;
		System.out.println(num1);
		ICase laCase = model.getCase(num1);
		ICase laVar = model.getVariable(num2);
		laCase.descendre(decalage, Constante.COULEUR_COMP);
		laVar.monter(decalage, Constante.COULEUR_COMP);
		
		//dec

		boolean varAGauche = laVar.getPositionX()<laCase.getPositionX();
		int distance = Math.abs(laCase.getPositionX()-laVar.getPositionX());
		int parcours = (distance-50)/2;
		//int tempsTot = 0;
		if(parcours > 0){
			if(laCase.getPositionX()<laVar.getPositionX()){//case1 a gauche de case2
				laCase.droite(parcours, Constante.COULEUR_COMP);
				laVar.gauche(parcours, Constante.COULEUR_COMP);
				tempsCompare += comparer(laCase, laVar);
				laCase.gauche(parcours, Constante.COULEUR_COMP);
				laVar.droite(parcours, Constante.COULEUR_COMP);
			}else{
				laCase.gauche(parcours, Constante.COULEUR_COMP);
				laVar.droite(parcours, Constante.COULEUR_COMP);
				tempsCompare += comparer(laVar, laCase);
				laCase.droite(parcours, Constante.COULEUR_COMP);
				laVar.gauche(parcours, Constante.COULEUR_COMP);
			}
		}else if(parcours < 0){
			parcours = 25;
			laCase.droite(parcours, Constante.COULEUR_COMP);
			laVar.gauche(parcours, Constante.COULEUR_COMP);
			tempsCompare += comparer(laCase, laVar);
			laCase.gauche(parcours, Constante.COULEUR_COMP);
			laVar.droite(parcours, Constante.COULEUR_COMP);
		}else{
			tempsCompare += comparer(laCase, laVar);
		}
		laCase.monter(decalage, Constante.COULEUR_COMP);
		laVar.descendre(decalage, Constante.COULEUR_COMP);
		int tempsTot = 2*decalage+2*parcours+tempsCompare;
		System.out.println("tps : " + tempsTot + "  tps comp : "+ tempsCompare);
		//ajout d'un mouvement rester au autre case
		for(int i = 0; i < model.getLesCases().nbCase();i++){
			if(i != num1){
				ICase cas = model.getCase(i);
				cas.rester(tempsTot, Constante.COULEUR_BASE);
			}
		}
		for(int i = 0; i < model.getLesCases().nbVariable();i++){
			if(i != num2){
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
