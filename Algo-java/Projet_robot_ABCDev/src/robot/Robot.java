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
	private int taille, posX, posY, direction;
	private boolean android, mobile, forward, left, scanZone = false, objectTaken;
	protected boolean powerOn;
	
	//constructeur par d�faut
	public Robot() { 
		this.name = "Robot";
		this.type = "Andro�de";
		this.taille = 180; //taille et d�terminer si andro�de ou pas sont inutilis�s
		this.android = true; // mais pourraient �tre utile sur une �volution potentielle du programme
		this.mobile = true;
		this.powerOn = true;
		this.posX = 0;
		this.posY = 0;
		this.direction = 0;		
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
		this.direction = 0;
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
	
	public String getDirection() {
		if (this.direction == 0) {
			return "Nord";
		}else if (this.direction  == 1) {
			return "Est";
		}else if(this.direction  == 2) {
			return "Sud";
		}else {
			return "Ouest";
		}
	}
	
	public boolean getScanned() {
		if (this.scanZone) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean getHold() {
		if(this.objectTaken) {
			return true;
		}else {
			return false;
		}
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
			Mouvement Ordre = _command;			
			switch(Ordre) {
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
					this.setDirection();
					break;
				case DROITE:
					this.left = false;
					this.setDirection();
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
			return false;
		}
	}	
	
	// d�termine la direction apr�s rotation, pour ensuite l'utiliser pour la phase de mouvement 
	public void setDirection() {
		if(this.left) { // calcul de la direction Y selon si la rotation est � gauche ou � droite
			if(this.direction >=1) {
				this.direction -= 1;
			}else {
				this.direction = 3;
			}
		}else {
			if(this.direction < 3 ) {
				this.direction += 1;
			}else {
				this.direction = 0;
			}
		}
	}
	
	// m�thode de mouvement, bas� sur sa direction (de 0 � 270) et si le robot avance ou recule
	public void setMove() { 
		if(this.mobile) {
			switch(this.direction) { // switch sur la valeur de la direction pour d�terminer son d�placement sur les deux axes
			case 0: // ici axe X
				if(this.forward) {// bool�en � true si le robot avance
					this.posX +=1;
				}else {
					this.posX -=1;
				}
				break;	
			case 1: // ici axe Y
				if(this.forward) {
					this.posY +=1;
				}else {
					this.posY -=1;
				}
				break;
			case 2: // axe X
				if(this.forward) {
					this.posX -=1;
				}else {
					this.posX +=1;
				}
				break;
			case 3: // axe Y
				if(this.forward) {
					this.posY -=1;
				}else {
					this.posY +=1;
				}
				break;
			}
			this.scanZone = false; // r�initialise le scan � false car changement de zone
		}
	}
	
	// scan du terrain pr�alable � la prise d'objets ou r�alisation d'une recette (pour le robot de cuisine), reste � true tant qu'il n'y a pas changement de "zone"
	public void scan() {
		if(!this.scanZone) {
			this.scanZone = true;
		}
	}
	
	// ne retourne true que si un scan pr�alable a �t� effectu�, si le robot ne porte pas d�j� quelque chose et qu'il est mobile
	public boolean takeObject() {
		if(this.mobile && this.scanZone && !this.objectTaken) {
			this.objectTaken = true; // indique que le robot tient un objet
			return true;
		}else {
			return false;
		}
	}
	
	// ne retourne true que s'il a un objet � l�cher, et le l�che, sinon retourne false
	public boolean dropObject() {
		if(this.objectTaken) {
			this.objectTaken = false;
			return true;
		}else {
			return false;
		}
	}

	// m�thode qui fait "agir" le robot, s'il est activ�, pourrait accueillir d'autres cas suivant les types de robots cr��s
	public String agir() {
		String action;
		if(this.powerOn) {
			switch(this.type) {
				case "WarBot":
					action ="Le robot tire sur ses cr�ateurs";
					break;
				case "Astromech":
					action = "Le robot r�pare le vaisseau";
					break;
				case "KitchenBot":
					if(this.scanZone) {
						action = "Le robot pr�pare un plat";
						this.scanZone = false; // une fois le plat pr�t, r�initialise le scan � false, �tant donn� qu'il ne se d�place pas
					}else {
						action ="<html><font color=\"red\">Avez-vous pens� � scanner les ingr�dients avant ?</font></html>";
					}
					break;
				default:
					action = "Le robot fait ce pourquoi il est con�u";
					break;
			}
		
		}else {
			action = "<html><font color=\"red\">Robot non activ�</font></html>";
		}
		//System.out.println(action);
		return action;
	}
	
	// m�thode humoristique, mais n�anmoins s�rieuse...
	public String destroyAllMankind() {
		String destroy;
		if (this.getPower()) {
			destroy = "Derni�re chance d'annuler la fin de l'humanit�...";
		}else {
			destroy = "Robot non activ�";
		}
		return destroy ;		
	}
}
