package robot;


public class App {

	public static void main(String[] args) {
		boolean test1, test2, test3, test4, test5, test6;
		Robot cylon = new Robot("Cylon", "WarBot", 200, true, false, 10, 0);
		cylon.setPower();
		test1 = cylon.setMouvement("AVANT"); //renvoient true jusque test5, car le cylon est activé 
		test2 = cylon.setMouvement("GAUCHE");
		test3 = cylon.setMouvement("DROITE");
		test4 = cylon.setMouvement("STOP");
		test5 = cylon.setMouvement("AGIR");
		Robot r2d2 = new Robot("R2D2", "Astromech", 120, false, false, 15, 15);
		test6 = r2d2.setMouvement("AVANT"); // renvoit false, R2D2 n'est pas activé, donc ne se déplace pas
	}

}
