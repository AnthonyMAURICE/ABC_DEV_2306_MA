package jalonExercice2;

public class Domino {
	private int pointsFaceA, pointsFaceB;
	
	public Domino() {
		this.pointsFaceA = 0;
		this.pointsFaceB = 0;
	}
	
	public Domino(int _faceA, int _faceB) {
		this.pointsFaceA = _faceA;
		this.pointsFaceB = _faceB;
	}
	
	public void affichePoints() {
		System.out.println("Les points de la face A : " + this.pointsFaceA + " et ceux de la face B : " + this.pointsFaceB);
	}
	
	public int valeur() {
		return this.pointsFaceA + this.pointsFaceB;
	}
	
	public boolean combo(Domino _autre) {
		if(this.pointsFaceA == _autre.pointsFaceA || this.pointsFaceB == _autre.pointsFaceB) {
			return true;
		}else {
			return false;
		}
	}
	
}
