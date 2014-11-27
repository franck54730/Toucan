package toucan.graphique.ecouteur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import toucan.model.Modele;

public class EcouteurVitesse implements ChangeListener {

	protected Modele model;
	
	public EcouteurVitesse(Modele m){
		model = m;
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		JSlider source = (JSlider)arg0.getSource();
		if (!source.getValueIsAdjusting()) {
			int val = (int)source.getValue();
			model.setVitesse(val);
		}
	}

}
