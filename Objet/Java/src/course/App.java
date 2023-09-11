package course;

import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		ArrayList<Section> sections = new ArrayList<Section>();
		ArrayList<Virage> virages = new ArrayList<Virage>();
		ArrayList<Voitures> supercar = new ArrayList<Voitures>();
		//Voitures[] supercar = new Voitures[4];
		
		Voitures gtr = new Voitures("Nissan GT-R", 0, 315, 15, 8, 15, true);
		Voitures lambo = new Voitures("Lamborghini Aventador", 0, 360, 12, 10, 10, true);
		Voitures ferrari = new Voitures("Ferrari 458", 0, 325, 10, 10, 8, true);
		Voitures porsche = new Voitures("Porsche 911 GT2 RS", 0, 340, 15, 10, 10, true);
		supercar.add(gtr);
		supercar.add(lambo);
		supercar.add(ferrari);
		supercar.add(porsche);
		
		
		
		Circuit circuit1 = new Circuit("Circuit 1");
		circuit1.createCircuit(sections, virages);

		
		for(int i = 0; i < supercar.size(); i++) {
			circuit1.course(supercar.get(i),sections, virages, 3);
		}
		

	}

}
