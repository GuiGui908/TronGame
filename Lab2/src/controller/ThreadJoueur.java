package controller;

import model.*;

public class ThreadJoueur extends Thread {
	public static Grille grille = new Grille();
	protected Joueur jou;
	
	// Constructeur
	public ThreadJoueur(Joueur jou) {
		super();
		this.jou = jou;
		grille.setPos(jou);
	}
}
