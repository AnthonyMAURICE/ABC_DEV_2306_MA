package caracteres2;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		String chaine, comp;
		char letter;
		int count = 0;
		Scanner scanner = new Scanner(System.in);
			System.out.println("Entrez une chaine de caract�res : ");
			chaine = scanner.nextLine() + ".".toLowerCase();
			if(chaine.length() == 0) {
				System.out.println("Quelle lettre souhaitez vous rechercher ?");
				letter = scanner.next().charAt(0);
	
			
				for(int i = 0; i < chaine.length(); i++ ) {
					if(letter == chaine.charAt(i)) {
						count++;
					}
				}
				
				if(count == 0) {
					System.out.println("La lettre test�e n'est pas pr�sente dans la chaine de caract�res");
				}
			}
		scanner.close();

	}

}
