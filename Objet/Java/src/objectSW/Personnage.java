package objectSW;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Personnage { // superclasse personnage de laquelle va découler Jedi, Sith et soldats
	protected String nom;
	protected int pointVie, x, y, v, force, classeArmure;

	
	public Personnage(String _n, int _x, int _y, int _v, int _force, int _cA) {
		this.nom = _n;
		this.pointVie = 100;
		this.x = _x;
		this.y = _y;
		this.v = _v;
		this.force = _force;
		this.classeArmure = _cA;
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
	
	public int getForce() {
		return this.force;
	}
	
	public int getCa() {
		return this.classeArmure;
	}
	
	public boolean isAlive() {
		if (this.pointVie > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public void setX(int _x) {
		this.x = _x;
	}
	
	public void setY(int _y) {
		this.y = _y;
	}
		
	public void heal() {
		if(this.pointVie <= 90) {
			this.pointVie = 100;
		}else {
			this.pointVie += 10;
		}
	}
	
	public void healMax() {
		this.force = 100;
		this.pointVie = 100;
	}
	
	public void seDeplacer(int dx, int dy) {
		this.x = (int) (this.x + dx*this.v);
		this.y = (int) (this.y + dy*this.v);
	}
	
	public String attack(Personnage _first, Personnage _adversaire) {
		String outcome = "";
		int touch = ThreadLocalRandom.current().nextInt(1, 100);
		if(touch >= _adversaire.getCa() + _adversaire.getWeapon().getDeflect()) {
			_adversaire.pointVie -= _first.getWeapon().getDammage();
			outcome = _first.getNom() + " attaque et inflige " + _first.getWeapon().getDammage() + " points de dégats !";
		}else {
			outcome = _first.getNom() + " a manqué son attaque !";
		}
		return outcome;
	}
	
	
	
	
	protected abstract Weapons getWeapon();

	protected abstract String parler();
}

