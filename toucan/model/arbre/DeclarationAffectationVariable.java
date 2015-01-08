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
		System.out.println();
		System.out.println();
		System.out.println("model.creeVariable(\"\", \""+idf+"\");"
			+   type+" "+idf + ";"
			+   idf+" = "+valeur+"\n");
		System.out.println();
		System.out.println();
		return "model.creeVariable(\"\", \""+idf+"\");"
			+   type+" "+idf + ";"
			+	"affV.executer(\""+idf+"\", \""+valeur+"\");\n"
			+   idf+" = "+valeur+"\n";
	}

}
