package toucan.graphique.ecouteur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import toucan.model.Modele;

public class EcouteurFermer implements ActionListener {

	protected Modele model;
	
	public EcouteurFermer(Modele m){
		model = m;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		System.exit(1);
	}
}
