package course;

import java.util.ArrayList;
import java.util.Scanner;

public class Circuit {
	private String name;
	private int tours, sections, virages;
	private boolean virage = false;

	public Circuit(String _name) {
		this.name = _name;
	}
	
	public void createCircuit(ArrayList<Section> sections, ArrayList<Virage> virages) {
		
		int nombreVirages = 0;
		int nombreSection = 0;
		boolean legit = false;
		System.out.println("Combien de sections à votre circuit ?");
		Scanner scanner = new Scanner(System.in);
			nombreSection = scanner.nextInt();
			int i = 0, j = 0;
			while(i < nombreSection) {
				System.out.println("Quelle longueur pour la section " + (i+1) + " ?");
				int longueur = scanner.nextInt();
				sections.add(new Section(longueur));
				i++;
			}
			do {
				System.out.println("Combien de virages à votre circuit ? entre " + (nombreSection-1) + " et " + (nombreSection + 1));
				nombreVirages = scanner.nextInt();
				if(nombreVirages >= nombreSection - 1 && nombreVirages <= nombreSection + 1) {
					legit = true;
				}else {
					System.out.println("Configuration de circuit impossible. Pas assez ou trop de virages");
				}
			}while(!legit);
			while(j < nombreVirages) {
				System.out.println("Quelle difficulté pour le virage " + (j+1) + "(de 1 à 4)?");
				int diff = scanner.nextInt();
				if(diff > 0 && diff < 5) {
					virages.add(new Virage(diff));
					j++;
				}else {
					System.out.println("Saisie invalide");
				}
			}
		
		scanner.close();
	}
	

	public void course(Voitures _voiture, ArrayList<Section> _sections, ArrayList<Virage> _virages, int _tours) {
		ArrayList<Integer> indexClassement = new ArrayList<Integer>();
		ArrayList<Integer> indexVMax = new ArrayList<Integer>();
		int indexTours = 0, indexTemps = 0;
		int tours = _tours;
		System.out.println("La " + _voiture.getName() + " démarre la course.");
		while(tours > 0) {
			int i = 0, temps = 0, temps2 = 0, j = 0;
			for(int sections = 0; sections < _sections.size(); sections++) {
				if(!this.virage) {
					int index = i+1;
					int longueurSection = _sections.get(i).getLongueur();
					while(longueurSection > _voiture.getVitesse()) {
						temps++;
						_voiture.accelerer();
						 longueurSection -=_voiture.getVitesse();
					}
					//System.out.println("La " + _voiture.getName() + " a passé la section " + index + " en " + temps + " temps");
					this.virage = true;
					if(i < _sections.size()) {
						i++;
					}else {
						i = 0;
					}
					
				}else {
					int index2 = j + 1;
					//System.out.println("La " + _voiture.getName() + " entamme le virage " + index2);
					while (_voiture.getVitesse() > _virages.get(j).getVitesseVirage() + _voiture.bonusAgilite()) {
						temps2++;
						_voiture.freiner();
					}
					//System.out.println("La " + _voiture.getName() + " a passé le virage " + index2 + " en " + temps2 + " temps");
					if(j < _virages.size()) {
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
		indexClassement.add(indexTemps);
		indexVMax.add(_voiture.getVitesse());
		String temp;
		System.out.println("La " + _voiture.getName() + " a terminé la course en " + indexTemps + " temps");
		indexTemps = 0;
		
	}
	
	

}