package tableau7;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		int length, counter = 1;
		
		Scanner scanner = new Scanner(System.in);
			System.out.println("Saisissez la taille du tableau : ");
			length = scanner.nextInt();
			int[] numberArray = new int[length];
			for(int i = 0; i < numberArray.length; i++) {
				System.out.println("Entrez la valeur numéro " + counter);
				numberArray[i] = scanner.nextInt() + 1;
				counter++;
			}
			
			for(int j : numberArray) {
				System.out.print(j + " ");
			}
		
		scanner.close();

	}

}
