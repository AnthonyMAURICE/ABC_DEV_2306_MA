package assurance;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
			int age, permis, accidents, anciennete, tarif = 0;
			
			Scanner scanner = new Scanner(System.in);
				System.out.println("entrez votre age : ");
				age = scanner.nextInt();
					if(age < 18) {
						System.out.println("Vous n'avez pas l'age d'avoir le permis");
					}else if (age >= 25) {
						tarif++;
					}else {
						tarif +=0;
					}
				System.out.println("Depuis combien d'annees avez-vous le permis ?");
				permis = scanner.nextInt();
					if(permis > 2) {
						tarif++;
					}else {
						tarif +=0;
					}
			
			
			
			
			
			
			scanner.close();

	}

}
