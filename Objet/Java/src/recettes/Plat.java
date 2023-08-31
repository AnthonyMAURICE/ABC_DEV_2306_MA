package recettes;

import java.util.ArrayList;

public class Plat {
	private String name;
	private ArrayList <Ingredient> list;
	
	public Plat() {
		this.name = "Choucroute";
		this.list = new ArrayList<Ingredient>();
	}
		
	public Plat(String name, ArrayList<Ingredient> list) {
		this.name = name;
		this.list = list;
	}
	
	public String getNom() {
		return this.name;
	}	
	
	public void addIngredient(Ingredient _ingredient) {
		list.add(_ingredient);
	}
	
	public ArrayList<Ingredient> getIngredient() {
		return this.list;
	}
	
	public boolean equality(Plat _plat) { // m�thode de comparaison des plats
				
		if(this.name.equals(_plat.name) && this.list.equals(_plat.list)) {
			return true ;
		}else {
			return false;
		}	 
	}
}
