package comparaison;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int age;
		
		System.out.println("Entrez votre age : ");
		age = scanner.nextInt();
		
		if (age >= 18) {
			System.out.println("Vous etes donc majeur.");
		}
		else if (age < 0) {
			System.out.println("Vous n'etes pas encore ne(e) !");
		}
		else {
			System.out.println("Vous etes donc mineur.");
		}
		scanner.close();
	}

}
