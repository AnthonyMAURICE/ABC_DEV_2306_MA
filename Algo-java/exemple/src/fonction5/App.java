package fonction5;

import java.util.Arrays;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		int length;
		
		Scanner scanner = new Scanner(System.in);
			
		System.out.println("Combien d'entrées dans votre tableau ?");
			length = scanner.nextInt();
		
			int[] array = new int[length];
			
			for(int i = 0; i < array.length; i++) {
				System.out.println("Entrez le nombre " + (i+1));
				array[i] = scanner.nextInt();
			}
			
		scanner.close();
		
		int number = greater(array);
		System.out.println(number + " est le plus grand.");
		
	}
	
	private static int greater(int[]a) {	
		int greater;
		Arrays.sort(a);
		greater = a[a.length - 1];
		return greater;
	}

}
