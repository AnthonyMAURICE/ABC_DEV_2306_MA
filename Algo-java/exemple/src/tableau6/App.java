package tableau6;

public class App {

	public static void main(String[] args) {
		int[] array1 = {4, 8, 7, 12};
		int[] array2 = {3, 6};
		int temp, signe = 0, resultat = 0;
		
		for(int i = 0; i < array2.length; i++) {
			for(int j = 0; j < array1.length; j++) {
				System.out.print(array2[i] + " * " + array1[j]);
				String calcul = (signe < (array1.length * array2.length)-1) ? " + " : " = ";
				signe++;
				System.out.print(calcul);
				temp = array2[i]*array1[j];
				resultat += temp;
			}
		}
		
		System.out.println(resultat);
	}

}
