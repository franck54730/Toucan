package toucan.model.algo;

import toucan.model.Modele;
import toucan.outils.KitJava;

public class AlgoFacade extends IAlgo {

	public AlgoFacade(Modele m) {
		super(m);
	}

	@Override
	public void trier() {
		// TODO Stub de la m�thode g�n�r� automatiquement
		KitJava k = new KitJava(model.getCode());
		System.out.println(k);
	}
}
