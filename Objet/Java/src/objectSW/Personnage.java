package objectSW;

public abstract class Personnage { // superclasse personnage de laquelle va découler Jedi, Sith et soldats
	protected String nom;
	protected int pointVie, x, y, v;
	
	
	public Personnage(String _n, int _x, int _y, int _v) {
		this.nom = _n;
		this.pointVie = 100;
		this.x = _x;
		this.y = _y;
		this.v = _v;
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
	
	public int getHp() {
		return this.pointVie;
	}
	
	public void setX(int _x) {
		this.x = _x;
	}
	
	public void setY(int _y) {
		this.y = _y;
	}
	
	public void seDeplacer(int dx, int dy, int time) {
		this.x = (int) (this.x + dx*this.v*time);
		this.y = (int) (this.y + dy*this.v*time);
	}
	
	public abstract String parler();
}

