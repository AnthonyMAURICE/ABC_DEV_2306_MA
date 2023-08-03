package fonction2;

import java.util.Scanner;

public class App {

	/*
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
			bissextile = "L'année est bissextile.";			
		}else {
			bissextile = "L'année n'est pas bissextile.";
		}
		return bissextile;
	}
	*/
	
	public static void main(String[] args) {
		int annee;
		
		Scanner scanner = new Scanner(System.in);
			System.out.println("Entrez une année : ");
			annee = scanner.nextInt();
			if(bissextile(annee)) {
				System.out.println("L'année est bissextile.");
			}else {
				System.out.println("L'année n'est pas bissextile.");
			}
			
		scanner.close();
	}
	
	private static boolean bissextile(int a) {
		return (a%4 == 0 && a%100 != 0) || a%400 == 0;
	}

}
