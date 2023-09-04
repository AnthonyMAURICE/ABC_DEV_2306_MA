package robot;

public class Robot {
	public enum Mouvement{
		AVANT,
		ARRIERE,
		GAUCHE,
		DROITE,
		AGIR,
		STOP;

	}
	private String name, type;
	private int taille, posX, posY;
	private boolean androide, powerOn;
	
	public Robot(String _name, String _type, int _taille, boolean _androide, boolean _powerOn, int _posX, int _posY) {
		this.name = _name;
		this.type = _type;
		this.taille = _taille;
		this.androide = _androide;
		this.powerOn = _powerOn;
		this.posX = _posX;
		this.posY = _posY;
	}
	
	public void setPower() {
		if(this.powerOn) {
			this.powerOn = false;
		}else {
			this.powerOn = true;
		}
	}
	
	public boolean setMouvement(String _command) {
		if(this.powerOn) {
			String command = _command;
			Mouvement control = Mouvement.valueOf(command);
			
			switch(control) {
				case AVANT:
					this.posX +=1;
					break;
				case ARRIERE:
					this.posX -=1;
					break;
				case GAUCHE:
					this.posY -= 1;
					break;
				case DROITE:
					this.posY += 1;
					break;
				case AGIR:
					System.out.println("Le robot fait ce qu'il a à faire"); // à faire évoluer par la suite suivant le type de robot.
					break;
				case STOP:
					System.out.println("Le robot s'arrête.");
					break;
				default:
					System.out.println("Commande invalide");
					break;
			}
			return true;
		}else {
			System.out.println("Le robot n'est pas activé");
			return false;
		}
		
	}


}
