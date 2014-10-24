package controller;

import java.awt.BorderLayout;

import model.Joueur;
import view.FenetrePlateau;
import view.HeaderPanel;
import view.JeuPanel;

public class Partie extends Thread{

	private ThreadJoueur[] tabThreadJou;
	private Joueur[] tabJou;
	private HeaderPanel hPan;
	Joueur humain;
	
	public Partie() {
		
		tabThreadJou = new ThreadJoueur[4];
	    tabJou = new Joueur[4];

	    // Cr�e les Joueurs( nom, position, vitesse)
	    humain = new Joueur("Youn�s", 0, 20);
	    tabJou[0] = humain;
	    tabJou[1] = new Joueur("Ordi 1", 1, 20);
		tabJou[2] = new Joueur("Ordi 2", 2, 20);
		tabJou[3] = new Joueur("Ordi 3", 3, 20);
	    
		// cr�e les Threads de contr�le
		tabThreadJou[0] = new ThreadHumain(humain);
		tabThreadJou[1] = new ThreadIA(humain,tabJou[1]);
		tabThreadJou[2] = new ThreadIA(humain, tabJou[2]);
		tabThreadJou[3] = new ThreadIA(humain, tabJou[3]);

		
		// Cr�ation de l'interface
		FenetrePlateau fenetrePlateau = new FenetrePlateau(humain);
		hPan = new HeaderPanel(tabJou, tabThreadJou);
		JeuPanel jPan = new JeuPanel();
		
		fenetrePlateau.getContentPane().add(hPan, BorderLayout.NORTH);
		fenetrePlateau.getContentPane().add(jPan);
		fenetrePlateau.setVisible(true);
	}
	

	@Override
	public void run() {
		try {
			while(true)
			{
				// Si l'humain meurt, on arr�te la manche
				if(humain.isDead())
				{
					tabJou[1].setScore();
					for(Joueur jou : tabJou) {
						if(!jou.isDead()) {
										// Score++
							jou.setDead(true);		// On tue le dernier joueur pour arr�ter le thread
							sleep(64);				// On attend un peu pour �tre s�r que le thread s'est arr�t�
						}
						System.out.println("     "+ jou.getNom() +" : "+ jou.getScore());
						jou.setDead(false);		// On r�anime chaque joueur pour la prochaine partie
					}
					System.out.println("winnnnnnnn !!!");
					hPan.setCommencerTrue();
				}
				sleep(50);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
