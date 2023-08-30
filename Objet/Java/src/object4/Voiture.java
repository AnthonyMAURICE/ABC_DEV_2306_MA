package object4;

public class Voiture {
	private String marque;
	private double prix;
	
	public Voiture() {
		marque = "Marque"; // je sais, pas inspiré...
		prix = 10000;
	}
	
	public String getMarque() {
		return this.marque;
	}
	
	public double getPrix() {
		return this.prix;
	}
	
	public void setMarque(String pMarque) {
		this.marque = pMarque;
	}
	
	public void setPrix(double pPrix) {
		this.prix = pPrix;
	}
	
	public void afficher() {
		System.out.println("Marque : " + this.marque + ", prix : " + this.prix);
	}
}
