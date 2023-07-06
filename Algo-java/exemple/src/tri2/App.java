package tri2;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double a, b, c;
		String message = "La chaine reorganisee est ";
		
		Scanner scanner = new Scanner(System.in);
			System.out.println("Veuillez entrer trois nombres différents.");
			System.out.println("Entrez le premier nombre (a) : ");
			a = scanner.nextDouble();
			System.out.println("Entrez le second nombre (b) : ");
			b = scanner.nextDouble();
			System.out.println("Entrez le troisieme nombre (c) : ");
			c = scanner.nextDouble();
			
			if (a == b && b == c ) {
				System.out.println("Les trois nombres sont egaux, veuillez recommencer...");
			}else if (a == b || a == c || b == c){
				System.out.println("Il y a des valeurs egales dans votre saisie, veuillez recommencer...");
			}else {			
				if(c < b && c < a) {
					if(a < b) {
						System.out.println(message + "\"c\" \"a\" \"b\" " + c + " " + a + " " + b);
					}else {
						System.out.println(message + "\"c\" \"b\" \"a\" " + c + " " + b + " " + a);
					}
				}else if(a < b) {
					if(b < c) {
						System.out.println(message + " \"a\" \"b\" \"c\" : " + a + " " + b + " " + c);
					}else {
						System.out.println(message + "\"a\" \"c\" \"b\" " + a + " " + c + " " + b);
					}	
				}else{
					if(a < c) {
						System.out.println(message + "\"b\" \"a\" \"c\" " + b + " " + a + " " + c);
					}else {
						System.out.println(message + "\"b\" \"c\" \"a\" " + b + " " + c + " " + a);
					}
				}
			}	
		scanner.close();
	}

}
