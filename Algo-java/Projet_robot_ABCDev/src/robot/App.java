package robot;

import robot.Robot.Mouvement;

public class App {

	public static void main(String[] args) {
		
		//booléens de test
		String type;
		boolean test1, test2, test3, test4, test5, test6, test7, test8, test9, test10, test11, testLeft, testRight;
		int posX, posY;
				
		Robot cylon = new Robot("Cylon", "WarBot", 200, true, false, 10, 0); //objet Robot construit avec paramètres
		type = cylon.getType();
		cylon.setPower();
		test1 = cylon.setMouvement(Mouvement.AVANT); //renvoient true jusque test3, car le cylon est activé 
		cylon.setMouvement(Mouvement.ARRIERE);
		test2 = cylon.setMouvement(Mouvement.GAUCHE);
		testLeft = cylon.setMouvement(Mouvement.AVANT); // test si le cylon avance bien sur le bon axe suite à sa première rotation
		test3 = cylon.setMouvement(Mouvement.DROITE);
		cylon.setMouvement(Mouvement.DROITE);
		cylon.setMouvement(Mouvement.ARRIERE);
		testRight = cylon.setMouvement(Mouvement.AVANT); // même test que précédement, cette fois après rotation à droite  
		posX = cylon.getPosX(); // retour des positions du cylon sur les axes x et y
		posY = cylon.getPosY();
		test4 = cylon.takeObject(); // renvoit false, pas de scan préalable
		cylon.scan();
		test5 = cylon.takeObject(); // renvoit true, scan effectué juste avant
		test6 = cylon.takeObject(); // renvoit false, un objet est déjà porté par le robot
		test7 = cylon.dropObject(); // lâche l'objet tenu, renvoit true
		test8 = cylon.setMouvement(Mouvement.DETRUIRE); // le cylon peut détruire l'humanité, renvoit true
		cylon.setPower();
		
		Robot r2d2 = new Robot("R2D2", "Astromech", 120, false, false, 15, 15); //objet Robot construit avec paramètres
		test9 = r2d2.setMouvement(Mouvement.AVANT); // renvoit false, R2D2 n'est pas activé, donc ne se déplace pas
		test10 = r2d2.setMouvement(Mouvement.DETRUIRE); // renvoit false, pas le bon type de robot
		Robot c3po = new Robot(); // objet Robot androïde construit par défaut
		test11 = c3po.setMouvement(Mouvement.AVANT); // renvoit true car activé dans le constructeur par défaut
		
	}

}
