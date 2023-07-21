package numberArray2;
import java.util.Scanner;
import java.util.ArrayList;
public class App {

	public static void main(String[] args) {
		int temp = 0, index = 0, number;
		ArrayList<Integer> values = new ArrayList<Integer>();
		
		Scanner scanner = new Scanner(System.in);
			
			do{
				System.out.println("Saisissez des nombres, ou 0 pour stopper");
				number = scanner.nextInt();
				values.add(number);
			}while(number != 0);

			for(int j = 0; j < values.size(); j++) { // boucle sur la liste de valeurs
				if (temp <= values.get(j)) { // si la valeur de la variable de stockage est inf�rieure ou �gale � la valeur pr�sente dans la liste
					temp = values.get(j); // elle prend sa valeur
					index = j; // et index stocke sa position dans la liste
				}
			}
			index++; // incr�mentation pour r�cup�rer la position, car le tableau commence � 0 et non � 1
			System.out.println("La valeur la plus �lev�e est : " + temp + " qui est en position " + index);
		
		scanner.close();

	}

}
