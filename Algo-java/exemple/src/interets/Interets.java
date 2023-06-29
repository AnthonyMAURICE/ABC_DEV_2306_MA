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
			double somme, interet,valeur1, valeur2, gain1, gain2;
			int annees;
			System.out.println("Saisissez la somme sur le compte : ");
			somme = scanner.nextDouble();
			System.out.println("Avec quel taux ?");
			interet = scanner.nextDouble();
			System.out.println("Sur combien d'annees ?");
			annees = scanner.nextInt();
			valeur1 = somme*(1 + annees * (interet/100));
			valeur2 = somme*Math.pow(1+(interet/100), annees);
			gain1 = valeur1 - somme;
			gain2 = valeur2 - somme;
			System.out.println("Les valeurs acquises (arrondis a deux decimales) par les interets sont de " 
								+ Math.round(valeur1 * 100.0) / 100.0 + " pour le simple et de " 							// la méthode Math.round() arrondit, 
								+ Math.round(valeur2 * 100.0) / 100.0 + " pour le compose, soit des gains respectifs (arrondis eux aussis) de " 	//et la multiplication suivie de la division par 100.0 
								+ Math.round(gain1 * 100.0) / 100.0 + " et " + Math.round(gain2 * 100.0) / 100.0);			//retourne le résultat avec 2 décimales
		scanner.close();
	}

}
