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
	
	
	public boolean cuire() {
		if(this.etat1.equals("cuit(e) ")) {
			return false;
		}else {
			this.etat1 = "cuit(e) ";
			return true;
		}	
	}
	
	public boolean decouper() {
		if(this.etat2.equals("découpé(e) ")) {
			return false;
		}else {
			this.etat2 = "découpé(e)";
			return true;
		}
	}
	
	public boolean isSame(Ingredient _ing) { // méthode de comparaison d'ingrédients
		if(this.nomAliment.equals(_ing.nomAliment) && this.etat1.equals(_ing.etat1) && this.etat2.equals(_ing.etat2)) {
			return true ;
		}else {
			return false;
		}
	}
}
