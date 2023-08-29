package russianDolls;

public class App {

	public static void main(String[] args) {
		PoupeeRusses firstDoll = new PoupeeRusses();
		PoupeeRusses p = new PoupeeRusses(true, false, false, 15);
		firstDoll.ouvrir();
		firstDoll.fermer();
		firstDoll.placerDans(firstDoll, p);
		firstDoll.placerDans(firstDoll, p);
		firstDoll.sortirDe(firstDoll, p);
		firstDoll.sortirDe(firstDoll, p);
	}

}
