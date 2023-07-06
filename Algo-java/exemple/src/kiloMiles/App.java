package kiloMiles;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			double  kilo = 0;
			double	miles;
			String kiloError;
			boolean legit = false;
			
		Scanner scanner = new Scanner(System.in);
			while (legit == false) {
				System.out.println("Entrez le nombre de kilometres : ");
				if (scanner.hasNextDouble()) {
					kilo = scanner.nextDouble();
					if (kilo < 0.01 || kilo > 1000000) {
						System.out.println("Entree invalide !");
					}else {
						legit = true;
						scanner.close();
					}
				}else {
					kiloError = scanner.next();
					if (kiloError.equals("q")) {
						System.exit(0);
					}else {
						System.out.println("Entree invalide !");
					}
				}
			}
			
			miles = kilo*0.62;
			System.out.println(kilo + "km donne : " + miles + " miles");		
		
	}

}
