package jalon;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		int nombre, multiplicateur, resultat;
		boolean control = false;
		String charInput;
		String reload = "o"; // initialisée à "o" pour qu'il y ait un nouveau passage dans la boucle en cas de saisie hors paramètes
		
		Scanner scanner = new Scanner(System.in);
			
			while(reload.equals("o")){ // boucle tant que reload est égal à "o"
				System.out.println("Saisir un nombre entre 1 et 10");
				if(scanner.hasNextInt()) { // contrôle de saisie, continue si c'est un nombre, sinon passe dans le "else"
					nombre = scanner.nextInt();
					if(nombre <= 10 && nombre >= 1) { // contrôle si la saisie est dans les paramètres demandés
						for(multiplicateur = 0; multiplicateur <= 10; multiplicateur++) { // boucle for qui fait le calcul et l'affichage des tables
							resultat = nombre * multiplicateur;
							System.out.println(multiplicateur + " * " + nombre + " = " + resultat);
						}
						do { // boucle "do while" pour contrôler le choix de continuer ou non 
						System.out.println("Souhaitez-vous afficher une autre table ? Oui(O) ou Non(N)");
						reload = scanner.next().toLowerCase(); // input qui détermine la sortie ou non de la boucle
							if (reload.equals("n") || reload.equals("o")) { // si l'entrée est conforme, passe à la suite
								if (reload.equals("n")) { // condition en cas de fin de programme
									System.out.println("Fin du programme");
								}
								control = true; // booléen qui détermine si la sasie est correcte et passe à "true"
							}else {
								System.out.println("Saisie incorrecte, recommencez.");
								control = false; // sinon reste à "false"
							}
						}while(!control); // boucle tant que la saisie est incorrecte
					}else { // sinon affiche un message d'erreur
						System.out.println("Vous avez saisi un nombre hors paramètres, veuillez recommencer.");
					}
				}else { // récupère la saisie initiale, si ce n'est pas un nombre
					charInput = scanner.next().toLowerCase();
					System.out.println("\"" +charInput + "\" est hors paramètres, veuillez recommencer.");
				}				
			}			
		scanner.close();
	}
}