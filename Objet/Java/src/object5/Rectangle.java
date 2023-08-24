package object5;

public class Rectangle {
	private double longueur, largeur;
	
	public Rectangle(double _longueur, double _largeur) {
		longueur = _longueur;
		largeur = _largeur;
	}
	
	public double surface(double _long, double _larg) {
		return _long * _larg;
	}
	
	public double perimetre(double _long, double _larg) {
		return (_long * 2) + (_larg * 2);
	}
	
	public void afficher() {
		System.out.println("La surface du rectangle de longueur " + this.longueur + " et de largueur " + this.largeur + " est : " + this.surface(longueur, largeur));
		System.out.println("Et son périmètre : " + this.perimetre(longueur, largeur));
	}
}
