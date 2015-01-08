package toucan.graphique.ecouteur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import toucan.model.Modele;

public class EcouteurDemarrer implements ActionListener {

	protected Modele model;
	
	public EcouteurDemarrer(Modele m){
		model = m;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if(model.isDepart()){
			Thread t = new Thread((Runnable) model, "Toucan");
			t.start();
		}else{
			model.arret();
		}
	}
}
