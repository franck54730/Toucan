package toucan.model.mouvements;

import java.awt.Color;

import toucan.model.cases.Coordonnee;

public class MouvementHaut extends Mouvement {

	public MouvementHaut(Coordonnee dep, int dur, int tps, String val, Color col) {
		super(dep,dur,tps,val,col);
	}
	
	@Override
	public Coordonnee getCoordonneeForTemps(int tps) {
		int x = depart.getX(); 
		int y = depart.getY(); 
		y -= tps - temps;
		return new Coordonnee(x, y);
	}
	
	@Override
	public Coordonnee getArrive() {
		return new Coordonnee(depart.getX(), depart.getY()-duree);
	}
}
