package fibonacciAurelien;

import java.util.Scanner;

public class App {
	
	 public static void main(String args[]){  
		  
		  int fibonacciSuite;
		  int nombre;
		  
		  Scanner sc = new Scanner(System.in);
		  System.out.println("Entrez un nombre positif :");
		  
		  nombre = sc.nextInt();
		  
		  for(int i=0; i<nombre+1; i++) {
		  
		  fibonacciSuite = fibonacci(i);   
		  System.out.println("Fibonacci(" + i + ") = " + fibonacciSuite);
		  
		  }
		  
		  sc.close();
		  
		 }  	
		 
	 static int fibonacci(int n){  //static pour les fonctions recursives
		  
		  if (n == 0)    
		    return 0; //retourne fibonacci(0) == 0
		  
		  else if(n == 1) //retourne fibonacci(1) == 1
			return 1;
		  
		  else    
		    return(fibonacci(n-1) + fibonacci(n-2));    
		 }   
}