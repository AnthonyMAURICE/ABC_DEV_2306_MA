package jalon;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		int nombre, multiplicateur, resultat;
		String reload = "o";
		
		Scanner scanner = new Scanner(System.in);
			
			do {
				System.out.println("Saisir un nombre entre 1 et 10");
				nombre = scanner.nextInt();
				if(nombre < 10 && nombre > 1) {
					for(multiplicateur = 0; multiplicateur <= 10; multiplicateur++) {
						resultat = nombre * multiplicateur;
						System.out.println(multiplicateur + " * " + nombre + " = " + resultat);
					}
					System.out.println("Souhaitez-vous afficher une autre table ? Oui(O) ou Non(N)");
					reload = scanner.next().toLowerCase();
				}else {
					System.out.println("Vous avez saisi un nombre hors parametres, veuillez recommencer.");
				}
			}while(reload.equals("o"));
		
			System.out.println("Fin du programme");
		scanner.close();
	}

}