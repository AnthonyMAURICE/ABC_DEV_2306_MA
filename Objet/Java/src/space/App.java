package space;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		int choice, turn = 1;
		boolean valid = false;
				
		Ship vaisseau = new Ship();
		Ship vaisseau2 = new Ship();
		
		Scanner scanner = new Scanner(System.in);
		//choix du vaisseau
			while(!valid) {
				System.out.println("Quel type de vaisseau choisissez-vous ? 1 pour un croiseur (plus lourdement armé), 2 pour une frégate (plus rapide et réactif)");
				choice = scanner.nextInt();
				if(choice == 1) {
					vaisseau.setType("Croiseur");
					vaisseau.setHull(100);
					vaisseau.setShields(50);
					vaisseau.setCannons(12);
					vaisseau.setEvasion(5);
					valid = true;
				}else if(choice == 2) {
					vaisseau.setType("Frégate");
					vaisseau.setHull(75);
					vaisseau.setShields(25);
					vaisseau.setCannons(8);
					vaisseau.setEvasion(12);
					valid = true;
				}else {
					System.out.println("Saisie incorrecte");
					valid = false;
				}
			}
			
			while(vaisseau.getHull() > 0 && vaisseau2.getHull() > 0) {
				vaisseau.afficher();
				System.out.println("Contre : ");
				vaisseau2.afficher();
				System.out.println("Tour : " + turn);
				vaisseau.combat(vaisseau, vaisseau2);
				vaisseau.combat(vaisseau2, vaisseau);
			}
			
			if(vaisseau.getHull() > 0) {
				System.out.println("Vous avez gagné !");
			}else {
				System.out.println("Vous avez perdu !");
			}
		scanner.close();

	}

}
