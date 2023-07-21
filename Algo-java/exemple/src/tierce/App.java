package tierce;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		int chevauxPartants = 0, chevauxJoues = 0, factorielleN = 1, factorielleP = 1, factorielleNP = 1, x, y;
		boolean verif = false;
		
		Scanner scanner = new Scanner(System.in);
		
			// saisie et contrôle des valeurs
			while(!verif) {
				System.out.println("Entrez le nombre de chevaux partants : ");
				chevauxPartants = scanner.nextInt();
				System.out.println("Entrez le nombre de chevaux joués : ");
				chevauxJoues = scanner.nextInt();
				
				if (chevauxJoues > chevauxPartants) {
					System.out.println("Entrez des nombres de chevaux joués inférieurs a ceux partants : ");
				}else {
					verif = true;
				}
				
			}
			
			// calcul des factorielles
			for(int i = 2; i <= chevauxPartants; i++) {
				factorielleN = factorielleN * i;
			}
			
			for(int j = 2; j <= chevauxJoues; j++) {
				factorielleP = factorielleP * j;
			}
				
			for(int k = 2; k <= (chevauxPartants - chevauxJoues); k++) {
				factorielleNP = factorielleNP * k;
			}
			
			//stockage des calculs dans les variables pour restitution par la suite dans la console
			x = factorielleN / factorielleNP;
			y = factorielleN / (factorielleP * factorielleNP);
			
			System.out.println("Vous avez dans l'ordre : 1 chance sur " + x + " et dans le désordre : 1 chance sur " + y + " de gagner");
		
		scanner.close();
		

	}

}