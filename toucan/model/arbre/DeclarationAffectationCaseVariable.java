package toucan.model.arbre;

public class DeclarationAffectationCaseVariable extends ArbreAbstrait {
	protected String type;
	protected String idf;
	protected String nCase;
	
	public DeclarationAffectationCaseVariable(String t, String i, String n){
		type = t;
		idf = i;
		nCase = n;
	}

	@Override
	public String getCodeDecorer() {
		return "model.creeVariable(\"\", \""+idf+"\");"
			+	"model.mettreAJour();"
			+   type+" "+idf + ";"
			+	"affCV.executer("+nCase+", \""+idf+"\");\n"
			 +  idf + " = tab["+nCase+"]";
	}
}
