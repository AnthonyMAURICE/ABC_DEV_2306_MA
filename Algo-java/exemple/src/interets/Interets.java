package interets;

import java.util.Scanner;

public class Interets {

	public static void main(String[] args) {
		/*
		 VARIABLE
		    S est un réel
		    N est un entier
		    i est un réel
		    Valeur1 est un réel
		    Valeur2 est un réel
		Début programme
		    Ecrire "Quelle est la somme sur votre compte ?"
		    Lire <-- S
		    /* Correction
		    Ecrire "Quel taux ?"
		    Lire <-- i
		    Ecrire "Sur combien d'années ?"
		    Lire <-- N
		    Valeur1 <-- S*(1 + N * i)
		    Valeur2 <-- S*(1+i)^N
		    Ecrire "Les valeurs acquisent par les intérêts sont de : ",Valeur1, " et ",Valeur2
		Fin programme
		 */
		Scanner scanner = new Scanner(System.in);
			float somme;
			int annees;
			float interet;
			double valeur1;
			double valeur2;
			System.out.println("Saisissez la somme sur le compte : ");
			somme = scanner.nextFloat();
			System.out.println("Avec quel taux ?");
			interet = scanner.nextFloat();
			System.out.println("Sur combien d'annees ?");
			annees = scanner.nextInt();
			valeur1 = somme*(1 + annees * interet);
			valeur2 = somme*Math.pow(1+interet, annees);
			System.out.println("Les valeurs acquises par les interets sont de " + valeur1 + " pour le simple et de " + valeur2 + " pour le compose.");
		scanner.close();
	}

}
