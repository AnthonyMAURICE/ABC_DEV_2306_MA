package heure1;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		int heure, minutes;
		String ajustement;
		
		Scanner scanner = new Scanner(System.in);
			System.out.println("Entrez une heure : ");
			heure = scanner.nextInt();
			System.out.println("Entrez les minutes : ");
			minutes = scanner.nextInt();
			
			minutes++;
			
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
					
			System.out.println("Dans une minute il sera : " + heure + "h" + ajustement +  minutes);
		
		scanner.close();
	}

}
