package objectSW;

public class Stormtrooper extends Personnage{
	private Blaster weapon;
	public Stormtrooper(String _n, int _x, int _y, int _v, Blaster _blaster) {
		super(_n, _x, _y, _v);
		this.weapon = _blaster;
	}
	
	

	@Override
	public String parler() {
		return "Pour l'Empire !";
	}

}
