package array;

import java.util.Arrays;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int length = 0;
		int number, count = 0;
		boolean check = false;
		
		Scanner scanner = new Scanner(System.in);
			System.out.println("Saisissez la taille du tableau : ");
			length = scanner.nextInt();
			System.out.println("Saisissez "+ length +" chiffres : ");
			int array [] = new int[length];
			for (int i = 0; i < array.length; i++) {
				count++;
				System.out.println("Nombre " + count);
				array[i] = scanner.nextInt();
			}
			
			Arrays.sort(array);
			
			System.out.println("Entrez un nombre");
			number = scanner.nextInt();
			for ( int j = 0; j< array.length; j++) {
				if (number == array[j]) {
					check = true;
				}
			}
			
			if (check == true) {
				System.out.println("Le nombre " + number + " figure parmi les elements");
			}else {
				System.out.println("404 Number Not Found");
			}
		
		scanner.close();
	}

}
