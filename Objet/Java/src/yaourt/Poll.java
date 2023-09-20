package yaourt;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//import java.util.stream.IntStream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Poll {
	
	public void fetching()throws Exception {
		// récupère l'url de l'API
		URL url = new URL("https://api.devoldere.net/polls/yoghurts/");
		
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
			String poll = ""; // chaine vide
			Scanner scanner = new Scanner(url.openStream()); // déclaration du scanner sur l'url de l'API

			while(scanner.hasNext()) { // boucle tant qu'il y a des éléments scannés
				poll += scanner.nextLine();
			}
			
				
			scanner.close();
			
			JSONParser parser = new JSONParser(); // déclaration du parser JSON
			JSONObject ob = (JSONObject) parser.parse(poll); // déclaration d'un objet JSON qui accueille les éléments passés par le parser

			JSONArray values = (JSONArray) ob.get("results"); // déclaration d'un tableau JSON qui accueille les éléments "results" de l'API
			
			System.out.println(values);
			prefered(values); // appelle la fonction suivante qui triera les valeurs
			
		}
	}
	
	public void prefered(JSONArray _values) {
		int[] colors = new int[5]; // déclaration d'un tableau d'entiers qui stockera les occurences de chaque couleurs
		String[] colors2 = {"red", "green", "yellow", "orange", "blue"}; // déclaration d'un tableau de chaines de caractères, qui contiendra les nom des couleurs
		for(int i = 0; i < _values.size(); i++) { // boucle sur le tableau JSON des résultas, incrémentant le nombres de chaque couleur
			if(_values.get(i).equals("red")) {
				colors[0] += 1;
			}else if (_values.get(i).equals("green")) {
				colors[1] += 1;
			}else if (_values.get(i).equals("yellow")) {
				colors[2] += 1;
			}else if (_values.get(i).equals("orange")) {
				colors[3] += 1;
			}else{
				colors[4] += 1;
			}
		}

		
		for (int j = 0; j < colors.length; j++) { // boucle pour contrôler les résultats de chaque couleurs
			System.out.println(colors2[j] + " : " + colors[j]);
		}
		
		sorting(colors, colors2, _values); // appel de la fonction qui réorganisera le tableau de noms
	}
		
	public void sorting(int[] _colors, String[] _colors2, JSONArray _values) {
		int tempNum;
		String tempName;
		for (int i = 0; i < _colors.length; i++){ // méthode de tri du tableau par deux boucles for imbriquées
            for (int j = i + 1; j < _colors.length; j++){
                if (_colors[i] > _colors[j]){ 
                
                    tempNum = _colors[i];
                    tempName=_colors2[i];

                    _colors[i] = _colors[j];
                    _colors2[i] = _colors2[j];

                    _colors[j] = tempNum;
                    _colors2[j] = tempName;
                }
            }
        }
		
		String[] sortedColors = _colors2;
		
		/* méthode de tri utilisant un IntStream
		String[] sortedColors = IntStream.range(0, _colors.length) // instruction qui classe le tableau de nom par rapport aux valeurs du tableau d'entiers
				.boxed().sorted((i, j) -> Integer.compare(_colors[i], _colors[j])) // en utilisant un Stream d'entiers, prenant comme base les valeurs du tableau d'entiers
				.map(i -> _colors2[i]).toArray(x -> new String[x]);// stockant les valeurs de chaque couleurs
		*/
		Arrays.sort(_colors); // tri du tableau d'entier par ordre croissant, pour tester les égalités des deuxième et troisième positions
		
		if(_colors[_colors.length - 2] == _colors[_colors.length - 3] || _colors[_colors.length - 1] == _colors[_colors.length - 2]) { // condition si la première et la deuxième ou si la seconde et la troisième sont ex aequo
			int counter = 0;
			boolean match = false;
			while(!match) { // boucle tant qu'une des deux n'a pas été trouvée dans le tableau "results"
				String temp = _values.get(counter).toString();
				if(temp.equals(sortedColors[sortedColors.length - 2]) || temp.equals(sortedColors[sortedColors.length - 1])) { // si la première est trouvée en premier, passe le booléen à true
					match = true;
				}else if (temp.equals(sortedColors[sortedColors.length - 2])){ // si la deuxième est trouvée, la place en premier et passe le booléen à true
					String tempString;
					tempString = sortedColors[sortedColors.length - 1];
					sortedColors[sortedColors.length - 1] = sortedColors[sortedColors.length - 2];
					sortedColors[sortedColors.length - 2] = tempString;
					match = true;
				}else if (temp.equals(sortedColors[sortedColors.length - 3])){ // sin la troisième est trouvée, la place en second et passe le booléen à true
					sortedColors[sortedColors.length - 2] = sortedColors[sortedColors.length - 3];
					match = true;
				}
				counter++; // incrémentation du compteur pour continuer à boucler sur le tableau
			}
		}
		
		for(int i = 0; i < sortedColors.length; i++) { // remplace les noms anglais par ceux en français
			if(sortedColors[i].equals("red")){
				sortedColors[i] = "rouge";
			}else if(sortedColors[i].equals("green")){
				sortedColors[i] = "vert";
			}else if(sortedColors[i].equals("yellow")){
				sortedColors[i] = "jaune";
			}else if(sortedColors[i].equals("blue")){
				sortedColors[i] = "bleu";
			}
		}
			
		System.out.println(sortedColors[sortedColors.length - 1] + " " + sortedColors[sortedColors.length - 2]);

	}
}
