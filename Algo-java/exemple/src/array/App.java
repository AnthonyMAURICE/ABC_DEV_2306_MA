package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		int length = 0;
		int number, count = 0;
		boolean check = false;
		ArrayList<Integer> index = new ArrayList<Integer>();
		Scanner scanner = new Scanner(System.in);
			System.out.println("Saisissez la taille du tableau : ");
			length = scanner.nextInt();
			System.out.println("Saisissez "+ length +" chiffres : ");
			int array [] = new int[length]; // déclaration du tableau avec le paramètre de taille choisie par l'uttilisateur
			for (int i = 0; i < array.length; i++) { // boucle sur le tableau pour la saisie des valeurs
				count++;
				System.out.println("Nombre " + count);
				array[i] = scanner.nextInt();
			}
			
			Arrays.sort(array); // trie le tableau en ordre croissant
			
			System.out.println("Entrez un nombre");
			number = scanner.nextInt();
			for ( int j = 0; j< array.length; j++) { // boucle pour chercher si la valeur de comparaison existe dans le tableau
				if (number == array[j]) {
					check = true; // si oui, passe le booléen à true
					index.add(j); // sauvegarde le ou les lindex trouvés
				}
			}
			
			if (check == true) {
				System.out.println("Le nombre " + number + " figure parmi les elements, a/aux index : " + index + " après tri par ordre croissant des valeurs.");
			}else {
				System.out.println("404 Number Not Found");
			}
		
		scanner.close();
	}
}