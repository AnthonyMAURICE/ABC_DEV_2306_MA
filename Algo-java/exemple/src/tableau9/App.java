package tableau9;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		int length, greaterNotes = 0, counter = 1;
		double moyenne, noteSomme = 0;
		
		Scanner scanner = new Scanner(System.in);
			System.out.println("Saisissez le nombre de notes à entrer : ");
			length = scanner.nextInt();
			double[] notes = new double[length];
			
			for(int i = 0; i < notes.length; i++) {
				System.out.println("Entrez la note : " + counter);
				notes[i] = scanner.nextDouble();
				if(notes[i] > 0 && notes[i] <=20) {
					noteSomme += notes[i];
					counter++;
				}else {
					System.out.println("Saisie invalide, veuillez recommencer");
					i--;
				}
			}
			
			moyenne = noteSomme / notes.length;
			
			// avec boucle for
			/*
			for(int j = 0; j < notes.length; j++) {
				if(notes[j] > moyenne) {
					greaterNotes++;
				}
			}
			*/
			
			// avec boucle for each
			for(double j : notes) {
				if(j > moyenne) {
					greaterNotes++;
				}
			}
			
			System.out.println("Il y a " + greaterNotes + " notes supérieures à la moyenne de la classe (" + Math.round(moyenne* 100.0)/100.0 + ").");
		
		
		
		scanner.close();

	}

}
