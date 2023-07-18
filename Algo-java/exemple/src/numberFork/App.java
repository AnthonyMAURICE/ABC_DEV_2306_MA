package numberFork;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		
		int number;
		boolean right = false;
		
		Scanner scanner = new Scanner(System.in);
			while(!right) {
				System.out.println("Entrez un nombre entre 1 et 3 : ");
				number = scanner.nextInt();
				if(number <1 || number > 3) {
					System.out.println("Saisie incorrecte, veuillez recommencer.");
				}else {
					right = true;
				}
			}
			
			System.out.println("Nombre conforme, merci.");
			scanner.close();
	}

}
