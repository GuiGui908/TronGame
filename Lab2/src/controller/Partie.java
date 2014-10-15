package controller;

import model.Grille;
import view.FenetrePlateau;

public class Partie {

	public static void main(String[] args) {
		Grille grille = new Grille();
		FenetrePlateau fenetrePlateau = new FenetrePlateau(grille);
		
		//System.out.println(grille);
	}

}
