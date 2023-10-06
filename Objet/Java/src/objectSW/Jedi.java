package objectSW;

//À reprendre, peut-être entièrement

public class Jedi extends Personnage{ // classe Jedi, qui est aussi parente de la classe Sith
	private Lightsaber saber;
	
	public Jedi(String _n, int _x, int _y, int _v, Lightsaber _saber, int _force, int _cA) {
		super(_n, _x, _y, _v, _force, _cA); // super constructeur pour hériter des attributs de la classe Personnage
		this.force = _force;
		this.saber = _saber;	
	}
	
	
	
	public void setIgnition() {
		this.saber.setIgnited();
	}
	
	

	@Override
	public String parler() {		
		return "Que la Force soit avec vous";
	}
	
	@Override
	public Lightsaber getWeapon() {
		return this.saber;
	}

}
