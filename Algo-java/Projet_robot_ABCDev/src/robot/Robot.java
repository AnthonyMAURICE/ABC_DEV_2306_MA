package robot;


public class Robot {
	// enum des différentes commandes pouvant se retrouver sur la manette finale
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
	
	//constructeur par défaut
	public Robot() { 
		this.name = "Robot";
		this.type = "Androïde";
		this.taille = 180;
		this.android = true;
		this.mobile = true;
		this.powerOn = true;
		this.posX = 0;
		this.posY = 0;
		this.angle = 0;
		
	}
	
	//constructeur avec paramètres
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
	// méthode qui met ou non le robot en marche suivant son état initial
	public void setPower() {
		if(this.powerOn) {
			this.powerOn = false;
		}else {
			this.powerOn = true;
		}
	}
	
	// méthode de mouvement, prenant l'enum déclaré en début de classe, si toutefois le robot est activé
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
			System.out.println("Le robot n'est pas activé");
			return false;
		}
	}
	
	// détermine l'angle sur l'axe Y après rotation, pour ensuite l'utiliser pour la phase de mouvement 
	public void setAngle() {
		if(this.left) { // calcul de l'angle Y selon si la rotation est à gauche ou à droite
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
	
	// méthode de mouvement, basé sur l'angle sur l'axe Y et si le robot avance ou recule
	public void setMove() { 
		if(this.mobile) {
			switch(this.angle) { // switch sur l'angle Y pour déterminer son déplacement sur les deux axes
			case 0: // ici axe X
				if(this.forward) {// booléen à true si le robot avance
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
	
	// scan du terrain préalable à la prise d'objets
	public void scan() {
		if(!this.scanObject) {
			this.scanObject = true;
		}else {
			this.scanObject = false;
		}
	}
	
	// ne renvoit true que si un scan préalable a été effectué, que si le robot ne porte pas déjà quelque chose et qu'il est mobile
	public boolean takeObject() {
		if(this.mobile && this.scanObject && !this.objectTaken) {
			this.objectTaken = true; // indique que le robot tient un objet
			this.scanObject = false; // réinitialise le scan à false
			return true;
		}else {
			return false;
		}
	}
	
	// ne renvoit true que s'il a un objet à lâcher, et le lâche
	public boolean dropObject() {
		if(this.objectTaken) {
			this.objectTaken = false;
			return true;
		}else {
			return false;
		}
	}
	
	// méthode qui fait "agir" le robot, s'il est activé
	public boolean agir() {
		if(this.powerOn) {
			System.out.println("Le robot fait ce pour quoi il est conçu");
			return true;
		}else {
			System.out.println("Le robot n'est pas activé");
			return false;
		}
	}
	
	// méthode humoristique, mais néanmoins sérieuse...
	public boolean destroyAllMankind() {
		if(this.type.equals("WarBot")){
			System.out.println("Les cylons ont été créés par les humains... Ils ont évolué... Ils se sont rebellés...");
			return true;
		}else {
			System.out.println("Ce robot ne causera pas la chute de l'humanité.");
			return false;
		}
	}

}
