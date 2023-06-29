package exemple;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String welcome = "bienvenue sur Eclipse !";
		//System.out.println("Hello World, " + welcome);
		/*
		VARIABLE
	    N1 est un entier
	    N2 est un entier
	    Resultat est un réel
		Début programme
		    Ecrire "Saisir le premier nombre : "
		    Lire <-- N1
		    Ecrire "Saisir le second nombre : "
		    Lire <-- N2
		    Resultat <-- (N1+N2)/2
		    Ecrire "La moyenne des deux nombres saisis est : ",Resultat
		Fin programme
		 */
		
		int n1, n2;
		double result;

		Scanner scanner = new Scanner(System.in);
			System.out.println("Saisissez le premier nombre : ");
			n1 = scanner.nextInt();
			System.out.println("Saisissez le second nombre : ");
			n2 = scanner.nextInt();
			result = (n1 + n2)/2;
			System.out.println("La moyenne des deux nombres est : " + result);
		scanner.close();
	}

}
