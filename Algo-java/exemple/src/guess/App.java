package guess;
import java.util.Random;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number, guess, essais, remaining = 5, forkUp, forkDown, forkReduce = 10;
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
				}else {
					if (guess < number){
						System.out.println("Vous etes en dessous...");
					}else {
						System.out.println("Vous etes au dessus...");	
					}
					forkUp = number + rand.nextInt(forkReduce);
					forkDown = number - rand.nextInt(forkReduce);
					if(forkDown < 0) {
						forkDown = 0;
					}else if (forkUp > 100) {
						forkUp = 100;
					}
					
					System.out.println("Entre " + forkDown + " et " + forkUp);
				}
				remaining--;
				forkReduce -= 2;	
			}
			if(guessed == true) {
				System.out.println("Bravo ! vous avez reussi en " + essais + " essais !");
			}else {
				System.out.println("Vous n'avez plus de coups, vous avez perdu...");
			}
		scanner.close();
	}
}