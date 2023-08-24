package object3;

public class App {

	public static void main(String[] args) {
		Compte monCompte = new Compte(100);
		
		monCompte.afficher();
		monCompte.deposer(10);
		monCompte.afficher();
		monCompte.retirer(10);
		monCompte.afficher();
	}

}
