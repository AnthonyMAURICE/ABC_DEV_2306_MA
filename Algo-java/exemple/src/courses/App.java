package courses;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int somme, shops = 0, money;
		
		
		Scanner scanner = new Scanner(System.in);
			System.out.println("Quelle est la somme de depart ?");
			somme = scanner.nextInt();
			money = somme;
			if(somme > 1) {
				while(somme>2) {
					System.out.println(somme);
					somme = somme / 2 + 1;
					shops +=1;
				}
			}else {
				System.out.println("Entree invalide");
			}
			
			shops++;
			System.out.println("Avec la somme de depart de : " + money + ", Barnabe a fait ses courses dans " + shops + " magasins.");
		
		scanner.close();
	}

}
