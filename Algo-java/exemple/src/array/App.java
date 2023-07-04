package array;

import java.util.Arrays;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array [] = new int[5];
		int number;
		boolean check = false;
		
		System.out.println("Rentrez 5 chiffres : ");
		Scanner scanner = new Scanner(System.in);
			for (int i = 0; i < 5; i++) {
				array[i] = scanner.nextInt();
				System.out.println("Valeur : " + array[i]);
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
