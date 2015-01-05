package toucan.model.algo;

import java.util.Arrays;

import toucan.model.Modele;
import toucan.model.animation.AffectationCaseCase;
import toucan.model.animation.AffectationCaseVariable;
import toucan.model.animation.AffectationVariableCase;
import toucan.model.animation.ComparaisonCaseCase;
import toucan.model.animation.ComparaisonVariableCase;

public class AlgoInsertion extends IAlgo {
	
	public AlgoInsertion(Modele m){
		super(m);
	}
	
	@Override
	public void trier() {
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
		System.out.println(Arrays.toString(tab));
	}

}
