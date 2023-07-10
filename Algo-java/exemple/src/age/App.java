package age;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		int age;
		
		Scanner scanner = new Scanner(System.in);
			System.out.println("Entrez votre age : ");
			age = scanner.nextInt();
			if (age < 6) {
				System.out.println("Vous etes trop jeune");
			}else if (age >= 6 && age <8) {
				System.out.println("Vous etes Poussin");
			}else if (age >= 8 && age <10) {
				System.out.println("Vous etes Pupille");
			}else if (age >= 10 && age <12) {
				System.out.println("Vous etes Minime");
			}else if (age >= 12 && age <18) {
				System.out.println("Vous etes Cadet");
			}else {
				System.out.println("Vous etes adulte");
			}
		scanner.close();
	}

}
