package fonction4;

public class App {

	public static void main(String[] args) {
		int cb = 5, cheques = 10, virements = 5, paiements = cb + cheques + virements;
		
		System.out.println("Nombre de paiements par Carte Bleue : " + cb);
		System.out.println("Nombre de ch�ques �mis : " + cheques);
		System.out.println("Nombre de virements automatiques : " + virements);
		
		System.out.println("Vous avez �mis " + paiements + " ordres de d�bit dont : ");
		System.out.println("	" + pourcent(cb, paiements) + "% par Carte Bleue");
		System.out.println("	" + pourcent(cheques, paiements) + "% par ch�que");
		System.out.println("	" + pourcent(virements, paiements) + "% par virement");

	}
	
	private static double pourcent(double a, double b) {
		double pourcent = (a/b) * 100;
		return pourcent;
	}

}
