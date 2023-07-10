package jalon;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		String isStudent;
		String jour;
		boolean student;
		int reduction = 0;
		
		Scanner scanner = new Scanner(System.in);
			System.out.println("Etes-vous etudiant ? Repondre par \"O\" ou \"o\" si oui.");
			isStudent = scanner.nextLine().toLowerCase();
			
			if (isStudent.equals("o")) {
				student = true;
			}else {
				student = false;
			}
					
			if (student == true) {
				System.out.println("Quel jour souhaitez vous venir ? ");
				jour = scanner.nextLine().toLowerCase();				
				if(jour.equals("mercredi")) {
					reduction = 50;
				}else if(jour.equals("jeudi")){
					reduction = 20;
				}else {
					if (jour.equals("lundi") || jour.equals("mardi") || jour.equals("vendredi") || jour.equals("samedi") || jour.equals("dimanche")) {
					reduction = 0;
					}else {
						System.out.println("Vous n'avez pas entre un jour valide !");
					}
				}
			}else {
				reduction = 0;
			}
			
			if (reduction !=0) {
			System.out.println("Selon votre situation et le jour choisi, vous beneficiez d'une reduction de " + reduction + "%");
			}else {
				System.out.println("Desole, mais vous n'avez le droit a aucune reduction.");
			}
		scanner.close();
	}

}