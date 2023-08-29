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
				System.out.println("Ferm�e");
			}
		}
		
		public void fermer() {
			if(this.ouverte && !this.isInOther) {
				this.ouverte = false;
				System.out.println("Ferm�e");
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
				System.out.println("La poup�e est d�j� dedans.");
			}
		}
		
		public void sortirDe(PoupeeRusses firstDoll, PoupeeRusses p) {
			if(dollInP && p.ouverte) {
				dollInP = false;
				System.out.println("Extraction accomplie avec succ�s");
			}else {
				System.out.println("Op�ration impossible, soit la poup�e p est ferm�e, soit la premi�re n'�tait pas dedans.");
			}
		}
}
