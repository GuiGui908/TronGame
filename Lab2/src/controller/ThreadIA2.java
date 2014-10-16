package controller;

import model.Grille;
import model.Joueur;

public class ThreadIA2 extends ThreadJoueur {

	public ThreadIA2(Joueur jou, Grille grille) {
		super(jou, grille);
	}


	@Override
	public void run() {
		while(true) {
			try {
				jou.vaDroite();
				grille.setPos(jou);
				sleep(200);
			} catch (InterruptedException e) {
			}
		}
	}

}
