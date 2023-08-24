package object3;

public class Compte {
	double solde;
	
	public Compte(double _solde) {
		solde = _solde;
	}
	
	
	public void deposer(double _montant) {
		solde += _montant;
	}
	
	public void retirer(double _montant) {
		solde -= _montant;
	}
	
	public void afficher() {
		System.out.println("solde : " +solde);
	}
}


