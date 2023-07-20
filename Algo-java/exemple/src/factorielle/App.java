package factorielle;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		int nombre = 0, temp = 1;
		boolean verif = false;
		String error;

		Scanner scanner = new Scanner(System.in);
			
			while(!verif) {
				System.out.println("Saisissez un nombre, nous calculerons sa factorielle.");
				if(scanner.hasNextInt()) {	// condition pour contrôler que la saisie utilisateur soit bien un entier
					nombre = scanner.nextInt();
					if(nombre>0) { // condition pour contrôler que la saisie est un nombre positif
						verif = true; // si ces deux conditions sont remplies, passe le booléen à true et permet la sortie de boucle
					}else {
						System.out.println("Veuillez entrer un entier positif");
					}
				}else {
					error = scanner.nextLine();
					System.out.println(error + " n'est pas un chiffre.");
				}
			}
			
			
			
			for(int i = 1; i <= nombre; i++) {
				temp = temp * i;
			}
			
			System.out.println("La factorielle de " + nombre + " donne : " + temp);
		
		scanner.close();

	}

}
