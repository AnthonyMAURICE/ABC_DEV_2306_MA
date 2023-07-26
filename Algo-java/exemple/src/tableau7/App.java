package tableau7;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		int length, counter = 1;
		boolean check = false;
		
		Scanner scanner = new Scanner(System.in);
		while(!check) {
			System.out.println("Saisissez la taille du tableau (entre 2 et 25) : ");
			length = scanner.nextInt();
			if(length > 1 && length <= 25) {
				check = true;
				int[] numberArray = new int[length];
				for(int i = 0; i < numberArray.length; i++) {
					System.out.println("Entrez la valeur numéro " + counter);
					numberArray[i] = scanner.nextInt() + 1;
					counter++;
				}
				System.out.print("Les valeurs entrées auxquelles on a ajouté 1 donnent : ");
				for(int j : numberArray) {
					System.out.print(j + " ");
				}
			}else {
				System.out.println("Saisie incorrecte ! Recommencez !");
			}
		}
			
		scanner.close();

	}

}
