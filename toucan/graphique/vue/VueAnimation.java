package toucan.graphique.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;

import toucan.graphique.CaseGraphique;
import toucan.graphique.LabelGraphic;
import toucan.graphique.LesCasesGraphiques;
import toucan.graphique.LesLabelGraphiques;
import toucan.model.Constante;
import toucan.model.Modele;
import toucan.model.cases.Case;
import toucan.model.cases.ICase;

public class VueAnimation extends JPanel {
	
    protected static int temporisation = 15 ;
    protected LesCasesGraphiques casesGraphiques;
    protected LesLabelGraphiques labelsGraphiques;
    protected Modele model;
    protected boolean mouvementFini;
    protected  int toto =0;
    
	public VueAnimation(Modele m) {
        super() ;
        this.setPreferredSize(new Dimension(1000, 700)) ;
        model = m;
        reconstruireCasesGraphiquesEtLabel();
        mouvementFini = true;
    }
	
	/**
	 * fonction qui instancie la liste des cases graphiques et l'initialise
	 */
	public void reconstruireCasesGraphiquesEtLabel(){
		casesGraphiques = new LesCasesGraphiques();
		labelsGraphiques = new LesLabelGraphiques();
		int nbVar = 0;
		for(ICase c : model.getLesCases()){
			casesGraphiques.ajouter(new CaseGraphique(c));
			if(c.isVariable()){
				labelsGraphiques.ajouter(new LabelGraphic(50*nbVar, model.getVariable(nbVar).getLabel()));
				nbVar++;
			}
		}
	}
	
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        int w = getWidth() ;
        int h = getHeight() ;

        GradientPaint gp = new GradientPaint(-w, -h, Color.LIGHT_GRAY, w, h, Color.WHITE);
        g2.setPaint(gp);
        g2.fillRect(0, 0, w, h);
        for(CaseGraphique uneCase : casesGraphiques){
        	uneCase.dessiner(g2,model.getTemps());
        }
        for(LabelGraphic label : labelsGraphiques){
        	label.dessiner(g2);
        }
        
        model.incTemps();
        try {
            Thread.sleep(temporisation) ;
        } catch (InterruptedException ex) {
            Logger.getLogger(VueAnimation.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(!model.estFini()){
        	if(model.isRun())
        		repaint() ;
        }else{
        	model.mettreAJour();
        }
    }
    
    /**
     * accesseur en ecriture sur temporisation
     * @param i
     */
    public void setTempo(int i){
    	temporisation = Constante.tempoForVitesse(i);
    }
}
