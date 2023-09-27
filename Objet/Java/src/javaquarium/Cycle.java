package javaquarium;

import java.util.Scanner;

public class Cycle {
	public Cycle() {
		
	}
	
	public void cycling() {
		int tours = 1, shop = 0;
		String choice = "";
		Aquarium aquarium = new Aquarium();
		
		aquarium.start();
		
		Scanner scanner = new Scanner(System.in);
			while(tours <= 25) {
				System.out.println("Tour " + tours);
				if(shop == 5) {
					System.out.println("Souhaitez vous acheter un poisson ? (O) pour oui");
					
						choice = scanner.nextLine().toLowerCase();
						if(choice.equals("o")) {
							aquarium.addPoisson();
						}else {
							System.out.println("Très bien...");
						}
					shop = 0;
				}
							
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
				shop++;
				tours++;
			}
		scanner.close();
	}
}
