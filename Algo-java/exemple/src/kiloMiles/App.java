package kiloMiles;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		
			double  kilo = 0;
			double	miles = 0;
			String kiloError;
			String quit = "q";
			boolean end = false;
			
		Scanner scanner = new Scanner(System.in);
			while (!end) {
				System.out.println("Entrez le nombre de kilometres entre 0.01 et 1.000.000 (ou entrez \"q\" ou \"Q\" pour quitter) : ");
				if (scanner.hasNextDouble()) { // méthode qui "détecte" le type de la saisie et renvoit "true" ou "false" selon le type renseigné
					kilo = scanner.nextDouble(); // ici, un double
					if (kilo < 0.01 || kilo > 1000000) {
						System.out.println("Entree invalide !");
					}else {
						miles = Math.round((kilo/1.609)*100.0)/100.0;
						System.out.println(kilo + "km donne : " + miles + " miles");	
					}
				}else { // les autres types passent dans le else, comme ici une chaine de caractères
					kiloError = scanner.next().toLowerCase();
					if (kiloError.equals(quit)) {
						end = true; // quitte le programme
					}else {
						System.out.println("Entree invalide !");
					}
				}
			}			
			scanner.close();		
	}
}