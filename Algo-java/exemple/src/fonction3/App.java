package fonction3;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		int day, month, year;
		boolean isValid = false;
		
		Scanner scanner = new Scanner(System.in);
		
			System.out.println("Saisissez le numéro du jour : ");
			day = scanner.nextInt();
			System.out.println("Saisissez le numéro du mois : ");
			month = scanner.nextInt();
			System.out.println("Saisissez le numéro de l'année : ");
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
		boolean valid = false, cas1, cas2, cas3, cas4;
		boolean bissextile;
		bissextile = (c%4 == 0 && c%100 != 0) || c%400 == 0;
		cas1 = (b == 1 || b == 3 || b == 5 || b == 8 || b == 10 || b == 12) && (a >= 1 && a <= 31);
		cas2 = (b == 4 || b == 6 || b == 9 || b == 11) && (a >= 1 && a <= 30);
		cas3 = b == 2 && bissextile  && a >= 1 && a <= 29;
		cas4 = b == 2 && a >= 1 && a <= 28;
		
		if(cas1 || cas2 || cas3 || cas4){
			valid = true;
		}
		else{
			valid = false;
		}
		return valid;
	}

}
