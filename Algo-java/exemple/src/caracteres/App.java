package caracteres;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		String chaine = "";
		char letter;
		char comp;
		int count = 0;
		int comparison;
		boolean legit = false;

		Scanner scanner = new Scanner(System.in);
			while (!legit) { // test si la saisie est conforme
				System.out.println("Entrez un mot ou une phrase : ");	
				if (scanner.hasNextLine()) {
					legit = true;
					chaine = scanner.nextLine().toLowerCase() + ".";
				}else {
					System.out.println("Entree non conforme");
				}
			}
			
			if (chaine.equals(".")) {
				System.out.println("LA CHAINE EST VIDE");		
			}else {	
				System.out.println("Entrez une lettre pour la comparaison (si d'aventure vous rentrez un mot, seule la premiere lettre sera prise en compte, vous etes prevenus) : ");
				comp = (scanner.next().charAt(0)); // enregistre la lettre (à l'index 0, prendra la première lettre si un mot est rentré) de comparaison dans un char
				comp = Character.toLowerCase(comp);
				for (int i = 0; i < chaine.length(); i++) { // boucle sur la chaine de caractères
					letter = chaine.charAt(i); // extrait la lettre à chaque passage dans la boucle
					comparison = Character.compare(letter, comp); // pour la comparer avec "comp", renvoit 0 si la comparaison est vérifiée
					if(comparison == 0){ // à chaque fois qu'elle l'est
						count += 1; // ajoute 1 à une variable de compteur
					}
				}
					
				if(count >= 1) { // si le compteur est positif -> la lettre a été trouvée au moins une fois
					System.out.println("Le caractere \"" + comp + "\" est present " + count + " fois dans la chaine de caractere testee.");
				}else{ // sinon, elle n'a pas été trouvée
					System.out.println("Le caractere \"" + comp + "\" n'est pas present.");
				}
			}
		
		scanner.close();
	}

}
