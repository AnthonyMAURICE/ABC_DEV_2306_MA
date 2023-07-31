package fonction7;

import java.util.Random;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		boolean encore = false, trouve = false, victoire = false;
		
		Scanner scanner = new Scanner(System.in);
			do {
				int nombreChoisi, nombre, essais = 0, nombreOrdi = 0, upFork = 100, downFork = 1; // variables d�clar�es et initilis�es ici
				String rejouer;																	// car besoin de les r�initialiser � chaque 
				encore = false;																	// d�but de partie pour la nombre de l'ordinateur
				nombre = fourchette(1, 100);													// g�n�r� al�atoirement
				
				do {
					System.out.println(nombre);
					System.out.println("Entrez un nombre, tentez de trouver le bon.");
					nombreChoisi = scanner.nextInt();
					if(nombreChoisi == nombre) {
						victoire = true;
						trouve = true;
					}else {
						if(nombreChoisi < nombre) {
							System.out.println("Vous �tes en dessous.");
						}else {
							System.out.println("Vous �tes au dessus.");
						}
						nombreOrdi = fourchette(downFork, upFork); // condition qui permet "d'affiner" le r�sultat de l'ordinateur
						if(nombreOrdi > nombre) {					// avec des fourchettes hautes et basses
							upFork = nombreOrdi;
						}else{
							downFork = nombreOrdi;
						}
						
						System.out.println(nombreOrdi);
						if(nombreOrdi == nombre) {
							victoire = false;
							trouve = true;
						}
					}
					essais++;
				}while(!trouve);
				if(victoire) {
					System.out.println("Bravo, vous avez gagn� en " + essais + " coup(s)");
				}else {
					System.out.println("D�sol�, SkyNet vous a battu");
				}
				victoire = false;
				trouve = false;
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
	
	private static int fourchette(int a, int b) {
		int number;
		Random rand = new Random();
		number = rand.nextInt(a, b);
		return number;
	}

}
