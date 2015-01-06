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
import toucan.model.arbre.ArbreAbstrait;
import toucan.model.arbre.AutreInstruction;
import toucan.model.arbre.BlocDInstruction;
import toucan.model.arbre.InstructionAffectationCaseCase;
import toucan.model.arbre.InstructionAffectationCaseVariable;
import toucan.model.arbre.InstructionAffectationVariableCase;
import toucan.outils.KitJava;

public class AlgoFacade extends AbstractAlgo {

	protected BlocDInstruction arbre;
	
	public AlgoFacade(Modele m) {
		super(m);
		arbre = new BlocDInstruction();
		arbre.ajouter(new AutreInstruction("int toto;\n"));
		arbre.ajouter(new InstructionAffectationCaseVariable(1, "toto"));
		arbre.ajouter(new InstructionAffectationCaseCase(1, 2));
		arbre.ajouter(new InstructionAffectationVariableCase(2, "toto"));
		System.out.println(arbre.getCodeDecorer());
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
	}
*/
	@Override
	public void trier() {
		// TODO Stub de la méthode généré automatiquement
		KitJava k = new KitJava(arbre.getCodeDecorer(), model);
		k.compiler();
		k.executer();
		System.out.println(k);
	}
}
