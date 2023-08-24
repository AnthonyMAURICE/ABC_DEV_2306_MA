package geometry;

public class Cercle {
	double rayon;
	Point centre = new Point(3, 3);
	double distancePoint;
	
	public double perimetre(double _rayon) {
		
		return 2* Math.PI *_rayon;
	}
	
	public double aire(double _rayon) {
		
		return Math.PI * Math.pow(_rayon, 2);
	}
	
	public void testAppartenance(double _x, double _y, double _rayon) {
		distancePoint = Math.sqrt(Math.pow(_x - centre.abscisse, 2) + Math.pow(_y - centre.ordonnee, 2));
		if(distancePoint > _rayon) {
			System.out.println("Il n'appartient pas au cercle");
		}else {
			System.out.println("Il appartient au cercle");
		}
	}
	
	public void afficher(double _rayon) {
		System.out.println("Le p�rim�tre du cercle est de " + Math.round(this.perimetre(_rayon)*100.0)/100.0);
		System.out.println("La surface du cercle est de " + Math.round(this.aire(_rayon)*100.0)/100.0);
	}
}
