package toucan.exception;

public class ParsingException extends ExceptionToucan {

	/**
	 * Exception de lecture du code utilisateur
	 * @param s
	 */
	public ParsingException(String s) {
		super(s);
	}
}
