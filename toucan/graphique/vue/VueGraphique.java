package toucan.graphique.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.lang.reflect.InvocationTargetException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import toucan.model.Modele;

public class VueGraphique extends JPanel implements Observer{
	
	protected Modele model;
	protected VueAnimation vueAnim;
	
	public VueGraphique(Modele m){
		m.addObserver(this);
		model = m;
		vueAnim = new VueAnimation(model);
		add(vueAnim);
	}
	
	public void update(Observable o, Object arg) {
		vueAnim.reconstruireCasesGraphiquesEtLabel();
		Runnable code = new Runnable() {
			public void run() {
        		vueAnim.setTempo(model.getVitesse());
        		vueAnim.repaint();
			}
		} ;
		if (SwingUtilities.isEventDispatchThread())
        	code.run() ;
		else
			try {
				SwingUtilities.invokeAndWait(code) ;
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
