package toucan.model.arbre;

public class AutreInstruction extends ArbreAbstrait {
	protected String code;
	
	public AutreInstruction(String c){
		code = c;
	}

	@Override
	public String getCodeDecorer() {
		// TODO Stub de la m�thode g�n�r� automatiquement
		return code;
	}

}
