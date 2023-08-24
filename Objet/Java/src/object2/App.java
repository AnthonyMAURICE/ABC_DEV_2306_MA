package object2;

public class App {

	public static void main(String[] args) {
		PorteDeGarage maPorte = new PorteDeGarage(true, true, 0); 
		
		boolean test1 = maPorte.deverrouillerPorte();
		boolean test2 = maPorte.ouvrir(50);
		boolean test3 = maPorte.fermer(20);
		boolean test4 = maPorte.ouvrirEntierement();
		boolean test7 = maPorte.ouvrirEntierement(); // renvoit false car déjà ouverte au maximum
		boolean test5 = maPorte.fermerEntierement();
		boolean test6 = maPorte.verrouillerPorte();

	}

}
