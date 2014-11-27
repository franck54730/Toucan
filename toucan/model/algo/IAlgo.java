package toucan.model.algo;

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

public abstract class IAlgo {
	
	protected Modele model;
	protected AffectationCaseCase affCC;
	protected AffectationCaseVariable affCV;
	protected AffectationVariableCase affVC;
	protected AffectationVariableVariable affVV;
	protected AffectationVariable affV;
	protected AffectationCase affC;
	protected AffectationBoolean affB;
	protected ComparaisonCaseCase compCC;
	protected ComparaisonVariableCase compVC;
	protected ComparaisonVariableVariable compVV;
	protected Increment inc;

	public IAlgo(Modele m){
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
	}
	
	/**
	 * fonction qui execute l'algo
	 */
	public abstract void trier();
}
