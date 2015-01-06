package toucan.graphique.vue;


import java.util.Observable;
import java.util.Observer;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import toucan.graphique.ecouteur.EcouteurAlgo;
import toucan.graphique.ecouteur.EcouteurDemarrer;
import toucan.model.Constante;
import toucan.model.Modele;

public class VueMenuBar extends JMenuBar implements Observer{
	protected Modele model;
	protected JMenu menuFichier;
	protected JMenu menuAlgo;
	protected JMenuItem itemBulle;
	protected JMenuItem itemPerso;
	protected JMenuItem itemDemarrer;
	
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
		itemBulle.addActionListener(new EcouteurAlgo(model,Constante.ID_ALGO_BULLE));
		menuAlgo.add(itemBulle);
		itemPerso = new JMenuItem("Trie perso");
		itemPerso.setToolTipText(Constante.TEXT_TIP_ITEMPERSO);
		itemPerso.addActionListener(new EcouteurAlgo(model,Constante.ID_ALGO_PERSO));
		menuAlgo.add(itemPerso);
		itemDemarrer = new JMenuItem("Démarrer");
		itemDemarrer.setToolTipText(Constante.TEXT_TIP_ITEMDEMARRER);
		itemDemarrer.addActionListener(new EcouteurDemarrer(model));
		menuAlgo.add(itemDemarrer);
		this.add(menuAlgo);
	}

	public void update(Observable arg0, Object arg1) {
		itemBulle.setEnabled(model.estFini());
	}
}
