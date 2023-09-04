package robot;

public class Robot {
	// enum des diff�rentes commandes pouvant se retrouver sur la manette finale
	enum Control{
		AVANT,
		ARRIERE,
		GAUCHE,
		DROITE,
		AGIR;
	}
	
	private String name, type;
	private int taille, posX, posY;
	private boolean androide, powerOn;
	
	//constructeur par d�faut
	public Robot() { 
		this.name = "Robot";
		this.type = "Andro�de";
		this.taille = 180;
		this.androide = true;
		this.powerOn = true;
		this.posX = 0;
		this.posY = 0;
		
	}
	
	//constructeur avec param�tres
	public Robot(String _name, String _type, int _taille, boolean _androide, boolean _powerOn, int _posX, int _posY) {
		this.name = _name;
		this.type = _type;
		this.taille = _taille;
		this.androide = _androide;
		this.powerOn = _powerOn;
		this.posX = _posX;
		this.posY = _posY;
	}
	
	//Getters
	public String getName() {
		return this.name;
	}
	
	public String getType() {
		return this.type;
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
	public boolean setControl(Control _command) {
		if(this.powerOn) {
			Control control = _command;
			
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
					System.out.println("Le robot fait ce qu'il a � faire"); // � faire �voluer par la suite suivant le type de robot.
					break;
			}
			return true;
		}else {
			System.out.println("Le robot n'est pas activ�");
			return false;
		}
		
	}

}
