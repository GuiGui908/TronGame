package controller;

import model.Joueur;
import view.FenetrePlateau;

public class Partie extends Thread{

	private ThreadJoueur[] tabThreadJou;
	private Joueur[] tabJou;
	Joueur humain;
	
	public Partie() {
		
		tabThreadJou = new ThreadJoueur[3];
	    tabJou = new Joueur[3];
	    humain = new Joueur("Younès", 0, 20);		// crée un Joueur( nom, position, vitesse)
	    
	    tabJou[0] = humain;
	    tabJou[1] = new Joueur("Ordi 1", 3, 20);
		tabJou[2] = new Joueur("Ordi 2",2, 20);
	    
		tabThreadJou[0] = new ThreadHumain(humain);	// crée un Thread de contrôle
		tabThreadJou[1] = new ThreadIA(humain,tabJou[1]);
		tabThreadJou[2] = new ThreadIA(humain, tabJou[2]);
		
		for(ThreadJoueur thrd : tabThreadJou)
			thrd.start();		

		// Création de l'interface
		FenetrePlateau fenetrePlateau = new FenetrePlateau(ThreadJoueur.grille, tabJou, humain);
		fenetrePlateau.setVisible(true);

	}
	

	@Override
	public void run() {
		try {
			boolean end = false;
			
			while(!end)
			{
			int vivant = tabJou.length;
			for(Joueur jou : tabJou)
				if(jou.isDead()) 
					vivant--;
//			System.out.println("vivant " +vivant);
			if(vivant == 1)
				{
				for(ThreadJoueur thrd : tabThreadJou)
					if(thrd.isRunning()) 
						thrd.setRunning(false);
				
				for(Joueur jou : tabJou)
					{
					if(!jou.isDead())
						jou.setScore();
				System.out.println("     "+ jou.getNom() +" : "+ jou.getScore());
					}
					System.out.println("winnnnnnnn !!!");
					end= true;
				}
			
			sleep(200);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
