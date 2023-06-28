package tri1;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int a, b;
		System.out.println("Entrez la valeur de \"a\" : ");
		a = scanner.nextInt();
		System.out.println("Entrez la valeur de \"b\" : ");
		b = scanner.nextInt();
		if (a < b) {
			System.out.println("\"a\" est plus petit (" + a + ") que b (" + b + ")");
		}else {
			System.out.println("\"b\" est plus petit (" + b + ") que a (" + a + ")");
		}
		scanner.close();
	}

}
