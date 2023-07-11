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
				System.out.println("Combien d'accidents responsables");
				accidents = scanner.nextInt();
					if(accidents >=1) {
						tarif -= accidents;
					}
				System.out.println("Chez nous depuis combien de temps ?");
				anciennete = scanner.nextInt();
					if (anciennete >5) {
						tarif++;
					}
					
				System.out.println(tarif);
				
							
				if(tarif <0) {
					System.out.println("Nous refusons de vous assurer");
				}else if (tarif == 0) {
					System.out.println("Vous serez au tarif rouge");
				}else if (tarif == 1) {
					System.out.println("Vous serez au tarif orange");
				}else if (tarif == 2) {
					System.out.println("Vous serez au tarif vert");
				}else {
					System.out.println("Vous serez au tarif bleu");
				}
				
			scanner.close();

	}

}
