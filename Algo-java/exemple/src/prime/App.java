package prime;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number;
		boolean isPrime = true;
		
		Scanner scanner = new Scanner (System.in);
			System.out.println("Entrez un nombre : ");
			number = scanner.nextInt();
			for (int i = 2 ; i < number ; i++) {
				if (number % i == 0) {
					isPrime = false;
				}
			}
			
			if (isPrime == true) {
				System.out.println("C'est un nombre premier");
			}else {
				System.out.println("Ce n'est pas un nombre premier");
			}
		
		scanner.close();
	}

}
