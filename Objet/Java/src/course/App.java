package course;

public class App {

	public static void main(String[] args) {
		
		Voitures[] supercar = new Voitures[4];
		Voitures gtr = new Voitures("Nissan GT-R", 0, 305, 15, 8, 8, true);
		Voitures lambo = new Voitures("Lamborghini Murcielago", 0, 305, 15, 8, 8, true);
		Voitures ferrari = new Voitures("Ferrari 458", 0, 305, 15, 8, 8, true);
		Voitures aston = new Voitures("Aston Martin Vantage", 0, 305, 15, 8, 8, true);
		supercar[0] = gtr;
		supercar[1] = lambo;
		supercar[2] = ferrari;
		supercar[3] = aston;
		
		Circuit circuit1 = new Circuit("Circuit d'Alsace", 3, 6);
		

	}

}
