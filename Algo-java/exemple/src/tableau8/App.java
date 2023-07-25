package tableau8;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		int[] numberArray = new int[5];
		int greater = 0, index = 0, counter = 1;
		Scanner scanner = new Scanner(System.in);
			for (int i = 0; i < numberArray.length ; i++) {
				System.out.println("Saisissez la valeur " + counter);
				numberArray[i] = scanner.nextInt(); 
				if(greater <= numberArray[i]) {
					greater = numberArray[i];
					index = i;
				}
				counter++;
			}

			
			System.out.println("La valeur la plus grande dans le tableau est : " + greater + " à l'index : " + index + ", soit la position : " +(index+1));
			
		scanner.close();
	}

}
