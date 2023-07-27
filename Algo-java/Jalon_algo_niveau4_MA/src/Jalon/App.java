package Jalon;

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
					
					
					
					if(nombre < 2) { // condition pour répondre au critère qu'au moins 2 nombres de la suite soient affichés
						nombre = 2;
					}
					
					System.out.println("Les " + nombre + " premiers nombres de la suite de Fibonacci sont\n");
			
					int[]suite = new int[nombre]; // déclaration du tableau avec en longueur la saisie utilisateur
					
					for(int i = 0 ; i < suite.length; i++) { // boucle for pour calculer et afficher la suite selon le nombre choisi
						if(i < 2) { // condition pour que les deux premiers nombres soient définis
							suite[i] = i;
						}else { // puis les suivants sont calculés en fonction des deux nombres précédents
							suite[i] += suite[i-1] + suite[i-2];
						}
						System.out.println("	" +suite[i]); // affichage de la suite, nombre après nombre (avec une tabulation pour respecter la capture d'écran)
					}
				
					System.out.println("\n" + nombre + " nombres affichés");
				}else {
					System.out.println("Fin du programme");
				}
			}while(nombre !=0);// puis la fin du "do while", boucle tant que nombre est différend de "0"
		
		scanner.close();

	}

}
