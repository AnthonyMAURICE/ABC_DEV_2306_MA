package objectSW;

//À reprendre, peut-être entièrement

public class Jedi extends Personnage{
	private boolean saberState;
	
	
	public Jedi(String _n, int _x, int _y, int _v, int _force, boolean _saberState) {
		super(_n, _x, _y, _v, _force);

		this.saberState = _saberState;
		this.v = 5;		
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void attribSaber() {
		String name = this.nom.toLowerCase(), color;
		if(name.equals("yoda")) {
			color = "vert";
		}else if(name.equals("mace windu")) {
			color = "violet";
		}else {
			color = "bleu";
		}
		Lightsaber lightsaber = new Lightsaber("Sabre de " + this.nom, 25, 95, 25, color);
	}
	
	public boolean ignitSaber(Lightsaber lightsaber) {
		if(!this.saberState) {
			lightsaber.getIgnited();
			return true;
		}else {
			return false;
		}

	}
	
	

	@Override
	public String parler() {		
		return "Que la Force soit avec vous";
	}

}
