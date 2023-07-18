package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		int length = 0, number, count = 0;
		boolean check = false, validLength = false;
		ArrayList<Integer> index = new ArrayList<Integer>();
		
		Scanner scanner = new Scanner(System.in);
			// premier bloc, contrôle de saisie
			while (!validLength) {
				System.out.println("Saisissez la taille du tableau (entre 2 et 10) : ");
				length = scanner.nextInt();
				if (length < 2 || length > 10) {// contrôle si la saisie utilisateur est correcte, sinon boucle
					System.out.println("Entrez une valeur pour votre tableau dans les parametres demandes !");
				}else {
					validLength = true;// permet de sortir de la boucle si la saisie est conforme
				}
			}
			//second bloc, déclaration et initialisation du tableau
			System.out.println("Saisissez "+ length +" chiffres : ");
			int[] array  = new int[length]; // déclaration du tableau avec le paramètre de taille choisie par l'uttilisateur
			for (int i = 0; i < array.length; i++) { // boucle sur le tableau pour la saisie des valeurs
				count++;
				System.out.println("Nombre " + count);
				array[i] = scanner.nextInt();
			}
			//tri du tableau par ordre croissant
			Arrays.sort(array); // trie le tableau en ordre croissant
			//troisième bloc, comparaison avec une entrée utilisateur
			System.out.println("Entrez un nombre");
			number = scanner.nextInt();
			for ( int j = 0; j< array.length; j++) { // boucle pour chercher si la valeur de comparaison existe dans le tableau
				if (number == array[j]) {
					check = true; // si oui, passe le booléen à true
					index.add(j); // sauvegarde le(s) index trouvés
				}
			}
			//quatrième bloc, sortie conditionnée par la comparaison du bloc 3
			if (check == true) {
				System.out.println("Le nombre " + number + " figure parmi les elements, index : " + index + ", apres tri par ordre croissant des valeurs.");
			}else {
				System.out.println("Error 404 : Number Not Found");
			}
		
		scanner.close();
	}
}