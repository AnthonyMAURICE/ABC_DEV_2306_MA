package javaquarium;

import java.util.concurrent.ThreadLocalRandom;

public  class Poissons {
	private String name;
	private int pv, age, generation = 0;
	private boolean female;
	private boolean carnivore;
	private boolean hasReproducedThisTurn = false;
	private String race;
	private Aquarium aquarium;
	private boolean isAlive = true;
	
	public Poissons(String _name, int _generation, int _pv, int _age, boolean _female, boolean _carnivore, String _race, Aquarium _aquarium) {
		this.name = _name;
		this.generation = _generation;
		this.pv = _pv;
		this.age = _age;
		this.female = _female;
		this.carnivore = _carnivore;
		this.race = _race;
		this.aquarium = _aquarium;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public int getGeneration() {
		return this.generation;
	}
	
	public boolean getGender() {
		return this.female;
	}
	
	public String getRace() {
		return this.race;
	}
	
	public int getPv() {
		return this.pv;
	}
	
	public boolean getReproThisTurn() {
		return this.hasReproducedThisTurn;
	}
	
	public void setReproNextTurn() {
		this.hasReproducedThisTurn = false;
	}
	
	public void setPv(int _pv) {
		this.pv += _pv;
	}
	

	public boolean setGender() { // m�thode qui d�finit le genre des poissons hermaphrodites selon l'�ge 
		if(this.race.equals("Bar")|| this.race.equals("Merou")) {
			if(this.age > 10) {
				this.female = true;
			}else {
				this.female = false;
			}
		}
		return this.female;
	}
	
	public void advanceAge() { // m�thode d'avancement de l'�ge des poissons
		this.age++;
		this.pv--;
		if(this.isAlive) {
			this.alive(); // qui appelle celle qui d�termine sa mort si trop �g�
		}	
	}
	
	public boolean alive(){ // m�thode qui d�termine si le poisson est en vie, selon son �ge et ses points de vie
		if(this.pv > 0 && age < 20) {
			return this.isAlive = true;
		}else {
			return this.isAlive = false;
		}
	}
	
	public void manger() { // m�thode dy cycle de restauration des poissons
		
		int menu = 0;
		if(this.pv <= 5 && this.isAlive) { // d�clenche le cycle de restauration si les points de vie sont inf�rieurs � 5 et s'il est vivant
			if(this.carnivore) { // partie pour les carnivores
				if(this.aquarium.getPoissons().size() > 1) {
					menu = ThreadLocalRandom.current().nextInt(0, this.aquarium.getPoissons().size());
				
				
					if(this.aquarium.getPoissons().get(menu).getRace().equals(this.race)) {
						System.out.println("Un poisson, m�me carnivore et affam�, ne peut attaquer un cong�n�re.");
					}else {
						System.out.println(this.name  + " " + this.generation+ " attaque " + this.aquarium.getPoissons().get(menu).getName());
						this.aquarium.getPoissons().get(menu).setPv(-4);
						System.out.println(this.aquarium.getPoissons().get(menu).getName() + " perd 4 points de vie ! " 
											+ (this.aquarium.getPoissons().get(menu).getGender()? "Elle":"Il") + " est � " 
											+ this.aquarium.getPoissons().get(menu).getPv());
						this.setPv(5);
						System.out.println(this.name + " " + this.generation+ " gagne 5 points de vie ! "+ (this.female? "Elle":"Il")+ " est � " + this.pv);
					}
				}	
			}else { // partie pour les herbivores
				if(this.aquarium.getAlgues().size() > 0) {
					menu = ThreadLocalRandom.current().nextInt(0, this.aquarium.getAlgues().size());
					this.aquarium.getAlgues().get(menu).setPv(-2);
					System.out.println("L'algue perd 2 points de vie ! Elle est � " 
									+ this.aquarium.getAlgues().get(menu).getPv());
					this.setPv(3);
					System.out.println(this.name + " " + this.generation + " gagne 3 points de vie ! "+ (this.female? "Elle":"Il")+ " est � " + this.pv);
					this.aquarium.getAlgues().get(menu).getExistence();
				}
			}		
		}
	}
	
	public void reproduce() { // m�thode principale du cycle de reproduction des poissons, compl�t�e dans la classe Aquarium
		String name = "";
		int mate = ThreadLocalRandom.current().nextInt(0, this.aquarium.getPoissons().size());
		if(this.age > 3 && this.aquarium.getPoissons().size()<30) {
			if(this.race.equals("Sole") || this.race.equals("Poisson-clown") && this != this.aquarium.getPoissons().get(mate)) {
				this.female = !this.aquarium.getPoissons().get(mate).getGender();
			}
			if(this.race.equals(this.aquarium.getPoissons().get(mate).getRace()) && this.female != this.aquarium.getPoissons().get(mate).getGender() && !this.hasReproducedThisTurn && !this.aquarium.getPoissons().get(mate).hasReproducedThisTurn) {	
				this.hasReproducedThisTurn = true;
				this.aquarium.getPoissons().get(mate).hasReproducedThisTurn = true;
				name = this.name;
				this.generation++;
				this.aquarium.reproFish(name, this.generation, this.race, this.carnivore);
			}
		}
	}
	
}