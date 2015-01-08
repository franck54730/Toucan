package toucan.model.algo;

import toucan.model.Modele;

public class AlgoBulle extends AbstractAlgo {
	
	public AlgoBulle(Modele m) {
		super(m);
	}

	@Override
	public void trier() {
		model.viderVariable();
		model.creeVariable("", "encore");
		model.creeVariable("", "n");
		model.creeVariable("", "i");
		model.creeVariable("", "tmp");
		boolean encore = true ;
		affB.executer(model.getVariableIndice("encore"), encore ? 1:0);
		int n = model.getLesCases().nbCase() ;
		affV.executer(model.getVariableIndice("n"), n);
		int[] tab = model.getTab();
		model.mettreAJour();
		while (encore) {
			encore = false ;
			affB.executer(model.getVariableIndice("encore"), encore? 1:0);
			affV.executer(model.getVariableIndice("i"),0);
			compVV.executer(model.getVariableIndice("i"), model.getVariableIndice("n"));
			for (int j = 0 ; j < n - 1; j++) {
				compCC.executer(j, j+1);
				if (tab[j] > tab[j+1]) {
					affCV.executer(j, model.getVariableIndice("tmp"));
					int var = tab[j] ;
					affCC.executer(j+1, j);
					tab[j] = tab[j+1] ;
					affVC.executer(j+1, model.getVariableIndice("tmp"));
					tab[j+1] = var ;
					encore = true ;
					affB.executer(model.getVariableIndice("encore"), encore? 1:0);
				}
				inc.executer(model.getVariableIndice("i"));
				compVV.executer(model.getVariableIndice("i"), model.getVariableIndice("n"));
				model.mettreAJour();
			}
			n = n-1 ;
			affV.executer(model.getVariableIndice("n"), n);
		}
	}

}
