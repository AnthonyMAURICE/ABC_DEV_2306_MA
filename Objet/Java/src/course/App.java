package course;

public class App {

	public static void main(String[] args) {
		
		Voitures gtr = new Voitures("Nissan GT-R", 0, 305, 15, 8, 15, true);
		Voitures lambo = new Voitures("Lamborghini Murcielago", 0, 305, 15, 8, 8, true);
		Voitures ferrari = new Voitures("Ferrari 458", 0, 305, 15, 8, 8, true);
		Voitures aston = new Voitures("Aston Martin Vantage", 0, 305, 15, 8, 8, true);

		
		Section[] sections = new Section[5];
		Section section1 = new Section(3000);
		Section section2 = new Section(1000);
		Section section3 = new Section(1000);
		Section section4 = new Section(4000);
		Section section5 = new Section(2000);
		sections[0] = section1;
		sections[1] = section2;
		sections[2] = section3;
		sections[3] = section4;
		sections[4] = section5;
		
		
		Virage[] virages = new Virage[5];
		Virage virage1 = new Virage(2);
		Virage virage2 = new Virage(2);
		Virage virage3 = new Virage(3);
		Virage virage4 = new Virage(2);
		Virage virage5 = new Virage(2);
		virages[0] = virage1;
		virages[1] = virage2;
		virages[2] = virage3;
		virages[3] = virage4;
		virages[4] = virage5;
		
		
		Circuit circuit1 = new Circuit("Circuit d'Alsace", 3);
		circuit1.course(gtr, sections, virages);

	}

}
