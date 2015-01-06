package toucan.model.arbre;

public class InstructionAffectationVariableCase extends InstructionAffectation {

	protected int num1;
	protected String var;
	
	public InstructionAffectationVariableCase(int n1,String varName){
		num1 = n1;
		var = varName;
	}
	
	@Override
	public String getCodeDecorer() {
		// TODO Stub de la m�thode g�n�r� automatiquement
		return "affVC.executer("+num1+", 4);\n"
			  +"tab["+num1+"] = "+var+";\n";
	}
}
