package toucan.outils;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.ToolProvider;

import toucan.model.Modele;
import toucan.model.algo.AbstractAlgo;
import toucan.model.algo.IAlgo;
import toucan.model.animation.AffectationBoolean;
import toucan.model.animation.AffectationCase;
import toucan.model.animation.AffectationCaseCase;
import toucan.model.animation.AffectationCaseVariable;
import toucan.model.animation.AffectationVariable;
import toucan.model.animation.AffectationVariableCase;
import toucan.model.animation.AffectationVariableVariable;
import toucan.model.animation.ComparaisonCaseCase;
import toucan.model.animation.ComparaisonVariableCase;
import toucan.model.animation.ComparaisonVariableVariable;
import toucan.model.animation.Increment;

public class KitJava {

    protected static String nomClasse = "AlgoPerso" ;
    protected static String nomPackage = "toucan.model.algo" ;
    
    protected JavaCompiler compiler ;
    protected ClassFileManager fileManager ;
	protected String laClasse;
	protected Modele model;
	
	public KitJava(String s,Modele m){
		model = m;
        compiler = ToolProvider.getSystemJavaCompiler();
        fileManager = new ClassFileManager(compiler.getStandardFileManager(null, null, null));
		construireCode(s);
	}
	
	public void construireCode(String code){
		StringBuilder str = new StringBuilder("package toucan.model.algo;"
				  +"\n\n"
				  +"public class AlgoPerso extends AbstractAlgo {\n"
				  +"	public void trier() {\n"
				  +"		int[] tab = model.getTab();\n"
				  +"		int nbCases = model.getNbCases();\n");
		
		String[] split = code.split("\n");
		for(String s : split){
			str.append("		"+s+"\n");
		}
		str.append("	}\n");
		/*
		str.append("	public void setModel(Modele m){");
		str.append("		model = m;");
		str.append("		affCC = new AffectationCaseCase(model);");
		str.append("		affCV = new AffectationCaseVariable(model);");
		str.append("		affVC = new AffectationVariableCase(model);");
		str.append("		compCC = new ComparaisonCaseCase(model);");
		str.append("		compVC = new ComparaisonVariableCase(model);");
		str.append("		affVV = new AffectationVariableVariable(model);");
		str.append("		compVV = new ComparaisonVariableVariable(model);");
		str.append("		affC = new AffectationCase(model);");
		str.append("		affV = new AffectationVariable(model);");
		str.append("		inc = new Increment(model);");
		str.append("		affB = new AffectationBoolean(model);");
		str.append("	}");*/
		str.append("}");
		laClasse = str.toString();
	}
	
    public void compiler() {
        // writer pour écrire les erreurs de compilation
        StringWriter sortieErreur = new StringWriter();

        Iterable<? extends JavaFileObject> fileObjects = getJavaSourceFromString(nomClasse, laClasse);

        compiler.getTask(sortieErreur, fileManager, null, null, null, fileObjects).call();
        try {
            sortieErreur.close() ;
        } catch (IOException ex) {
            Logger.getLogger(TestOutils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("compilation du code : ");
        System.out.println(laClasse);
        System.out.println("-------------------------------------");
        System.out.println("sortie d'erreur de la compilation : ") ;
        System.out.println(sortieErreur);
        System.out.println("-------------------------------------");
    }

    
    public void executer() {
        try {
            String nomExecutable = nomPackage + "." + nomClasse ;
            System.out.println("nomexécutable : " + nomExecutable);
            
            Object instance = fileManager.getClassLoader(javax.tools.StandardLocation.CLASS_PATH).loadClass("toucan.model.algo.AlgoPerso").newInstance();
            ((IAlgo)instance).setModel(model);
            ((IAlgo)instance).trier() ;
            
            System.out.println("-------------------------------------");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestOutils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TestOutils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TestOutils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
	public String toString(){
		return laClasse;
	}
	
    private Iterable<JavaSource> getJavaSourceFromString(String fileName, String code) {
    	return Collections.singletonList(new JavaSource(fileName, code));
    }
	
	public static void main(String[] args){
	}
}
