package object2;

public class PorteDeGarage {
	boolean verrouillee;
	boolean estFermee;
	int niveauOuverture;
	boolean verified;
	
	
	public PorteDeGarage() {
		verrouillee = true;
		estFermee = true;
		niveauOuverture = 0;
		verified = true;
	}
	
	public PorteDeGarage(boolean _verrouillee, boolean _estFermee, int _niveauOuverture) {
		this.verrouillee = _verrouillee;
		this.estFermee = _estFermee;
		this.niveauOuverture = _niveauOuverture;
		
		if((this.verrouillee && this.estFermee && this.niveauOuverture ==0) ^ this.niveauOuverture != 0) {
			verified = true;
		}else {
			verified = false;
		}
	}
	
	public boolean verrouillerPorte() {
		if(verified && this.estFermee && !this.verrouillee) {
			this.verrouillee = true;
			return true;
		}else {
			System.out.println("Ne peux verrouiller ce qui fermé n'est pas...");
			return false;
		}
	}
	
	public boolean deverrouillerPorte() {
		if(verified && this.verrouillee) {
			this.verrouillee = false;
			return true;
		}else {
			System.out.println("Ne peux déverrouiller ce qui verrouillé n'est pas...");
			return false;
		}
	}
	
	public boolean fermer(int _angle) {
		if(verified && !this.estFermee && _angle <= this.niveauOuverture) {
			this.niveauOuverture -= _angle;
			return true;
		}else {
			return false;
		}
	}
	
	public boolean ouvrir(int _angle) {
		if(verified && !this.verrouillee && _angle <= (100 - this.niveauOuverture)) {
			this.estFermee = false;
			this.niveauOuverture += _angle;
			return true;
		}else {
			return false;
		}
	}
	
	public boolean ouvrirEntierement() {
		if(verified && !this.verrouillee && this.niveauOuverture != 100) {
			this.estFermee = false;
			this.niveauOuverture = 100;
			return true;
		}else {
			return false;
		}
	}
	
	public boolean fermerEntierement() {
		if(verified && !this.estFermee) {
			this.estFermee = true;
			this.niveauOuverture = 0;
			return true;
		}else {
			return false;
		}
	}
}
