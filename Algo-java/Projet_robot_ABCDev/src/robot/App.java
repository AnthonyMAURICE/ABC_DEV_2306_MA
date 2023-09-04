package robot;

import robot.Robot.Mouvement;

public class App {

	public static void main(String[] args) {
		
		//bool�ens de test
		boolean test1, test2, test3, test4, test5, test6, test7, test8, test9, test10, test11;
		int posX, posY;
				
		Robot cylon = new Robot("Cylon", "WarBot", 200, true, false, 10, 0); //objet Robot construit avec param�tres
		cylon.setPower();
		test1 = cylon.setMouvement(Mouvement.AVANT); //renvoient true jusque test7, car le cylon est activ� 
		test2 = cylon.setMouvement(Mouvement.GAUCHE);
		test3 = cylon.setMouvement(Mouvement.DROITE);
		posX = cylon.getPosX();
		posY = cylon.getPosY();
		test4 = cylon.takeObject(); // renvoit false, pas de scan pr�alable
		cylon.scan();
		test5 = cylon.takeObject(); // renvoit true, scan effectu� juste avant
		test6 = cylon.takeObject(); // renvoit false, un objet est d�j� port� par le robot
		test7 = cylon.dropObject();
		test8 = cylon.setMouvement(Mouvement.DETRUIRE); // le cylon peut d�truire l'humanit�, renvoit true
		cylon.setPower(); 
		Robot r2d2 = new Robot("R2D2", "Astromech", 120, false, false, 15, 15); //objet Robot construit avec param�tres
		test9 = r2d2.setMouvement(Mouvement.AVANT); // renvoit false, R2D2 n'est pas activ�, donc ne se d�place pas
		Robot c3po = new Robot(); // objet Robot andro�de construit par d�faut
		test10 = c3po.setMouvement(Mouvement.AVANT); // renvoit true car activ� par d�faut
		test11 = r2d2.setMouvement(Mouvement.DETRUIRE); // renvoit faux, pas le bon type de robot, R2D2 ne d�truit pas l'humanit�, lui...
	}

}
