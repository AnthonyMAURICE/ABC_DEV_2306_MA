package objectSW;

import java.util.Random;

public class Fight {
	Jedi jedi;
	Sith sith;
	
	public Fight(Jedi _jedi, Sith _sith) {
		this.jedi = _jedi;
		this.sith = _sith;
	}
	
	public void fighting(Jedi _jedi, Sith _sith) {
		boolean jediVictory;
		int jediHp = this.jedi.pointVie;
		int sithHp = this.sith.pointVie;
		int jediForce = this.jedi.force;
		int sithForce = this.sith.force;
		int hitChance;
		while(jediHp > 0 && sithHp > 0) {
			Random rand = new Random();
			hitChance = rand.nextInt((100 - 1) + 1) + 1;
			
		}
		
		if(jediHp > 0) {
			jediVictory = true;
		}else {
			jediVictory = false;
		}
		
	}
}
