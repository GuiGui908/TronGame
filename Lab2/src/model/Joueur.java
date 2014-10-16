package model;

import java.awt.Color;

public class Joueur {
	private String nom;

	/*	Role :
	 * 0 = humain
	 * 1 = ordinateur d'IA 1 
	 * 2 = ordinateur d'IA 2 
	 * 3 = ordinateur d'IA 3 */
	private int role;
	private int score;
	private Color couleur;
	private int posX, posY;
	private int direction;
	private int vitesse;
	
	
	/*  Constructeurs  */
	public Joueur() {
		this("Joueur par défaut", 0);
	}

	public Joueur(String nom, int role) {
		this(nom, role, role*6+10, role*6+16, 0, 0);
	}

	public Joueur(String nom, int role, int posX,
			int posY, int direction, int vitesse) {
		this.nom = nom;
		this.role = role;
		score = 0;
		couleur = Joueur.getColor((byte) role);
		this.posX = posX;
		this.posY = posY;
		this.direction = direction;
		this.vitesse = vitesse;
	}

	/*  Getters  */
	public String getNom() {
		return nom;
	}

	public int getRole() {
		return role;
	}

	public int getScore() {
		return score;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
	
	public Color getCouleur() {
		return couleur;
	}

	/*  Setters  */
	public void setScore(int score) {
		this.score = score;
	}

	public void vaHaut() {
		posY--;
	}

	public void vaBas() {
		posY++;
	}
	
	public void vaGauche() {
		posX--;
	}
	
	public void vaDroite() {
		posX++;
	}
	
	// Méthode statique
	public static Color getColor(byte role) {
		switch (role) {
		case -1:
			return Color.LIGHT_GRAY;
		case 0:
			return Color.GREEN;
		case 1:
			return Color.YELLOW;
		case 2:
			return Color.BLUE;
		case 3:
			return Color.RED;
		}
		return Color.WHITE;
	}
}
