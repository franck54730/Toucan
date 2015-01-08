package toucan.model.arbre;

public class InstructionAffectationVariable extends InstructionAffectation {

	protected String val;
	protected String var;
	
	public InstructionAffectationVariable(String v,String varName){
		val = v;
		var = varName;
	}
	
	@Override
	public String getCodeDecorer() {
		return "affV.executer(\""+var+"\", \""+val+"\");\n"
			  +var+" = "+val+"\n";
	}
}
