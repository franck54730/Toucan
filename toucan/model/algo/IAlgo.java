package toucan.model.algo;

import toucan.exception.CompilationException;
import toucan.exception.ExecutionException;
import toucan.exception.ParsingException;
import toucan.model.Modele;

public interface IAlgo {
	public void setModel(Modele m);
	public void trier() throws ParsingException, CompilationException, ExecutionException;
}
