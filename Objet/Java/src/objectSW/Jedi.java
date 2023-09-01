package objectSW;

//À reprendre, peut-être entièrement

public class Jedi extends Personnage{
	private Lightsaber saber;
	
	
	public Jedi(String _n, int _x, int _y, int _v, int _force, Lightsaber _saber) {
		super(_n, _x, _y, _v, _force);

		this.saber = _saber;
		this.v = 5;		
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public Lightsaber getSaber() {
		return this.saber;
	}
	
	public void setIgnition() {
		this.saber.setIgnited();
	}
	
	

	@Override
	public String parler() {		
		return "Que la Force soit avec vous";
	}

}
