package javaquarium;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public  class Poissons {
	private String name;
	private int pv, age;
	private boolean female;
	private boolean carnivore;
	private String race;
	private Aquarium aquarium;
	private boolean isAlive = true;
	
	public Poissons(String _name, int _pv, int _age, boolean _female, boolean _carnivore, String _race, Aquarium _aquarium) {
		this.name = _name;
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
	
	public boolean getGender() {
		return this.female;
	}
	
	public String getRace() {
		return this.race;
	}
	
	public int getPv() {
		return this.pv;
	}
	
	public void setPv(int _pv) {
		this.pv += _pv;
	}
	
	public void advanceAge() {
		this.age++;
		if(this.isAlive) {
			this.alive();
		}	
	}
	
	public void setGender() {
		if(this.race.equals("Bar")|| this.race.equals("M�rou")) {
			if(this.age > 10) {
				if(this.female) {
					this.female = false;
				}else {
					this.female = true;
				}
			}
		}else if(this.race.equals("Sole")|| this.race.equals("Poisson-clown")) {
			
		}
	}
	
	public boolean alive(){
		if(this.pv > 0 && age <= 20) {
			return this.isAlive = true;
		}else {
			System.out.println(this.name + (this.female? " est morte..." : " est mort..."));
			this.aquarium.getPoissons().remove(this);
			return this.isAlive = false;
		}
	}
	
	public void manger() {
		int menu = 0;
		if(this.pv <= 5 && this.isAlive) {
			if(this.carnivore) {
				menu = ThreadLocalRandom.current().nextInt(0, this.aquarium.getPoissons().size());
				if(this.aquarium.getPoissons().get(menu).getRace().equals(this.race)) {
					System.out.println("Un poisson, m�me carnivore et affam�, ne peut se manger lui-m�me, ni attaquer un cong�n�re.");
				}else {
					System.out.println(this.name + " attaque " + this.aquarium.getPoissons().get(menu).getName());
					this.aquarium.getPoissons().get(menu).setPv(-4);
					System.out.println(this.aquarium.getPoissons().get(menu).getName() + " perd 4 points de vie ! " 
										+ (this.aquarium.getPoissons().get(menu).getGender()? "Elle":"Il") + " est � " 
										+ this.aquarium.getPoissons().get(menu).getPv());
					this.setPv(5);
					System.out.println(this.name + " gagne 5 points de vie ! "+ (this.female? "Elle":"Il")+ " est � " + this.pv);
					this.aquarium.getPoissons().get(menu).alive();
				}
			}else {
				menu = ThreadLocalRandom.current().nextInt(0, this.aquarium.getAlgues().size());
				this.aquarium.getAlgues().get(menu).setPv(-2);
				System.out.println("L'algue perd 2 points de vie ! Elle est � " 
						+ this.aquarium.getAlgues().get(menu).getPv());
				this.setPv(3);
				System.out.println(this.name + " gagne 3 points de vie ! "+ (this.female? "Elle":"Il")+ " est � " + this.pv);
				this.aquarium.getAlgues().get(menu).setExistence();
			}		
		}else {
			this.pv -= 1;
		}
	}
	
	public void reproduce() {
		int mate = ThreadLocalRandom.current().nextInt(0, this.aquarium.getPoissons().size());
		if(this.race.equals("Sole") || this.race.equals("Sole")) {
			this.female = !this.aquarium.getPoissons().get(mate).getGender();
		}
		if(this.race.equals(this.aquarium.getPoissons().get(mate).getRace()) && this.female != this.aquarium.getPoissons().get(mate).getGender()) {	
			Scanner scanner = new Scanner(System.in);
			System.out.println("Quel nom pour le nouveau poisson ?");
			String name = scanner.nextLine();
			scanner.close();
			this.aquarium.reproFish(name, this.race, this.carnivore);
		}
	}
}
