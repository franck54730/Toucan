package toucan.graphique.vue;


import java.util.Observable;
import java.util.Observer;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import toucan.graphique.ecouteur.EcouteurBulle;
import toucan.model.Constante;
import toucan.model.Modele;

public class VueMenuBar extends JMenuBar implements Observer{
	protected Modele model;
	protected JMenu menuFichier;
	protected JMenu menuAlgo;
	protected JMenuItem itemBulle;
	
	public VueMenuBar(Modele m){
		model = m;
		model.addObserver(this);
		menuFichier = new JMenu("Fichier");
		menuFichier.setToolTipText(Constante.TEXT_TIP_MENUFICHIER);
		this.add(menuFichier);
		menuAlgo = new JMenu("Algo");
		menuAlgo.setToolTipText(Constante.TEXT_TIP_MENUALGO);
		itemBulle = new JMenuItem("Trie a bulle");
		itemBulle.setToolTipText(Constante.TEXT_TIP_ITEMBULLE);
		itemBulle.addActionListener(new EcouteurBulle(model));
		menuAlgo.add(itemBulle);
		this.add(menuAlgo);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		itemBulle.setEnabled(model.estFini());
	}
}
