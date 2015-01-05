package toucan.graphique.ecouteur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import toucan.model.Modele;

public class EcouteurBulle implements ActionListener {

	protected Modele model;
	
	public EcouteurBulle(Modele m){
		model = m;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Thread t = new Thread((Runnable) model, "Toucan");
		t.start();
	}
}
