package objectSW;

public abstract class Personnage {
	protected String nom;
	protected int pointVie, x, y, v, force;
	
	
	public Personnage(String _n, int _x, int _y, int _v, int _force) {
		this.nom = _n;
		this.pointVie = 100;
		this.x = _x;
		this.y = _y;
		this.v = _v;
		this.force = _force;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getV() {
		return this.v;
	}
	
	public int getForce() {
		return this.force;
	}
	
	public int getHp() {
		return this.pointVie;
	}
	
	public void setX(int _x) {
		this.x = _x;
	}
	
	public void setY(int _y) {
		this.y = _y;
	}
	
	public void seDeplacer(int dx, int dy, int t) {
		this.x = (int) ((this.x + dx*this.v*t) / Math.sqrt(dx * dy + dy * dy));
		this.y = (int) ((this.y + dy*this.v*t) / Math.sqrt(dx * dy + dy * dy));
	}
	
	public abstract String parler();
}

