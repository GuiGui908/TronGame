package controller;

import model.Joueur;

public class ThreadHumain extends ThreadJoueur {

	public ThreadHumain(Joueur jou) {
		super(jou);
	}

	@Override
	public void run() {
		/* Boucle à l'infini
		 	1. lance le thread
			2. avance tant qu'il n'est pas crashé
			3. attend que la fin de la manche */
		while (true) {

			System.out.println("Lancement humain : " + getName());
			while (!jou.isDead()) {
				try {
					jou.avance();
					if (grille.setPos(jou) == false) {
						// Fin de partie (l'humain s'est crashé)
						System.out.println("T'es mort bouffon !!!!");
						jou.setDead(true);
					}
					sleep(jou.getVitesse());
				} catch (InterruptedException e) {
				}
			}
			try {
				wait(); // Attend que les autres joueurs finissent
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
