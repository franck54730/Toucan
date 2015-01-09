package toucan.exception;

public class ExceptionToucan extends Exception {
	protected String erreur;
	
	/**
	 * Exception de toucan
	 * @param s String
	 */
	public ExceptionToucan(String s) {
		erreur = s.toString();
	}
	
	/**
	 * permet de recuperer le message d'erreur
	 * @return String
	 */
	public String getErreur(){
		return erreur;
	}
}
