package fonction4;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		int cb, cheques, virements, paiements;
		
		Scanner scanner = new Scanner(System.in);
		
			System.out.println("Précisez vos paiements : ");
			System.out.println("Par carte bancaire : ");
			cb = scanner.nextInt();
			System.out.println("Par chèques : ");
			cheques = scanner.nextInt();
			System.out.println("Par virements : ");
			virements = scanner.nextInt();
			
			paiements = cb + cheques + virements;
		
			System.out.println("Nombre de paiements par Carte Bleue : " + cb);
			System.out.println("Nombre de chèques émis : " + cheques);
			System.out.println("Nombre de virements automatiques : " + virements);
			
			System.out.println("Vous avez émis " + paiements + " ordres de débit dont : ");
			System.out.println("	" + Math.round(pourcent(cb, paiements)*10.0)/10.0 + "% par Carte Bleue");
			System.out.println("	" +  Math.round(pourcent(cheques, paiements)*10.0)/10.0 + "% par chèque");
			System.out.println("	" +Math.round(pourcent(virements, paiements)*10.0)/10.0 + "% par virements");
			
		scanner.close();
	}
	
	private static double pourcent(double a, double b) {
		double pourcent = (a/b) * 100;
		return pourcent;
	}

}
