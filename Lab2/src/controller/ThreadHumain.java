package controller;

import model.Joueur;

public class ThreadHumain extends ThreadJoueur {

	//private char direction;  On a d�j� un attribut Joueur jou qui poss�de une direction
	public ThreadHumain(Joueur jou) {
		super(jou);
		//direction = 'g';
	}

	/*
	public void setDirection(char direction) {
		this.direction = direction;
	}*/


	@Override
	public void run() {
		
		
		System.out.println("Lancement humain : "+getName());
		while(running) {
			try {
				jou.avance();
				if(grille.setPos(jou) == false) {
					// Fin de partie (l'humain s'est crash�)
					running = false;
					System.out.println("T'es mort bouffon !!!!");
					jou.setDead(true);
				}
				sleep(jou.getVitesse());
			} catch (InterruptedException e) {
			}
		}
	}

}
