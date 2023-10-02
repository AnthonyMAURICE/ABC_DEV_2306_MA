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
			}else {
				this.ouverte = false;
			}
		}
		
		public void fermer() {
			if(this.ouverte && !this.isInOther) {
				this.ouverte = false;
			}else {
				this.ouverte = true;
			}
		}
		
		public void placerDans(PoupeeRusses p) {
			if(!dollInP && p.ouverte && !this.isInOther && !p.hasIn && this.heigth < p.heigth) {
				dollInP = true;
			}else if (!dollInP) {
				dollInP = false;
			}else {
				System.out.println("La poupée est déjà dedans.");
			}
		}
		
		public void sortirDe(PoupeeRusses p) {
			if(dollInP && p.ouverte) {
				dollInP = false;
				System.out.println("Extraction accomplie avec succès");
			}else {
				System.out.println("Opération impossible, soit la poupée p est fermée, soit la première n'était pas dedans.");
			}
		}
}
