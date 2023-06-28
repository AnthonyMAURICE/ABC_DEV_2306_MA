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
			float rayon;
			double aire, volume;
			
			System.out.println("Saisissez le rayon de la sphere : ");
			rayon = scanner.nextFloat();
			aire = 4*Math.PI*Math.pow(rayon, 2);
			volume = (4/3)*Math.PI*Math.pow(rayon, 3);
			System.out.println("L'aire et le volume de la sphere de rayon " + rayon + " sont : " + aire + ", " + volume);
		scanner.close();
	}

}
