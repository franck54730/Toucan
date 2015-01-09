package toucan.outils;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.ToolProvider;

import toucan.exception.CompilationException;
import toucan.exception.ExecutionException;
import toucan.exception.ParsingException;
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
				  +"		model.mettreAJour();"
				  +"		model.viderVariable();\n"
				  +"		int[] tab = model.getTab();\n"
				  +"		int nbCases = model.getNbCases();\n");
		
		String[] split = code.split("\n");
		for(String s : split){
			str.append("		"+s+"\n");
		}
		str.append("	}\n");
		str.append("}");
		laClasse = str.toString();
	}
	
    public void compiler() throws CompilationException {
        // writer pour écrire les erreurs de compilation
        StringWriter sortieErreur = new StringWriter();

        Iterable<? extends JavaFileObject> fileObjects = getJavaSourceFromString(nomClasse, laClasse);

        compiler.getTask(sortieErreur, fileManager, null, null, null, fileObjects).call();
        try {
            sortieErreur.close() ;
        } catch (IOException ex) {
        	Logger.getLogger(TestOutils.class.getName()).log(Level.SEVERE, null, ex);
        }
        String err = sortieErreur.toString();
        if(!err.equals("")){
        	throw new CompilationException(err);
        }
        
    }

    
    public void executer() throws CompilationException, ParsingException, ExecutionException {
        try {
            String nomExecutable = nomPackage + "." + nomClasse ;
            
            Object instance = fileManager.getClassLoader(javax.tools.StandardLocation.CLASS_PATH).loadClass("toucan.model.algo.AlgoPerso").newInstance();
            ((IAlgo)instance).setModel(model);
            ((IAlgo)instance).trier() ;
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestOutils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TestOutils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TestOutils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CompilationException ex){
        	System.out.println(ex.getErreur());
        } catch (Exception ex){
        	throw new ExecutionException("Erreur pendant l'execution du code");
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
