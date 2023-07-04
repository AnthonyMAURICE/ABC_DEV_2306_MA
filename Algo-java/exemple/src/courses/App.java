package courses;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s, shops = 0, money;
		
		
		Scanner scanner = new Scanner(System.in);
			System.out.println("Quelle est la somme de depart ?");
			s = scanner.nextInt();
			money = s;
			if(s > 1) {
				while(s>3) {
					s = s / 2 + 1;
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
