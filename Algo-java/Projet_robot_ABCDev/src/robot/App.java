package robot;

import robot.Robot.Mouvement;

public class App {

	public static void main(String[] args) {
		
		//booléens de test
		boolean test1, test2, test3, test4, test5, test6;
		int posX, posY;
				
		Robot cylon = new Robot("Cylon", "WarBot", 200, true, false, 10, 0); //objet Robot construit avec paramètres
		cylon.setPower();
		test1 = cylon.setMouvement(Mouvement.AVANT); //renvoient true jusque test5, car le cylon est activé 
		test2 = cylon.setMouvement(Mouvement.GAUCHE);
		test3 = cylon.setMouvement(Mouvement.DROITE);
		posX = cylon.getPosX();
		posY = cylon.getPosY();
		cylon.setPower(); 
		Robot r2d2 = new Robot("R2D2", "Astromech", 120, false, false, 15, 15); //objet Robot construit avec paramètres
		test5 = r2d2.setMouvement(Mouvement.AVANT); // renvoit false, R2D2 n'est pas activé, donc ne se déplace pas
		Robot c3po = new Robot(); // objet Robot androïde construit par défaut
		test6 = c3po.setMouvement(Mouvement.AVANT); // renvoit true car activé par défaut
	}

}
