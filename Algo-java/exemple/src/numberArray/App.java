package numberArray;
import java.util.Scanner;
import java.util.Arrays;
public class App {

	public static void main(String[] args) {

		int temp = 0, index = 0;
		int[] values = new int[20];
		
		Scanner scanner = new Scanner(System.in);
			for (int i = 0; i < values.length; i++) {
				System.out.println("entrez le nombre " + (i+1));
				values[i] = scanner.nextInt();
			}
			
			// récupération de la valeur la plus élevée avec son index
			
			for(int j = 0; j < values.length; j++) {
				if (temp <= values[j]) {
					temp = values[j];
					index = j;
				}
			}
			index++;
			System.out.println("La valeur la plus elevee est : " + temp + " qui est en position : " + index);
			
			
			//récupération de la valeur la plus grande par la méthode sort()

			Arrays.sort(values);
			
			System.out.println("La valeur la plus grande est : " + values[19]);

		
		scanner.close();
		

	}

}
