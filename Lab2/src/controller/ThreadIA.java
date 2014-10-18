package controller;

import model.Grille;
import model.Joueur;

public class ThreadIA extends ThreadJoueur {
	// le joueur de couleur jaune 
	
	public ThreadIA(Joueur jou, Grille grille) {
		super(jou, grille);
	}

	@Override
	public void run() {
		while(true) {
			try {
				
					if(jou.getDirection() == 'd' && grille.getPos(jou.getPosX(),jou.getPosY()+1) != -1)
						jou.changeDir('h');
					else if(jou.getDirection() == 'g' && grille.getPos(jou.getPosX(),jou.getPosY()-1) != -1)
						jou.changeDir('b');
					else if(jou.getDirection() == 'h' && grille.getPos(jou.getPosX()-1,jou.getPosY()) != -1)
						jou.changeDir('g');
					else if(jou.getDirection() == 'b' && grille.getPos(jou.getPosX()+1,jou.getPosY()) != -1)
						jou.changeDir('d');
					else
				
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

				jou.changeDir(jou.getDirection());					
				grille.setPos(jou);
				sleep(jou.getVitesse());
			} catch (InterruptedException e) {
			}
		}
	}
}
