package object3;

public class Compte {
	double solde;
	
	public Compte(double _solde) {
		this.solde = _solde;
	}
	
	
	public void deposer(double _montant) {
		this.solde += _montant;
	}
	
	public void retirer(double _montant) {
		this.solde -= _montant;
	}
	
	public void afficher() {
		System.out.println("solde : " +this.solde);
	}
}


