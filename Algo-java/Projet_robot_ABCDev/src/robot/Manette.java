package robot;

import robot.Robot.Mouvement;

public class Manette { //rendue obsolète par l'interface graphique
	
	public Manette() {
		
	}
	
	public void control(Robot _robot, char _command) {
		switch(_command) {
			case 'z':
				_robot.setMouvement(Mouvement.AVANT);
				break;
			case 'q':
				_robot.setMouvement(Mouvement.GAUCHE);
				break;
			case 's':
				_robot.setMouvement(Mouvement.ARRIERE);
				break;
			case 'd':
				_robot.setMouvement(Mouvement.DROITE);
				break;
			case '0':
				_robot.setMouvement(Mouvement.SCANNER);
				break;
			case '1':
				_robot.setMouvement(Mouvement.SAISIR);
				break;
			case '2':
				_robot.setMouvement(Mouvement.LACHER);
				break;
			case '3':
				_robot.setMouvement(Mouvement.AGIR);
				break;
			case '5':
				_robot.setMouvement(Mouvement.DETRUIRE);
				break;
			case 'p':
				_robot.setPower();
				break;
			case 'n':
				System.out.println("Fin du programme");
				break;
			default:
				System.out.println("Mouvement invalide");
				break;
				
		}
	}
	
}
