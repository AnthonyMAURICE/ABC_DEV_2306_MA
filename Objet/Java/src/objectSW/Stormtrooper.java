package objectSW;

public class Stormtrooper extends Personnage{
	private Blaster weapon;
	public Stormtrooper(String _n, int _x, int _y, int _v, Blaster _blaster, int _force, int _cA) {
		super(_n, _x, _y, _v, _force, _cA);
		this.weapon = _blaster;
	}
	
	public Weapons getWeapon() {
		return this.weapon;
	}
	

	@Override
	public String parler() {
		return "Pour l'Empire !";
	}

}
