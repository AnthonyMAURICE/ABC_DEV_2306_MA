package objectSW;

public class App {

	public static void main(String[] args) {
		
		Lightsaber lightsaber1 = new Lightsaber("Sabre Laser", 10, 95, 25, "vert", false);
		Jedi yoda = new Jedi("Yoda", 45, 56, 5, lightsaber1, 120, 25);
		yoda.getWeapon().setIgnited();
		Lightsaber lightsaber2 = new Lightsaber("Sabre Laser", 10, 95, 25, "violet", false);
		Jedi windu = new Jedi("Mace Windu", 42, 17, 5, lightsaber2, 120, 25);
		windu.getWeapon().setIgnited();
		Lightsaber lightsaber3 = new Lightsaber("Sabre Laser", 10, 95, 25, "bleu", false);
		Jedi kenobi = new Jedi("Obi-Wan Kenobi", 40, 42, 5, lightsaber3, 110, 25);
		kenobi.getWeapon().setIgnited();
		Lightsaber ligthsaber4 = new Lightsaber("Sabre Laser", 10, 95, 25, "rouge", false);
		Sith vador = new Sith("Vader", 66, 66, 5, ligthsaber4, 120, 20);
		vador.getWeapon().setIgnited();
		yoda.seDeplacer(2, 1);
		System.out.println(yoda.parler());
		System.out.println(windu.parler());
		System.out.println(vador.parler());
		System.out.println(lightsaber1.getAccuracy());
		System.out.println(kenobi.getNom());
		Blaster blasterE11 = new Blaster("Blaster E11", 15, 80, true);
		Stormtrooper trooper = new Stormtrooper("Cody", 60, 60, 5, blasterE11, 0, 35);
		System.out.println(trooper.getWeapon().getName() + ", précision : " + trooper.getWeapon().getAccuracy());
		yoda.fight(vador);
		windu.fight(trooper);
	}

}
