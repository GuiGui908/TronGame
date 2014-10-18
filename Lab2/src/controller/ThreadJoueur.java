package controller;

import model.*;

public class ThreadJoueur extends Thread {
	static Grille grille = new Grille();
	Joueur jou;
	
	// Constructeur
	public ThreadJoueur(Joueur jou) {
		super();
		this.jou = jou;
		grille.setPos(jou);
	}

}
