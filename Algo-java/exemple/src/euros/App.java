package euros;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		
		int somme = 0, prix = 0, tempPrix = 0, bill10 = 0, bill5 = 0, p1 = 0;
		
		Scanner scanner = new Scanner(System.in);
			
			do {
				System.out.println("Prix du produit (entrez 0 pour terminer vos achats)");
				tempPrix = scanner.nextInt();
				prix += tempPrix;
			}while(tempPrix != 0);
			
			do {
				System.out.println("Vous devez la somme de : " + prix + " euros");
				System.out.println("Entrez le montant de votre paiement : ");
				somme = scanner.nextInt();
				if(somme < prix) {
					System.out.println("Vous etes en dessous de ce que vous devez...");
				}
			}while (somme < prix);
			
			while(somme - prix != 0) {
				if (somme - prix >= 10) {
					bill10++;
					somme -= 10;
				}else if(somme - prix >= 5){
					bill5++;
					somme -= 5;
				}else{
					p1++;
					somme--;
				}
			}
			System.out.println("Le magasin vous rend " + bill10 + " billets de 10E, " + bill5 + " billets de 5E et " + p1 + " pieces de 1E.");
			System.out.println("Merci, revenez nous voir !");
		
		scanner.close();
	}

}
