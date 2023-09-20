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
		// r�cup�re l'url de l'API
		URL url = new URL("https://api.devoldere.net/polls/yoghurts/");
		
		// s'y connecte, lance une requ�te "GET" et renvoit le code de r�ponse
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
			Scanner scanner = new Scanner(url.openStream()); // d�claration du scanner sur l'url de l'API

			while(scanner.hasNext()) { // boucle tant qu'il y a des �l�ments scann�s
				poll += scanner.nextLine();
			}
			
				
			scanner.close();
			
			JSONParser parser = new JSONParser(); // d�claration du parser JSON
			JSONObject ob = (JSONObject) parser.parse(poll); // d�claration d'un objet JSON qui accueille les �l�ments pass�s par le parser

			JSONArray values = (JSONArray) ob.get("results"); // d�claration d'un tableau JSON qui accueille les �l�ments "results" de l'API
			
			System.out.println(values);
			prefered(values); // appelle la fonction suivante qui triera les valeurs
			
		}
	}
	
	public void prefered(JSONArray _values) {
		int[] colors = new int[5]; // d�claration d'un tableau d'entiers qui stockera les occurences de chaque couleurs
		String[] colors2 = {"red", "green", "yellow", "orange", "blue"}; // d�claration d'un tableau de chaines de caract�res, qui contiendra les nom des couleurs
		for(int i = 0; i < _values.size(); i++) { // boucle sur le tableau JSON des r�sultas, incr�mentant le nombres de chaque couleur
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

		
		for (int j = 0; j < colors.length; j++) { // boucle pour contr�ler les r�sultats de chaque couleurs
			System.out.println(colors2[j] + " : " + colors[j]);
		}
		
		sorting(colors, colors2, _values); // appel de la fonction qui r�organisera le tableau de noms
	}
		
	public void sorting(int[] _colors, String[] _colors2, JSONArray _values) {
		int tempNum;
		String tempName;
		for (int i = 0; i < _colors.length; i++){ // m�thode de tri du tableau par deux boucles for imbriqu�es
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
		
		/* m�thode de tri utilisant un IntStream
		String[] sortedColors = IntStream.range(0, _colors.length) // instruction qui classe le tableau de nom par rapport aux valeurs du tableau d'entiers
				.boxed().sorted((i, j) -> Integer.compare(_colors[i], _colors[j])) // en utilisant un Stream d'entiers, prenant comme base les valeurs du tableau d'entiers
				.map(i -> _colors2[i]).toArray(x -> new String[x]);// stockant les valeurs de chaque couleurs
		*/
		Arrays.sort(_colors); // tri du tableau d'entier par ordre croissant, pour tester les �galit�s des deuxi�me et troisi�me positions
		
		if(_colors[_colors.length - 2] == _colors[_colors.length - 3] || _colors[_colors.length - 1] == _colors[_colors.length - 2]) { // condition si la premi�re et la deuxi�me ou si la seconde et la troisi�me sont ex aequo
			int counter = 0;
			boolean match = false;
			while(!match) { // boucle tant qu'une des deux n'a pas �t� trouv�e dans le tableau "results"
				String temp = _values.get(counter).toString();
				if(temp.equals(sortedColors[sortedColors.length - 2]) || temp.equals(sortedColors[sortedColors.length - 1])) { // si la premi�re est trouv�e en premier, passe le bool�en � true
					match = true;
				}else if (temp.equals(sortedColors[sortedColors.length - 2])){ // si la deuxi�me est trouv�e, la place en premier et passe le bool�en � true
					String tempString;
					tempString = sortedColors[sortedColors.length - 1];
					sortedColors[sortedColors.length - 1] = sortedColors[sortedColors.length - 2];
					sortedColors[sortedColors.length - 2] = tempString;
					match = true;
				}else if (temp.equals(sortedColors[sortedColors.length - 3])){ // sin la troisi�me est trouv�e, la place en second et passe le bool�en � true
					sortedColors[sortedColors.length - 2] = sortedColors[sortedColors.length - 3];
					match = true;
				}
				counter++; // incr�mentation du compteur pour continuer � boucler sur le tableau
			}
		}
		
		for(int i = 0; i < sortedColors.length; i++) { // remplace les noms anglais par ceux en fran�ais
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
