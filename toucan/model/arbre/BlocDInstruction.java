package toucan.model.arbre;

import java.util.ArrayList;

public class BlocDInstruction extends ArbreAbstrait {

	protected ArrayList<ArbreAbstrait> alArbre;
	
	public BlocDInstruction(){
		alArbre = new ArrayList<>();
	}
	
	@Override
	public String getCodeDecorer() {
		StringBuilder rep = new StringBuilder("");
		for(ArbreAbstrait a : alArbre){
			rep.append(a.getCodeDecorer());
		}
		return rep.toString();
	}
	
	public void ajouter(ArbreAbstrait a){
		alArbre.add(a);
	}
}
