package objectSW;

public class Lightsaber extends Weapons{
	private String name, color;
	private int deflect;
	private boolean ignited;
	

	public Lightsaber(int _dammage, int _accuracy, int _deflect, String _color, boolean _ranged) {
		super(_dammage, _accuracy, _ranged);
		this.name = "Sabre laser";
		this.deflect = _deflect;
		this.color = _color;
		this.ignited = false;
	}
	
	public String getName() {
		return this.name;
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
