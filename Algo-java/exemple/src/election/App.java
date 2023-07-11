package election;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		double score1, score2, score3, score4, scoreGlobal;
		boolean legit;
		
		Scanner scanner = new Scanner(System.in);
		
		do {
			System.out.println("Saisissez le score du candidat 1");
			score1 = scanner.nextDouble();
			System.out.println("Saisissez le score du candidat 2");
			score2 = scanner.nextDouble();
			System.out.println("Saisissez le score du candidat 3");
			score3 = scanner.nextDouble();
			System.out.println("Saisissez le score du candidat 4");
			score4 = scanner.nextDouble();
			
			scoreGlobal = score1 + score2 + score3 +score4;
			if(scoreGlobal > 100) {
				System.out.println("Il y a manifestement bourrage d'urnes...");
				legit = false;
			}else {
				legit = true;
			}
			
		}while(legit == false);
		
		if(score1 > 50) {
			System.out.println("Le candidat 1 a ete reelu au premier tour avec " + score1 + "% des voix");
		}else if (score1 > 12.5) {
			if (score1 > score2 && score1 > score3 && score1 > score4) {
				System.out.println("Le candidat 1 est qualifie au second tour en ballotage favorable");
			}else {
				System.out.println("Le candidat 1 est qualifie au second tour en ballotage defavorable");
			}
		}else {
			System.out.println("Le candidat 1 est battu au premier tour");
		}
		
		scanner.close();
	}

}
