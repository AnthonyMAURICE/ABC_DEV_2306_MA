package fonction7;

import java.util.Random;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		boolean encore; // initialisée au début car condition de la première boucle "do while"
		Scanner scanner = new Scanner(System.in);
			do {
				int nombreChoisi, nombre, essais = 0, nombreOrdi = 0, upFork = 100, downFork = 1; // variables déclarées et initilisées ici
				String rejouer;																	// car besoin de les réinitialiser à chaque 
				boolean trouve = false, victoire = false;										// début de partie																
				nombre = aleatoire(downFork, upFork); // généré aléatoirement
				do {
					System.out.println(nombre);
					System.out.println("Entrez un nombre entre "+downFork+ " et " + upFork +", tentez de trouver le bon.");
					nombreChoisi = scanner.nextInt();
					// Tour de l'humain(e)
					trouve = check(nombreChoisi, nombre);
					if(!trouve) {
						if(nombreChoisi < nombre) {
							System.out.println("Vous êtes en dessous.");
							downFork = nombreChoisi;
						}else {
							System.out.println("Vous êtes au dessus.");
							upFork = nombreChoisi;
						}
						nombreOrdi = aleatoire(downFork, upFork);  // arguments "d'affinage" du résultat de l'ordinateur, commencent à 1 et 100 par défaut
						System.out.println("L'ordinateur tente : " +nombreOrdi);
						trouve = check(nombreOrdi, nombre);
						if(nombreOrdi < nombre) {
							downFork = nombreOrdi;
						}else {
							upFork = nombreOrdi;
						}
					}else {
						victoire = true;
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
	
	private static boolean check(int a, int b) {
		boolean checked = false;
		if (a==b) {
			checked = true;
		}
		return checked;
	}
	
	private static int aleatoire(int a, int b) {
		Random rand = new Random();
		int number = rand.nextInt(a, b);
		return number;
	}		
}