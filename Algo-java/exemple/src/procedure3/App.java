package procedure3;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		String chaine;
		Scanner scanner = new Scanner(System.in);
			System.out.println("entrez une chaine de caractères");
			chaine = scanner.nextLine();
			//inversionChaine(chaine);
			
			System.out.println(inverted(chaine));
		scanner.close();
	}
	
	// avec une procédure
	/*
	private static void inversionChaine(String origin) {
		String reversed = "";
				
		for(int i = 0; i < origin.length() ; i++) {
			reversed = origin.charAt(i) + reversed;
		}
		
		System.out.println(reversed);

	}
	*/
	
	// avec une fonction
	private static String inverted(String origin) {
		String reversed = "";
		for(int i = 0; i < origin.length() ; i++) {
			reversed = origin.charAt(i) + reversed;
		}
		return reversed;
	}
}