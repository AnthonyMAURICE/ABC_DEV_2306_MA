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
		double perimeter, demiperimeter;
		double aire;
		
		perimeter = a + b + c;
		demiperimeter = perimeter / 2;
		
		aire = Math.sqrt(demiperimeter * ((demiperimeter - a) * (demiperimeter - b) * (demiperimeter - c)));
		
		System.out.println("Le périmètre du triangle est de : " + perimeter + " et son aire de : " + Math.round(aire * 100.0) / 100.0);
	}

}
