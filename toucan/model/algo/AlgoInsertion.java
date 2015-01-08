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
	public void trier() {/*
		System.out.println("tri insert : ");
		int[] tab = model.getTab();
		int n = model.getLesCases().nbCase() ;
		System.out.println(Arrays.toString(tab));
		int i, j;
		for (i = 1; i < n; ++i) {
			int elem = tab[i];
			affCV.executer(i, 0);
			j=i;
			compVC.executer(j-1, 0);
			while (j > 0 && tab[j-1] > elem){
				tab[j] = tab[j-1];
				affCC.executer(j-1, j);
				j--;
				compVC.executer(j-1, 0);
			}
			tab[j] = elem;
			affVC.executer(j, 0);
		}
		System.out.println(Arrays.toString(tab));*/
		
		model.viderVariable();
		model.creeVariable("", "encore");
		model.creeVariable("", "n");
		model.creeVariable("", "i");
		model.creeVariable("", "tmp");
		model.mettreAJour();
		affCV.executer(0, "i");
		/*
		model.viderVariable();
		int[] tab = model.getTab();
		int nbCases = model.getNbCases();
		model.creeVariable("", "i");int i ;affCV.executer(0, "i");
		i = tab[0]
		 ;
		 */
	}

}
