package dice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Game2 {
	public void fetching() throws Exception {
		// récupère l'url de l'API
		URL url = new URL("https://api.devoldere.net/polls/dice/");
		
		// s'y connecte, lance une requête "GET" et renvoit le code de réponse
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
				while(scanner.hasNext()) { // récupère par le scanner les valeurs et les ajoute à la chaine de caractères
					dice += scanner.nextLine();
				}
			scanner.close();
			
			JSONParser parser = new JSONParser(); // déclaration du parser JSON
			JSONObject ob = (JSONObject) parser.parse(dice); // déclaration d'un objet JSON qui accueille les éléments passés par le parser
			JSONArray values = (JSONArray) ob.get("results"); // déclaration d'un tableau JSON qui accueille les éléments "results" de l'API
			scoring(values);
		}
	}
	
	public void scoring(JSONArray _values) {
		int points1 = 0, points2 = 0, points3 = 0; // variables stockant les scores des joueurs
		boolean checked = false; // booléen de contrôle des entrées
		for(int i = 0; i < _values.size(); i++) { // boucle for sur le tableau d'entrées
			checked = control(Integer.parseInt(String.valueOf(_values.get(i).toString().charAt(0))), Integer.parseInt(String.valueOf(_values.get(i).toString().charAt(2))), Integer.parseInt(String.valueOf(_values.get(i).toString().charAt(4)))); // fonction de contrôle
			if (checked) { // si le contrôle revient positif, passe dans le switch 
				switch(Integer.parseInt(String.valueOf(_values.get(i).toString().charAt(0)))){ //switch sur la valeur de l'id du joueur
				case 1: // calcul des points pour chaque, envoit à une fonction dédiée au calcul du score
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
		afficheResults(points1, points2, points3); // appelle la méthode d'affichage des résultats
	}
	
	public boolean control(int id, int score1, int score2) {
		if(id < 4 && id >0 && score1 > 0 && score1 <=6 && score2 > 0 && score2 <=6) {
			return true;
		}else {
			return false;
		}
	}
	
	public int calculScore(int points, int score1, int score2) { // calcul du score avec en paramètres les points déjà acquis (s'il y a) et les deux valeurs de score extraites du tableau d'entrées
		if(score1 == score2) { // attribution du score en fonction des entrées
			points -=2;
		}else if(score1 + score2 > 10) {
			points += 3;
		}else if(score1 + score2 >= 6 && score1 + score2 <=10) {
			points += 1;
		}
		if(points < 0) {
			points = 0;
		}
		return points;
	}
	
	public void afficheResults(int _points1, int _points2, int _points3) {
		System.out.println("Joueur 1 : " + _points1 + ", Joueur 2 : " + _points2 + ", Joueur3 : " + _points3);
	}
}