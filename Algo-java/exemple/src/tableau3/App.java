package tableau3;
import java.util.Scanner; 
public class App {

	public static void main(String[] args) {
		int length, counter = 1, posCount = 0, negCount = 0, zeroCount = 0;
		
		Scanner scanner = new Scanner(System.in);
			System.out.println("Saisissez la taille du tableau : ");
			length = scanner.nextInt();
			int[] numberArray = new int[length];
			
			for(int i = 0 ; i < numberArray.length ; i++) {
				System.out.println("Entrez la valeur num�ro " + counter);
				numberArray[i] = scanner.nextInt();
				if(numberArray[i] > 0) {
					posCount++;
				}else if(numberArray[i] < 0) {
					negCount++;
				}else {
					zeroCount++;
				}
				counter++;
			}
			
			System.out.println("Il y a dans le tableau " + posCount + " valeur(s) positive(s), " 
								+ negCount + " valeur(s) n�gative(s) et " 
								+ zeroCount + " fois z�ro");
		scanner.close();

	}

}
