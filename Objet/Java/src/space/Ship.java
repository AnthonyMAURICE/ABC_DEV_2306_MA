package space;

import java.util.Random;

public class Ship {
	private String type;
	private int hullPoints, shields, cannons;
	private double evasion;
	
	public Ship() {
		this.type = "Croiseur";
		this.hullPoints = 100;
		this.shields = 50;
		this.cannons = 12;
		this.evasion = 5;
	}
	
	public Ship(String _type, int _hullPoints, int _shields, int _cannons, double _evasion) {
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
	
	public double getEvasion() {
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
	
	public void setEvasion(double _evasion) {
		this.evasion = _evasion;
	}
	
	
	

	public void combat(Ship vaisseauAttack, Ship vaisseauDefense) {
		int hitChance;
		boolean touch;
		int dammages ;
		Random rand = new Random();
		int modifier = rand.nextInt((4 - 1) + 1) + 1;
		hitChance = rand.nextInt((20 - 1) + 1) + 1;
		if(hitChance > vaisseauDefense.evasion) {
			touch = true;			
			dammages = (vaisseauAttack.cannons * modifier);
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
			touch = false;
		}
	}


}
