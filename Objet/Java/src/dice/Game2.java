package dice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Game2 {
	public void fetching()throws Exception {
		// r�cup�re l'url de l'API
		URL url = new URL("https://api.devoldere.net/polls/dice/");
		
		// s'y connecte, lance une requ�te "GET" et renvoit le code de r�ponse
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		int responseCode = connection.getResponseCode();		
		// si le code est 200, poursuit, sinon renvoit le code d'erreur
		if(responseCode !=200) {
			throw new RuntimeException("HttpResponseCode: " + responseCode);
		}else {
			String dice = ""; // chaine vide
			Scanner scanner = new Scanner(url.openStream()); 
				while(scanner.hasNext()) { // r�cup�re par le scanner les valeurs et les ajoute � la chaine de caract�res
					dice += scanner.nextLine();
				}
			scanner.close();
			
			JSONParser parser = new JSONParser(); // d�claration du parser JSON
			JSONObject ob = (JSONObject) parser.parse(dice); // d�claration d'un objet JSON qui accueille les �l�ments pass�s par le parser
			JSONArray values = (JSONArray) ob.get("results"); // d�claration d'un tableau JSON qui accueille les �l�ments "results" de l'API
			scoring(values);
		}
	}
	
	public void scoring(JSONArray _values) {
		int points1 = 0, points2 = 0, points3 = 0;
		boolean checked = false;
		for(int i = 0; i < _values.size(); i++) {
			checked = control(Integer.parseInt(String.valueOf(_values.get(i).toString().charAt(0))), Integer.parseInt(String.valueOf(_values.get(i).toString().charAt(2))), Integer.parseInt(String.valueOf(_values.get(i).toString().charAt(4))));
			if (checked) {
				switch(Integer.parseInt(String.valueOf(_values.get(i).toString().charAt(0)))){
				case 1:
					points1 = calculScore(points1, Integer.parseInt(String.valueOf(_values.get(i).toString().charAt(2))), Integer.parseInt(String.valueOf(_values.get(i).toString().charAt(4))));
					break;
				case 2:
					points2 = calculScore(points2, Integer.parseInt(String.valueOf(_values.get(i).toString().charAt(2))), Integer.parseInt(String.valueOf(_values.get(i).toString().charAt(4))));
					break;
				case 3:
					points3 = calculScore(points3, Integer.parseInt(String.valueOf(_values.get(i).toString().charAt(2))), Integer.parseInt(String.valueOf(_values.get(i).toString().charAt(4))));
					break;
				}
				
			}else {
				System.out.println("To investigate");
				break;
			}
		}
		afficheResults(points1, points2, points3);
	}
	
	public boolean control(int id, int score1, int score2) {
		if(id < 4 && id >0 && score1 > 0 && score1 <=6 && score2 > 0 && score2 <=6) {
			return true;
		}else {
			return false;
		}
	}
	
	public int calculScore(int points, int score1, int score2) {
		if(score1 == score2) {
			points -=2;
		}else if(score1 + score2 > 10) {
			points += 3;
		}else if(score1 + score2 >= 6 && score1 + score2 <=10) {
			points += 1;
		}
		return points;
	}
	
	public void afficheResults(int _points1, int _points2, int _points3) {
		System.out.println("Joueur 1 : " + _points1 + ", Joueur 2 : " + _points2 + ", Joueur3 : " + _points3);
	}
}