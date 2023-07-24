package jalon;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		int nombre, multiplicateur, resultat;
		boolean control = false;
		String charInput;
		String reload = "o"; // initialis�e � "o" pour qu'il y ait un nouveau passage dans la boucle en cas de saisie hors param�tes
		
		Scanner scanner = new Scanner(System.in);
			
			while(reload.equals("o")){ // boucle tant que reload est �gal � "o"
				System.out.println("Saisir un nombre entre 1 et 10");
				if(scanner.hasNextInt()) { // contr�le de saisie, continue si c'est un nombre, sinon passe dans le "else"
					nombre = scanner.nextInt();
					if(nombre <= 10 && nombre >= 1) { // contr�le si la saisie est dans les param�tres demand�s
						for(multiplicateur = 0; multiplicateur <= 10; multiplicateur++) { // boucle for qui fait le calcul et l'affichage des tables
							resultat = nombre * multiplicateur;
							System.out.println(multiplicateur + " * " + nombre + " = " + resultat);
						}
						do { // boucle "do while" pour contr�ler le choix de continuer ou non 
						System.out.println("Souhaitez-vous afficher une autre table ? Oui(O) ou Non(N)");
						reload = scanner.next().toLowerCase(); // input qui d�termine la sortie ou non de la boucle
							if (reload.equals("n") || reload.equals("o")) { // si l'entr�e est conforme, passe � la suite
								if (reload.equals("n")) { // condition en cas de fin de programme
									System.out.println("Fin du programme");
								}
								control = true; // bool�en qui d�termine si la sasie est correcte et passe � "true"
							}else {
								System.out.println("Saisie incorrecte, recommencez.");
								control = false; // sinon reste � "false"
							}
						}while(!control); // boucle tant que la saisie est incorrecte
					}else { // sinon affiche un message d'erreur
						System.out.println("Vous avez saisi un nombre hors param�tres, veuillez recommencer.");
					}
				}else { // r�cup�re la saisie initiale, si ce n'est pas un nombre
					charInput = scanner.next().toLowerCase();
					System.out.println("\"" +charInput + "\" est hors param�tres, veuillez recommencer.");
				}				
			}			
		scanner.close();
	}
}