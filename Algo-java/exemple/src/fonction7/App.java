package fonction7;

import java.util.Random;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		boolean encore; // initialis�e au d�but car condition de la premi�re boucle "do while"
		Scanner scanner = new Scanner(System.in);
			do {
				int forkUp = 100, forkDown = 0; // variables pour la fourchette du joueur
				int nombreChoisi, nombre, essais = 0, nombreOrdi = 0, upFork = 100, downFork = 1; // variables d�clar�es et initilis�es ici
				String rejouer;																	// car besoin de les r�initialiser � chaque 
				boolean trouve = false, victoire = false;										// d�but de partie																
				nombre = aleatoire(1, 100); // g�n�r� al�atoirement
				do {
					System.out.println("Entrez un nombre, tentez de trouver le bon.");
					nombreChoisi = scanner.nextInt();
					// Tour de l'humain(e)
					if(nombreChoisi == nombre) { // passe les deux bool�ens � true en cas de victoire
						victoire = true;
						trouve = true;
					}else { // sinon, indication de positionnement et au tour de l'ordinateur "d'essayer"
						if(nombreChoisi < nombre) {
							System.out.println("Vous �tes en dessous.");
							forkDown = nombreChoisi;
						}else {
							System.out.println("Vous �tes au dessus.");
							forkUp = nombreChoisi;
						}
						System.out.println("Entre " + forkDown + " et " + forkUp); // affiche la fourchette basse puis haute
						
						//Tour de l'ordinateur
						nombreOrdi = aleatoire(downFork, upFork);  // arguments "d'affinage" du r�sultat de l'ordinateur, commencent � 1 et 100 par d�faut
						System.out.println("L'ordinateur tente : " + nombreOrdi);
						
						if(nombreOrdi == nombre) { // quand l'ordinateur trouve, le jeu s'arr�te mais le bool�en de victoire reste � false
							trouve = true;
						}else if(nombreOrdi < nombre) {					// condition qui permet "d'affiner" le r�sultat de l'ordinateur
							downFork = nombreOrdi;					// avec des fourchettes hautes et basses bas�es sur ses coups pr�c�dents
						}else{
							upFork = nombreOrdi;
						}
					}
					essais++;
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