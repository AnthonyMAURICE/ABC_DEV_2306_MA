package objectSW;

public abstract class Weapons {
	public Weapons(String _name, int _dammage, int _accuracy) {
		
	}
	
}


class Lightsaber extends Weapons{
	private String name, color;
	private int dammage, accuracy, deflect;
	private boolean ignited, ranged;

	public Lightsaber(String _name, int dammage, int _accuracy, int _deflect, String _color) {
		super(_name, dammage, _accuracy);
		this.name = _name;
		this.dammage = dammage;
		this.accuracy = _accuracy;
		this.deflect = _deflect;
		this.color = _color;
		this.ignited = false;
		this.ranged = false;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean getIgnited() {
		return this.ignited;
	}
	
}