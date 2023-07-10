package photocop;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		float price = 0;
		int copies;
		
		Scanner scanner = new Scanner(System.in);
			System.out.println("Combien de photocopies voulez-vous ?");
			copies = scanner.nextInt();
			for(int i = copies; i > 0; i--) {
				if(i > 30) {
					price += 0.08;
				}else if (i > 10 && i <= 30) {
					price += 0.09;
				}else {
					price += 0.1;
				}
			}
			System.out.println("Le prix final pour " + copies + " copies est de : " + Math.round((price)*100.00)/100.00);
		
		scanner.close();
	}

}
