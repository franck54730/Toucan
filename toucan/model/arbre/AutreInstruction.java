package toucan.model.arbre;

public class AutreInstruction extends ArbreAbstrait {
	protected String code;
	
	public AutreInstruction(String c){
		code = c;
	}

	@Override
	public String getCodeDecorer() {
		return code;
	}

}
