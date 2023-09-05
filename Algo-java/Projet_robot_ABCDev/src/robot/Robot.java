package robot;


public class Robot {
	// enum des diff�rentes commandes pouvant se retrouver sur la manette finale
	enum Mouvement{
		AVANT,
		ARRIERE,
		GAUCHE,
		DROITE,
		SCANNER,
		SAISIR,
		LACHER,
		AGIR,
		DETRUIRE;
	}
	
	
	private String name, type;
	private int taille, posX, posY, angle;
	private boolean android, mobile, powerOn, forward, left, scanObject = false, objectTaken;
	
	//constructeur par d�faut
	public Robot() { 
		this.name = "Robot";
		this.type = "Andro�de";
		this.taille = 180;
		this.android = true;
		this.mobile = true;
		this.powerOn = true;
		this.posX = 0;
		this.posY = 0;
		this.angle = 0;
		
	}
	
	//constructeur avec param�tres
	public Robot(String _name, String _type, int _taille, boolean _androide, boolean _mobile, boolean _powerOn, int _posX, int _posY) {
		this.name = _name;
		this.type = _type;
		this.taille = _taille;
		this.android = _androide;
		this.mobile = _mobile;
		this.powerOn = _powerOn;
		this.posX = _posX;
		this.posY = _posY;
		this.angle = 0;
	}
	
	//Getters
	public String getName() {
		return this.name;
	}
	
	public String getType() {
		return this.type;
	}
	
	public boolean getPower() {
		return this.powerOn;
	}
	
	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}
	
	//Setters
	// m�thode qui met ou non le robot en marche suivant son �tat initial
	public void setPower() {
		if(this.powerOn) {
			this.powerOn = false;
		}else {
			this.powerOn = true;
		}
	}
	
	// m�thode de mouvement, prenant l'enum d�clar� en d�but de classe, si toutefois le robot est activ�
	public boolean setMouvement(Mouvement _command) {
		if(this.powerOn) {
			Mouvement Mouvement = _command;			
			switch(Mouvement) {
				case AVANT:
					this.forward = true;
					this.setMove();
					break;
				case ARRIERE:
					this.forward = false;
					this.setMove();
					break;
				case GAUCHE:
					this.left = true;
					this.setAngle();
					break;
				case DROITE:
					this.left = false;
					this.setAngle();
					break;
				case SCANNER:
					this.scan();
					break;
				case SAISIR:
					this.takeObject();
					break;
				case LACHER:
					this.dropObject();
					break;
				case AGIR:
					this.agir();
					break;
				case DETRUIRE:
					this.destroyAllMankind();
					break;
			}
			return true;
		}else{
			System.out.println("Le robot n'est pas activ�");
			return false;
		}
	}
	
	// d�termine l'angle sur l'axe Y apr�s rotation, pour ensuite l'utiliser pour la phase de mouvement 
	public void setAngle() {
		if(this.left) { // calcul de l'angle Y selon si la rotation est � gauche ou � droite
			if(this.angle >=90) {
				this.angle -= 90;
			}else {
				this.angle = 270;
			}
		}else {
			if(this.angle < 270 ) {
				this.angle += 90;
			}else {
				this.angle = 0;
			}
		}
	}
	
	// m�thode de mouvement, bas� sur l'angle sur l'axe Y et si le robot avance ou recule
	public void setMove() { 
		if(this.mobile) {
			switch(this.angle) { // switch sur l'angle Y pour d�terminer son d�placement sur les deux axes
			case 0: // ici axe X
				if(this.forward) {// bool�en � true si le robot avance
					this.posX +=1;
				}else {
					this.posX -=1;
				}
				break;	
			case 90: // ici axe Y
				if(this.forward) {
					this.posY +=1;
				}else {
					this.posY -=1;
				}
				break;
			case 180: // axe X
				if(this.forward) {
					this.posX -=1;
				}else {
					this.posX +=1;
				}
				break;
			case 270: // axe Y
				if(this.forward) {
					this.posY -=1;
				}else {
					this.posY +=1;
				}
				break;
			}
		}else {
			System.out.println("Le robot n'est pas mobile");
		}
	}
	
	// scan du terrain pr�alable � la prise d'objets
	public void scan() {
		if(!this.scanObject) {
			this.scanObject = true;
		}else {
			this.scanObject = false;
		}
	}
	
	// ne renvoit true que si un scan pr�alable a �t� effectu�, que si le robot ne porte pas d�j� quelque chose et qu'il est mobile
	public boolean takeObject() {
		if(this.mobile && this.scanObject && !this.objectTaken) {
			this.objectTaken = true; // indique que le robot tient un objet
			this.scanObject = false; // r�initialise le scan � false
			return true;
		}else {
			return false;
		}
	}
	
	// ne renvoit true que s'il a un objet � l�cher, et le l�che
	public boolean dropObject() {
		if(this.objectTaken) {
			this.objectTaken = false;
			return true;
		}else {
			return false;
		}
	}
	
	// m�thode qui fait "agir" le robot, s'il est activ�
	public boolean agir() {
		if(this.powerOn) {
			System.out.println("Le robot fait ce pour quoi il est con�u");
			return true;
		}else {
			System.out.println("Le robot n'est pas activ�");
			return false;
		}
	}
	
	// m�thode humoristique, mais n�anmoins s�rieuse...
	public boolean destroyAllMankind() {
		if(this.type.equals("WarBot")){
			System.out.println("Les cylons ont �t� cr��s par les humains... Ils ont �volu�... Ils se sont rebell�s...");
			return true;
		}else {
			System.out.println("Ce robot ne causera pas la chute de l'humanit�.");
			return false;
		}
	}

}
