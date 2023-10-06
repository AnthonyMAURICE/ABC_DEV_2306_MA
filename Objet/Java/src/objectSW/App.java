package objectSW;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.SwingUtilities;

public class App {

	public static void main(String[] args) {
		ArrayList<Personnage> liste = new ArrayList<Personnage>();
		
		Lightsaber lightsaber1 = new Lightsaber("Sabre Laser", 10, 95, 25, "vert", false);
		Jedi yoda = new Jedi("Yoda", 45, 56, 5, lightsaber1, 100, 25);
		yoda.getWeapon().setIgnited();
		liste.add(yoda);
		Lightsaber lightsaber2 = new Lightsaber("Sabre Laser", 10, 95, 25, "violet", false);
		Jedi windu = new Jedi("Mace Windu", 42, 17, 5, lightsaber2, 100, 25);
		windu.getWeapon().setIgnited();
		liste.add(windu);
		Lightsaber lightsaber3 = new Lightsaber("Sabre Laser", 10, 95, 25, "bleu", false);
		Jedi kenobi = new Jedi("Obi-Wan Kenobi", 40, 42, 5, lightsaber3, 100, 25);
		kenobi.getWeapon().setIgnited();
		liste.add(kenobi);
		Lightsaber ligthsaber4 = new Lightsaber("Sabre Laser", 10, 95, 25, "rouge", false);
		Sith vador = new Sith("Vader", 66, 66, 5, ligthsaber4, 100, 20);
		vador.getWeapon().setIgnited();
		liste.add(vador);
		Blaster blasterLourd = new Blaster("Blaster Lourd", 15, 80, true);
		Mandalorian trooper = new Mandalorian("Mandalore", 60, 60, 5, blasterLourd, 100, 50);
		liste.add(trooper);
		HashMap<Integer, String> test = new HashMap<Integer, String>();
		
		/*
		yoda.seDeplacer(2, 1);
		
		System.out.println(yoda.parler());
		System.out.println(windu.parler());
		System.out.println(vador.parler());
		*/

		/*yoda.fight(vador);
		vador.fight(kenobi);
		windu.fight(trooper);
		*/
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ChoiceUI userChoice = new ChoiceUI(liste);
				userChoice.setVisible(true);
			}
		});
	}

}
