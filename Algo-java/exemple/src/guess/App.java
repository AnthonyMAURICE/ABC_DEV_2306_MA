package guess;
import java.util.Random;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number, guess, essais, remaining = 5, forkUp, forkDown, forkReduce = 10;
		String error;
		boolean guessed = false;
		Random rand = new Random();
		essais = 0;
		Scanner scanner = new Scanner(System.in);
			number = (int)(Math.random()*101);// sélection d'un nombre aléatoire entre 1 et 100 
			while (guessed == false && remaining > 0)  {; //boucle tant que l booléen est faux et que le nombre de coups restants est supérieur à  0
				essais++; // incrémentation de la variable qui traque le nombre d'essais
				System.out.println("Devinez le chiffre mystere entre 0 et 100 (vous avez "+ remaining +" coups pour reussir)");
				if(scanner.hasNextInt()) { // contrôle que la saisie est bien un nombre
					guess = scanner.nextInt(); // nombre proposé par le joueur
					if (guess == number) {
						System.out.println("Vous avez gagne !");
						guessed = true; // le booléen passe à  true si le nombre est trouvé
					}else { // sinon la fourchette est donnée
						if (guess < number){
							System.out.print("Vous etes en dessous... ");
						}else {
							System.out.print("Vous etes au dessus... ");	
						}
						forkUp = number + rand.nextInt(forkReduce); // deux calculs de définition de la fourchette (fourchette haute et fourchette basse) à  chaque essai infructueux
						forkDown = number - rand.nextInt(forkReduce);
						if(forkDown < 0) { // simple condition pour éviter les fourchettes hors paramètres
							forkDown = 0;
						}else if (forkUp > 100) {
							forkUp = 100;
						}
						
						System.out.println("Entre " + forkDown + " et " + forkUp); // affiche la fourchette basse puis haute
					}
				}else { // sinon, si c'est une chaîne de caractères, passe dans le "else"
					error = scanner.next();
					System.out.println("Vous avez entré : " + error + ". Saisie incorrecte. Vous perdez ce tour !");
				}
				remaining--; // le nombre de coups restants diminue de 1 à  chaque passage dans la boucle (avec 5 au départ)
				forkReduce -= 2;// la variable d'amplitude de la fourchette diminue elle aussi (avec 10 au départ)
			}
			if(guessed) { //condition de fin
				System.out.println("Bravo ! vous avez reussi en " + essais + " essais !");
			}else {//avec guessed à  false si l'utilisateur n'a pas trouvé au terme des 5 coups
				System.out.println("Vous n'avez plus de coups, vous avez perdu...");
			}
		scanner.close();
	}
}