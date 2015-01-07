package toucan.model.arbre;

public class InstructionAffectationVariableCase extends InstructionAffectation {

	protected String num1;
	protected String var;
	
	public InstructionAffectationVariableCase(String n1,String varName){
		num1 = n1;
		var = varName;
	}
	
	@Override
	public String getCodeDecorer() {
		return "affVC.executer("+num1+", 4);\n"
			  +"tab["+num1+"] = "+var+"\n";
	}
}
