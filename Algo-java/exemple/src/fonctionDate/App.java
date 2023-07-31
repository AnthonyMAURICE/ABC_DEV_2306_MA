package fonctionDate;


import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		int day, month;
		String year;
		
		
		Scanner scanner = new Scanner(System.in);
			System.out.println("Entrez le jour : ");
			day = scanner.nextInt();
			System.out.println("Entrez le mois : ");
			month = scanner.nextInt();
			System.out.println("Entrez l'année : ");
			year = scanner.next();
			

			
		scanner.close();
	}

}
