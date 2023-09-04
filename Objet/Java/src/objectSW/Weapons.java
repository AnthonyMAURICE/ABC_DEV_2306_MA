package objectSW;

public abstract class Weapons { // superclasse Weapons, de laquelle découle toutes les classes d'armes
	private int accuracy, dammage;
	private boolean ranged;
	public Weapons(int _dammage, int _accuracy, boolean _ranged) {
		this.dammage = _dammage;
		this.accuracy = _accuracy;
		this.ranged = _ranged;
	}
	
	public int getDammage() {
		return this.dammage;
	}
	
	public int getAccuracy() {
		return this.accuracy;
	}
	
	public boolean getRanged() {
		return this.ranged;
	}
	
}

