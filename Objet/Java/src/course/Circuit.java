package course;

public class Circuit {
	private String name;
	private int tours;
	private boolean virage = false;

	public Circuit(String _name) {
		this.name = _name;
		
	}
	
	
	

	public void course(Voitures _voiture, Section[] _sections, Virage[] _virage, int _tours) {
		int indexTours = 0, indexTemps = 0;
		int tours = _tours;
		System.out.println("La " + _voiture.getName() + " démarre la course.");
		while(tours > 0) {
			int i = 0, temps = 0, temps2 = 0, j = 0;
			for(int sections = 0; sections < _sections.length; sections++) {
				if(!this.virage) {
					int index = i+1;
					int longueurSection = _sections[i].getLongueur();
					while(longueurSection > _voiture.getVitesse()) {
						temps++;
						_voiture.accelerer();
						 longueurSection -=_voiture.getVitesse();
					}
					//System.out.println("La " + _voiture.getName() + " a passé la section " + index + " en " + temps + " temps");
					this.virage = true;
					if(i < _sections.length) {
						i++;
					}else {
						i = 0;
					}
					
				}else {
					int index2 = j + 1;
					//System.out.println("La " + _voiture.getName() + " entamme le virage " + index2);
					while (_voiture.getVitesse() > _virage[j].getVitesseVirage() + _voiture.bonusAgilite()) {
						temps2++;
						_voiture.freiner();
					}
					//System.out.println("La " + _voiture.getName() + " a passé le virage " + index2 + " en " + temps2 + " temps");
					if(j < _virage.length) {
						j++;
					}else {
						j = 0;
					}
					this.virage = false;
				}
			}
			indexTours++;
			//System.out.println("La " + _voiture.getName() + " a terminé le tour " + indexTours + " en " + (temps + temps2) + " temps");
			indexTemps += temps + temps2;
			tours--;
			
			
		}
		
		System.out.println("La " + _voiture.getName() + " a terminé la course en " + indexTemps + " temps");
		indexTemps = 0;
	}
	
	

}