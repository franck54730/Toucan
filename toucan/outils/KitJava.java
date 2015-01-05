package toucan.outils;

public class KitJava {

	protected String laClasse;
	
	public KitJava(String s){
		construireCode(s);
	}
	
	public void construireCode(String code){
		StringBuilder str = new StringBuilder("");
		str.append("package toucan.model.algo;");
		str.append("\n\n");
		str.append("public class AlgoPerso {\n");
		str.append("	public void test() {\n");
		String[] split = code.split("\n");
		for(String s : split){
			str.append("		"+s+"\n");
		}
		str.append("	}\n");
		str.append("}");
		laClasse = str.toString();
	}
	
	public void compiler(){
		
	}
	
	public void executer(){
		
	}
	
	public String toString(){
		return laClasse;
	}
	
	public static void main(String[] args){
		KitJava k = new KitJava("int toto = 5;");
		System.out.println(k);
	}
}
