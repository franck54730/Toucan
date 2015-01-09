package toucan.model.algo;

import java.io.ByteArrayInputStream;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import toucan.analyse.AnalyseurLexical;
import toucan.analyse.AnalyseurSyntaxique;
import toucan.exception.CompilationException;
import toucan.exception.ExecutionException;
import toucan.exception.ParsingException;
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
	
	@Override
	public void trier() throws ParsingException, CompilationException, ExecutionException {
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
		KitJava k = null;
		try{
			k = new KitJava(arbre.getCodeDecorer(), model);
		}catch(Exception e){
			throw new ParsingException("Erreur de lecture du code.");
		}
		if(k != null){
			k.compiler();
			try{
				k.executer();
			}catch(ExecutionException e){
				throw e;
			}
		}
	}
}
