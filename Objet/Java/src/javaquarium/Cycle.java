package javaquarium;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Cycle {
	public Cycle() {
		
	}
	
	public void cycling() throws InterruptedException, IOException {
		int tours = 1; 
		String state, data = "", data2 = "";
		String traceLog = "";

		Aquarium aquarium = new Aquarium();
		
		aquarium.start();
		
		Scanner scanner = new Scanner(System.in);
			while(tours <= 100) {
				//TimeUnit.SECONDS.sleep(2);
				
				if(tours == 25) {
					
					
					File loading = new File("C:\\Users\\amaurice\\Documents\\Git\\ABCDEV_2306_MA\\Objet\\Java\\src\\javaquarium\\loadAlgues.txt");
					File loading2 = new File("C:\\Users\\amaurice\\Documents\\Git\\ABCDEV_2306_MA\\Objet\\Java\\src\\javaquarium\\loadFish.txt");
					Scanner load = new Scanner(loading);
					Scanner load2 = new Scanner(loading2);
					
					while(load.hasNextLine()) {
						data += load.nextLine();
					}
					while(load2.hasNextLine()) {
						data2 += load2.nextLine();
					}
					
					String[] split = data.replace("ans", "").replace("algues", "").split(" ");
					String[] split2 = data2.replace(",", "").replace("ans", "").split(" ");
					
					for(int i = 0; i < split2.length; i+=3) {
						Poissons poisson = new Poissons(split2[i], 1, 10, 0, true, true, split2[i+1], aquarium);
						poisson.setGender();
						aquarium.getPoissons().add(poisson);
					}
					

					
					load.close();
					load2.close();
					
					
					
				}
				/*
				if(aquarium.getPoissons().size()< 6) {
					System.out.println("Souhaitez vous acheter un poisson ? (O) pour oui");
					
						choice = scanner.nextLine().toLowerCase();
						if(choice.equals("o")) {
							aquarium.addPoissonManual();
						}else {
							System.out.println("Très bien...");
						}
				}
				*/
				for(int k = 0; k < aquarium.getAlgues().size(); k++) {
					aquarium.getAlgues().get(k).setPv(1);
					aquarium.getAlgues().get(k).advanceAge();
					if(aquarium.getAlgues().size() > 0) {
						aquarium.getAlgues().get(k).reproduce();
					}
					
				}
				
				for(int i = 0; i < aquarium.getPoissons().size(); i++) {
					aquarium.getPoissons().get(i).manger();
					aquarium.getPoissons().get(i).advanceAge();
					
					aquarium.getPoissons().get(i).setGender();
					if(aquarium.getPoissons().get(i).getPv() > 5 && aquarium.getPoissons().size() > 1) { 
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
					
					if(tours == 35) {
						FileWriter writer = new FileWriter("C:\\Users\\amaurice\\Documents\\Git\\ABCDEV_2306_MA\\Objet\\Java\\src\\javaquarium\\saveTurn35.txt");
						writer.write("=== Tour " + tours + ": ===\n" + String.valueOf(aquarium.state()));
						writer.close();
					}
				}

				traceLog += "=== Tour " + tours + ": ===\n" + String.valueOf(aquarium.state() + "\n");
				System.out.println("===Tour " + tours+"===");
				tours++;
				state = aquarium.state();
				System.out.println(state);
				
			}
			FileWriter log = new FileWriter("C:\\Users\\amaurice\\Documents\\Git\\ABCDEV_2306_MA\\Objet\\Java\\src\\javaquarium\\log.txt");
			log.write(traceLog);
			log.close();
			scanner.close();
		
	}
	
	
}
