package objectSW;

public class Mandalorian extends Personnage{
	private Blaster weapon;
	public Mandalorian(String _n, int _x, int _y, int _v, Blaster _blaster, int _force, int _cA) {
		super(_n, _x, _y, _v, _force, _cA);
		this.weapon = _blaster;
	}
	
	
	@Override
	public Weapons getWeapon() {
		return this.weapon;
	}
	

	@Override
	public String parler() {
		return "Telle est la voie !";
	}
}
