package toucan.model.arbre;

public class InstructionAffectationVariable extends InstructionAffectation {

	protected String val;
	protected String var;
	
	public InstructionAffectationVariable(String valeur,String varName){
		val = valeur;
		var = varName;
	}
	
	@Override
	public String getCodeDecorer() {
		return "affV.executer(\""+var+"\", \""+val+"\");\n"
			  +var+" = "+val+"\n";
	}
}
