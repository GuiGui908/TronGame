package controller;


import model.Joueur;

public class ThreadIA extends ThreadJoueur {
	// le joueur de couleur jaune 
	Joueur humain = null;
	public ThreadIA(Joueur humain, Joueur ordi) {
		super(ordi);
		this.humain = humain;
	}

	@Override
	public void run() {
		boolean running = true;

		System.out.println("Lancement de l'ordi : "+getName());
		while(running) {
			try { 
				int rand = (int) (Math.random() *10);
				int x = jou.getPosX();
				int y = jou.getPosY();
				// une intelligence pour suivre le "humain"
				if(jou.getRole() == 2)
					jou.setDirection(humain.getDirection());
				// Si la case devant est pas libre alors on tourne	
				
				if(jou.getDirection() == 'd' && grille.getPos(x+1 ,y) != -1)  // direction droite
				{	System.out.println(rand);
				// si le haut et le bas est libre

				if(jou.getRole() == 3 &&  grille.getPos(x ,y-1) == -1 && grille.getPos(x ,y+1) == -1)
				{
					if(rand <5) 						jou.setDirection('b');
					else							    jou.setDirection('h');
				}
				else 
				{
					if(grille.getPos(x ,y-1) == -1)	 	jou.setDirection('h');
					else 								jou.setDirection('b');
				}

				}
				
				else if(jou.getDirection() == 'g' && grille.getPos(x-1, y) != -1)  // direction gauche
				{	System.out.println(rand);
				// si le haut et le bas sont libre

				if(jou.getRole() == 3 &&  grille.getPos(x ,y-1) == -1 && grille.getPos(x ,y+1) == -1)
				{
					if(rand <5) 						jou.setDirection('b');
					else							    jou.setDirection('h');
				}
				else 
				{
					if(grille.getPos(x ,y-1) == -1)	 	jou.setDirection('h');
					else 								jou.setDirection('b');
				}

				}
				
				else if(jou.getDirection() == 'h' && grille.getPos(x, y-1) != -1)  // direction haut
				{ 
					{	System.out.println(rand);
					// si la gauche  et la droite sont libre

					if(jou.getRole() == 3 &&  grille.getPos(x+1 ,y) == -1 && grille.getPos(x-1 ,y) == -1)
					{
						if(rand <5) 						jou.setDirection('g');
						else							    jou.setDirection('d');
					}
					else 
					{
						if(grille.getPos(x-1 ,y) == -1)	 	jou.setDirection('g');
						else 								jou.setDirection('d');
					}

					}
				}
				
				
				else if(jou.getDirection() == 'b' && grille.getPos(x, y+1) != -1)  // direction bas
				{ 
					{	System.out.println(rand);
					// si la gauche  et la droite sont libre

					if(jou.getRole() == 3 &&  grille.getPos(x+1 ,y) == -1 && grille.getPos(x-1 ,y) == -1)
					{
						if(rand <5) 						jou.setDirection('g');
						else							    jou.setDirection('d');
					}
					else 
					{
						if(grille.getPos(x-1 ,y) == -1)	 	jou.setDirection('g');
						else 								jou.setDirection('d');
					}

					}
				}

				jou.avance();		// On avance
				
				if(grille.setPos(jou) == false) {	// Si on s'est planté
					// Fin de partie (l'IA s'est crashé)
					running = false;
					System.out.println("Ordinateur crashé !!!!");
					jou.setDead(true);
				}	
				sleep(jou.getVitesse());

			} catch (InterruptedException e) {
			}
		}
	}
}
