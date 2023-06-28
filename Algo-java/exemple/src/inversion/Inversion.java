package inversion;

import java.util.Scanner;

public class Inversion {

	public static void main(String[] args) {
		/*
		 VARIABLE
		    a est un entier
		    b est un entier
		    c est un entier
			Début programme
			    Ecrire "Entrez la valeur de a : "
			    Lire <-- a
			    Ecrire "Entrez la valeur de b : "
			    Lire <-- b
			    Ecrire "Les valeurs choisies sont : ",a, " et " ,b
			    c <-- a
			    a <-- b
			    b <-- c
			    Ecrire "Les valeurs finales (après inversion) sont : ",a," et ",b
			Fin programme    
		 */
		int a;
		int b;
		int c;
		Scanner scanner = new Scanner(System.in);
			System.out.println("Saisissez la valeur de \"a\" : ");
			a = scanner.nextInt();
			System.out.println("Saisissez la valeur de \"b\" : ");
			b = scanner.nextInt();
			System.out.println("Les valeurs de \"a\" et \"b\" avant inversion sont de : " + a + " et " + b);
			c = a;
			a = b;
			b = c;
			System.out.println("Inversion en cours...");
			System.out.println("Les valeurs de \"a\" et \"b\" post-inversion sont de : " + a + " et " + b);
		scanner.close();

	}

}
