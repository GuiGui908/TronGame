package controller;

import model.Grille;
import model.Joueur;

public class ThreadIA extends ThreadJoueur {
	// le joueur de couleur jaune 
	
	public ThreadIA(Joueur jou, Grille grille) {
		super(jou, grille);
	}

	@Override
	public void run() {
		while(true) {
			try {
				
				jou.changeDir('g');
				grille.setPos(jou);
				sleep(jou.getVitesse());
			} catch (InterruptedException e) {
			}
		}
	}
}
