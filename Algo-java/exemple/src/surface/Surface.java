package surface;

import java.util.Scanner;

public class Surface {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
			float rayon;
			float angle;
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
