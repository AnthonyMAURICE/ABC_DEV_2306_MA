package procedure2;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		double cote1, cote2, cote3, perimeter, aire;
		
		Scanner scanner = new Scanner(System.in);
			System.out.println("Saisissez les trois côtés du triangle : ");
			cote1 = scanner.nextDouble();
			cote2 = scanner.nextDouble();
			cote3 = scanner.nextDouble();
			
			//perimAire(cote1, cote2, cote3);
			perimeter = perimCalc(cote1, cote2, cote3);
			
			aire = aireCalc(cote1, cote2, cote3);
		
		
		System.out.println("Le périmètre du triangle est de : " + perimeter + " et son aire de : " + aire);
		scanner.close();

	}
	/*
	private static void perimAire(double a, double b, double c) {
		double perimeter, demiperimeter, aire;
		
		perimeter = a + b + c;
		demiperimeter = perimeter / 2;
		
		aire = Math.sqrt(demiperimeter * ((demiperimeter - a) * (demiperimeter - b) * (demiperimeter - c)));
		
		System.out.println("Le périmètre du triangle est de : " + perimeter + " et son aire de : " + Math.round(aire * 100.0) / 100.0);
	}
	*/
	private static double perimCalc (double a, double b, double c) {
		double perimeter;
		perimeter = a + b + c;
		return perimeter;
	}
	
	private static double aireCalc (double a, double b, double c) {
		double aire, d;
		d = perimCalc(a, b, c) / 2;
		aire = Math.sqrt(d * ((d - a) * (d - b) * (d - c)));
		return Math.round(aire * 100.0)/ 100.0;
	}

}
