package toucan.exception;

public class ExceptionToucan extends Exception {
	protected String erreur;
	
	public ExceptionToucan(String s) {
		erreur = s.toString();
	}
	
	public String getErreur(){
		return erreur;
	}
}
