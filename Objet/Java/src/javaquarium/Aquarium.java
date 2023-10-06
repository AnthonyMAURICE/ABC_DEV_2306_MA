package javaquarium;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Aquarium {
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
	
	public String state() { // fonction qui retourne un état des lieux de l'aquarium, poissons et algues en vie
		String state = "";
		for(int l = 0; l < this.getPoissons().size(); l++) {
			state += this.getPoissons().get(l).getName() + " " + this.getPoissons().get(l).getGeneration() + " : " + this.getPoissons().get(l).getPv() + " pv \n";
		}
		state += "Il reste " + this.getAlgues().size() + " algues\n";
		return state;
	}
		
	public void addAlgue(int _pv) {	// méthode d'ajout d'algue à la liste, si le nombre est inférieur à 30
		if(this.nbeAlgues.size() < 30) {
			Algue algue = new Algue(_pv, 0, true, this);
			this.nbeAlgues.add(algue);
			System.out.println("Une nouvelle algue est née");
		}
	}
	
	public void removeAlgue() { // méthode qui "enlève" de la liste les algues mortes
		for(int i = 0; i < this.nbeAlgues.size(); i++) {
			if(this.nbeAlgues.get(i).getExistence() == false) {
				this.nbeAlgues.remove(i);
			}
		}
	}
	
	public void reproFish(String _name, int _generation, String _race, boolean _carnivore) { // deuxième partie de la méthode de reproduction des poissons, pour les ajouter à la liste
		int random = ThreadLocalRandom.current().nextInt(0, 1);
		boolean fem = false;
		if(random == 1 || _race.equals("Merou") || _race.equals("Bar")) {
			fem = true;
		}else {
			fem = false;
		}
		Poissons fish = new Poissons(_name, _generation, 10, 0, fem, _carnivore, _race, this);
		fishList.add(fish);	
	}
	
	public void start() { // méthode initialisant l'aquarium avec des poissons et des algues
		Poissons carnivore1 = new Poissons("Léviathan", 1, 10, 0, false, true, "Merou", this);
		Poissons carnivore2 = new Poissons("Kraken", 1, 10, 0, true, true, "Thon", this);
		Poissons carnivore3 = new Poissons("TerrorFish", 1, 10, 0, true,true, "Poisson-clown", this);
		Poissons carnivore4 = new Poissons("Cthulhu", 1, 10, 0, false, true, "Thon", this);
		Poissons carnivore5 = new Poissons("DrEvil", 1, 10, 10, false, true, "Merou", this);
		Poissons carnivore6 = new Poissons("Bob", 1, 10, 0, false, true, "Poisson-clown", this);
		Poissons herbivore1 = new Poissons("Écureuil", 1, 10, 0, false, false, "Bar", this);
		Poissons herbivore2 = new Poissons("FishNChips", 1, 10, 0, true, false, "Sole", this);
		Poissons herbivore3 = new Poissons("Magikarp", 1, 10, 0, false, false, "Carpe", this);
		Poissons herbivore4 = new Poissons("Bar", 1, 10, 10, true, false, "Bar", this);
		Poissons herbivore5 = new Poissons("Meunière", 1, 10, 0, false, false, "Sole", this);
		Poissons herbivore6 = new Poissons("Carpette", 1, 10, 0, true, false, "Carpe", this);
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
		this.addAlgue(10);
	}	
	/*
	public void addPoissonManual() {
		
	}
	*/
}