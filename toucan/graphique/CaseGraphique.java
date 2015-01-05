package toucan.graphique;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import toucan.model.cases.Case;
import toucan.model.cases.Coordonnee;
import toucan.model.cases.ICase;
import toucan.model.cases.Variable;


public class CaseGraphique extends BufferedImage{
	protected ICase laCase;
    protected Graphics2D carre ;
    protected int cote = 50 ;
    protected int xLabel;
    protected int yLabel;
    
    
    /**
     * Instanciation d'un élément graphique à dessiner (ici un carré)
     * @param c La case qui définie la case graphique
     */
    public CaseGraphique(ICase c) {
        super(150, 150, BufferedImage.TYPE_INT_ARGB);
        laCase = c;
        carre = createGraphics();
        dessinerCase(0) ;
    }
    
    /**
     * Dessin de l'élément graphique (l'élément graphique est redessiné, car sa couleur et son contenu peuvent 
     * changer au cours de l'animation
     */
    private void dessinerCase(int temps) {
        carre.setPaint(Color.white) ;
        carre.fillRect(0, 0, cote, cote) ;
        
        carre.setColor(laCase.getCouleurForTemps(temps)) ;
        carre.drawRect(0, 0, cote, cote); 

        carre.setFont(new Font("Arial", Font.BOLD, 16));
        dessinerChaineAuCentre(laCase.getValeurForTemps(temps));  
    }

    /**
     * Fonction pour centrer la chaîne de caractères dans l'élément graphique
     * @param s chaîne de caractère à écrire au centre de d'élément graphique
     */
    private void dessinerChaineAuCentre(String s) {
        // Find the size of string s in the font of the Graphics context 
        FontMetrics fm = carre.getFontMetrics();
        int xC = (cote - fm.stringWidth(s)) / 2;
        int yC = (fm.getAscent() + (cote - (fm.getAscent() + fm.getDescent())) / 2);
        
        // Center text horizontally and vertically within provided rectangular bounds
        carre.drawString(s, xC, yC);
    }
    
    /**
     * Dessin de l'élément graphique et positionnement dans la fenêtre graphique pour un
     * temps donné
     * @param g fenêtre graphique dans laquelle on dessine
     * @param t temps de l'application
     * @return retourne vrai si le mouvement est fini
     */
    public void dessiner(Graphics g, int temps) {   
        dessinerCase(temps);
        Coordonnee c = laCase.getCoordonneeForTemps(temps);
        g.drawImage(this, c.getX(), c.getY(), null);
    }
}
