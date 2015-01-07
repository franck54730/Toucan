package toucan.model.arbre;

public class InstructionAffectationCaseVariable extends InstructionAffectation {

	protected String num1;
	protected String var;
	
	public InstructionAffectationCaseVariable(String n1,String varName){
		num1 = n1;
		var = varName;
	}
	
	@Override
	public String getCodeDecorer() {
		return "affCV.executer("+num1+", 4);\n"
			   +var+" = tab["+num1+"]\n";
	}
}
