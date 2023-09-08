package course;

public class Circuit {
	private String name;
	private int tours;
	private boolean virage = false;

	public Circuit(String _name, int _tours) {
		this.name = _name;
		this.tours = _tours;
		
	}
	
	
	

	public void course(Voitures _voiture, Section[] _sections, Virage[] _virage) {
		while(tours > 0) {
			System.out.println("La " + _voiture.getName() + " démarre la course.");
			int i = 0, temps = 0;
			for(int sections = 0; sections < _sections.length; sections++) {
				if(!this.virage) {
					int index = i+1;
					int longueurSection = _sections[i].getLongueur();
					while(longueurSection > 100) {
						temps++;
						_voiture.accelerer();
						 longueurSection -=_voiture.getVitesse();
					}
					System.out.println("La " + _voiture.getName() + " a passé la section " + index + " en " + temps + " temps");
					this.virage = true;
					if(i < _sections.length) {
						i++;
					}else {
						i = 0;
					}
					
				}else {
					int j = 0, temps2 = 0;
					int index2 = j + 1;
					System.out.println("La " + _voiture.getName() + " entamme le virage " + index2);
					while (_voiture.getVitesse() > _virage[j].getVitesseVirage() + _voiture.bonusAgilite()) {
						temps2++;
						_voiture.freiner();
					}
					System.out.println("La " + _voiture.getName() + " a passé le virage " + index2 + " en " + temps2 + " temps");
					if(j < _virage.length) {
						j++;
					}else {
						j = 0;
					}
					this.virage = false;
				}
			}
			tours--;
			
			
		}

	}
	
	

}