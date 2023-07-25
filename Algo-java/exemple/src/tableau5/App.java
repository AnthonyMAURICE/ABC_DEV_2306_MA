package tableau5;

public class App {

	public static void main(String[] args) {
		int[] array1 = {4, 8, 7 ,9, 1, 5, 4, 6};
		int[] array2 = {7, 6, 5, 2, 1, 3, 7, 4};
		int[] array3 = new int[8];
		
		for(int i = 0; i< array3.length; i++) {
			array3[i] = array1[i] + array2[i];
			System.out.print(array3[i] + " ");
		}

	}

}
