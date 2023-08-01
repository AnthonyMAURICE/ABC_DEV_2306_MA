package fonction7;

import java.util.Random;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		boolean encore = false; // initialisée au début car condition de la première boucle "do while"
		
		Scanner scanner = new Scanner(System.in);
			do {
				int nombreChoisi, nombre, essais = 0, nombreOrdi = 0, upFork = 100, downFork = 1; // variables déclarées et initilisées ici
				int forkUp, forkDown, forkReduce = 20; // variables pour la fourchette du joueur
				String rejouer;																	// car besoin de les réinitialiser à chaque 
				boolean trouve = false, victoire = false;										// début de partie
				encore = false;																	
				nombre = aleatoire(1, 100);													// généré aléatoirement
				Random random = new Random();
				do {
					System.out.println("Entrez un nombre, tentez de trouver le bon.");
					nombreChoisi = scanner.nextInt();
					
					if(nombreChoisi == nombre) { // passe les deux booléens à true en cas de victoire
						victoire = true;
						trouve = true;
					}else { // sinon, indication de positionnement et au tour de l'ordinateur "d'essayer"
						
						if(nombreChoisi < nombre) {
							System.out.println("Vous êtes en dessous.");
						}else {
							System.out.println("Vous êtes au dessus.");
						}
						forkUp = nombre + random.nextInt(forkReduce); // deux calculs de définition de la fourchette du joueur (fourchette haute et fourchette basse) à  chaque essai infructueux
						forkDown = nombre - random.nextInt(forkReduce);
						if(forkDown < 0) { // simple condition pour éviter les fourchettes hors paramètres
							forkDown = 0;
						}else if (forkUp > 100) {
							forkUp = 100;
						}
						System.out.println("Entre " + forkDown + " et " + forkUp); // affiche la fourchette basse puis haute
						nombreOrdi = aleatoire(downFork, upFork);  // arguments "d'affinage" du résultat de l'ordinateur, commencent à 1 et 100 par défaut
						System.out.println("L'odinateur tente : " + nombreOrdi);
						
						if(nombreOrdi == nombre) { // quand l'ordinateur trouve, le jeu s'arrête mais le booléen de victoire reste à false
							trouve = true;
						}
						else if(nombreOrdi > nombre) {					// condition qui permet "d'affiner" le résultat de l'ordinateur
							upFork = nombreOrdi;					// avec des fourchettes hautes et basses basées sur ses coups précédents
						}else{
							downFork = nombreOrdi;
						}

					}
					essais++;
					forkReduce -= 4;// la variable d'amplitude de la fourchette diminue à chaque tour (avec 20 au départ)
				}while(!trouve);
				
				if(victoire) {
					System.out.println("Bravo, vous avez gagné en " + essais + " coup(s)");
				}else {
					System.out.println("Désolé, SkyNet vous a battu");
				}
			
				System.out.println("Une autre partie ? (O pour oui)");
				rejouer = scanner.next().toLowerCase();
				
				if(rejouer.equals("o")) {
					encore = true;
				}else {
					encore = false;
				}
				
			}while(encore);
		
			System.out.println("Merci d'avoir joué.");
		
		scanner.close();

	}
	
	private static int aleatoire(int a, int b) {
		Random rand = new Random();
		int number = rand.nextInt(a, b);
		return number;
	}

}