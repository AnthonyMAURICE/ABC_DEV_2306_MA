package numberArray2;
import java.util.Scanner;
import java.util.ArrayList;
public class App {

	public static void main(String[] args) {
		int temp = 0, index = 0, number;
		boolean saisie = true;
		ArrayList<Integer> values = new ArrayList<Integer>();
		
		Scanner scanner = new Scanner(System.in);
			System.out.println("Saisissez des nombres, ou 0 pour stopper");
			while(saisie) {
				number = scanner.nextInt();
				values.add(number);
				if(number == 0) {
					saisie = false;
				}
			}

			for(int j = 0; j < values.size(); j++) { // boucle sur la liste de valeurs
				if (temp <= values.get(j)) { // si la valeur de la variable de stockage est inférieure ou égale à la valeur présente dans la liste
					temp = values.get(j); // elle prend sa valeur
					index = j; // et index stocke sa position dans la liste
				}
			}
			index++; // incrémentation car le tableau commence à 0 et non à 1
			System.out.println("La valeur la plus elevee est : " + temp + " qui est en position : " + index);
		
		scanner.close();

	}

}
