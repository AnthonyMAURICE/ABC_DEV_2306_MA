package airevolume;

import java.util.Scanner;

public class AireVolume {

	public static void main(String[] args) {
		/*
		VARIABLE
	    R est un réel
	    Aire est un réel
	    Volume est un réel
		/*Correction
		CONSTANTE
		    π est un réel
		
		Début programme
		    Ecrire "Saisissez le rayon de la sphère : "
		    Lire <-- R
		    Aire <-- 4*π*R^2
		    Volume <-- (4/3)*π*R^3
		    Ecrire "L'aire et le volume de la sphère sont de : ",Aire," et ",Volume
		Fin programme
		*/
		Scanner scanner = new Scanner(System.in);
			double rayon, aire, volume;

			System.out.println("Saisissez le rayon de la sphere : ");
			rayon = scanner.nextDouble();
			aire = 4*Math.PI*Math.pow(rayon, 2);
			volume = (4/3)*Math.PI*Math.pow(rayon, 3);
			System.out.println("L'aire et le volume (arrondis à deux decimales) de la sphere de rayon " 
								+ rayon + " sont : " + Math.round(aire * 100.0)/100.0 	// la méthode Math.round() arrondit, 
								+ " et " + Math.round(volume * 100.0) / 100.0);			//et la multiplication suivie de la division par 100.0 retourne le résultat avec 2 décimales
		scanner.close();
	}

}
