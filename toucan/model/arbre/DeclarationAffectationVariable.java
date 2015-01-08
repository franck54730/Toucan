package toucan.model.arbre;

public class DeclarationAffectationVariable extends ArbreAbstrait {
	protected String type;
	protected String idf;
	protected String valeur;
	
	public DeclarationAffectationVariable(String t, String i, String val){
		type = t;
		idf = i;
		valeur = val;
	}

	@Override
	public String getCodeDecorer() {
		return "model.creeVariable(\"\", \""+idf+"\");"
			+	"model.mettreAJour();"
			+   type+" "+idf + ";"
			+	"affV.executer(\""+idf+"\", \""+valeur+"\");\n"
			+   idf+" = "+valeur+"\n";
	}

}
