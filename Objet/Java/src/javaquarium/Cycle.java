package javaquarium;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.SwingUtilities;

public class Cycle {
	public Cycle() {
		
	}
	
	public void cycling() throws InterruptedException, IOException {
		int tours = 1; 
		String state;
		String traceLog = "";
		//int shop = 0;
		String choice = "";
		Aquarium aquarium = new Aquarium();
		
		aquarium.start();
		
		Scanner scanner = new Scanner(System.in);
			while(tours <= 100) {
				//TimeUnit.SECONDS.sleep(2);

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

				//shop++;
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
		
		/*
		// Interface graphique
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				InterfaceGraphique userInterface = new InterfaceGraphique(aquarium);
				userInterface.setVisible(true);
			}
		});
		*/
	}
	
	
}
