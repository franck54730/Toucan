package toucan.model.cases;

public class Coordonnee {
	protected int x;
	protected int y;
	
	public Coordonnee(int cx, int cy){
		x = cx;
		y = cy;
	}

	/**
	 * accesseur en lecture sur X
	 * @return
	 */
	public int getX() {
		return x;
	}

	/**
	 * accesseur en ecriture sur X
	 * @return
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * accesseur en lecture sur Y
	 * @return
	 */
	public int getY() {
		return y;
	}

	/**
	 * accesseur en ecriture sur Y
	 * @return
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public boolean equals(Object object){
		boolean rep = false;
		if(object instanceof Coordonnee){
		    Coordonnee c = (Coordonnee)object;
		    rep = c.getX() == this.x && c.getY() == this.y;
		} 
		return rep;
	}
}
