package impots;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		int age = 0;
		String genre = "";
		boolean infos = false;
		
		Scanner scanner = new Scanner(System.in);
			while (!infos) {
				System.out.println("Homme (H) ou femme (F) ?");
				genre = scanner.next().toLowerCase();
				if(genre.equals("h") || genre.equals("f")) {	
					System.out.println(genre);
					System.out.println("Veillez entrer votre age : ");
					if(scanner.hasNextInt()) {
						age = scanner.nextInt();
						if(age < 0 || age > 100) {
							System.out.println("Age incorrect ! Veuillez recommencer la procedure, et ce depuis le debut !");
						}else {
							infos = true;
						}
					}else {
						System.out.println("Vous n'avez pas entre d'informations valides !");
					}
				}else {
					System.out.println("Vous n'avez pas entre d'informations valides !");
				}
				
			}
			
			if((genre.equals("h") && age >= 20) || (genre.equals("f") && (age >= 18 && age <=35))){
				System.out.println("Vous paierez des impots");
			}else {
				System.out.println("Vous n'etes pas imposable");
			}
			
		scanner.close();
	}

}
