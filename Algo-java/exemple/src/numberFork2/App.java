package numberFork2;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		int number;
		boolean right = false;
		
		Scanner scanner = new Scanner(System.in);
			while(!right) {
				System.out.println("Saisissez un nombre entre 10 et 20");
				number = scanner.nextInt();
				if(number < 10) {
					System.out.println("Plus grand !");
				}else if (number >20) {
					System.out.println("Plus petit !");
				}else {
					System.out.println("Saisie conforme");
					right = true;
				}
			}
		
		
		scanner.close();

	}

}
