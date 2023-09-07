package course;

import java.util.Random;

public class Voitures {
	private int vMax, vitesse, acceleration, freinage, agilite, distance; 
	private boolean boost;
	private String nom;
	
	
	public Voitures(String _nom, int _vitesse, int _vMax, int _acceleration, int _freinage, int _agilite, boolean _boost) {
		this.nom = _nom;
		this.vitesse = _vitesse;
		this.vMax = _vMax;
		this.acceleration = _acceleration;
		this.freinage = _freinage;
		this.agilite = _agilite;
		this.boost = _boost;
		this.distance = 0;
	}
	
	public int getVitesse() {
		return this.vitesse;
	}
	
	public int getDistance() {
		return this.distance;
	}
	
	public boolean accelerer() {
		if(this.vitesse < this.vMax) {
			Random rand = new Random();
			this.vitesse += this.acceleration*(rand.nextInt(15-10) + 10);
			this.distance += this.vitesse;
			return true;
		}else {
			this.vitesse = this.vMax;
			this.distance += this.vitesse;
			return false;
		}
		
	}
	
	public boolean freiner() {
		if(this.vitesse > 0) {
			Random rand = new Random();
			this.vitesse -= this.freinage*(rand.nextInt(15-10) + 10);
			return true;
		}else {
			this.vitesse = 0;
			return false;
		}
	}
	

	public boolean boost() {
		if(this.boost) {
			return false;
		}
		return true;
	}
}
