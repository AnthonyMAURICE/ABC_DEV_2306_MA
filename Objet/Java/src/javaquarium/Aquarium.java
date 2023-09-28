package javaquarium;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Aquarium {
	private int flag = 0;
	private ArrayList<Algue> nbeAlgues;
	private ArrayList<Poissons> fishList;
	
	public Aquarium() {
		this.nbeAlgues = new ArrayList<Algue>();
		this.fishList = new ArrayList<Poissons>();
	}
	
	public ArrayList<Algue> getAlgues() {
		return this.nbeAlgues;
	}
	
	public ArrayList<Poissons> getPoissons() {
		return this.fishList;
	}
	
	public void state() {
		for(int l = 0; l < this.getPoissons().size(); l++) {
			System.out.println(this.getPoissons().get(l).getName() + " : " + this.getPoissons().get(l).getPv() + " pv");
		}
	}
		
	public void addAlgue(int _pv) {	
		if(this.flag < 20) {
			Algue algue = new Algue(_pv, 0, true, this, flag);
			this.nbeAlgues.add(algue);
			this.flag++;
		}else {
			for(int i = 0; i < this.flag; i++) {
				if(this.nbeAlgues.get(i).getExistence() == false) {
					this.nbeAlgues.get(i).setPv(10);
					this.nbeAlgues.get(i).getExistence();
					this.nbeAlgues.add(this.nbeAlgues.get(i));
				}
			}
		}
		System.out.println("Une nouvelle algue est née");
		System.out.println("Elles sont au nombre de " + this.getAlgues().size());
	}
	
	public void removeAlgue() {
		for(int i = 0; i < this.nbeAlgues.size(); i++) {
			if(this.nbeAlgues.get(i).getExistence() == false) {
				this.nbeAlgues.remove(i);
				this.flag--;
			}
		}
	}
	
	public void reduceFlag() {
		this.flag--;
	}
	
	public void reproFish(String _name, String _race, boolean _carnivore) {
		int random = ThreadLocalRandom.current().nextInt(0, 1);
		boolean fem = false;
		if(random == 1 || _race.equals("Mérou") || _race.equals("Bar")) {
			fem = true;
		}else {
			fem = false;
		}
		Poissons fish = new Poissons(_name, 10, 0, fem, _carnivore, _race, this);
		fishList.add(fish);	
	}
	
	public void start() {
		Poissons carnivore1 = new Poissons("Léviathan", 10, 0, false, true, "Mérou", this);
		Poissons carnivore2 = new Poissons("Kraken", 10, 0, true, true, "Thon", this);
		Poissons carnivore3 = new Poissons("TerrorFish", 10, 0, true,true, "Poisson-clown", this);
		Poissons herbivore1 = new Poissons("Écureuil", 10, 0, false, false, "Bar", this);
		Poissons herbivore2 = new Poissons("FishNChips", 10, 0, true, false, "Sole", this);
		Poissons herbivore3 = new Poissons("Magikarp", 10, 0, false, false, "Carpe", this);
		Poissons carnivore4 = new Poissons("Cthulhu", 10, 0, false, true, "Thon", this);
		Poissons carnivore5 = new Poissons("DrEvil", 10, 10, false, true, "Mérou", this);
		Poissons carnivore6 = new Poissons("Bob", 10, 0, false, true, "Poisson-clown", this);
		Poissons herbivore4 = new Poissons("Bar", 10, 10, true, false, "Bar", this);
		Poissons herbivore5 = new Poissons("Meunière", 10, 0, false, false, "Sole", this);
		Poissons herbivore6 = new Poissons("Carpette", 10, 0, true, false, "Carpe", this);
		fishList.add(carnivore1);
		fishList.add(carnivore2);
		fishList.add(carnivore3);
		fishList.add(carnivore4);
		fishList.add(carnivore5);
		fishList.add(carnivore6);
		fishList.add(herbivore1);
		fishList.add(herbivore2);
		fishList.add(herbivore3);
		fishList.add(herbivore4);
		fishList.add(herbivore5);
		fishList.add(herbivore6);
		this.addAlgue(10);
		this.addAlgue(10);
		this.addAlgue(10);
		this.addAlgue(10);
	}
	
	/*
	public void addPoissonManual() {
		int choix = 0;
		boolean female = false, checked = false, carnivore = false;
		Scanner scanner = new Scanner(System.in);
		String fishName, fishSpecies = "", genre;
		System.out.println("Quel nom pour votre poisson ?");
		fishName = scanner.nextLine();
		do {
			System.out.println("Un (m)âle ou une (f)emelle ?");
			genre = scanner.nextLine().toLowerCase();
			if(genre.equals("m")) {
				female = false;
				checked = true;
			}else if(genre.equals("f")) {
				female = true;
				checked = true;
			}else {
				System.out.println("Saisie invalide");
			}
		}while(!checked);
		System.out.println("Quel type de poisson voulez-vous ajouter ?");
		System.out.println("1 = Mérou, 2 = Thon, 3 = Poisson-clown, 4 = Sole, 5 = Bar, 6 = Carpe");
			if(scanner.hasNextInt()) {
				choix = scanner.nextInt();
				switch(choix) {
					case 1:
						fishSpecies = "Mérou";
						female = false;
						carnivore = true;
						break;
					case 2:
						fishSpecies = "Thon";
						carnivore = true;
						break;
					case 3:
						fishSpecies = "Poisson-clown";
						carnivore = true;
						break;
					case 4:
						fishSpecies = "Sole";
						carnivore = false;
						break;
					case 5:
						fishSpecies = "Bar";
						female = false;
						carnivore = false;
						break;
					case 6:
						fishSpecies = "Carpe";
						carnivore = false;
						break;
					default:
						System.out.println("Saisie invalide !");
						break;		
				}
				if(choix <= 3) {
					Poissons carn = new Poissons(fishName, 10, 0, female, carnivore, fishSpecies, this);
					this.fishList.add(carn);
				}else {
					Poissons herb = new Poissons(fishName, 10, 0, female, carnivore, fishSpecies, this);
					this.fishList.add(herb);
				}
			}else {
				System.out.println("Saisie invalide ! ");
			}
			scanner.close();
	}*/
}
