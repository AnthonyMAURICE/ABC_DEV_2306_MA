package procedure3;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		String chaine;
		Scanner scanner = new Scanner(System.in);
			System.out.println("entrez une chaine de caractères");
			chaine = scanner.nextLine();

			inversionChaine(chaine);
		scanner.close();
	}

	private static void inversionChaine(String origin) {
		char[] reversed = new char[origin.length()];
		int j = 0;
		
		for(int i = origin.length()-1; i >= 0; i--) {
			reversed[j] = origin.charAt(i);
			j++;
		}
		
		System.out.println(reversed);

	}
}
