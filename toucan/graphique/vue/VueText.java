package toucan.graphique.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Hashtable;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import toucan.graphique.ecouteur.EcouteurGoStop;
import toucan.graphique.ecouteur.EcouteurText;
import toucan.graphique.ecouteur.EcouteurVitesse;
import toucan.model.Constante;
import toucan.model.Modele;

public class VueText extends JPanel implements Observer  {

	protected Modele model;
	protected static JEditorPane editor;
	
	public VueText(Modele m){
		model = m;
		m.addObserver(this);
		editor = new JEditorPane();
		editor.setPreferredSize(new Dimension(800, 350));
		editor.addKeyListener(new EcouteurText(model, editor));
		JScrollPane scrollPane = new JScrollPane(editor);  
		this.add(scrollPane);
	}
	
	public void update(Observable arg0, Object arg1) {
	}
}