package bissextile;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int annee;
		
		Scanner scanner = new Scanner(System.in);
			System.out.println("Entrez une annee : ");		
			if (scanner.hasNextInt()) {
				annee = scanner.nextInt();
				if (annee % 4 != 0 || annee % 4 == 0 && (annee % 100 == 0 && annee % 400 != 0)) {
					System.out.println("L'annee " + annee + " n'est pas bissextile.");
				}else {
					System.out.println("L'annee " + annee + " est bissextile.");
				}
			}else {
				System.out.println("Vous n'avez pas saisi un nombre !");
			}
		
		scanner.close();
	}

}
