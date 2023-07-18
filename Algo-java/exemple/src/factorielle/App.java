package factorielle;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		int nombre, temp = 1;

		Scanner scanner = new Scanner(System.in);
			System.out.println("Saisissez un nombre, nous calculerons sa factorielle.");
			nombre = scanner.nextInt();
			
			for(int i = 1; i <= nombre; i++) {
				temp *=i;
			}
			
			System.out.println("La factorielle de " + nombre + " donne : " + temp);
		
		scanner.close();

	}

}
