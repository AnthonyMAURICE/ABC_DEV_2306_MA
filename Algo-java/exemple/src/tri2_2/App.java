package tri2_2;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {

double a, b, c, d;
		
		Scanner scanner = new Scanner(System.in);
			System.out.println("Entrez le premier nombre : ");
			a = scanner.nextDouble();
			System.out.println("Entrez le second nombre : ");
			b = scanner.nextDouble();
			System.out.println("Entrez le troisieme nombre : ");
			c = scanner.nextDouble();
			
			if(a > c) {
				d = c;
				c = a;
				a = d;
			}
			
			if(a > b) {
				d = b;
				b = a;
				a = d;
			}
			
			if(b > c) {
				d = c;
				c = b;
				b = d;
			}

			System.out.println("Les valeurs reorganisees dans l'ordre croissant donnent : \"a\" = " + a + ", \"b\" = " + b + " et \"c\" = " + c);
			
			
		scanner.close();
	}

}
