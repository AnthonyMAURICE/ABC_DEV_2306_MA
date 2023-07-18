package euros;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		
		int somme = 0, prix = 0, tempPrix = 0;
		boolean shopping = true, checkout = false, payment = false;
		
		Scanner scanner = new Scanner(System.in);
			while(shopping) {
				System.out.println("Prix du produit (entrez 0 pour terminer vos achats)");
				tempPrix = scanner.nextInt();
				if(tempPrix != 0) {
					prix += tempPrix;
				}else {
					shopping = false;
				}
			}
			
			System.out.println("Vous devez la somme de : " + prix + " euros");
			
			while(!checkout) {
				System.out.println("Entrez votre paiement : ");
				somme = scanner.nextInt();
				if(somme < prix) {
					System.out.println("Vous etes en dessous de ce que vous devez...");
				}else {
					checkout = true;
				}
			}
			
			while(!payment) {
				if (somme - prix > 10) {
					System.out.println("Je vous rends un billet de 10");
					somme -= 10;
				}else if(somme - prix > 5){
					System.out.println("Je vous rends un billet de 5");
					somme -= 5;
				}else if (somme - prix >= 1) {
					System.out.println("Je vous rends une piece de 1");
					somme -= 1;
				}else {
					System.out.println("Merci, revenez nous voir !");
					payment = true;
				}
			}
		
		scanner.close();
	}

}
