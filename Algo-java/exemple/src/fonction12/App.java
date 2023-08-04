package fonction12;

import java.util.Scanner;

public class App {
	
	private static String purge(String origin, String purger) {
		String purgedChaine = origin;
		
		for(int i = 0; i < purger.length(); i++) {
			purgedChaine = purgedChaine.replaceAll(String.valueOf(purger.charAt(i)), "");
		}
		
		return purgedChaine;
	}
	
	
	public static void main(String[] args) {
		String chaine;
		String characters;
		Scanner scanner = new Scanner(System.in);
			System.out.println("Entrez une chaine de caractères : ");
			chaine = scanner.nextLine().toLowerCase();
			System.out.println("Entrez les caractère à purger : ");
			characters = scanner.nextLine().toLowerCase();
			System.out.println(purge(chaine, characters));
		scanner.close();

	}

}
