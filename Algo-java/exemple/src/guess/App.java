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
			number = (int)(Math.random()*101);// s�lection d'un nombre al�atoire entre 1 et 100 
			while (guessed == false && remaining > 0)  {; //boucle tant que l bool�en est faux et que le nombre de coups restants est sup�rieur � 0
				essais++; // incr�mentation de la variable qui traque le nombre d'essais
				System.out.println("Devinez le chiffre mystere entre 0 et 100 (vous avez "+ remaining +" coups pour reussir)");
				if(scanner.hasNextInt()) { // contr�le que la saisie est bien un nombre
					guess = scanner.nextInt(); // nombre propos� par le joueur
					if (guess == number) {
						System.out.println("Vous avez gagne !");
						guessed = true; // le bool�en passe � true si le nombre est trouv�
					}else { // sinon la fourchette est donn�e
						if (guess < number){
							System.out.print("Vous etes en dessous... ");
						}else {
							System.out.print("Vous etes au dessus... ");	
						}
						forkUp = number + rand.nextInt(forkReduce); // deux calculs de d�finition de la fourchette (fourchette haute et fourchette basse) � chaque essai infructueux
						forkDown = number - rand.nextInt(forkReduce);
						if(forkDown < 0) { // simple condition pour �viter les fourchettes hors param�tres
							forkDown = 0;
						}else if (forkUp > 100) {
							forkUp = 100;
						}
						
						System.out.println("Entre " + forkDown + " et " + forkUp); // affiche la fourchette basse puis haute
					}
				}else { // sinon, si c'est une cha�ne de caract�res, passe dans le "else"
					error = scanner.next();
					System.out.println("Vous avez entr� : " + error + ". Saisie incorrecte. Vous perdez ce tour !");
				}
				remaining--; // le nombre de coups restants diminue de 1 � chaque passage dans la boucle (avec 5 au d�part)
				forkReduce -= 2;// la variable d'amplitude de la fourchette diminue elle aussi (avec 10 au d�part)
			}
			if(guessed) { //condition de fin
				System.out.println("Bravo ! vous avez reussi en " + essais + " essais !");
			}else {//avec guessed � false si l'utilisateur n'a pas trouv� au terme des 5 coups
				System.out.println("Vous n'avez plus de coups, vous avez perdu...");
			}
		scanner.close();
	}
}