package objectSW;

public abstract class Weapons { // superclasse Weapons, de laquelle découle toutes les classes d'armes
	private String name;
	private int accuracy, dammage;
	private boolean ranged;
	public int getDeflect;
	public Weapons(String _name, int _dammage, int _accuracy, boolean _ranged) {
		this.name = _name;
		this.dammage = _dammage;
		this.accuracy = _accuracy;
		this.ranged = _ranged;
	}
	
	public String getName() {
		return this.name;
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

	protected abstract int getDeflect();
	
}

