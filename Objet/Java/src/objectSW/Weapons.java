package objectSW;

public abstract class Weapons {
	private int accuracy;
	public Weapons(String _name, int _dammage, int _accuracy, boolean ranged) {
		
	}
	
	public int getAccuracy() {
		return this.accuracy;
	}
	
}


class Lightsaber extends Weapons{
	private String name, color;
	private int dammage, accuracy, deflect;
	private boolean ignited, ranged;
	

	public Lightsaber(String _name, int dammage, int _accuracy, int _deflect, String _color, boolean _ranged) {
		super(_name, dammage, _accuracy, _ranged);
		this.name = _name;
		this.dammage = dammage;
		this.accuracy = _accuracy;
		this.deflect = _deflect;
		this.color = _color;
		this.ignited = false;
		this.ranged = _ranged;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getColor() {
		return this.color;
	}
	
	
		
	public void setIgnited() {
		if(this.ignited) {
			this.ignited = false;
		}else {
			this.ignited = true;
		}
	}
	
}