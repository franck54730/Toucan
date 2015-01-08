package toucan.graphique.ecouteur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import toucan.model.Modele;

public class EcouteurReinit implements ActionListener {

	protected Modele model;
	
	public EcouteurReinit(Modele m){
		model = m;
	}

	public void actionPerformed(ActionEvent e) {
		model.reinit();
	}

}
