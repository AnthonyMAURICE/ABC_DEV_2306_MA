package numberArray;
import java.util.Scanner;
import java.util.Arrays;
public class App {

	public static void main(String[] args) {

		int temp = 0, index = 0, indexForEach = 0;
		int[] values = new int[20];
		
		Scanner scanner = new Scanner(System.in);
			for (int i = 0; i < values.length; i++) {
				System.out.println("Entrez le nombre " + (i+1) + " sur 20");
				values[i] = scanner.nextInt();
			}
			
			// r�cup�ration de la valeur la plus �lev�e avec son index
			
			/*for(int j = 0; j < values.length; j++) { // boucle sur le tableau de valeurs (boucle for)
				if (temp <= values[j]) { // si la valeur de la variable de stockage est inf�rieure ou �gale � la valeur pr�sente dans le tableau
					temp = values[j]; // elle prend sa valeur
					index = j; // et index stocke sa position dans le tableau
				}
			}*/
			
			for(int i : values) {// boucle for-each (index seulement r�cup�rable avec une variable d�di�e)
				if (temp <= i) { // si la valeur de la variable de stockage est inf�rieure ou �gale � la valeur pr�sente dans le tableau
					temp = i; // elle prend sa valeur
					index = indexForEach; // index prend la valeur de la variable d�di�e seulement si la condition est remplie
				}
				indexForEach++; // incr�mentation de la variable d'index de la boucle for-each
			}
			
			index++; // incr�mentation car le tableau commence � 0 et non � 1
			System.out.println("La valeur la plus �lev�e est : " + temp + " qui �tait le num�ro " + index);
			
			
			//r�cup�ration de la valeur la plus grande par la m�thode sort()

			Arrays.sort(values);
			
			System.out.println("La valeur la plus grande est : " + values[19]);

		
		scanner.close();
		

	}

}
