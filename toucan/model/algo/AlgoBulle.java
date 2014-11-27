package toucan.model.algo;

import toucan.model.Modele;
import toucan.model.animation.AffectationCaseCase;
import toucan.model.animation.AffectationCaseVariable;
import toucan.model.animation.AffectationVariableCase;
import toucan.model.animation.ComparaisonCaseCase;
import toucan.model.animation.ComparaisonVariableCase;

public class AlgoBulle extends IAlgo {
	
	public AlgoBulle(Modele m){
		super(m);
	}
	
	@Override
	public void trier() {
		int indiceEncore = 0;
		int indiceN = 1;
		int indiceN_1 = 2;
		int indiceJ = 3;
		int indiceTmp = 4;
		boolean encore = true ;
		affB.executer(indiceEncore, encore ? 1:0);
		int n = model.getLesCases().nbCase() ;
		affV.executer(indiceN, n);
		affV.executer(indiceN_1, n-1);
		int[] tab = model.getTab();
		model.mettreAJour();
		while (encore) {
			encore = false ;
			affB.executer(indiceEncore, encore? 1:0);
			affV.executer(indiceJ,0);
			compVV.executer(indiceJ, indiceN_1);
			for (int j = 0 ; j < n - 1; j++) {
				compCC.executer(j, j+1);
				if (tab[j] > tab[j+1]) {
					affCV.executer(j, indiceTmp);
					int var = tab[j] ;
					affCC.executer(j+1, j);
					tab[j] = tab[j+1] ;
					affVC.executer(j+1, indiceTmp);
					tab[j+1] = var ;
					encore = true ;
					affB.executer(indiceEncore, encore? 1:0);
				}
				inc.executer(indiceJ);
				compVV.executer(indiceJ, indiceN_1);
				model.mettreAJour();
			}
			n = n-1 ;
			affV.executer(indiceN, n);
			affV.executer(indiceN_1, n-1);
		}
	}

}
