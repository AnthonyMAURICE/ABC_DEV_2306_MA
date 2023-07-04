package tri2;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double a, b, c;
		
		Scanner scanner = new Scanner(System.in);
			System.out.println("Entrez le premier nombre : ");
			a = scanner.nextDouble();
			System.out.println("Entrez le second nombre : ");
			b = scanner.nextDouble();
			System.out.println("Entrez le troisieme nombre : ");
			c = scanner.nextDouble();
			
			if(c < b && a > c) {
				if(a < b) {
					System.out.println("La chaine reorganisee est \"c\" \"a\" \"b\" " + c + " " + a + " " + b);
				}else {
					System.out.println("La chaine reorganisee est \"c\" \"b\" \"a\" " + c + " " + b + " " + a);
				}
			
			}else if(a < b) {
				if(b < c) {
					System.out.println("La chaine reorganisee est  \"a\" \"b\" \"c\" : " + a + " " + b + " " + c);
				}else {
					System.out.println("La chaine reorganisee est \"a\" \"c\" \"b\" " + a + " " + c + " " + b);
				}	
			
			}else{
				if(a < c) {
					System.out.println("La chaine reorganisee est \"b\" \"a\" \"c\" " + b + " " + a + " " + c);
				}else {
					System.out.println("La chaine reorganisee est \"b\" \"c\" \"a\" " + b + " " + c + " " + a);
				}
			}
			
		scanner.close();
	}

}
