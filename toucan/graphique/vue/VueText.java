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
import toucan.graphique.ecouteur.EcouteurText;
import toucan.graphique.ecouteur.EcouteurVitesse;
import toucan.model.Constante;
import toucan.model.Modele;

public class VueText extends JPanel implements Observer  {

	protected Modele model;
	protected JEditorPane editor;
	
	public VueText(Modele m){
		model = m;
		m.addObserver(this);
		editor = new JEditorPane();
		this.add(editor);
		JButton button = new JButton();
		this.add(button);
		button.addActionListener(new EcouteurText(model));
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
	}
}