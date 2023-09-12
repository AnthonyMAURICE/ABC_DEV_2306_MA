package jalon;

public class App {

	public static void main(String[] args) {
		Article article1 = new Article(42, "Produit 1", 214.5);
		Article article2 = new Article(314, "Produit 2", 108);
		
		System.out.println("Prix TTC de l'article : " + article1.calculerPrixTTC() + ", son prix hors taxes était de : " + article1.getPrixHT());
		
		article2.afficherArticle();
	}

}
