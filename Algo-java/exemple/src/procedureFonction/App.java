package procedureFonction;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		String name, hello;
		//int nombre1, nombre2, nombre3;
		
		Scanner scanner = new Scanner(System.in);
			/*
			System.out.println("Saisissez 2 nombres : ");
			nombre1 = scanner.nextInt();
			nombre2 = scanner.nextInt();
		
			procedureExemple(nombre1, nombre2);
			
			nombre3 = fonctionExemple(nombre1, nombre2);
			
			System.out.println("Leur addition donne : " +nombre3);
			
			nombre3 = fonctionExemple(nombre1, nombre3);
			
			System.out.println("Leur addition donne : " +nombre3);
			*/
			System.out.println("Entrez votre nom : ");
			
			name = scanner.nextLine();
			
			hello = helloWorld(name);
			
			System.out.println(hello);
			
		scanner.close();
	}
	
	/*
	private static void procedureExemple(int a, int b) {
		int c = a +b;
		System.out.println("Leur addition donne : " + c);
	}
	
	private static int fonctionExemple(int a, int b) {
		int c = a + b;
		return c;
	}
	*/
	private static String helloWorld(String a) {
		String helloName = "Salut ";
		return helloName + a;
		
	}

}
