package fonction7;

import java.util.Random;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		boolean encore = false; 
		
		Scanner scanner = new Scanner(System.in);
			do {
				int nombreChoisi, nombre, essais = 0, nombreOrdi = 0, upFork = 100, downFork = 1; // variables déclarées et initilisées ici
				String rejouer;																	// car besoin de les réinitialiser à chaque 
				boolean trouve = false, victoire = false;										// début de partie
				encore = false;																	
				nombre = fourchette(1, 100);													// généré aléatoirement
				
				do {
					System.out.println(nombre);
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
						nombreOrdi = fourchette(downFork, upFork);  // arguments "d'affinage" du résultat de l'ordinateur
						
						if(nombreOrdi > nombre) {					// condition qui permet "d'affiner" le résultat de l'ordinateur
							upFork = nombreOrdi;					// avec des fourchettes hautes et basses
						}else{
							downFork = nombreOrdi;
						}
						
						System.out.println(nombreOrdi);
						
						if(nombreOrdi == nombre) { // quand l'ordinateur trouve, le jeu s'arrête mais le booléen de victoire reste à false
							trouve = true;
						}
						
					}
					essais++;
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
	
	private static int fourchette(int a, int b) {
		int number;
		Random rand = new Random();
		number = rand.nextInt(a, b);
		return number;
	}

}
