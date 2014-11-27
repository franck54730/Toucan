package toucan.graphique.vue;

import java.awt.Color;
import java.util.Hashtable;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import toucan.graphique.ecouteur.EcouteurGoStop;
import toucan.graphique.ecouteur.EcouteurVitesse;
import toucan.model.Constante;
import toucan.model.Modele;

public class VueControll extends JPanel implements Observer  {

	protected Modele model;
	protected JButton boutonGoStop;
	protected JLabel labelVitesse;
	protected JSlider slider;
	
	public VueControll(Modele m){
		model = m;
		m.addObserver(this);
		boutonGoStop = new JButton("Stop");
		boutonGoStop.setEnabled(false);
		boutonGoStop.addActionListener(new EcouteurGoStop(model));
		this.add(boutonGoStop);
		/* Slider pour la vitesse de l'animation */
		slider = new JSlider(JSlider.HORIZONTAL, 1, 5, 3);
		slider.setBackground(Color.LIGHT_GRAY);
		slider.setMinorTickSpacing(5);
		slider.setPaintTicks(true);
		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		labelTable.put( new Integer( 5 ), new JLabel("Rapide") );
		labelTable.put( new Integer( 1 ), new JLabel("Lent") );
		slider.setLabelTable( labelTable );
		slider.setPaintLabels(true);
		this.add(slider);
		slider.addChangeListener(new EcouteurVitesse(model));
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		boutonGoStop.setText(model.isRun()?"Stop":"Go");
		boutonGoStop.setEnabled(true);
	}
}