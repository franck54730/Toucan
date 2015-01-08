package toucan.model.animation;

import toucan.model.Constante;
import toucan.model.Modele;
import toucan.model.cases.Case;
import toucan.model.cases.ICase;

public abstract class IAnimation {
	
	protected Modele model;
	
	public IAnimation(Modele m){
		model = m;
	}
	/**
	 * fonction qui execute une annimation entre deux cases
	 * @param num1
	 * @param num2
	 */
	public abstract void executer(int num1, int num2);

	/**
	 * fonction qui execute une annimation entre deux cases
	 * @param num1
	 * @param num2
	 */
	public abstract void executer(String var, String val);
	
	/**
	 * fonction qui execute une annimation sur une case
	 * @param num1
	 */
	public abstract void executer(int num1);
	
	/**
	 * fonction qui reinitialise la couleur des cases
	 */
	public void reinit() {
		for(ICase c : model.getLesCases()){
			if(c.isVariable())
				c.rester(1, Constante.COULEUR_VAR);
			else
				c.rester(1, Constante.COULEUR_BASE);
		}
	}
}
