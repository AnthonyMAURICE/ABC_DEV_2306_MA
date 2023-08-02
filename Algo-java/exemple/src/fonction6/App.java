package fonction6;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nombre1, nombre2;
		Scanner scanner = new Scanner(System.in);
			System.out.println("Entrez le premier nombre : ");
			nombre1 = scanner.nextInt();
			System.out.println("Entrez le deuxième nombre : ");
			nombre2 = scanner.nextInt();
			if (divisible(nombre1, nombre2)) { // fonction passée en paramètre de condition
				System.out.println(nombre1 + " est divisible par " + nombre2);
			}else {
				System.out.println(nombre1 + " n'est pas divisible par " + nombre2);
			}
		scanner.close();
	}
	
	private static boolean divisible(int a, int b) {
		
		if(a%b == 0) {
			return true;
		}else {
			return false;
		}
	}

}
