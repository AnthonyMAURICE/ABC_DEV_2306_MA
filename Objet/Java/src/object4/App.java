package object4;

public class App {

	public static void main(String[] args) {
		Voiture maVoiture = new Voiture();
		
		maVoiture.afficher();
		maVoiture.setMarque("QuiRoule");// encore moins inspiré...
		maVoiture.setPrix(75000);
		maVoiture.afficher();

	}

}
