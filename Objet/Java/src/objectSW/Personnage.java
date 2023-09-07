package objectSW;

import java.util.Random;

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
	
	public void setX(int _x) {
		this.x = _x;
	}
	
	public void setY(int _y) {
		this.y = _y;
	}
	
	public void seDeplacer(int dx, int dy) {
		this.x = (int) (this.x + dx*this.v);
		this.y = (int) (this.y + dy*this.v);
	}
	
	public boolean fight(Personnage _adversaire) {
		int hp1 = this.pointVie;
		int hp2 = _adversaire.pointVie;
		int attack;
		Random rand = new Random();
		
		while(hp1 > 0 && hp2 >0) {
			attack = rand.nextInt(100) + 1;
			if(attack >= _adversaire.classeArmure + _adversaire.getWeapon().getDeflect()) {
				hp2 -= rand.nextInt(this.getWeapon().getDammage() + 1) ;
			}
			attack = rand.nextInt(100) + 1;
			if(attack >= this.classeArmure + this.getWeapon().getDeflect()) {
				hp1 -= rand.nextInt(_adversaire.getWeapon().getDammage() + 1);
			}
		}
		
		if(hp2 <= 0) {
			System.out.println(this.getNom() + " a gagné");
		}else {
			System.out.println(_adversaire.getNom() + " a gagné");
		}
		
		return true;
	}
	
	protected abstract Weapons getWeapon();

	protected abstract String parler();
}

