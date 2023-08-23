package java_object1;


public class Bottle {
	final double capaciteEnL;
	double contenanceEnL;
	boolean estOuverte;
	String nom;
	
	public Bottle(){
		capaciteEnL = 1.5;
		contenanceEnL = 1.25;
		estOuverte = false;
		nom = "Eau";
	}
	
	public Bottle(double _capaciteEnL, double _contenanceEnL, boolean _estOuverte, String _nom) {
		this.capaciteEnL = _capaciteEnL;
		this.contenanceEnL = _contenanceEnL;
		this.estOuverte = _estOuverte;
		this.nom = _nom;
	}
	
	public boolean ouvrir(){
		if(!this.estOuverte) {
			this.estOuverte = true;	
			return true;
		}	else {
			return false;
		}
	}
	
	public boolean fermer(){
		if(this.estOuverte) {
			this.estOuverte = false;	
			return true;
		}	else {
			return false;
		}
	}
	
	public boolean remplirTout(){
		if (this.estOuverte) {
			this.contenanceEnL = this.capaciteEnL;
			return true;
		}else {
			System.out.println("Ouvrez la bouteille avant !");
			return false;
		}
	}
	
	public boolean remplir(double _quantiteEnL){
		if (estOuverte) {
			if((this.contenanceEnL + _quantiteEnL) < this.capaciteEnL) {
				this.contenanceEnL += _quantiteEnL;
				return true;
			}else {
				System.out.println("Ça va déborder...");
				return false;
			}
		}else {
			System.out.println("Ouvrez la bouteille avant !");
			return false;
		}
	}
	
	public boolean viderTout() {
		if (this.estOuverte) {
			this.contenanceEnL = 0;
			return true;
		}else {
			System.out.println("Ouvrez la bouteille avant !");
			return false;
		}
	}
	
	public boolean vider(double _quantiteEnL) {
		if (this.estOuverte) {
			if((this.contenanceEnL - _quantiteEnL) >= 0) {
				this.contenanceEnL -= _quantiteEnL;
				return true;
			}else {
				System.out.println("Vous briserez deux ou trois lois de la physique à vider quelque chose de déjà vide...");
				return false;
			}
		}else {
			System.out.println("Ouvrez la bouteille avant !");
			return false;
		}
	}
}
