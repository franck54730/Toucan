package toucan.model.algo;

import java.io.ByteArrayInputStream;

import toucan.analyse.AnalyseurLexical;
import toucan.analyse.AnalyseurSyntaxique;
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
		String code = model.getCode();
		AnalyseurSyntaxique analyseur = new AnalyseurSyntaxique(
				new AnalyseurLexical(
				new ByteArrayInputStream(code.getBytes()))) ;
		ArbreAbstrait arbre = null;
		try{
			arbre = (ArbreAbstrait) analyseur.parse().value;
		}catch(Exception e){
			
		}

		KitJava k = new KitJava(arbre.getCodeDecorer(), model);
		k.compiler();
		k.executer();
		System.out.println(k);
	}
}
