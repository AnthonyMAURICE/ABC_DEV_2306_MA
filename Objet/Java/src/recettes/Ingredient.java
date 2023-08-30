package recettes;

public class Ingredient {
	private String nomAliment, etat1, etat2, unite;
	private int quantite;
	
	public Ingredient(String _nom, String _etat1, String _etat2, int _quantite, String _unite) {
		this.nomAliment = _nom;
		this.etat1 = _etat1;
		this.etat2 = _etat2;
		this.quantite = _quantite;
		this.unite = _unite;
	}
	
	public String getNom() {
		return this.nomAliment;
	}
	
	public String getEtat1() {
		return this.etat1;
	}
	
	public String getEtat2() {
		return this.etat2;
	}
	
	public int getQuantite() {
		return this.quantite;
	}
	
	public String getUnite() {
		return this.unite;
	}
	
	public boolean comparison(Ingredient _ingredient, Ingredient _ingredient2) {
		if(_ingredient.nomAliment.equals(_ingredient2.nomAliment) && _ingredient.etat1.equals(_ingredient2.etat1) && (_ingredient.etat2.equals(_ingredient2.etat2))) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean cuire() {
		if(this.etat1.equals("cuit ") || this.etat1.equals("cuite ")) {
			return false;
		}else {
			this.etat1 = "cuit";
			return true;
		}
		
	}
	
	public boolean decouper() {
		if(this.etat2.equals("découpé ") || this.etat2.equals("découpée ")) {
			return false;
		}else {
			this.etat2 = "découpé(e)";
			return true;
		}
	}
}
