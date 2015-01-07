package toucan.model.arbre;

public class InstructionAffectationCaseCase extends InstructionAffectation {

	protected String num1;
	protected String num2;
	
	public InstructionAffectationCaseCase(String n1, String n2){
		num1 = n1;
		num2 = n2;
	}
	
	@Override
	public String getCodeDecorer() {
		return "affCC.executer("+num2+", "+num1+");\n"
			  +"tab["+num1+"] = tab["+num2+"]\n";
	}
}
