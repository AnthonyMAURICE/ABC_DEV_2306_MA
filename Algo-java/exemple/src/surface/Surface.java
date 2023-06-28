package surface;

import java.util.Scanner;

public class Surface {

	public static void main(String[] args) {
		/*
		 VARIABLE
		    R est un réel
		    A est un réel
		    Resultat est un réel
		CONSTANTE
		    Pi est un réel
		Début programme
		    Ecrire "Quelle est la valeur du rayon du cercle ? "
		    Lire <-- R
		    Ecrire "Quel est l'angle pour le calcul ? "
		    Lire <-- A
		    Resultat <-- (Pi*R^2*A)/360
		    Ecrire "L'aire du secteur circulaire est de : ",Resultat
		Fin programme
		 */
		Scanner scanner = new Scanner(System.in);
			float rayon, angle;
			double resultat;
			
			System.out.println("Saisissez le rayon du cercle : ");
			rayon = scanner.nextFloat();
			System.out.println("Saisissez l'angle : ");
			angle = scanner.nextFloat();
			resultat = (Math.PI*Math.pow(rayon, 2)*angle)/360;
			System.out.println("L'aire du secteur circulaire est de : " + resultat);
		scanner.close();
	}

}
