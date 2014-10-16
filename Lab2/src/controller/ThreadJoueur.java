package controller;

import model.Grille;
import model.Joueur;

public class ThreadJoueur extends Thread {
	Joueur jou;
	Grille grille;
	
	// Constructeur
	public ThreadJoueur(Joueur jou, Grille grille) {
		super();
		this.jou = jou;
		this.grille = grille;
		grille.setPos(jou);
	}

}
