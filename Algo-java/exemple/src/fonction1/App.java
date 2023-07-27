package fonction1;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		double nombre1, nombre2;
		
		Scanner scanner = new Scanner(System.in);
			System.out.println("Entrez le premier nombre : ");
			nombre1 = scanner.nextDouble();
			System.out.println("Entrez le second nombre : ");
			nombre2 = scanner.nextDouble();
		
			System.out.println("La moyenne de " + nombre1 + " et " + nombre2 + " est : " + moyenne(nombre1, nombre2));
		scanner.close();
	}
	
	private static double moyenne(double a, double b) {
		double resultat = (a + b) / 2;
		return resultat;
		
	}
	

}
