package jalon;

public class Article {
	private int reference;
	private String designation;
	private double prixHT;
	private static final double tauxTVA = 20;
	
	public Article() {
		this.reference = 1;
		this.designation = "Produit par défaut";
		this.prixHT = 1;
	}
	
	public Article(int _ref, String _designation, double _prixHT) {
		this.reference = _ref;
		this.designation = _designation;
		this.prixHT = _prixHT;
	}
		
	public double getPrixHT() {
		return this.prixHT;
	}
	
	public double calculerPrixTTC() {
		return (this.prixHT + (this.prixHT * tauxTVA / 100));
	}
	
	public void afficherArticle() {
		System.out.println("Référence de l'article : " +this.reference + ", sa désignation : " + this.designation + ", son prix HT : " + this.prixHT + " et TTC : " + this.calculerPrixTTC());
	}

}
