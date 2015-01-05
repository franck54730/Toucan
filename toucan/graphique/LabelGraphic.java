package toucan.graphique;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import toucan.model.Constante;
import toucan.model.cases.Case;
import toucan.model.cases.Coordonnee;
import toucan.model.cases.ICase;
import toucan.model.cases.Variable;


public class LabelGraphic extends BufferedImage{
	protected String label;
    protected Graphics2D carre ;
    protected int xLabel;
    protected int yLabel;
    
    
    /**
     * Instanciation d'un élément graphique à dessiner (ici un carré)
     * @param x abscisse initiale de l'élément graphique dans la fenêtre
     * @param l ordonnée initiale de l'élément graphique dans la fenêtre
     */
    public LabelGraphic(int x, String l) {
        super(150, 150, BufferedImage.TYPE_INT_ARGB);
        carre = createGraphics();
        xLabel = x;
        yLabel = Constante.Y_LABEL;
        label = l;
        dessinerLabel(l) ;
    }
    
    /**
     * Fonction qui écrit une string en dessous de la case
     */
    public void dessinerLabel(String l) {
    	carre.setPaint(new Color(0, 0,0, 0)) ;
        carre.setColor(Color.BLACK);
        carre.setFont(new Font("Arial", Font.BOLD, 16));

        FontMetrics fm = carre.getFontMetrics();
        int xLabel = (50 - fm.stringWidth(l)) / 2;
        int yLabel = (fm.getAscent() + (50/2 - (fm.getAscent() + fm.getDescent())) / 2);
        
        carre.drawString(label, xLabel , yLabel);
    } 
    
    /**
     * fonction qui ecrit la string
     * @param g fenêtre graphique dans laquelle on dessine
     */
    public void dessiner(Graphics g){
        g.drawImage(this, xLabel, yLabel, null);
    }
}
