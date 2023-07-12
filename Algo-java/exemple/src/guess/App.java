package guess;
import java.util.Random;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number, guess, essais, remaining = 5;
		boolean guessed = false;
		Random rand = new Random();
		essais = 0;
		Scanner scanner = new Scanner(System.in);
		number = (int)(Math.random()*101);
		while (guessed == false && remaining > 0)  {;
			essais++;
			System.out.println("Devinez le chiffre mystere entre 0 et 100 (vous avez "+ remaining +" coups pour reussir)");
			guess = scanner.nextInt();
			if (guess == number) {
				System.out.println("Vous avez gagne !!!");
				guessed = true;
			}else if (guess < number){
				System.out.println("Vous etes en dessous...");
				System.out.println("Entre " + (number-rand.nextInt(10 - 1)) + " et " + (number+rand.nextInt(10 + 1)));
			}else {
				System.out.println("Vous etes au dessus...");
				System.out.println("Entre " + (number-rand.nextInt(10 - 1)) + " et " + (number+rand.nextInt(10 + 1)));
			}
			remaining--;

		}
		if(guessed == true) {
			System.out.println("Bravo ! vous avez reussi en " + essais + " essais !");
		}else {
			System.out.println("Vous n'avez plus de coups, vous avez perdu...");
		}
		scanner.close();
	}
}
