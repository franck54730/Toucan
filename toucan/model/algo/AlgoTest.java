package toucan.model.algo;

import toucan.model.Modele;
import toucan.model.animation.AffectationCaseCase;
import toucan.model.animation.AffectationCaseVariable;
import toucan.model.animation.AffectationVariableCase;
import toucan.model.animation.AffectationVariableVariable;
import toucan.model.animation.ComparaisonCaseCase;
import toucan.model.animation.ComparaisonVariableCase;
import toucan.model.animation.ComparaisonVariableVariable;

public class AlgoTest extends IAlgo {
	
	public AlgoTest(Modele m) {
		super(m);
	}

	@Override
	public void trier() {
		compVV.executer(0, 2);
		compVV.executer(3, 1);
	}

}
