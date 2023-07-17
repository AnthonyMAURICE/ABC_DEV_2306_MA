package heure2;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		int heure = 0, minutes = 0, secondes = 0;
		String ajustement;
		boolean realistic = false;
		
		Scanner scanner = new Scanner(System.in);
			while(!realistic) {
				System.out.println("Entrez une heure : ");
				heure = scanner.nextInt();
				System.out.println("Entrez les minutes : ");
				minutes = scanner.nextInt();
				System.out.println("Entrez les secondes : ");
				secondes = scanner.nextInt();
				if(heure >=0 && heure < 24 && minutes > 0 && minutes < 60 && secondes >=0 && secondes < 60) {
					realistic = true;
				}else {
					System.out.println("Entrez une heure valide !");
				}
				
			}
			secondes++;
			
			if (secondes == 60) {
				minutes++;
				secondes = 0;
			}
			
			if (minutes == 60) {
				heure++;
				minutes = 0;
			}
			
			if(heure == 24) {
				heure = 0;
			}
			
			if(minutes < 10) {
				ajustement = "0";
			}else {
				ajustement = "";
			}
			
					
			System.out.println("Dans une seconde il sera : " + heure + "h" + ajustement +  minutes + " et " + secondes + " seconde(s)");
		
		scanner.close();
	}

}
