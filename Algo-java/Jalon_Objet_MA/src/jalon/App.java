package jalon;

public class App {

	public static void main(String[] args) {
		Article article1 = new Article(42, "Produit 1", 214.5);
		Article article2 = new Article(314, "Produit 2", 108);
		Article articleTemoin = new Article();
		
		System.out.println("Prix TTC de l'article 1 : " + article1.calculerPrixTTC() + ", son prix hors taxes �tait de : " + article1.getPrixHT());
		System.out.println("Prix TTC de l'article 2 : " + article2.calculerPrixTTC() + ", son prix hors taxes �tait de : " + article2.getPrixHT());
		System.out.println("Prix TTC de l'article t�moin (constructeur par d�faut) : " + articleTemoin.calculerPrixTTC() + ", son prix hors taxes �tait de : " + articleTemoin.getPrixHT());
		
		
		
		article2.afficherArticle();
	}

}
