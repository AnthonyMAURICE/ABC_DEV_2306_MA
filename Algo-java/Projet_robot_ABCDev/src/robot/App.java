package robot;

import robot.Robot.Control;

public class App {

	public static void main(String[] args) {
		
		//booléens de test
		boolean test1, test2, test3, test4, test5, test6;
				
		Robot cylon = new Robot("Cylon", "WarBot", 200, true, false, 10, 0); //objet Robot construit avec paramètres
		cylon.setPower();
		test1 = cylon.setControl(Control.AVANT); //renvoient true jusque test5, car le cylon est activé 
		test2 = cylon.setControl(Control.GAUCHE);
		test3 = cylon.setControl(Control.DROITE);
		test4 = cylon.setControl(Control.AGIR);
		Robot r2d2 = new Robot("R2D2", "Astromech", 120, false, false, 15, 15); //objet Robot construit avec paramètres
		test5 = r2d2.setControl(Control.AVANT); // renvoit false, R2D2 n'est pas activé, donc ne se déplace pas
		Robot c3po = new Robot(); // objet Robot androïde construit par défaut
		test6 = c3po.setControl(Control.AVANT); // renvoit true car activé par défaut
	}

}
