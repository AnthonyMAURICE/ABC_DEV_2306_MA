package bissextile;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a;
		
		Scanner scanner = new Scanner(System.in);
			System.out.println("Entrez une annee : ");
			a = scanner.nextInt();
			
			if (a % 4 != 0 || a % 4 == 0 && (a % 100 == 0 && a % 400 != 0)) {
				System.out.println("L'annee " + a + " n'est pas bissextile.");
			}else {
				System.out.println("L'annee " + a + " est bissextile.");
			}
		
		scanner.close();
	}

}
