package caracteres;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		String chaine = "";
		char letter;
		char comp;
		int count = 0;
		int comparison;
		boolean legit = false;
		ArrayList<Integer> index = new ArrayList<Integer>();// liste pour enregistrer, s'il y a comparaison positive par la suite, l'index de cette comparaison

		Scanner scanner = new Scanner(System.in);
			while (!legit) { // test si la saisie est conforme
				System.out.println("Entrez un mot ou une phrase : ");	
				if (scanner.hasNextLine()) {
					legit = true;
					chaine = scanner.nextLine().toLowerCase() + "."; // enregistre un mot ou une phrase, forcée en minuscule, Java étant sensible à la casse
				}else {
					System.out.println("Entree non conforme");
				}
			}
			
			if (chaine.equals(".")) {// vu que la chaine de caractères doit finir par un ".", c'est le seul cas où elle sera considérée comme vide
				System.out.println("LA CHAINE EST VIDE");		
			}else {	
				System.out.println("Entrez une lettre pour la comparaison (si d'aventure vous rentrez un mot, seule la premiere lettre sera prise en compte, vous etes prevenus) : ");
				comp = (scanner.next().charAt(0)); // enregistre la lettre (à l'index 0, prendra la première lettre si un mot est rentré) de comparaison dans un char
				comp = Character.toLowerCase(comp);// force le caractère en minuscule, rend la recherche insensible à la casse, tout comme la chaine de caractères enregistrée avant
				for (int i = 0; i < chaine.length(); i++) { // boucle sur la chaine de caractères
					letter = chaine.charAt(i); // extrait la lettre à chaque passage dans la boucle
					comparison = Character.compare(letter, comp); // pour la comparer avec "comp", renvoit 0 si la comparaison est vérifiée
					if(comparison == 0){ // à chaque fois qu'elle l'est
						count += 1; // ajoute 1 à une variable de compteur
						index.add(i); // ajoute à la liste l'index de la comparaison vérifiée
					}
				}
					
				if(count >= 1) { // si le compteur est positif -> la lettre a été trouvée au moins une fois
					System.out.println("Le caractere \"" + comp + "\" est present " + count + " fois dans la chaine de caractere testee, index : " + index);
				}else{ // sinon, elle n'a pas été trouvée
					System.out.println("Le caractere \"" + comp + "\" n'est pas present.");
				}
			}
		
		scanner.close();
	}

}
