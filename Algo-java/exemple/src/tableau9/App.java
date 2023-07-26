package tableau9;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		int length, greaterNotes = 0, counter = 1;
		double moyenne, noteSomme = 0;
		
		Scanner scanner = new Scanner(System.in);
			System.out.println("Saisissez le nombre de notes � entrer : ");
			length = scanner.nextInt();// l'utilisateur d�finit la taille du tableau
			double[] notes = new double[length];
			
			for(int i = 0; i < notes.length; i++) { // boucle qui fait entrer les valeurs das le tableau par l'utilisateur
				System.out.println("Entrez la note " + counter + " : ");
				notes[i] = scanner.nextDouble();
				if(notes[i] >= 0 && notes[i] <=20) { // contr�le que la note entr�e soit entre 0 et 20 
					noteSomme += notes[i]; // auquel cas la variable stocke la de la note avec la/les pr�c�dente(s) 
					counter++;
				}else { // sinon affiche le message d'erreur
					System.out.println("Saisie invalide, veuillez recommencer");
					i--; //et d�cr�mente i pour refaire un passage dans la boucle au m�me index
				}
			}
			
			moyenne = noteSomme / notes.length; // calcul de la moyenne
			
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
				if(j > moyenne) { // si la valeur test�e est sup�rieure � la moyenne
					greaterNotes++; // incr�mente la variable qui stocke les valeurs sup�rieures � celle-ci
				}
			}
			
			System.out.println("Il y a " + greaterNotes + " notes sup�rieures � la moyenne de la classe (" + Math.round(moyenne* 100.0)/100.0 + ").");
		scanner.close();
	}

}
