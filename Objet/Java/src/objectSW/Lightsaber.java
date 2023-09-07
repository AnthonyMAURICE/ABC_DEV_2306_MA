package objectSW;

public class Lightsaber extends Weapons{
	private String color;
	private int deflect;
	private boolean ignited;
	

	public Lightsaber(String _name, int _dammage, int _accuracy, int _deflect, String _color, boolean _ranged) {
		super(_name, _dammage, _accuracy, _ranged);
		this.deflect = _deflect;
		this.color = _color;
		this.ignited = false;
	}

	public int getDeflect() {
		return this.deflect;
	}
	
	public String getColor() {
		return this.color;
	}
		
	public void setIgnited() { // méthode d'activation ou désactivation du sabre laser 
		if(this.ignited) {
			this.ignited = false;
		}else {
			this.ignited = true;
		}
	}
}
