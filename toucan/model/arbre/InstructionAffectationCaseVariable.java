package toucan.model.arbre;

public class InstructionAffectationCaseVariable extends InstructionAffectation {

	protected int num1;
	protected String var;
	
	public InstructionAffectationCaseVariable(int n1,String varName){
		num1 = n1;
		var = varName;
	}
	
	@Override
	public String getCodeDecorer() {
		// TODO Stub de la m�thode g�n�r� automatiquement
		return "affCV.executer("+num1+", 4);\n"
			   +var+" = tab["+num1+"];\n";
	}
}
