package procedure4;

import java.util.Scanner;

public class App {

	private static void ageCheck(int a) {
		if(a<0) {
			System.out.println("Vous n'�tes pas n�");
		}else if (a>=18) {
			System.out.println("Vous �tes majeur");
		}else {
			System.out.println("Vous �tes mineur");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int age;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Entrez votre �ge");
			age = scanner.nextInt();
			
			ageCheck(age);
		scanner.close();
	}

}
