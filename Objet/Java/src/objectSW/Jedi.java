package objectSW;

//� reprendre, peut-�tre enti�rement

public class Jedi extends Personnage{ // classe Jedi, qui est aussi parente de la classe Sith
	private Lightsaber saber;
	private int force;
	
	public Jedi(String _n, int _x, int _y, int _v, int _force, Lightsaber _saber) {
		super(_n, _x, _y, _v); // super constructeur pour h�riter des attributs de la classe Personnage
		this.force = _force;
		this.saber = _saber;	
	}
	
	public Lightsaber getSaber() {
		return this.saber;
	}
	
	public int getForce() {
		return this.force;
	}
	
	public void setIgnition() {
		this.saber.setIgnited();
	}
	
	

	@Override
	public String parler() {		
		return "Que la Force soit avec vous";
	}

}
