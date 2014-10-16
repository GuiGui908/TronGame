package controller;

import model.Grille;
import model.Joueur;

public class ThreadIA3 extends ThreadJoueur {

	public ThreadIA3(Joueur jou, Grille grille) {
		super(jou, grille);
	}


	@Override
	public void run() {
		while(true) {
			try {
				jou.vaBas();
				grille.setPos(jou);
				sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

}
