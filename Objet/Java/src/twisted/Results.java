package twisted;

import java.util.Random;
import java.util.stream.IntStream;

public class Results {
	private String winners, color;
	private String[] colors;
	private int prize = 6000, equality;
	Random rand = new Random();
	private int[][][] score;
	
	public Results(int[][][] diceResult, String[] _colors) {
		this.score = diceResult;
		this.colors = _colors;
	}
	
	public void compare(){
		int[][][] scoreFinaux = new int[this.score.length][this.score.length][3];
		int[][] total = new int[this.score.length][1];
		int temp = 0, gain = 1;
		String gagnants = "";
		for(int i = 0; i < this.score.length; i++) {
			for(int j = 0; j < this.score[i].length; j++) {
				for(int k = 0; k < this.score[i][j].length; k++) {
					scoreFinaux[i][j][k] = this.score[i][j][k];
					if(k >=1 && k < 2) {
						if(scoreFinaux[i][j][k] == scoreFinaux[i][j][k - 1]) {
							this.equality++;
						}
						if(scoreFinaux[i][j][k] + scoreFinaux[i][j][k-1] + scoreFinaux[i][j][k +1] == 3 ||scoreFinaux[i][j][k] + scoreFinaux[i][j][k-1] + scoreFinaux[i][j][k +1] == 18) {
							total[j][0] += 3;
						}else if(scoreFinaux[i][j][k] + scoreFinaux[i][j][k-1] + scoreFinaux[i][j][k +1] >= 12) {
							total[j][0] += 2;
						}else if(scoreFinaux[i][j][k] + scoreFinaux[i][j][k-1] + scoreFinaux[i][j][k +1] <= 6) {
							total[j][0] += 1;
						}else {
							total[j][0] += 0;
						}
					}
				}
			}
		}
		
		for(int tri = 0; tri < total.length; tri++) {
			for(int l = 1; l < total.length - tri; l++) {
				if(total[l-1][0] > total[l][0]) {

					temp = total[l-1][0];
					total[l -1][0] = total[l][0];
					total[l][0] = temp;	
				}	
			}
		}
		
		for(int m = total.length -1; m >=0; m--) {
			if(total[m][0] == total[m-1][0]) {
				gain++;	
				
			}else {
				break;
			}
			
		}
		System.out.println(gain);
		this.prize = this.prize /gain;
		gagnants += "il y a " + gain + " gagnant(s) ";
		for(int n = total.length-1; n >= 0; n--) {
			gagnants += total[n][0];
			if(n > 0) {
				gagnants += "/";
			}
		}
		this.winners = gagnants;
		chosenColor(this.equality);
	}
	
	public void chosenColor(int _equality) {
		Random rand = new Random();
		int[] randColor = new int[5];
		while(_equality > 0) {
			randColor[rand.nextInt(5-1)+1] += 1;			
			_equality--;
		}
		String[] sortedColors = IntStream.range(0, this.colors.length) 
				.boxed().sorted((i, j) -> Integer.compare(randColor[i], randColor[j]))
				.map(i -> this.colors[i]).toArray(x -> new String[x]);
		this.color = sortedColors[sortedColors.length - 1];
	}
	
	public String getWinners() {

		return this.winners;
	}
	
	public int getPrizeValue() {
		return this.prize;
	}
	
	public String getColor() {
		return this.color;
	}
}
