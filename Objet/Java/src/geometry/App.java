package geometry;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		double rayon, dx, dy;
		
		

		Scanner scanner = new Scanner(System.in);
			System.out.println("Quel rayon pour votre cercle ?");
			rayon = scanner.nextDouble();
			Cercle cercle = new Cercle(rayon);
			cercle.afficher(rayon);
			
			System.out.println("Définissez l'abscisse du point de test : ");
			dx = scanner.nextDouble();
			System.out.println("Pareil pour l'ordonnée : ");
			dy = scanner.nextDouble();
			Point testPoint = new Point(dx, dy);
			
			cercle.testAppartenance(testPoint.abscisse, testPoint.ordonnee, rayon);
		scanner.close();
	}

}
