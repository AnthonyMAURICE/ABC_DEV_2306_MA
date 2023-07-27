package fonction2;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		int annee;
		
		Scanner scanner = new Scanner(System.in);
			System.out.println("Entrez une ann�e : ");
			annee = scanner.nextInt();
			System.out.println(bissextile(annee));
			
		scanner.close();
	}
	
	private static String bissextile(int a) {
		if (a % 4 != 0 || a % 4 == 0 && (a % 100 == 0 && a % 400 != 0)) {
			String bissextile = "L'ann�e n'est pas bissextile.";
			return bissextile;
		}else {
			String bissextile = "L'ann�e est bissextile.";
			return bissextile;
		}
	}

}
