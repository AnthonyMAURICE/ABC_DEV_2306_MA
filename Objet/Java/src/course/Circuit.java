package course;

public class Circuit {
	private String name;
	private int longueur, tours, sections;

	public Circuit(String _name, int _tours, int _sections) {
		this.name = _name;
		this.tours = _tours;
		this.sections = _sections;
	}
	
	public void course(Voitures[] _voitures) {
		int course = this.tours * this.sections;
		
		while(course > 0) {
			if(course%0 == 2) {
				this.line(_voitures);
			}else {
				this.virage(_voitures);	
			}
			course--;
		}
		
	}
	
	public void line(Voitures[] _voitures) {
		
	}
	
	public void virage(Voitures[] _voitures) {
		
	}

}