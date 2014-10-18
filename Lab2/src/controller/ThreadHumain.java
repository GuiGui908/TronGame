package controller;

import model.Grille;
import model.Joueur;

public class ThreadHumain extends ThreadJoueur {

	private char direction;
	public ThreadHumain(Joueur jou, Grille grille) {
		super(jou, grille);
		direction = 'g';
	}

	
	public void setDirection(char direction) {
		this.direction = direction;
	}


	@Override
	public void run() {
		while(true) {
			try {
				
				jou.changeDir(direction);
				grille.setPos(jou);
				sleep(jou.getVitesse());
			} catch (InterruptedException e) {
			}
		}
	}

}
