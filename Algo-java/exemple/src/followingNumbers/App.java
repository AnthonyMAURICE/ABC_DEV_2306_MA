package followingNumbers;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		int nombre, counter;
		
		Scanner scanner = new Scanner(System.in);
			System.out.println("Saisissez un nombre");
				nombre = scanner.nextInt();
				counter = nombre + 1;
				
				System.out.println("Avec boucle while");
				
				while(counter <= nombre + 10) {
					System.out.print(counter + " ");
					counter++;
				}
		
				System.out.println("\nAvec boucle for");
				
				for(counter = nombre + 1; counter <= nombre + 10; counter++) {
					System.out.print(counter + " ");
				}
		
		scanner.close();

	}

}
