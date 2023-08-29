package montres;

public class App {

	public static void main(String[] args) {
		String time;
		Montre montre1 = new Montre();
		Montre montre2 = new Montre(23, 59);
		Montre montre3 = new Montre(montre1.heure, montre1.minutes);
		
		montre1.avancerHeure();
		montre2.avancerHeure();
		montre3.avancerHeure();
		
		
		Personnes test = new Personnes ("Test", true);
		Personnes test2 = new Personnes ("Test2", false);
		
		time = test.tellTime(montre3);
		System.out.println(time);
		time = test2.tellTime(montre3);
		System.out.println(time);
	}

}
