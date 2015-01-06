package toucan.model.arbre;

public class InstructionAffectationCaseCase extends InstructionAffectation {

	protected int num1;
	protected int num2;
	
	public InstructionAffectationCaseCase(int n1, int n2){
		num1 = n1;
		num2 = n2;
	}
	
	@Override
	public String getCodeDecorer() {
		// TODO Stub de la méthode généré automatiquement
		return "affCC.executer("+num2+", "+num1+");\n"
			  +"tab["+num1+"] = tab["+num2+"];\n";
	}
}
