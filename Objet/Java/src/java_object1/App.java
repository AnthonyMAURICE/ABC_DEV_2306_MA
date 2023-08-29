package java_object1;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		double water;
		Scanner scanner = new Scanner(System.in);
			//Bottle waterBottle = new Bottle();
			Bottle waterBottle2 = new Bottle(1.5, 1.25, true, "Eau Minérale");
		
			boolean test1 = waterBottle2.fermer();	
			boolean test2 = waterBottle2.ouvrir();
			boolean test3 = waterBottle2.remplirTout();
			boolean test4 = waterBottle2.viderTout();
			
			
			System.out.println("Remplir de combien ?");
			water = scanner.nextDouble();
			boolean test5 = waterBottle2.remplir(water);
			
			System.out.println("Vider de combien ?");
			water = scanner.nextDouble();
			boolean test6 = waterBottle2.vider(water);
								
						

			
		scanner.close();
	}
}
