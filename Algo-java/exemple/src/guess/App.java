package guess;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number, guess, essais;
		boolean guessed = false;
		essais = 0;
		Scanner scanner = new Scanner(System.in);
		number = (int)(Math.random()*101);
		while (guessed == false) {;
			essais++;
			System.out.println("Devinez le chiffre mystere entre 0 et 100");
			guess = scanner.nextInt();
			if (guess == number) {
				System.out.println("Vous avez gagne !!!");
				guessed = true;
			}else if (guess < number){
				System.out.println("Vous etes en dessous...");
				
			}else {
				System.out.println("Vous etes au dessus...");
			}
		}
		System.out.println("Bravo ! vous avez reussi en " + essais + " essais !");
		scanner.close();
	}
}
