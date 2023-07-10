package zero;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		int number;
		
		Scanner scanner = new Scanner(System.in);
			System.out.println("Entrez un nombre : ");
				number = scanner.nextInt();
				
				if (number > 0) {
					System.out.println("Le nombre est positif");
				}else if (number < 0) {
					System.out.println("Le nombre est negatif");
				}else {
					System.out.println("Le nombre vaut 0");
				}
				
				
		scanner.close();
	}

}
