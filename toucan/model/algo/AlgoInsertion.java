package toucan.model.algo;

import java.util.Arrays;

import toucan.model.Modele;
import toucan.model.animation.AffectationBoolean;
import toucan.model.animation.AffectationCase;
import toucan.model.animation.AffectationCaseCase;
import toucan.model.animation.AffectationCaseVariable;
import toucan.model.animation.AffectationVariable;
import toucan.model.animation.AffectationVariableCase;
import toucan.model.animation.AffectationVariableVariable;
import toucan.model.animation.ComparaisonCaseCase;
import toucan.model.animation.ComparaisonVariableCase;
import toucan.model.animation.ComparaisonVariableVariable;
import toucan.model.animation.Increment;

public class AlgoInsertion extends AbstractAlgo {
	
	public AlgoInsertion(Modele m){
		super(m);
	}
	
	/*
	public void setModel(Modele m){
		model = m;
		affCC = new AffectationCaseCase(model);
		affCV = new AffectationCaseVariable(model);
		affVC = new AffectationVariableCase(model);
		compCC = new ComparaisonCaseCase(model);
		compVC = new ComparaisonVariableCase(model);
		affVV = new AffectationVariableVariable(model);
		compVV = new ComparaisonVariableVariable(model);
		affC = new AffectationCase(model);
		affV = new AffectationVariable(model);
		inc = new Increment(model);
		affB = new AffectationBoolean(model);
	}*/
	
	@Override
	public void trier() {
		/*
  procédure tri_insertion(tableau T, entier n)
      pour i de 1 à n-1
          x ← T[i]
          j ← i
          tant que j > 0 et T[j - 1] > x
              T[j] ← T[j - 1]
              j ← j - 1
          fin tant que
          T[j] ← x
     fin pour
  fin procédure
		 */
		int[] tab = model.getTab();
		int nbCases = model.getLesCases().nbCase() ;
		model.viderVariable();
		model.creeVariable("", "n");
		model.creeVariable("", "i");
		model.creeVariable("", "j");
		model.creeVariable("", "tmp");
		model.mettreAJour();
		affV.executer(model.getVariableIndice("n"), nbCases);
		affV.executer(model.getVariableIndice("i"), 1);
		compVV.executer(model.getVariableIndice("i"), model.getVariableIndice("n"));
		for(int i = 1; i < nbCases; i++){
			int x = tab[i];
			affCV.executer(i, model.getVariableIndice("tmp"));
			int j = i;
			affVV.executer(model.getVariableIndice("i"), model.getVariableIndice("j"));
			compVC.executer(j-1, model.getVariableIndice("tmp"));
			while(j > 0 && tab[j-1] > x){
				tab[j] = tab[j-1];
				affCC.executer(j-1, j);
				j = j-1;
				affV.executer(model.getVariableIndice("j"), j-1);
				compVC.executer(j, model.getVariableIndice("tmp"));
			}
			tab[j] = x;
			affVC.executer(j, model.getVariableIndice("tmp"));
			inc.executer(model.getVariableIndice("i"));
		}
	}

}
