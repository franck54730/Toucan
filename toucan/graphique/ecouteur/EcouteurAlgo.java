package toucan.graphique.ecouteur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import toucan.model.Constante;
import toucan.model.Modele;

public class EcouteurAlgo implements ActionListener {

	protected Modele model;
	protected int algo;
	
	public EcouteurAlgo(Modele m, int a){
		model = m;
		algo = a;
	}

	public void actionPerformed(ActionEvent arg0) {
		model.setAlgo(algo);
	}
}
