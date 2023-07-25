package tableau4;

public class App {

	public static void main(String[] args) {
		int tempNumber = 0;
		int[] sumArray = {5, 18, -40, 289, 42};
		
		for(int i = 0; i < sumArray.length; i++) {
			tempNumber += sumArray[i];
		}
		
		System.out.println(tempNumber);
	}

}
