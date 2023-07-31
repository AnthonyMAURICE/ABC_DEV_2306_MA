package fonction3;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		int day, month, year;
		boolean isValid = false;
		
		Scanner scanner = new Scanner(System.in);
		
			System.out.println("Saisissez le numÈro du jour : ");
			day = scanner.nextInt();
			System.out.println("Saisissez le numÈro du mois : ");
			month = scanner.nextInt();
			System.out.println("Saisissez le numÈro de l'annÈe : ");
			year = scanner.nextInt();
		
			isValid = validDay(day, month, year);
		
			if(isValid) {
				System.out.println("La date est valide");
			}else {
				System.out.println("La date n'est pas valide");
			}
		
		
		scanner.close();

	}
	
	private static boolean validDay(int a, int b, int c) {
		boolean valid = false;
		if(a == 31 && (b == 2 || b == 4 || b == 6 || b == 9 || b == 11)) { // contr√¥le les mois √† 30 jours
			valid = false;
		}else if (b == 2 && a >29) { // contr√¥le le mois de f√©vrier
			valid = false;
		}else if(b == 2 && a >= 29 && (c % 4 != 0 || c % 4 == 0 && (c % 100 == 0 && c % 400 != 0))) { // contr√¥le les ann√©es bissextiles
			valid = false;
		}else { // et si cela arrive jusqu'√† cette condition, la date est valide
			valid = true;
		}
		
		return valid;
	}

}
