package objectSW;

public class Blaster extends Weapons{ // à terminer
	private String name;
	
	public Blaster(String _name, int _dammage, int _accuracy, boolean _ranged) {
		super(_name, _dammage, _accuracy, _ranged);

	}

	@Override
	protected int getDeflect() {
		return 0;
	}

}
