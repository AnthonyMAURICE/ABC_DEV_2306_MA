package fonction7;

import java.util.Random;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		boolean encore = false; // initialis�e au d�but car condition de la premi�re boucle "do while"
		
		Scanner scanner = new Scanner(System.in);
			do {
				int nombreChoisi, nombre, essais = 0, nombreOrdi = 0, upFork = 100, downFork = 1; // variables d�clar�es et initilis�es ici
				int forkUp, forkDown, forkReduce = 20; // variables pour la fourchette du joueur
				String rejouer;																	// car besoin de les r�initialiser � chaque 
				boolean trouve = false, victoire = false;										// d�but de partie
				encore = false;																	
				nombre = aleatoire(1, 100);													// g�n�r� al�atoirement
				Random random = new Random();
				do {
					System.out.println("Entrez un nombre, tentez de trouver le bon.");
					nombreChoisi = scanner.nextInt();
					
					if(nombreChoisi == nombre) { // passe les deux bool�ens � true en cas de victoire
						victoire = true;
						trouve = true;
					}else { // sinon, indication de positionnement et au tour de l'ordinateur "d'essayer"
						
						if(nombreChoisi < nombre) {
							System.out.println("Vous �tes en dessous.");
						}else {
							System.out.println("Vous �tes au dessus.");
						}
						forkUp = nombre + random.nextInt(forkReduce); // deux calculs de d�finition de la fourchette du joueur (fourchette haute et fourchette basse) � chaque essai infructueux
						forkDown = nombre - random.nextInt(forkReduce);
						if(forkDown < 0) { // simple condition pour �viter les fourchettes hors param�tres
							forkDown = 0;
						}else if (forkUp > 100) {
							forkUp = 100;
						}
						System.out.println("Entre " + forkDown + " et " + forkUp); // affiche la fourchette basse puis haute
						nombreOrdi = aleatoire(downFork, upFork);  // arguments "d'affinage" du r�sultat de l'ordinateur, commencent � 1 et 100 par d�faut
						System.out.println("L'odinateur tente : " + nombreOrdi);
						
						if(nombreOrdi == nombre) { // quand l'ordinateur trouve, le jeu s'arr�te mais le bool�en de victoire reste � false
							trouve = true;
						}
						else if(nombreOrdi > nombre) {					// condition qui permet "d'affiner" le r�sultat de l'ordinateur
							upFork = nombreOrdi;					// avec des fourchettes hautes et basses bas�es sur ses coups pr�c�dents
						}else{
							downFork = nombreOrdi;
						}

					}
					essais++;
					forkReduce -= 4;// la variable d'amplitude de la fourchette diminue � chaque tour (avec 20 au d�part)
				}while(!trouve);
				
				if(victoire) {
					System.out.println("Bravo, vous avez gagn� en " + essais + " coup(s)");
				}else {
					System.out.println("D�sol�, SkyNet vous a battu");
				}
			
				System.out.println("Une autre partie ? (O pour oui)");
				rejouer = scanner.next().toLowerCase();
				
				if(rejouer.equals("o")) {
					encore = true;
				}else {
					encore = false;
				}
				
			}while(encore);
		
			System.out.println("Merci d'avoir jou�.");
		
		scanner.close();

	}
	
	private static int aleatoire(int a, int b) {
		Random rand = new Random();
		int number = rand.nextInt(a, b);
		return number;
	}

}