package geometry;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		double rayon, x, y;
		
		Cercle cercle = new Cercle();

		Scanner scanner = new Scanner(System.in);
			System.out.println("Quel rayon pour votre cercle ?");
			rayon = scanner.nextDouble();
			cercle.afficher(rayon);
			cercle.testAppartenance(rayon);
			
			
		scanner.close();
	}

}
