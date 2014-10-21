package controller;

import model.*;

public class ThreadJoueur extends Thread {
	static Grille grille = new Grille();
	Joueur jou;
	boolean running;
	
	// Constructeur
	public ThreadJoueur(Joueur jou) {
		super();
		this.jou = jou;
		this.running = true;
		grille.setPos(jou);
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}
	
	

}
