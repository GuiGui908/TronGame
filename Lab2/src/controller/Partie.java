package controller;

import model.Joueur;
import view.FenetrePlateau;

public class Partie {

	public static void main(String[] args) {
		
		ThreadJoueur tabThreadJou[] = new ThreadJoueur[2];
		Joueur tabJou[] = new Joueur[2];
		tabJou[0] = new Joueur("Youn�s", 0, 40);		// cr�e un Joueur( nom, position, vitesse)
		tabThreadJou[0] = new ThreadHumain(tabJou[0]);	// cr�e un Thread de contr�le
		tabThreadJou[0].start();	// lance le Thread de contr�le
	

		// Cr�ation des quatre joueurs 

		tabJou[1] = new Joueur("Ordi 1", 1, 50);
		tabThreadJou[1] = new ThreadIA(tabJou[1]);
		tabThreadJou[1].start();
		
//		tabJou[2] = new Joueur("Ordi 2", 2);
//		tabThreadJou[2] = new ThreadIA2(tabJou[2], grille);
//		tabThreadJou[2].start();
		
//		tabJou[3] = new Joueur("Ordi 3", 3);
//		tabThreadJou[3] = new ThreadIA3(tabJou[3], grille);
//		tabThreadJou[3].start();

		// Cr�ation de l'interface
		FenetrePlateau fenetrePlateau = new FenetrePlateau(ThreadJoueur.grille, tabJou, tabJou[0]);
		//fenetrePlateau.setCtrl((ThreadHumain) tabThreadJou[0]);
		fenetrePlateau.setVisible(true);

	}

}
