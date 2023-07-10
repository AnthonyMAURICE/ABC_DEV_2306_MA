package binaire;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class App {

	public static void main(String[] args) {
		int decimal, modulo, firstNum;

		ArrayList<Integer> binary = new ArrayList<Integer>(); // déclaration d'un tableau liste, car extensible au besoin
		
		Scanner scanner = new Scanner(System.in);
			System.out.println("Entrez un nombre (en base dix) : ");
			decimal = scanner.nextInt();
			firstNum = decimal; // enregistre le nombre choisi dans une variable pour conserver sa valeur
			
			while (decimal > 1 ) {
				modulo = decimal % 2; //enregistre le modulo de la division par 2
				decimal = decimal /2; // puis divise le nombre par deux pour le passage suivant dans la boucle
				binary.add(modulo); // ajout du modulo au tableau
			}
			
			if (firstNum == 0) {
				binary.add(0); //ajoute 0, pour le cas où le nombre entré est 0 et ne serait pas passé dans la boucle while
			}else {
				binary.add(1); //ajoute 1, c'est à dire le dernier modulo
			}
			
			
			Collections.reverse(binary); // méthode qui inverse le tableau pour la lecture de gauche à droite
			
			System.out.print(firstNum + " en base dix donne : ");
			for (int i = 0; i < binary.size(); i++) { // boucle for pour extraire chaque valeur du tableau
				System.out.print(binary.get(i)); // pour les afficher l'une après l'autre
			}
			System.out.print(" en binaire.");
		scanner.close();
	}
		
}
