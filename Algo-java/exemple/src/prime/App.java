package prime;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number;
		boolean isPrime = true;
		
		Scanner scanner = new Scanner (System.in);
			System.out.println("Entrez un nombre : ");
			number = scanner.nextInt();
			
			if(number < 2) { // si number est inferieur à 2
				isPrime = false; // mets isPrime à false d'office 
			}else { // sinon passe dans la boucle for
				for (int i = 2 ; i < number ; i++) {
					if (number % i == 0) { // si un modulo est détecté
						isPrime = false; // renvoit isPrime à false
					}
				}
			}
			
			if (isPrime == true) { // condition sur le booléen
				System.out.println("C'est un nombre premier");
			}else {
				if(number >0) { // détecte si le nombre entré est supérieur à 0
					System.out.println("Ce n'est pas un nombre premier");
				}else { // sinon, renvoit ce message
					System.out.println("Vous avez entre un nombre negatif ou egal a 0");
				}
			}
			
		scanner.close();
		
	}

}
