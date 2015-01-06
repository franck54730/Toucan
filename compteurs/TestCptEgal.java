package compteurs ;

import java.io.* ;

public class TestCptEgal{
    public static void main (String[] args) {
    	CptEgal analyseur = new CptEgal(System.in) ;
	try {
	    int k = analyseur.analyser() ;
	    System.out.println("resultat de l'analyse : " + k) ;
	    System.out.println("nbCases : " + analyseur.nbNbCasesOccurence() + " usages") ;
            System.out.println("tab : " + analyseur.nbTabOccurence() + " usages") ;
	}
	catch (IOException e) {
	    System.out.println("probleme d'entree-sortie..." + e.getMessage()) ;
	}
    }
}
