package fonction8;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		int nombre;
		Scanner scanner = new Scanner(System.in);
			
			System.out.println("[La suite de Fibonacci]");
			
			do { // boucle "do while" pour lancer le programme même quand nombre n'est pas encore définit
				System.out.println("\nCombien de nombres de la suite de Fibonacci souhaitez-vous afficher : "); 
				System.out.println("Appuyez sur la touche 0 pour quitter le programme");
				nombre = scanner.nextInt();
				if(nombre != 0) {// condition pour lancer le programme seulement si la saisie est différente de "0"
					for (int i = 0; i <= nombre; i++) {
			            long number = fonctionSuite(i);
			            System.out.println("	" + number);
			        }
				}else {
					System.out.println("Fin du programme");
				}
			}while(nombre !=0);// puis la fin du "do while", boucle tant que nombre est différend de "0"
		
		scanner.close();
	}
	
	private static long fonctionSuite(int a) {
		if (a == 0) {
            return 0;
		}else if (a == 1) {
            return 1;
		}else {
            return fonctionSuite(a - 1) + fonctionSuite(a - 2);
        }
	}
}