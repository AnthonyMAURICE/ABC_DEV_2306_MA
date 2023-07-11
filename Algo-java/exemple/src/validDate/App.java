package validDate;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		int day = 0, month = 0, year = 0;
		boolean infos = false;
		
		Scanner scanner = new Scanner(System.in);
		
		while(!infos) {
			System.out.println("Entrez une date. Pour commencer, le jour :  ");
			day = scanner.nextInt();
			System.out.println("Puis, le mois : ");
			month = scanner.nextInt();
			System.out.println("Et enfin l'annee");
			year = scanner.nextInt();
			
			if(day < 1 || day > 31) {
				System.out.println("Entree invalide, recommencez");
			}else {
				infos = true;
			}
		}
		
		if (infos == true) {
			
			if(day == 31 && (month == 2 || month == 4 || month == 6 || month == 9 || month == 11)) {
				System.out.println("Il n'y a pas de 31 ces mois. Date non valide.");
			}else if (month == 2 && day >29) {
				System.out.println("Il n'y a pas de 30 fevrier.");
			}else if(month == 2 && day >= 29 && (year % 4 != 0 || year % 4 == 0 && (year % 100 == 0 && year % 400 != 0))) {
				System.out.println("Ce n'est pas une annee bissextile. Date non valide.");
			}else {
				System.out.println("Cette date est valide");
			}
		}
		scanner.close();
	}

}
