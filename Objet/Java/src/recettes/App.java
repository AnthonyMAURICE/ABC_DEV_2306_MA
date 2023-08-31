package recettes;

import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		ArrayList <Ingredient> ingList = new ArrayList <Ingredient>();
		boolean compare, test1, test2, test3, testCompare, testCompare2, testCompare3, testCompare4, testCompare5;
		Ingredient choux = new Ingredient("choux ", "cuit(e) ", "", 500,  "g");
		Ingredient lard = new Ingredient("lard ", "cuit(e), ", "entier(e) ", 150, " g");
		Ingredient saucisse = new Ingredient("saucisse ", "cuit(e) ", "entier(e) ", 2, "");
		Ingredient choux2 = new Ingredient("choux ", "cuit(e) ", "", 650, " g");

		
		Plat choucroute = new Plat();
		Plat choucroute2 = new Plat();
		choucroute.addIngredient(choux); // ajoute � la suite les ingr�dients au plat
		choucroute.addIngredient(lard);
		choucroute.addIngredient(saucisse);
		choucroute2.addIngredient(lard);
		ingList = choucroute.getIngredient(); // r�cup�re la liste d'ingr�dients
		Plat choucroute3 = new Plat("Choucroute", ingList); 
		testCompare4 = choux.isSame(choux2); // renvoit "true", les deux ingr�dients ont des noms et des etat1 similaires
		test1 = choux.decouper();
		test2 = choux.cuire();
		test3 = lard.decouper();
		testCompare = choucroute.equality(choucroute2); // renvoit "false", les deux plats n'ont pas les m�mes ingr�dients
		testCompare2 = choucroute.equality(choucroute3); // renvoit "true", les deux plats sont similaires
		testCompare3 = choux.isSame(saucisse); // renvoit "false", les deux ingr�dients sont diff�rents
		testCompare5 = choux.isSame(choux2); // renvoit "false", un des �tats est diff�rent (etat2 est "d�coup�(e) sur le premier objet
	}

}
