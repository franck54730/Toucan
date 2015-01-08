package toucan.graphique.vue;


import java.util.Observable;
import java.util.Observer;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import toucan.graphique.ecouteur.EcouteurAlgo;
import toucan.graphique.ecouteur.EcouteurDemarrer;
import toucan.graphique.ecouteur.EcouteurReinit;
import toucan.model.Constante;
import toucan.model.Modele;

public class VueMenuBar extends JMenuBar implements Observer{
	protected Modele model;
	protected JMenu menuFichier;
	protected JMenu menuAlgo;
	protected JMenuItem itemBulle;
	protected JMenuItem itemInsertion;
	protected JMenuItem itemPerso;
	protected JMenuItem itemDemarrer;
	protected JMenuItem itemReinitialiser;
	
	public VueMenuBar(Modele m){
		model = m;
		model.addObserver(this);
		menuFichier = new JMenu("Fichier");
		menuFichier.setToolTipText(Constante.TEXT_TIP_MENUFICHIER);
		itemReinitialiser = new JMenuItem("Reinitialiser");
		itemReinitialiser.setToolTipText(Constante.TEXT_TIP_ITEMREINIT);
		itemReinitialiser.addActionListener(new EcouteurReinit(model));
		menuFichier.add(itemReinitialiser);
		this.add(menuFichier);
		menuAlgo = new JMenu("Algo");
		menuAlgo.setToolTipText(Constante.TEXT_TIP_MENUALGO);
		itemBulle = new JMenuItem("Trie a bulle");
		itemBulle.setToolTipText(Constante.TEXT_TIP_ITEMBULLE);
		itemBulle.addActionListener(new EcouteurAlgo(model,Constante.ID_ALGO_BULLE));
		menuAlgo.add(itemBulle);
		
		itemInsertion = new JMenuItem("Trie par insertion");
		itemInsertion.setToolTipText(Constante.TEXT_TIP_ITEMINSERTION);
		itemInsertion.addActionListener(new EcouteurAlgo(model,Constante.ID_ALGO_INSERTION));
		menuAlgo.add(itemInsertion);
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
		itemBulle.setEnabled(model.isDepart());
		itemPerso.setEnabled(model.isDepart());
		itemDemarrer.setText(model.isDepart()?"Démarrer":"Arrêter");
	}
}
