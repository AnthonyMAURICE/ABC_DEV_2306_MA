package fonctionDate;


import java.util.Scanner;

public class App {
	
	private static String dayOfWeek(int annee, int mois, int jour) {
		int jourSemaine;
		String weekDay ="";
		java.time.LocalDate dateLocale = java.time.LocalDate.of(annee, mois, jour);
		jourSemaine = dateLocale.getDayOfWeek().getValue();	
		switch(jourSemaine) {
			case 1:{
				weekDay = "Lundi";
				break;
			}
			case 2:{
				weekDay = "Mardi";
				break;
			}	
			case 3:{
				weekDay = "Mercredi";
				break;
			}	
			case 4:{
				weekDay = "Jeudi";
				break;
			}	
			case 5:{
				weekDay = "Vendredi";
				break;
			}	
			case 6:{
				weekDay = "Samedi";
				break;
			}	
			case 7:{
				weekDay = "Dimanche";
				break;
			}	
		}	
		return weekDay;
	}
	
	private static boolean validDate(int a, int b, int c) {
		boolean valid = false, cas1, cas2, cas3, cas4;
		boolean bissextile;
		bissextile = (c%4 == 0 && c%100 != 0) || c%400 == 0;
		cas1 = (b == 1 || b == 3 || b == 5 || b == 8 || b == 10 || b == 12) && (a >= 1 && a <= 31);
		cas2 = (b == 4 || b == 6 || b == 9 || b == 11) && (a >= 1 && a <= 30);
		cas3 = b == 2 && bissextile  && a >= 1 && a <= 29;
		cas4 = b == 2 && a >= 1 && a <= 28;
		
		if(cas1 || cas2 || cas3 || cas4){
			valid = true;
		}
		else{
			System.out.println("Entrée invalide");
			valid = false;
		}
		return valid;
	}

	public static void main(String[] args) {
		int day, month, year;
		boolean weekDay = false;
		String dayOfWeek ="";
		
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Entrez le jour : ");
			day = scanner.nextInt();
			System.out.println("Entrez le mois : ");
			month = scanner.nextInt();
			System.out.println("Entrez l'année : ");
			year = scanner.nextInt();
			weekDay = validDate(day, month, year);
		}while(!weekDay);
					
		dayOfWeek = dayOfWeek(year, month, day);	
		System.out.println(dayOfWeek);
		
		scanner.close();
	}

}
