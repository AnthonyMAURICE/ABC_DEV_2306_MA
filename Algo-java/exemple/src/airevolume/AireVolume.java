package airevolume;

import java.util.Scanner;

public class AireVolume {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
			float rayon;
			double aire;
			double volume;
			
			System.out.println("Saisissez le rayon de la sphere : ");
			rayon = scanner.nextFloat();
			aire = 4*Math.PI*Math.pow(rayon, 2);
			volume = (4/3)*Math.PI*Math.pow(rayon, 3);
			System.out.println("L'aire et le volume de la sphere de rayon " + rayon + " sont : " + aire + ", " + volume);
		scanner.close();
	}

}
