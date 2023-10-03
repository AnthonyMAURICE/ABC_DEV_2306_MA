package javaquarium;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Cycle {
	private int tours = 1; 
	private String state, data = "", data2 = "";
	private String traceLog = "";
	
	public Cycle() {
		
	}
	
	public void cycling() throws InterruptedException, IOException {
		Aquarium aquarium = new Aquarium();
		aquarium.start();
		Scanner scanner = new Scanner(System.in);
			while(tours <= 100) { // boucle sur 100 tours de jeu (environs 5 g�n�rations, du moins pour l'esp�rance de vie des poissons)
				TimeUnit.SECONDS.sleep(2); // timer, 2 secondes par tour
				if(tours == 25) {
					// au tour 25 (arbitrairement choisi) deux fichiers .txt sont charg�s, lus et trait�s
					File loading = new File("C:\\Users\\amaurice\\Documents\\Git\\ABCDEV_2306_MA\\Objet\\Java\\src\\javaquarium\\loadAlgues.txt");
					File loading2 = new File("C:\\Users\\amaurice\\Documents\\Git\\ABCDEV_2306_MA\\Objet\\Java\\src\\javaquarium\\loadFish.txt");
					Scanner load = new Scanner(loading); // premier scanner pour le fichier d'ajout d'algues
					Scanner load2 = new Scanner(loading2); // second scanner, pour le fichier d'ajout de poissons 
					
					while(load.hasNextLine()) { // tant qu'il y a quelque chose � lire
						data += load.nextLine() + " "; // c'est ajout� � une chaine de caract�re
					}
					while(load2.hasNextLine()) { // idem pour le second scanner
						data2 += load2.nextLine();
					}
					
					String[] split = data.split(" "); // la chaine est transform�e en tableau, un mot (ou nombre) par entr�e
					ArrayList<Integer> algueLoad = new ArrayList<Integer>(); // d�claration d'une ArrayList qui servira plus tard... 
					for(int i = 0; i < split.length; i++) {
						if(!split[i].equals("algues") && !split[i].equals("ans")) {
							algueLoad.add(Integer.parseInt(split[i])); // ... pour accueilir les nombres du tableau seulement
						}
					}
					
					for(int i = 0; i < algueLoad.size()-1; i+=2) { // boucle sur l'ArrayList pour ajouter les algues selon leur nombre et �ge
						for(int j = 0; j < algueLoad.get(i); j++) {
							Algue algue = new Algue(10, algueLoad.get(i+1), true, aquarium); // cr�ation d'un objet algue
							aquarium.getAlgues().add(algue); // et ajout � l'ArrayList li�e � l'aquarium
						}
					}
					
					String[] split2 = data2.replace(",", "").replace("ans", "").split(" "); //deuxi�me tabeau, pour les poissons
					for(int i = 0; i < split2.length; i+=3) { // boucle dessus, i est incr�ment� de 3 our passer au "bloc" suivant
						Poissons poisson = new Poissons(split2[i], 1, 10, 0, true, true, split2[i+1], aquarium); // cr�ation d'un objet poisson
						poisson.setGender(); // initialisation du genre, surtout pour le m�rou, hermaphrodite selon l'�ge
						aquarium.getPoissons().add(poisson); // et ajout � l'ArrayList li�e � l'aquarium
					}
	
					load.close(); // fermeture des deux scanners
					load2.close();

				}
				/* � revoir, pour ajout manuel de poissons
				
				if(aquarium.getPoissons().size()< 6) {
					System.out.println("Souhaitez vous acheter un poisson ? (O) pour oui");
					
						choice = scanner.nextLine().toLowerCase();
						if(choice.equals("o")) {
							aquarium.addPoissonManual();
						}else {
							System.out.println("Tr�s bien...");
						}
				}
				*/
				// boucle de cycle de vie des algues
				for(int k = 0; k < aquarium.getAlgues().size(); k++) {
					aquarium.getAlgues().get(k).setPv(1);
					aquarium.getAlgues().get(k).advanceAge();
					if(aquarium.getAlgues().size() > 0) {
						aquarium.getAlgues().get(k).reproduce();
					}	
				}
				// boucle de cycle de vie des poissons
				for(int i = 0; i < aquarium.getPoissons().size(); i++) {
					aquarium.getPoissons().get(i).manger();
					aquarium.getPoissons().get(i).advanceAge();
					
					aquarium.getPoissons().get(i).setGender();
					if(aquarium.getPoissons().get(i).getPv() > 5 && aquarium.getPoissons().size() > 1) { 
						aquarium.getPoissons().get(i).reproduce();
					}
				}
				// boucle de cycle de reproduction des poissons
				for (int j = 0; j < aquarium.getPoissons().size(); j++) {
					aquarium.getPoissons().get(j).setReproNextTurn();
					if(!aquarium.getPoissons().get(j).alive()) {
						System.out.println(aquarium.getPoissons().get(j).getName() + (aquarium.getPoissons().get(j).getGender()? " est morte..." : " est mort..."));
						aquarium.getPoissons().remove(aquarium.getPoissons().get(j));
						j--;
					}
					
					if(tours == 35) { // "sauvegarde" du tour 35 dans un fichier .txt
						FileWriter writer = new FileWriter("C:\\Users\\amaurice\\Documents\\Git\\ABCDEV_2306_MA\\Objet\\Java\\src\\javaquarium\\saveTurn35.txt");
						writer.write("=== Tour " + tours + ": ===\n" + String.valueOf(aquarium.state()));
						writer.close();
					}
				}

				traceLog += "=== Tour " + tours + ": ===\n" + String.valueOf(aquarium.state() + "\n"); // "sauvegarde" de chaque tour dans une variable
				System.out.println("===Tour " + tours+"===");
				tours++;
				state = aquarium.state();
				System.out.println(state);
				
			}
			FileWriter log = new FileWriter("C:\\Users\\amaurice\\Documents\\Git\\ABCDEV_2306_MA\\Objet\\Java\\src\\javaquarium\\log.txt");
			log.write(traceLog); // puis "�cris" dans un log.txt
			log.close();
			scanner.close();	
	}
}