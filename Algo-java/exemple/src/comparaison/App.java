package comparaison;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a;
		
		System.out.println("Entrez votre age : ");
		a = scanner.nextInt();
		
		if (a >= 18) {
			System.out.println("Vous etes donc majeur.");
		}
		else if (a < 0) {
			System.out.println("Vous n'etes pas encore ne !");
		}
		else {
			System.out.println("Vous etes donc mineur.");
		}
		scanner.close();
	}

}
