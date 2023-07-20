package jalon;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		int nombre, multiplicateur, resultat;
		String reload = "o"; // initialisée à "o" pour qu'il y ait un nouveau passage dans la boucle en cas de saisie hors paramètes
		
		Scanner scanner = new Scanner(System.in);
			
			while(reload.equals("o")){ // boucle tant que reload est égal à "o"
				System.out.println("Saisir un nombre entre 1 et 10");
				nombre = scanner.nextInt();
				if(nombre < 10 && nombre > 1) { // contrôle si la saisie est dans les paramètres demandés
					for(multiplicateur = 0; multiplicateur <= 10; multiplicateur++) { // boucle for qui fait le calcul et l'affichage des tables
						resultat = nombre * multiplicateur;
						System.out.println(multiplicateur + " * " + nombre + " = " + resultat);
					}
					System.out.println("Souhaitez-vous afficher une autre table ? Oui(O) ou Non(N)");
					reload = scanner.next().toLowerCase(); // input qui détermine la sortie ou non de la boucle
				}else { // sinon affiche un message d'erreur
					System.out.println("Vous avez saisi un nombre hors parametres, veuillez recommencer.");
				}
			}
		
			System.out.println("Fin du programme");
		scanner.close();
	}

}