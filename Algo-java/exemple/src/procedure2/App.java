package procedure2;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		double cote1, cote2, cote3;
		
		Scanner scanner = new Scanner(System.in);
			System.out.println("Saisissez les trois côtés du triangle : ");
			cote1 = scanner.nextDouble();
			cote2 = scanner.nextDouble();
			cote3 = scanner.nextDouble();
			
			perimAire(cote1, cote2, cote3);
		
		
		scanner.close();

	}
	
	private static void perimAire(double a, double b, double c) {
		double perimeter;
		double aire;
		
		perimeter = a + b + c;
		
		aire = Math.pow((perimeter /2 - a) * (perimeter / 2 - b) * (perimeter / 2 - c), 1/2);
		
		System.out.println("Le périmètre du triangle est de : " + perimeter + " et son aire de : " + Math.round(aire * 100.0) / 100.0);
	}

}
