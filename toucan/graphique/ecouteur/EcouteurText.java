package toucan.graphique.ecouteur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JEditorPane;

import toucan.model.Modele;

public class EcouteurText implements KeyListener {
	
	protected Modele model;
	protected JEditorPane editor;
	
	public EcouteurText(Modele m, JEditorPane e){
		model = m;
		editor = e;
	}

	public void keyPressed(KeyEvent arg0) {
		// TODO Stub de la méthode généré automatiquement
	}

	public void keyReleased(KeyEvent arg0) {
		model.setCode(editor.getText());
	}

	public void keyTyped(KeyEvent arg0) {
		model.setCode(editor.getText());
	}

}
