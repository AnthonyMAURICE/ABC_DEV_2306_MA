package geometry;

import java.util.Scanner;

public class Cercle {
	double rayon;
	Point centre = new Point(3, 3);
	double dx, dy, distancePoint;
	
	public double perimetre(double _rayon) {
		
		return 2* Math.PI *_rayon;
	}
	
	public double aire(double _rayon) {
		
		return Math.PI * Math.pow(_rayon, 2);
	}
	
	public void testAppartenance(double _rayon) {
		Scanner scanner = new Scanner(System.in);
			System.out.println("Définissez l'abscisse du point de test : ");
			dx = scanner.nextDouble();
			System.out.println("Pareil pour l'ordonnée : ");
			dy = scanner.nextDouble();
		scanner.close();
		distancePoint = Math.sqrt(Math.pow(dx - centre.abscisse, 2) + Math.pow(dy - centre.ordonnee, 2));
		if(distancePoint > _rayon) {
			System.out.println("Il n'appartient pas au cercle");
		}else {
			System.out.println("Il appartient au cercle");
		}
	}
	
	public void afficher(double _rayon) {
		System.out.println("Le périmètre du cercle est de " + Math.round(this.perimetre(_rayon)*100.0)/100.0);
		System.out.println("La surface du cercle est de " + Math.round(this.aire(_rayon)*100.0)/100.0);
	}
}
