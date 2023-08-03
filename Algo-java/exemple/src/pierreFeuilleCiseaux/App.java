package pierreFeuilleCiseaux;

import java.util.Random;
import java.util.Scanner;

public class App {

	private static String choixOrdi() {
		String choixMachine;
		Random rand = new Random();
		int choice = rand.nextInt(1, 3);
		if (choice == 1) {
			choixMachine = "p";
		}else if(choice == 2) {
			choixMachine = "f";
		}else {
			choixMachine = "c";
		}
		return choixMachine;
	}
	
	private static boolean confront(String a, String b) {
		boolean lost = a.equals("p") && b.equals("f")|| a.equals("f") && b.equals("c") || a.equals("c")&& b.equals("p");
		return lost;
	}
	
	private static String choice(String a) {
		String completeChoice = "";
		if(a.equals("p")) {
			completeChoice = "Pierre";
		}else if (a.equals("f")) {
			completeChoice = "Feuille";
		}else {
			completeChoice = "Ciseaux";
		}
		return completeChoice;
	}
	
	public static void main(String[] args) {
		int score1 = 0, score2 = 0, manche = 0;
		String choix, ordi;
		String continuer = "o";
		Scanner scanner = new Scanner(System.in);
		do {
			manche++;
			System.out.println("(P)ierre, (F)euille ou (C)iseaux ?");
			System.out.println("Manche " + manche);
			choix = scanner.next().toLowerCase();
			if (choix.equals("p")|| choix.equals("f") || choix.equals("c")) {
				ordi = choixOrdi();
				System.out.println("Vous : " + choice(choix) + " et l'ordinateur : " + choice(ordi));
				if(choix.equals(ordi)) {
					System.out.println("Égalité");
				}else {
					if(confront(choix, ordi)) {
						System.out.println("Un point pour SkyNet");
						score2++;
					}else {
						System.out.println("Un point pour vous");
						score1++;
					}
				}
				System.out.println("Souhaitez-vous faire une autre manche ? ((O)ui)");
				continuer = scanner.next().toLowerCase();
			}else{
				manche--;
				System.out.println("Entrée invalide");
			}
		}while(continuer.equals("o"));
		System.out.println("Résultat final : ");
		System.out.println("Humain(e) : " + score1 + " / SkyNet : " + score2);
		scanner.close();
	}

}
