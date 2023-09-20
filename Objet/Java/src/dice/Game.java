package dice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Game {
	public void fetching()throws Exception {
		// récupère l'url de l'API
		URL url = new URL("https://api.devoldere.net/polls/dice/");
		
		// s'y connecte, lance une requête "GET" et renvoit le code de réponse
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		int responseCode = connection.getResponseCode();
		System.out.println(responseCode);	
		
		// si le code est 200, poursuit, sinon renvoit le code d'erreur
		if(responseCode !=200) {
			throw new RuntimeException("HttpResponseCode: " + responseCode);
		}else {
			String dice = ""; // chaine vide
			Scanner scanner = new Scanner(url.openStream()); 

			while(scanner.hasNext()) { 
				dice += scanner.nextLine();
			}
			
				
			scanner.close();
			
			JSONParser parser = new JSONParser(); 
			JSONObject ob = (JSONObject) parser.parse(dice); 

			JSONArray values = (JSONArray) ob.get("results"); 
			
			System.out.println(values);
			scoring(values);
			
		}
	}
	
	public void scoring(JSONArray _values) {
		ArrayList<ArrayList<Integer>> score = new ArrayList<ArrayList<Integer>>(3); 
		ArrayList<Integer> score1 = new ArrayList<Integer>();
		ArrayList<Integer> score2 = new ArrayList<Integer>();
		ArrayList<Integer> score3 = new ArrayList<Integer>();
		score.add(score1);
		score.add(score2);
		score.add(score3);
		for(int i = 0; i < _values.size(); i++) {
			if(_values.get(i).toString().charAt(0) == '1') {
				score1.add(Integer.parseInt(String.valueOf(_values.get(i).toString().charAt(2))));
				score1.add(Integer.parseInt(String.valueOf(_values.get(i).toString().charAt(4))));
			}else if (_values.get(i).toString().charAt(0) == '2') {
				score2.add(Integer.parseInt(String.valueOf(_values.get(i).toString().charAt(2))));
				score2.add(Integer.parseInt(String.valueOf(_values.get(i).toString().charAt(4))));
			}else if (_values.get(i).toString().charAt(0) == '3'){
				score3.add(Integer.parseInt(String.valueOf(_values.get(i).toString().charAt(2))));
				score3.add(Integer.parseInt(String.valueOf(_values.get(i).toString().charAt(4))));
			}else {
				System.out.println("Entrée non conforme détectée, fin de la procédure. Maudis pirates... To investigate...");
			}
			
		}
		control(score);		
	}
	
	public void control(ArrayList<ArrayList<Integer>> _score) {
		boolean checked = false;
		for(int i = 0; i < _score.size(); i++) {
			for(int j: _score.get(i)) {
				if(j >= 1 || j <= 6) {
					checked = true;	
				}else {
					System.out.println("Entrée non conforme détectée, fin de la procédure. Maudis pirates... To investigate...");
				}
			}
		}
		if(checked) {
			System.out.println(_score);
			calculScore(_score);
		}
	}
	
	public void calculScore(ArrayList<ArrayList<Integer>> _score) {
		ArrayList<Integer>scoreFinal = new ArrayList<Integer>();
		int temp1, temp2, temp3 = 0;
		for(int i = 0; i < _score.size(); i++) {
			for(int j = 1; j < _score.get(i).size(); j++) {
				temp1 = _score.get(i).get(j);
				temp2 = _score.get(i).get(j - 1);
				if(temp1 == temp2) {
					temp3 -=2;
				}else {
					if(temp1 + temp2 >= 6 && temp1 + temp2 <=10){
						temp3 += 1;
					}else if (temp1 + temp2 > 10) {
						temp3 += 3;
					}
				}
			}
			
			if(temp3 < 0) {
				temp3 = 0;
			}
			scoreFinal.add(temp3);
			temp3 = 0;
		}
		System.out.println(scoreFinal);
		int bigger = 0, tempScore = scoreFinal.get(0);
		for(int k = 0; k < scoreFinal.size(); k++) {		
			if (tempScore <= scoreFinal.get(k)) {
				tempScore = scoreFinal.get(k);
				bigger = k;
			}
		}
		System.out.println("Le joueur " + (bigger+1) + " est arrivé le premier avec un score de " + scoreFinal.get(bigger) + " points.");
	}
}
