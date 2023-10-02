package russianDolls;

public class App {

	public static void main(String[] args) {
		PoupeeRusses firstDoll = new PoupeeRusses();
		PoupeeRusses p = new PoupeeRusses(true, false, false, 15);
		firstDoll.ouvrir();
		firstDoll.fermer();
		firstDoll.placerDans(p);
		firstDoll.placerDans(p);
		firstDoll.sortirDe(p);
		firstDoll.sortirDe(p);
	} 

}
