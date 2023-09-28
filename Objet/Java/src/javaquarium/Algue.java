package javaquarium;

import java.util.concurrent.ThreadLocalRandom;

public class Algue {
	private int pv, age, flag;
	private boolean exist = true;
	private Aquarium aquarium;
	
	public Algue(int _pv, int _age, boolean _exist, Aquarium _aquarium, int _flag) {
		this.pv = _pv;
		this.age = _age;
		this.exist = _exist;
		this.aquarium = _aquarium;
		this.flag = _flag;
	}
	
	public int getPv() {
		return this.pv;
	}
	
	public int getFlag() {
		return this.flag;
	}
	
	public boolean getExistence() {
		if(this.pv > 0 && age <= 20) {
			return this.exist = true;
		}else {
			System.out.println("Une algue est morte...");
			this.aquarium.getAlgues().remove(this);
			this.aquarium.reduceFlag();
			System.out.println("Elles sont au nombre de " + this.aquarium.getAlgues().size());
			return this.exist = false;
		}
	}
	
	public void advanceAge() {
		this.age++;
		this.getExistence();
	}
	
	public void reproduce() {
		int randAlgueRepro = ThreadLocalRandom.current().nextInt(0, 2);
		if(this.pv >=10 && randAlgueRepro == 1 && this.aquarium.getAlgues().size() < 20) {
			this.pv /= 2;
			this.aquarium.addAlgue(5);
		}
	}
	
	public void setPv(int _pv) {
		this.pv += _pv;
		this.getExistence();
	}
	
	
}
