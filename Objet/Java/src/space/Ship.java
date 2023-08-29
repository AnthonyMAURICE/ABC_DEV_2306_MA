package space;

import java.util.Random;

public class Ship {
	private String type;
	private int hullPoints, shields, cannons, evasion;
	
	public Ship() {
		this.type = "Croiseur";
		this.hullPoints = 100;
		this.shields = 50;
		this.cannons = 12;
		this.evasion = 5;
	}
	
	public Ship(String _type, int _hullPoints, int _shields, int _cannons, int _evasion) {
		this.type = _type;
		this.hullPoints = _hullPoints;
		this.shields = _shields;
		this.cannons = _cannons;
		this.evasion = _evasion;
	}
	
	public String getType() {
		return this.type;
	}
	
	public double getHull() {
		return this.hullPoints;
	}
	
	public double getShields() {
		return this.shields;
	}

	public int getCannons() {
		return this.cannons;
	}
	
	public int getEvasion() {
		return this.evasion;
	}
	
	public void setType(String _type) {
		this.type = _type;
	}
	
	public void setHull(int _hull) {
		this.hullPoints = _hull;
	}
	
	public void setShields(int _shields) {
		this.shields = _shields;
	}
	
	public void setCannons(int _cannons) {
		this.cannons = _cannons;
	}
	
	public void setEvasion(int _evasion) {
		this.evasion = _evasion;
	}
	
	public void afficher() {
		System.out.println(this.getType() + ", points de coque : " + this.getHull() + ", boucliers : " + this.getShields() 
		+ ", cannons : " + this.getCannons() + ", évasion : " + this.getEvasion());
	}
	

	public void combat(Ship vaisseauAttack, Ship vaisseauDefense) {
		int hitChance;
		int dammages;
		Random rand = new Random();
		hitChance = rand.nextInt(1, 20);
		if(hitChance > vaisseauDefense.evasion) {
			System.out.println("Touché");
			dammages = (vaisseauAttack.cannons * rand.nextInt(1, 4));
			System.out.println("Le vaisseau prend " + dammages + " de dégats");
			if (vaisseauDefense.shields > 0) {
				vaisseauDefense.shields -= dammages;
				if (vaisseauDefense.shields < 0) {
					vaisseauDefense.hullPoints += vaisseauDefense.shields;
					vaisseauDefense.shields = 0;
				}
			}else {
				vaisseauDefense.hullPoints -= dammages;
			}
		
		}else {
			System.out.println("Manqué !");
		}
	}


}
