package robot;

import robot.Robot.Mouvement;

public class App {

	public static void main(String[] args) {
		
		//variables de test
		boolean test1, test2, test3, test4, test5, test6, test7, test8, test9, test10, test11, test12, testMixer, testMixer2, testMixer3;
		int cylonPosX, cylonPosY;
				
		Robot cylon = new Robot("Cylon", "WarBot", 200, true, true, false, 10, 0); //objet Robot construit avec param�tres
		cylon.setPower();
		test1 = cylon.setMouvement(Mouvement.AVANT); //renvoit true car le cylon est activ� et mofidie ses attributs de position
		cylon.setMouvement(Mouvement.ARRIERE);
		test2 = cylon.setMouvement(Mouvement.GAUCHE);
		cylon.setMouvement(Mouvement.AVANT); // test si le cylon avance bien sur le bon axe suite � sa rotation � gauche
		test3 = cylon.setMouvement(Mouvement.DROITE);
		cylon.setMouvement(Mouvement.AVANT); // m�me test que pr�c�dement, cette fois apr�s rotation � droite  
		cylonPosX = cylon.getPosX(); // retour des positions du cylon sur les axes x et y pour v�rifier qu'il se d�place sur les bons axes suite aux rotations
		cylonPosY = cylon.getPosY();
		test4 = cylon.takeObject(); // renvoit false, pas de scan pr�alable
		cylon.scan();
		test5 = cylon.takeObject(); // renvoit true, scan effectu� juste avant
		test6 = cylon.takeObject(); // renvoit false, le scan a �t� r�initialis� � false
		cylon.scan();
		test7 = cylon.takeObject();
		test8 = cylon.dropObject(); // l�che l'objet tenu, renvoit true
		test9 = cylon.setMouvement(Mouvement.DETRUIRE); // le cylon peut effectuer l'action, renvoit true
		cylon.setPower();
		
		Robot r2d2 = new Robot("R2D2", "Astromech", 120, false, true, false, 15, 15); //objet Robot construit avec param�tres
		test10 = r2d2.setMouvement(Mouvement.AVANT); // renvoit false, R2D2 n'est pas activ�, donc ne se d�place pas
		r2d2.setPower();
		test11 = r2d2.setMouvement(Mouvement.DETRUIRE); // renvoit true car le mouvement est valide, mais pas le bon type de robot pour la m�thode associ�e
		
		Robot c3po = new Robot(); // objet Robot andro�de construit par d�faut
		test12 = c3po.setMouvement(Mouvement.AVANT); // renvoit true car activ� dans le constructeur par d�faut
		
		Robot mixer = new Robot("Mixeur", "Robot de cuisine", 50, false, false, true, 10, 10); // cr�ation d'un robot de cuisine, non mobile
		testMixer = mixer.setMouvement(Mouvement.AVANT); // renvoit true car la commande est valide, mais ne d�place pas le robot car non mobile
		testMixer2 = mixer.setMouvement(Mouvement.AGIR); // renvoit true, action de base du robot, � modeler selon le type
		mixer.scan(); // parce que pourquoi pas, un mixer avec scan d'ingr�dients par exemple
		testMixer3 = mixer.takeObject(); // renverra false, un mixeur ne peut saisir un objet
		
	}

}
