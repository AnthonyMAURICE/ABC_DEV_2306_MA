package objectSW;

public class Lightsaber extends Weapons{
	private String name, color;
	private int dammage, accuracy, deflect;
	private boolean ignited, ranged;
	

	public Lightsaber(int dammage, int _accuracy, int _deflect, String _color, boolean _ranged) {
		super(dammage, _accuracy, _ranged);
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
		
	public void setIgnited() {
		if(this.ignited) {
			this.ignited = false;
		}else {
			this.ignited = true;
		}
	}
}
