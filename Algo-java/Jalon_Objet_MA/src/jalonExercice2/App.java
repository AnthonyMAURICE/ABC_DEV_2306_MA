package jalonExercice2;

public class App {

	public static void main(String[] args) {
		Domino domino1 = new Domino(2, 6);
		Domino domino2 = new Domino(4, 3);
		Domino domino3 = new Domino(4, 4);
		
		domino1.affichePoints();
		System.out.println(domino2.valeur());
		
		boolean test1 = domino1.combo(domino2); // retourne false, aucune des faces n'est égale à celles de l'autre domino
		boolean test2 = domino2.combo(domino3); // retourne true, correspondance trouvée
		System.out.println("Test 1 : " + test1 + " et test 2 : " + test2);
	}

}
