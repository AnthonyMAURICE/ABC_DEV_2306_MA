package javaquarium;

public class Algue {
	private int pv, age;
	private boolean exist = true;
	private Aquarium aquarium;
	
	public Algue(int _pv, int _age, boolean _exist, Aquarium _aquarium) {
		this.pv = _pv;
		this.age = _age;
		this.exist = _exist;
		this.aquarium = _aquarium;
	}
	
	public int getPv() {
		return this.pv;
	}
	
	public boolean getExistence() {
		if(this.pv > 0 && age <= 20) {
			return this.exist = true;
		}else {
			System.out.println("Une algue est morte...");
			this.aquarium.getAlgues().remove(this);
			System.out.println("Elles sont au nombre de " + this.aquarium.getAlgues().size());
			return this.exist = false;
		}
	}
	
	public void advanceAge() {
		this.age++;
		if(this.exist) {
			this.getExistence();
		}	
	}
	
	public void reproduce() {
		if(this.pv >=10) {
			this.pv /= 2;
			this.aquarium.addAlgue(5);
			System.out.println("Une nouvelle algue est née");
			System.out.println("Elles sont au nombre de " + this.aquarium.getAlgues().size());
		}
	}
	
	public void setPv(int _pv) {
		this.pv += _pv;
		this.setExistence();
	}
	
	public boolean setExistence() {
		if(this.pv > 0) {
			return this.exist = true;
		}else {
			return this.exist = false;
		}
	}
}
