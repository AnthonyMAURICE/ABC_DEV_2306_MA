package addingLoop;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		int nombre, temp = 0;

		Scanner scanner = new Scanner(System.in);
			System.out.println("Saisissez un nombre, nous calculerons la somme des entiers jusque celui-ci.");
			nombre = scanner.nextInt();
			
			for(int i = 0; i <= nombre; i++) {
				temp +=i;
			}
			
			System.out.println("La somme des entiers jusque : " + nombre + " donne : " + temp);
		
		scanner.close();

	}

}
