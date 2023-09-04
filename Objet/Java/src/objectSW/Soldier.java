package objectSW;

public class Soldier extends Personnage{

	public Soldier(String _n, int _x, int _y, int _v) {
		super(_n, _x, _y, _v);
		
	}

	@Override
	public String parler() {
		return "Pour l'Empire !";
	}

}
