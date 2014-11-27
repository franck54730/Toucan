package toucan.graphique.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import toucan.model.Modele;

/**
 * 24 juin 2014
 * 
 * @author brigitte wrobel-dautcourt
 */

public class Toucan extends JFrame {
    
    public Toucan() {
        super("Projet Toucan - animation des algorithmes de tris");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Modele model = new Modele(50);
        // instanciation de la vue de l'animation
        VueGraphique vueGraphique = new VueGraphique(model) ;
        add(vueGraphique, BorderLayout.CENTER) ;
        VueControll vueControll = new VueControll(model);
        add(vueControll, BorderLayout.NORTH);
        VueMenuBar menu = new VueMenuBar(model);
        setJMenuBar(menu);
        
        pack();			
        setVisible(true);
    }

    public static void main(String[] args) {
        new Toucan() ;
    }
}
