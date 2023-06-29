package jalon;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		String prenom;
		String nom;
		int departement;
		String mail = "@arfp.asso.fr";
		Scanner scanner = new Scanner(System.in);
			System.out.println("Entrez votre prenom : ");
			prenom = scanner.next();
			System.out.println("Entrez votre nom : ");
			nom = scanner.next();
			System.out.println("Saisissez le numero de votre departement : ");
			departement = scanner.nextInt();
			System.out.println("Les deux adresses mail que nous vous proposons sont : \"" + prenom + nom + departement + mail
								+ "\" et \"" + nom + departement + prenom + mail + "\"");
		scanner.close();
	}

}
