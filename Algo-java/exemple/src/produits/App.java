package produits;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		int number1, number2;
		
		Scanner scanner = new Scanner(System.in);
			System.out.println("Entrez le premier nombre : ");
			number1 = scanner.nextInt();
			System.out.println("Entrez le second nombre : ");
			number2 = scanner.nextInt();
			
			if(number1 < 0 ^ number2 < 0) {
				System.out.println("Le produit de " + number1 + " et " + number2 + " sera negatif");
			}else if(number1 == 0 || number2 == 0) {
				System.out.println("Le produit de " + number1 + " et " + number2 + " sera 0");
			}else {
				System.out.println("Le produit de " + number1 + " et " + number2 + " sera positif");
			}
	}

}
