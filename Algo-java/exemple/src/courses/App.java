package courses;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int shops = 0;
		double somme, money;
		
		Scanner scanner = new Scanner(System.in);
			System.out.println("Quelle est la somme de depart ?");
			somme = scanner.nextDouble();
			money = somme;
			if(somme >= 1) {
				while(somme>2) {
					somme = somme / 2 - 1;
					shops ++;
				}
				shops++;
				System.out.println("Avec la somme de depart de : " + money + ", Barnabe a fait ses courses dans " + shops + " magasins.");
			}else {
				System.out.println("Barnabé n'a pu faire ses courses das aucun magasin.");
			}
	
		scanner.close();
	}

}
