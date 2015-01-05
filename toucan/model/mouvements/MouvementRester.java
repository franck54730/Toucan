package toucan.model.mouvements;

import java.awt.Color;

import toucan.model.cases.Coordonnee;

public class MouvementRester extends Mouvement {

	public MouvementRester(Coordonnee dep, int dur, int tps, String val, Color col) {
		super(dep,dur,tps,val,col);
	}

	@Override
	public Coordonnee getArrive() {
		return new Coordonnee(depart.getX(), depart.getY());
	}

	@Override
	public Coordonnee getCoordonneeForTemps(int temps) {
		return depart;
	}
}
