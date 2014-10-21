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

	    // Cr�e les Joueurs( nom, position, vitesse)
	    humain = new Joueur("Youn�s", 0, 20);
	    tabJou[0] = humain;
	    tabJou[1] = new Joueur("Ordi 1", 3, 20);
		tabJou[2] = new Joueur("Ordi 2",2, 20);
	    
		// cr�e les Threads de contr�le
		tabThreadJou[0] = new ThreadHumain(humain);
		tabThreadJou[1] = new ThreadIA(humain,tabJou[1]);
		tabThreadJou[2] = new ThreadIA(humain, tabJou[2]);
		
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
