package controller;

import model.*;

public class ThreadJoueur extends Thread {
	public static Grille grille = new Grille();
	protected Joueur jou;
	protected boolean running;
	
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
