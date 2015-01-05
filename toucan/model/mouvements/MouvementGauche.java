package toucan.model.mouvements;

import java.awt.Color;

import toucan.model.cases.Coordonnee;

public class MouvementGauche extends Mouvement {

	public MouvementGauche(Coordonnee dep, int dur, int tps, String val, Color col) {
		super(dep,dur,tps,val,col);
	}

	@Override
	public Coordonnee getCoordonneeForTemps(int tps) {
		int x = depart.getX(); 
		int y = depart.getY(); 
		x -= tps - temps;
		return new Coordonnee(x, y);
	}
	
	@Override
	public Coordonnee getArrive() {
		return new Coordonnee(depart.getX()-duree, depart.getY());
	}
}
