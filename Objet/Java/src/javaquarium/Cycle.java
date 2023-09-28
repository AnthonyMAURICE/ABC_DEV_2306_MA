package javaquarium;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Cycle {
	public Cycle() {
		
	}
	
	public void cycling() throws InterruptedException {
		int tours = 1; 
		//int shop = 0;
		//String choice = "";
		Aquarium aquarium = new Aquarium();
		
		aquarium.start();
		
		Scanner scanner = new Scanner(System.in);
			while(tours <= 50) {
				TimeUnit.SECONDS.sleep(2);
				System.out.println("===Tour " + tours+"===");
				
				/*
				if(shop == 5) {
					System.out.println("Souhaitez vous acheter un poisson ? (O) pour oui");
					
						choice = scanner.nextLine().toLowerCase();
						if(choice.equals("o")) {
							aquarium.addPoissonManual();
						}else {
							System.out.println("Très bien...");
						}
					shop = 0;
				}
				*/				

				for(int k = 0; k < aquarium.getAlgues().size(); k++) {
					aquarium.getAlgues().get(k).setPv(1);
					aquarium.getAlgues().get(k).advanceAge();
					aquarium.getAlgues().get(k).reproduce();
				}
				
				for(int i = 0; i < aquarium.getPoissons().size(); i++) {
					aquarium.getPoissons().get(i).manger();
					aquarium.getPoissons().get(i).advanceAge();
					
					aquarium.getPoissons().get(i).setGender();
					if(aquarium.getPoissons().get(i).getPv() > 5) { 
						aquarium.getPoissons().get(i).reproduce();
					}	
				}
				
				for (int j = 0; j < aquarium.getPoissons().size(); j++) {
					aquarium.getPoissons().get(j).setReproNextTurn();
					if(!aquarium.getPoissons().get(j).alive()) {
						System.out.println(aquarium.getPoissons().get(j).getName() + (aquarium.getPoissons().get(j).getGender()? " est morte..." : " est mort..."));
						aquarium.getPoissons().remove(aquarium.getPoissons().get(j));
						j--;
					}
				}

				//shop++;
				tours++;
				aquarium.state();
			}
		scanner.close();
	}
}
