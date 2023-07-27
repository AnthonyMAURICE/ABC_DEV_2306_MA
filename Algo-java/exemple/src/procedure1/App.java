package procedure1;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		int a, b;
		Scanner scanner = new Scanner(System.in);
			System.out.println("Saisissez la valeur de \"a\"");
			a = scanner.nextInt();
			System.out.println("Saisissez la valeur de \"b\"");
			b = scanner.nextInt();
			
			System.out.println("a avant inversion : " + a + " et b avant inversion : " + b);
			
			inversion(a, b);
			
		scanner.close();
	}
	
	private static void inversion(int a, int b) {
		int temp;
		temp = a;
		a = b;
		b = temp;
		System.out.println("a après inversion : " + a + " et b après inversion : " + b);
	}

}
