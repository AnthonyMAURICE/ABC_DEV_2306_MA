package robot;

import robot.Robot.Mouvement;

public class App {

	public static void main(String[] args) {
		
		Robot cylon = new Robot("Cylon", "WarBot", 200, true, true, false, 10, 0); //objet Robot construit avec param�tres
		cylon.setPower();
		boolean test1 = cylon.setMouvement(Mouvement.AVANT); //retourne true car le cylon est activ� et mofidie ses attributs de position
		cylon.setMouvement(Mouvement.ARRIERE);
		boolean test2 = cylon.setMouvement(Mouvement.GAUCHE);
		cylon.setMouvement(Mouvement.AVANT); // test si le cylon avance bien sur le bon axe suite � sa rotation � gauche
		boolean test3 = cylon.setMouvement(Mouvement.DROITE);
		cylon.setMouvement(Mouvement.AVANT); // m�me test que pr�c�dement, cette fois apr�s rotation � droite  
		int cylonPosX = cylon.getPosX(); // retour des positions du cylon sur les axes x et y pour v�rifier qu'il se d�place sur les bons axes suite aux rotations
		int cylonPosY = cylon.getPosY();
		boolean test4 = cylon.takeObject(); // retourne false, pas de scan pr�alable
		cylon.scan();
		boolean test5 = cylon.takeObject(); // retourne true, scan effectu� juste avant
		boolean test6 = cylon.takeObject(); // retourne false, le scan a �t� r�initialis� � false
		cylon.scan();
		boolean test7 = cylon.takeObject(); // retourne false, le robot tient d�j� un objet
		boolean test8 = cylon.dropObject(); // l�che l'objet tenu, retourne true
		boolean test9 = cylon.setMouvement(Mouvement.DETRUIRE); // le cylon peut effectuer l'action, retourne true
		cylon.setPower();
		
		Robot r2d2 = new Robot("R2D2", "Astromech", 120, false, true, false, 15, 15); //objet Robot construit avec param�tres
		boolean test10 = r2d2.setMouvement(Mouvement.AVANT); // retourne false, R2D2 n'est pas activ�, donc ne se d�place pas
		r2d2.setPower();
		boolean test11 = r2d2.setMouvement(Mouvement.DETRUIRE); // retourne true car le mouvement est valide, mais pas le bon type de robot pour la m�thode associ�e
		
		Robot c3po = new Robot(); // objet Robot andro�de construit par d�faut
		boolean test12 = c3po.setMouvement(Mouvement.AVANT); // retourne true car activ� dans le constructeur par d�faut
		
		Robot mixer = new Robot("Mixeur", "Robot de cuisine", 50, false, false, true, 10, 10); // cr�ation d'un robot de cuisine, non mobile
		boolean testMixer = mixer.setMouvement(Mouvement.AVANT); // retourne true car la commande est valide, mais ne d�place pas le robot car non mobile
		boolean testMixer2 = mixer.setMouvement(Mouvement.AGIR); // retourne true, action de base du robot, � modeler selon le type
		mixer.scan(); // parce que pourquoi pas, un mixer avec scan d'ingr�dients par exemple
		boolean testMixer3 = mixer.takeObject(); // renverra false, un mixeur ne peut saisir un objet
		
	}

}
