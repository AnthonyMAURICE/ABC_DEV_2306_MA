package tri2;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double a, b, c, d;
		
		Scanner scanner = new Scanner(System.in);
			System.out.println("Entrez le premier nombre : ");
			a = scanner.nextDouble();
			System.out.println("Entrez le second nombre : ");
			b = scanner.nextDouble();
			System.out.println("Entrez le troisieme nombre : ");
			c = scanner.nextDouble();
			
			while(a > c) {
				d = c;
				c = a;
				a = d;
			}
			
			while(a > b) {
				d = b;
				b = a;
				a = d;
			}
			
			while(b > c) {
				d = c;
				c = b;
				b = d;
			}

			System.out.println("Les valeurs reorganisees donnent : \"a\" = " + a + ", \"b\" = " + b + " et \"c\" = " + c);
		scanner.close();
	}

}
