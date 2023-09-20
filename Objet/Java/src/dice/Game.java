package dice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import java.util.Scanner;


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
		ArrayList<ArrayList<Integer>> score = new ArrayList<ArrayList<Integer>>(3); // déclaration d'une liste pour contenir les trois listes de scores, une par joueur
		ArrayList<Integer> score1 = new ArrayList<Integer>(); //déclaration des listes de score
		ArrayList<Integer> score2 = new ArrayList<Integer>();
		ArrayList<Integer> score3 = new ArrayList<Integer>();
		score.add(score1); //ajout des 3 listes à la liste principale
		score.add(score2);
		score.add(score3);
		for(int i = 0; i < _values.size(); i++) { // boucle for qui ajoute aux listes les scores, triés selon l'id du joueur (chiffre à l'index "0")
			if(_values.get(i).toString().charAt(0) == '1') { // joueur 1
				score1.add(Integer.parseInt(String.valueOf(_values.get(i).toString().charAt(2)))); // stocke les scores sous forme d'entiers
				score1.add(Integer.parseInt(String.valueOf(_values.get(i).toString().charAt(4))));
			}else if (_values.get(i).toString().charAt(0) == '2') { // joueur 2
				score2.add(Integer.parseInt(String.valueOf(_values.get(i).toString().charAt(2))));
				score2.add(Integer.parseInt(String.valueOf(_values.get(i).toString().charAt(4))));
			}else if (_values.get(i).toString().charAt(0) == '3'){ // joueur 3
				score3.add(Integer.parseInt(String.valueOf(_values.get(i).toString().charAt(2))));
				score3.add(Integer.parseInt(String.valueOf(_values.get(i).toString().charAt(4))));
			}else {
				System.out.println("Entrée non conforme détectée, fin de la procédure. Maudis pirates... To investigate...");
			}
			
		}
		control(score);		
	}
	
	public void control(ArrayList<ArrayList<Integer>> _score) { // contrôle la validité des entrées
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
		if(checked) { // ne passe que si les entrées ont été validées
			calculScore(_score);
		}
	}
	
	public void calculScore(ArrayList<ArrayList<Integer>> _score) { // calcul du score
		ArrayList<Integer>scoreFinal = new ArrayList<Integer>();
		int temp1, temp2, temp3 = 0;
		for(int i = 0; i < _score.size(); i++) { // première boucle for, boucle sur la liste principale contenant les trois autres
			for(int j = 1; j < _score.get(i).size(); j++) { // deuxième boucle, boucle sur chaque liste de scores, commence à 1 pour éviter les erreurs de type "out of bound"
				temp1 = _score.get(i).get(j); // récupère la valeur du 2ème dé (de score, pas l'id)
				temp2 = _score.get(i).get(j - 1); // récupère celle du premier
				if(temp1 == temp2) { // si les valeurs sont identiques
					temp3 -=2; // -2 au score
				}else { // sinon
					if(temp1 + temp2 >= 6 && temp1 + temp2 <=10){ // ajoute 1
						temp3 += 1;
					}else if (temp1 + temp2 > 10) { // ou 3 suivant le score total des deux dés
						temp3 += 3;
					}
				}
			}			
			if(temp3 < 0) { // si le score est négatif, il passe à 0
				temp3 = 0;
			}
			scoreFinal.add(temp3); // le score final est ajouté à la liste correspondant à chaque joueur
			temp3 = 0; // réinitialisation de la variable à 0 pour le passage suivant dans la boucle
		}
		System.out.println("Les scores sont : ");
		for(int k = 0; k < scoreFinal.size(); k++) { // boucle pour afficher les scores par joueurs
			System.out.println("Joueur " + (k+1) + " : " + scoreFinal.get(k));
		}
	}
}