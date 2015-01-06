package toucan.graphique.ecouteur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import toucan.model.Modele;

public class EcouteurGoStop implements ActionListener {

	protected Modele model;
	
	public EcouteurGoStop(Modele m){
		model = m;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		model.goStop();
	}

}
