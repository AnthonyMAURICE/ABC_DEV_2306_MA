package twisted;

import java.util.Random;

public class App {

	public static void main(String[] args) {
		
		int[][][] diceResult = new int[20][20][3]; // la première dimension représente les joueurs, la seconde les lancers de dés
		String[] colors = {"Rouge", "Vert", "Bleu", "Jaune", "Orange"}; 
		Random rand = new Random();
		for(int i = 0; i < diceResult.length ; i++) {
			for(int j = 0; j < diceResult.length ; j++) {
				for(int k = 0; k < 3; k++) {
					diceResult[i][j][k] += rand.nextInt(6 - 1) +1; 
				}
				
			}
		}
		Results results = new Results(diceResult, colors);
		results.compare();
		String test = results.getWinners();
		String test2 = results.getColor();
		int test3 = results.getPrizeValue();
		System.out.println(test);
		System.out.println("La couleur plébiscitée est : " + test2);
		System.out.println("Le prix est de : " + test3);
	}

}
