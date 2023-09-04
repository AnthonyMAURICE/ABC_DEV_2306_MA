package objectSW;

public class Sith extends Jedi{
	
	public Sith(String _n, int _x, int _y, int _v, int _force, Lightsaber _saber) {
		super(_n, _x, _y, _v, _force, _saber);
		this.nom = "Darth " + _n;
	}

	
	
	@Override
	public String parler() {		
		return "Obtempérez et mourez !";
	}
}
