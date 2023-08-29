package russianDolls;

public class PoupeeRusses {

	boolean ouverte;
	boolean isInOther;
	boolean hasIn;
	double heigth;
	boolean dollInP = false;
		public PoupeeRusses() {
			ouverte = false;
			isInOther = false;
			hasIn = false;
			heigth = 10;
		}
		
		public PoupeeRusses(boolean _ouverte, boolean _isInOther, boolean _hasIn, double _heigth){
			ouverte = _ouverte;
			isInOther = _isInOther;
			hasIn = _hasIn;
			heigth = _heigth;
		}
		
		public void ouvrir() {
			if(!this.ouverte && !this.isInOther) {
				this.ouverte = true;
				System.out.println("Ouverte");
			}else {
				this.ouverte = false;
				System.out.println("Fermée");
			}
		}
		
		public void fermer() {
			if(this.ouverte && !this.isInOther) {
				this.ouverte = false;
				System.out.println("Fermée");
			}else {
				this.ouverte = true;
				System.out.println("Ouverte");
			}
		}
		
		public void placerDans(PoupeeRusses firstDoll, PoupeeRusses p) {
			if(!dollInP && p.ouverte && !firstDoll.isInOther && !p.hasIn && firstDoll.heigth < p.heigth) {
				dollInP = true;
				System.out.println("C'est bon");
			}else if (!dollInP) {
				dollInP = false;
				System.out.println("C'est pas bon");
			}else {
				System.out.println("La poupée est déjà dedans.");
			}
		}
		
		public void sortirDe(PoupeeRusses firstDoll, PoupeeRusses p) {
			if(dollInP && p.ouverte) {
				dollInP = false;
				System.out.println("Extraction accomplie avec succès");
			}else {
				System.out.println("Opération impossible, soit la poupée p est fermée, soit la première n'était pas dedans.");
			}
		}
}
