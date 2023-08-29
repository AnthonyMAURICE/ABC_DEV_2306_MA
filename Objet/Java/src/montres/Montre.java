package montres;

public class Montre {

	int heure, minutes;
	
	public Montre() {
		this.heure = 13;
		this.minutes = 45;
	}
	
	public Montre(int _heure, int _minutes) {
		this.heure = _heure;
		this.minutes = _minutes;
	}
	
	public void avancerHeure() {
		this.minutes += 1;
		if(this.minutes == 60) {
			this.minutes = 0;
			this.heure += 1;
		}
		if (this.heure == 24) {
			this.heure = 0;
		}
		
	}
		
}
