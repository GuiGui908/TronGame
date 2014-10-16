package controller;

import model.Grille;
import model.Joueur;

public class ThreadIA1 extends ThreadJoueur {
	
	public ThreadIA1(Joueur jou, Grille grille) {
		super(jou, grille);
	}

	@Override
	public void run() {
		while(true) {
			try {
				jou.vaGauche();
				grille.setPos(jou);
				sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}
}
