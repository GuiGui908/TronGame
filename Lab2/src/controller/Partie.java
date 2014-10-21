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
		
		tabThreadJou = new ThreadJoueur[3];
	    tabJou = new Joueur[3];

	    // Crée les Joueurs( nom, position, vitesse)
	    humain = new Joueur("Younès", 0, 20);
	    tabJou[0] = humain;
	    tabJou[1] = new Joueur("Ordi 1", 3, 20);
		tabJou[2] = new Joueur("Ordi 2",2, 20);
	    
		// crée les Threads de contrôle
		tabThreadJou[0] = new ThreadHumain(humain);
		tabThreadJou[1] = new ThreadIA(humain,tabJou[1]);
		tabThreadJou[2] = new ThreadIA(humain, tabJou[2]);
		
		// Création de l'interface
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
				int vivant = tabJou.length;
				for(Joueur jou : tabJou)
					if(jou.isDead()) 
						vivant--;
				
//				System.out.println("vivant " +vivant);
				// Si il reste plus qu'un thread vivant
				if(vivant == 1)
				{
					for(Joueur jou : tabJou) {
						if(!jou.isDead()) {
							jou.setScore();			// Score++
							jou.setDead(true);		// On tue le dernier joueur pour arrêter le thread
							sleep(64);				// On attend un peu pour être sûr que le thread s'est arrêté
						}
						System.out.println("     "+ jou.getNom() +" : "+ jou.getScore());
						jou.setDead(false);		// On réanime chaque joueur pour la prochaine partie
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
