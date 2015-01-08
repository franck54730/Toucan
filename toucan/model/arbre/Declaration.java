package toucan.model.arbre;

public class Declaration extends ArbreAbstrait {
	protected String type;
	protected String idf;
	
	public Declaration(String t, String i){
		type = t;
		idf = i;
	}

	@Override
	public String getCodeDecorer() {
		return "model.creeVariable(\"\", \""+idf+"\");"
			+   type+" "+idf;
	}

}
