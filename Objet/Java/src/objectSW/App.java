package objectSW;

public class App {

	public static void main(String[] args) {
		Jedi yoda = new Jedi("Yoda", 45, 56, 5, 120, false);
		yoda.attribSaber();
		Jedi windu = new Jedi("Mace Windu", 42, 17, 5, 120, false);
		windu.attribSaber();
		System.out.println(yoda.parler());
		System.out.println(windu.parler());
		
	}

}
