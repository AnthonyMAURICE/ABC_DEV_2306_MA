package recettes;

import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		ArrayList <Ingredient> ingList = new ArrayList <Ingredient>();
		boolean compare, test1, test2, test3, testCompare, testCompare2;
		Ingredient choux = new Ingredient("choux ", "cuit ", "", 500,  "g");
		Ingredient lard = new Ingredient("lard ", "cuit, ", "entier ", 150, " g");
		Ingredient saucisse = new Ingredient("saucisse ", "cuite ", "entière ", 2, "");

		
		Plat choucroute = new Plat();
		Plat choucroute2 = new Plat();
		choucroute.addIngredient(choux);
		choucroute.addIngredient(lard);
		choucroute.addIngredient(saucisse);
		choucroute2.addIngredient(lard);
		ingList = choucroute.getIngredient();
		Plat choucroute3 = new Plat("Choucroute", ingList);
		compare = choucroute.equals(choucroute2);
		
		test1 = choux.decouper();
		test2 = choux.cuire();
		test3 = lard.decouper();
		testCompare = choucroute.equality(choucroute2);
		testCompare2 = choucroute.equality(choucroute3);
	}

}
