package fonction2;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		int annee;
		
		Scanner scanner = new Scanner(System.in);
			System.out.println("Entrez une année : ");
			annee = scanner.nextInt();
			System.out.println(bissextile(annee));
			
		scanner.close();
	}
	
	private static String bissextile(int a) {
		String bissextile = "";
		if ((a%4 == 0 && a%100 != 0) || a%400 == 0){
			bissextile = "L'année n'est pas bissextile.";			
		}else {
			bissextile = "L'année est bissextile.";
		}
		return bissextile;
	}

}
