package diviseur;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int divi;
		
		Scanner scanner = new Scanner(System.in);
			System.out.println("Entrez un nombre : ");
			divi = scanner.nextInt();
			System.out.println("Les diviseurs de " + divi + " sont : ");
			for(int i = 2; i < divi; i++) {
				if (divi % i == 0) {
					System.out.print(i + " ");
				}
			}
		
		scanner.close();
	}

}
