package fonction8;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		int nombre;
		int i = 0;
		Scanner scanner = new Scanner(System.in);
			
			System.out.println("[La suite de Fibonacci]");
			
			do { // boucle "do while" pour lancer le programme même quand nombre n'est pas encore définit
				System.out.println("\nCombien de nombres de la suite de Fibonacci souhaitez-vous afficher : "); 
				System.out.println("Appuyez sur la touche 0 pour quitter le programme");
				nombre = scanner.nextInt();
				if(nombre != 0) {// condition pour lancer le programme seulement si la saisie est différente de "0"
					if(nombre < 2) { // condition pour répondre au critère qu'au moins 2 nombres de la suite soient affichés
						nombre = 2;
					}
					long[] suite = new long[nombre];
					System.out.println("Les " + nombre + " premiers nombres de la suite de Fibonacci sont\n");
					suite = fonctionSuite(suite, i);
					for(long j : suite) {
						System.out.println("	" +j);
					}	
				}else {
					System.out.println("Fin du programme");
				}
			}while(nombre !=0);// puis la fin du "do while", boucle tant que nombre est différend de "0"
		
		scanner.close();
	}
	
	private static long[] fonctionSuite(long[] array, int a) {
		long[] suite = array;
		if(a < suite.length) {
			if(a < 2) {
				suite[a] = a;
			}else {
				suite[a] = suite[a - 1] + suite[a - 2];
			}
			a++;
			fonctionSuite(suite, a);
		}
		return suite;
	}
}