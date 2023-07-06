package binaire;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class App {

	public static void main(String[] args) {
		int decimal, modulo, firstNum;
		ArrayList<Integer> binary = new ArrayList<Integer>();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Entrez un nombre en base dix : ");
		decimal = scanner.nextInt();
		firstNum = decimal;
		while (decimal > 1 ) {
			modulo = decimal % 2;
			decimal = decimal /2;
			binary.add(modulo);
		}
			binary.add(1);
			Collections.reverse(binary);
			System.out.println(firstNum + " en base dix donne : " + binary + " en binaire.");
			
			scanner.close();
	}
		
}
