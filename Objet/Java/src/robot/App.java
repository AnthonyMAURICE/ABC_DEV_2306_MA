package robot;

import robot.Robot.Mouvement;

public class App {

	public static void main(String[] args) {
		
		Robot cylon = new Robot("Cylon", "WarBot", 200, true, true, false, 10, 0); //objet Robot construit avec param�tres
		cylon.setPower();
		boolean test1 = cylon.setMouvement(Mouvement.AVANT); //retourne true car le cylon est activ� et mofidie ses attributs de position
		cylon.scan();
		cylon.setMouvement(Mouvement.ARRIERE); // repasse this.scan � false, changement de "zone"
		cylon.scan();
		boolean test2 = cylon.setMouvement(Mouvement.GAUCHE); // this.scan reste � true, simple rotation dans la m�me zone, passera � false au prochain ordre (Mouvement.AVANT)
		cylon.setMouvement(Mouvement.AVANT); // test si le cylon avance bien sur le bon axe suite � sa rotation � gauche
		boolean test3 = cylon.setMouvement(Mouvement.DROITE);
		cylon.setMouvement(Mouvement.AVANT); // m�me test que pr�c�dement, cette fois apr�s rotation � droite  
		int cylonPosX = cylon.getPosX(); // retour des positions du cylon sur les axes x et y pour v�rifier qu'il se d�place sur les bons axes suite aux rotations
		int cylonPosY = cylon.getPosY();
		boolean test4 = cylon.takeObject(); // retourne false, pas de scan pr�alable
		cylon.scan();
		boolean test5 = cylon.takeObject(); // retourne true, scan effectu� juste avant
		boolean test7 = cylon.takeObject(); // retourne false, le robot tient d�j� un objet
		boolean test8 = cylon.dropObject(); // l�che l'objet tenu, retourne true
		boolean test9 = cylon.setMouvement(Mouvement.DETRUIRE); // le cylon peut effectuer l'action, retourne true
		boolean test10 = cylon.setMouvement(Mouvement.AGIR);
		cylon.setPower();

		Robot r2d2 = new Robot("R2D2", "Astromech", 120, false, true, false, 15, 15); //objet Robot construit avec param�tres
		boolean test11 = r2d2.setMouvement(Mouvement.AVANT); // retourne false, R2D2 n'est pas activ�, donc ne se d�place pas
		r2d2.setPower();
		boolean test12 = r2d2.setMouvement(Mouvement.DETRUIRE); // retourne true car le mouvement est valide, mais pas le bon type de robot pour la m�thode associ�e
		boolean test13 = r2d2.setMouvement(Mouvement.AGIR);
		
		Robot c3po = new Robot(); // objet Robot andro�de construit par d�faut
		boolean test14 = c3po.setMouvement(Mouvement.AVANT); // retourne true car activ� dans le constructeur par d�faut
		boolean test15 = c3po.setMouvement(Mouvement.AGIR);
		
		Robot mixer = new Robot("Mixeur", "KitchenBot", 50, false, false, true, 10, 10); // cr�ation d'un robot de cuisine, non mobile
		boolean testMixer = mixer.setMouvement(Mouvement.AVANT); // retourne true car la commande est valide, mais ne d�place pas le robot car non mobile
		boolean testMixer2 = mixer.setMouvement(Mouvement.AGIR); // retourne true, mais ne peut faire l'action car absence de scan pr�alable
		mixer.scan(); // parce que pourquoi pas, un mixeur avec scan d'ingr�dients
		boolean testMixer3 = mixer.takeObject(); // renverra false, un mixeur ne peut saisir un objet
		boolean testMixer5 = mixer.setMouvement(Mouvement.AGIR); // le robot cuisinier peut agir et pr�parer un plat
	}

}
