package yaourt;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.stream.IntStream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Poll {
	
	public void fetching()throws Exception {
		URL url = new URL("https://api.devoldere.net/polls/yoghurts/");

		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		int responseCode = connection.getResponseCode();
		System.out.println(responseCode);	
	
		if(responseCode !=200) {
			throw new RuntimeException("HttpResponseCode: " + responseCode);
		}else {
			String poll = "";
			Scanner scanner = new Scanner(url.openStream());

			while(scanner.hasNext()) {
				poll += scanner.nextLine();
			}
			
				
			scanner.close();
			
			JSONParser parser = new JSONParser();
			JSONObject ob = (JSONObject) parser.parse(poll);

			JSONArray values = (JSONArray) ob.get("results");
			
			System.out.println(values);
			prefered(values);
			
		}
	}
	
	public void prefered(JSONArray _values) {
		String preferedColors = "";
		int index1 = 0, index2 = 0, greater = 0;
		int[] colors = new int[5];
		String[] colors2 = {"rouge", "vert", "jaune", "orange", "bleu"};
		int red = 0, green = 0, yellow = 0, orange = 0, blue = 0;
		for(int i = 0; i < _values.size(); i++) {
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

		
		for (int j = 0; j < colors.length; j++) {
			System.out.println(colors[j]);
		}

		
		String[] sortedColors = IntStream.range(0, colors.length)
				.boxed().sorted((i, j) -> Integer.compare(colors[i], colors[j]))
				.map(i -> colors2[i]).toArray(x -> new String[x]);
		
		System.arraycopy(sortedColors, 0, colors2, 0, colors2.length);
		
		if(sortedColors[sortedColors.length - 2].equals(sortedColors[sortedColors.length - 3])) {
			int counter = 0;
			boolean match = false;
			while(!match) {
				String temp = _values.get(counter).toString();
				if(temp.equals(sortedColors[sortedColors.length - 2])) {
					match = true;
				}else {
					sortedColors[sortedColors.length - 2] = sortedColors[sortedColors.length - 3];
					match = true;
				}
				counter++;
			}
		}
				
		System.out.println(sortedColors[sortedColors.length - 1] + " " + sortedColors[sortedColors.length - 2]);
	}
}
