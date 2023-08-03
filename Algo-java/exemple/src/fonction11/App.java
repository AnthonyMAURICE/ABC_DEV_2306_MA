package fonction11;

import java.util.Scanner;

public class App {
	
	private static String purge(String origin, String purger) {
		String purgeChaine = origin.replace(purger, "");
		
		return purgeChaine;
	}

	public static void main(String[] args) {
		String chaine;
		String character;
		Scanner scanner = new Scanner(System.in);
			System.out.println("Entrez une chaine de caractères : ");
			chaine = scanner.nextLine();
			System.out.println("Entrez le caractère à purger : ");
			character = scanner.next();
			System.out.println(purge(chaine, character));
		scanner.close();

	}

}
