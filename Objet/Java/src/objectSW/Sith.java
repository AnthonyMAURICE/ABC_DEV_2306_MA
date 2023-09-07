package objectSW;

public class Sith extends Jedi{
	
	public Sith(String _n, int _x, int _y, int _v, Lightsaber _saber,int _force, int _cA) {
		super(_n, _x, _y, _v, _saber, _force, _cA);
		this.nom = "Darth " + _n;
	}

	
	
	@Override
	public String parler() {		
		return "Obtempérez et mourez !";
	}
}
