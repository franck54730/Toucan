package toucan.graphique.vue;


import java.util.Observable;
import java.util.Observer;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import toucan.graphique.ecouteur.EcouteurAlgo;
import toucan.graphique.ecouteur.EcouteurDemarrer;
import toucan.graphique.ecouteur.EcouteurFermer;
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
	protected JMenuItem itemFermer;
	
	public VueMenuBar(Modele m){
		model = m;
		model.addObserver(this);
		menuFichier = new JMenu("Fichier");
		menuFichier.setToolTipText(Constante.TEXT_TIP_MENUFICHIER);
		itemReinitialiser = new JMenuItem("Reinitialiser");
		itemReinitialiser.setToolTipText(Constante.TEXT_TIP_ITEMREINIT);
		itemReinitialiser.addActionListener(new EcouteurReinit(model));
		menuFichier.add(itemReinitialiser);
		itemFermer = new JMenuItem("Fermer");
		itemFermer.setToolTipText(Constante.TEXT_TIP_ITEMDFERMER);
		itemFermer.addActionListener(new EcouteurFermer(model));
		menuFichier.add(itemFermer);
		this.add(menuFichier);
		menuAlgo = new JMenu("Algo");
		menuAlgo.setToolTipText(Constante.TEXT_TIP_MENUALGO);
		itemBulle = new JMenuItem("Tri � bulle");
		itemBulle.setToolTipText(Constante.TEXT_TIP_ITEMBULLE);
		itemBulle.addActionListener(new EcouteurAlgo(model,Constante.ID_ALGO_BULLE));
		menuAlgo.add(itemBulle);
		
		itemInsertion = new JMenuItem("Tri par insertion");
		itemInsertion.setToolTipText(Constante.TEXT_TIP_ITEMINSERTION);
		itemInsertion.addActionListener(new EcouteurAlgo(model,Constante.ID_ALGO_INSERTION));
		menuAlgo.add(itemInsertion);
		itemPerso = new JMenuItem("Tri perso");
		itemPerso.setToolTipText(Constante.TEXT_TIP_ITEMPERSO);
		itemPerso.addActionListener(new EcouteurAlgo(model,Constante.ID_ALGO_PERSO));
		menuAlgo.add(itemPerso);
		itemDemarrer = new JMenuItem("D�marrer");
		itemDemarrer.setToolTipText(Constante.TEXT_TIP_ITEMDEMARRER);
		itemDemarrer.addActionListener(new EcouteurDemarrer(model));
		menuAlgo.add(itemDemarrer);
		this.add(menuAlgo);
		itemBulle.setEnabled(model.isDepart()&&!model.isBulle());
		itemInsertion.setEnabled(model.isDepart()&&!model.isInsertion());
		itemPerso.setEnabled(model.isDepart()&&!model.isPerso());
	}

	public void update(Observable arg0, Object arg1) {
		itemBulle.setEnabled(model.isDepart()&&!model.isBulle());
		itemInsertion.setEnabled(model.isDepart()&&!model.isInsertion());
		itemPerso.setEnabled(model.isDepart()&&!model.isPerso());
		itemDemarrer.setText(model.isDepart()?"D�marrer":"Arr�ter");
		itemDemarrer.setToolTipText(model.isDepart()?Constante.TEXT_TIP_ITEMDEMARRER:Constante.TEXT_TIP_ITEMARRETER);
	}
}
