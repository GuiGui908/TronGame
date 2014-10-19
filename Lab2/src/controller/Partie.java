package controller;

import model.Joueur;
import view.FenetrePlateau;

public class Partie {

	public static void main(String[] args) {
		
		ThreadJoueur tabThreadJou[] = new ThreadJoueur[3];
		Joueur tabJou[] = new Joueur[2];
		Joueur humain = new Joueur("Younès", 0, 20);		// crée un Joueur( nom, position, vitesse)
		tabThreadJou[0] = new ThreadHumain(humain);	// crée un Thread de contrôle
		tabThreadJou[0].start();	// lance le Thread de contrôle
	

		// Création des quatre joueurs 

		tabJou[0] = new Joueur("Ordi 1", 3, 20);
		tabThreadJou[1] = new ThreadIA(humain,tabJou[0]);
		tabThreadJou[1].start();
		
		tabJou[1] = new Joueur("Ordi 2",2, 20);
		tabThreadJou[2] = new ThreadIA(humain, tabJou[1]);
		tabThreadJou[2].start();
		
//		tabJou[3] = new Joueur("Ordi 3", 3);
//		tabThreadJou[3] = new ThreadIA3(tabJou[3], grille);
//		tabThreadJou[3].start();

		// Création de l'interface
		FenetrePlateau fenetrePlateau = new FenetrePlateau(ThreadJoueur.grille, tabJou, humain);
		//fenetrePlateau.setCtrl((ThreadHumain) tabThreadJou[0]);
		fenetrePlateau.setVisible(true);

	}

}
