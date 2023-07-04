package caracteres;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		String chaine = "";
		char letter;
		char comp;
		int count = 0;
		int comparison;
		boolean legit = false;

		Scanner scanner = new Scanner(System.in);
			while (legit == false) { 
				System.out.println("Entrez un mot ou une phrase : ");	
					if (scanner.hasNextLine()) {
						legit = true;
						chaine = scanner.nextLine() + ".";
					}else {
						System.out.println("Entree non conforme");
					}
			}
			
			if (chaine.equals("") || chaine.equals(".")) {
				System.out.println("LA CHAINE EST VIDE");		
			}else {	
				System.out.println("Entrez une letter pour la comparaison : ");
				comp = (scanner.next().charAt(0));
				for (int i = 0; i < chaine.length(); i++) {
					letter = chaine.charAt(i);
					comparison =Character.compare(letter, comp);
					if(comparison == 0){
						count += 1;
					}
				}
					
				if(count >= 1) {
					System.out.println("Le caractere " + comp + " est present " + count + " fois dans la chaine de caractere testee.");
				}else{
					System.out.println("Le caractere " + comp + " n'est pas present.");
				}
			}
		
		scanner.close();
	}

}
