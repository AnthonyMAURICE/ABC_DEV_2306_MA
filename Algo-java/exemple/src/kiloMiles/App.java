package kiloMiles;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			double  kilo = 0;
			double	miles = 0;
			String kiloError;
			boolean legit = false;
			
		Scanner scanner = new Scanner(System.in);
			while (legit == false) {
				System.out.println("Entrez le nombre de kilometres entre 0.01 et 1.000.000 (ou entrez \"q\" ou \"Q\" pour quitter) : ");
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
					if ((kiloError.equals("q")) || (kiloError.equals("Q"))) {
						System.exit(0);
					}else {
						System.out.println("Entree invalide !");
					}
				}
			}
			
			miles = Math.round((kilo/1.609)*100.0)/100.0;
			System.out.println(kilo + "km donne : " + miles + " miles");		
		
	}
}