package fonction9;

import java.util.Scanner;



public class App {

	private static int somme(int a, int b, int c, int d, int e) {
		int sum = a + b + c + d + e;
		return sum;
	}
	
	public static void main(String[] args) {
		int nb1, nb2, nb3, nb4, nb5;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Saisissez le nombre 1 : ");
		nb1 = scanner.nextInt();
		System.out.println("Saisissez le nombre 2 : ");
		nb2 = scanner.nextInt();
		System.out.println("Saisissez le nombre 3 : ");
		nb3 = scanner.nextInt();
		System.out.println("Saisissez le nombre 4 : ");
		nb4 = scanner.nextInt();
		System.out.println("Saisissez le nombre 5 : ");
		nb5 = scanner.nextInt();
		
		System.out.println("La somme de ces nombres donne : " + somme(nb1, nb2, nb3, nb4, nb5));
		
		scanner.close();

	}

}
