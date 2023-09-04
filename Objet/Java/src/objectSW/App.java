package objectSW;

public class App {

	public static void main(String[] args) {
		
		Lightsaber lightsaber1 = new Lightsaber(10, 95, 25, "vert", false);
		Jedi yoda = new Jedi("Yoda", 45, 56, 5, 120, lightsaber1);
		yoda.getSaber().setIgnited();
		Lightsaber lightsaber2 = new Lightsaber(10, 95, 25, "violet", false);
		Jedi windu = new Jedi("Mace Windu", 42, 17, 5, 120, lightsaber2);
		Lightsaber lightsaber3 = new Lightsaber(10, 95, 25, "bleu", false);
		Jedi kenobi = new Jedi("Obi-Wan Kenobi", 40, 42, 5, 110, lightsaber3);
		Lightsaber ligthsaber4 = new Lightsaber(10, 95, 25, "rouge", false);
		Sith vador = new Sith("Darth Vader", 66, 66, 5, 120, ligthsaber4);
		System.out.println(yoda.parler());
		System.out.println(windu.parler());
		System.out.println(vador.parler());
		System.out.println(lightsaber1.getAccuracy());
		
	}

}
