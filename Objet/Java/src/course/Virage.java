package course;

public class Virage {
	private int difficulty;
	
	public Virage(int _difficulty) {
		this.difficulty = _difficulty;
	}
	
	public int getVitesseVirage() {
		int vitesseMax = 0;
		switch(this.difficulty) {
		case 1:
			vitesseMax = 200;
			break;
		case 2:
			vitesseMax = 150;
			break;
		case 3:
			vitesseMax = 100;
			break;
		case 4:
			vitesseMax = 50;
			break;
		}
		return vitesseMax;
	}
	

}
