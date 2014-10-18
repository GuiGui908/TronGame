package controller;


import model.Joueur;

public class ThreadIA extends ThreadJoueur {
	// le joueur de couleur jaune 
	
	public ThreadIA(Joueur jou) {
		super(jou);
	}

	@Override
	public void run() {
		boolean running = true;
		
		System.out.println("Lancement de l'ordi : "+getName());
		while(running) {
			try {
				// Si la case devant est pas libre alors on tourne	
				if(jou.getDirection() == 'd' && grille.getPos(jou.getPosX()+1 ,jou.getPosY()) != -1)
					jou.setDirection('h');
				else if(jou.getDirection() == 'g' && grille.getPos(jou.getPosX()-1, jou.getPosY()) != -1)
					jou.setDirection('b');
				else if(jou.getDirection() == 'h' && grille.getPos(jou.getPosX(), jou.getPosY()-1) != -1)
					jou.setDirection('g'); 
				else if(jou.getDirection() == 'b' && grille.getPos(jou.getPosX(), jou.getPosY()+1) != -1)
					jou.setDirection('d');
				
				jou.avance();		// On avance
				if(grille.setPos(jou) == false) {	// Si on s'est planté
					// Fin de partie (l'IA s'est crashé)
					running = false;
					System.out.println("Ordinateur crashé !!!!");
				}
				sleep(jou.getVitesse());
				
//				if(jou.getDirection() == 'd')
//					if(jou.getPosY() ==  grille.getLargeur()-1)// || grille.getPos(jou.getPosX(),jou.getPosY()+1) != -1)
//						jou.changeDir('h');
//
//				if(jou.getDirection() == 'g')
//					if(jou.getPosY() == 1)// || grille.getPos(jou.getPosX(),jou.getPosY()-1) != -1)
//						jou.changeDir('b');
//
//				if(jou.getDirection() == 'h')
//					if(jou.getPosX() == 1 )//|| grille.getPos(jou.getPosX()-1,jou.getPosY()) != -1)
//						jou.changeDir('g');
//
//				if(jou.getDirection() == 'b')
//					if(jou.getPosX() ==  grille.getHauteur()-1 )//|| grille.getPos(jou.getPosX()+1,jou.getPosY()) != -1)
//						jou.changeDir('d');
			} catch (InterruptedException e) {
			}
		}
	}
}
