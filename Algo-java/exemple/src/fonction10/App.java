package fonction10;

import java.util.Scanner;

public class App {
	
	private static int voyelles(String origin) {
		char letter, compare;
		int voyelles = 0;
		String list = "aeiouy";
		for(int i = 0; i < origin.length(); i++) {
			letter = origin.charAt(i);
			for(int j = 0; j < list.length(); j++) {
				compare = list.charAt(j);
				if (letter == compare) {
					voyelles++;
				}
			}
			
		}
		return voyelles;

	}

	public static void main(String[] args) {
		String chaine;
		
		Scanner scanner = new Scanner(System.in);
			System.out.println("Entrez une chaine de caractères.");
			chaine = scanner.nextLine();
			System.out.println("Dans cette chaine de caractères : " + voyelles(chaine) + " voyelles");
		scanner.close();

	}

}
