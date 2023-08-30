package recettes;

import java.util.ArrayList;

public class Plat {
	private String name;
	private ArrayList <Ingredient> list;
	
	public Plat() {
		this.name = "choucroute2";
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
	
	public boolean equals(ArrayList<Ingredient> _list1, ArrayList<Ingredient> _list2) {
		if(_list1.equals(_list2)) {
			return true;
		}else {
			return false;
		}
	}
	
	
}
