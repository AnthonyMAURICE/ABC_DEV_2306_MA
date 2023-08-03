package fonction12;

import java.util.Scanner;

public class App {
	
	private static String purge(String origin, String purger) {
		String purgedChaine = origin;
		
		for(int i = 0; i < purger.length(); i++) {
			String temporary = String.valueOf(purger.charAt(i));
			purgedChaine = purgedChaine.replaceAll(temporary, "");

		}
		
		return purgedChaine;
	}
	
	
	public static void main(String[] args) {
		String chaine;
		String characters;
		Scanner scanner = new Scanner(System.in);
			System.out.println("Entrez une chaine de caractères : ");
			chaine = scanner.nextLine();
			System.out.println("Entrez les caractère à purger : ");
			characters = scanner.nextLine();
			System.out.println(purge(chaine, characters));
		scanner.close();

	}

}
