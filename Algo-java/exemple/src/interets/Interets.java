package interets;

import java.util.Scanner;

public class Interets {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
			float somme;
			int annees;
			float interet;
			float valeur1;
			double valeur2;
			System.out.println("Saisissez la somme sur le compte : ");
			somme = scanner.nextFloat();
			System.out.println("Avec quel taux ?");
			interet = scanner.nextFloat();
			System.out.println("Sur combien d'annees ?");
			annees = scanner.nextInt();
			valeur1 = somme*(1 + annees * interet);
			valeur2 = somme*Math.pow(1+interet, annees);
			System.out.println("Les valeurs acquises par les interets sont de " + valeur1 + " pour le premier taux et de " + valeur2 + " pour le second taux.");
		scanner.close();
	}

}
