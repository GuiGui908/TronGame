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
	private char direction;
	private int vitesse;
	private boolean isDead;
	
	/*  Constructeurs  */
	public Joueur() {
		this("Joueur par défaut", 0, 0);
	}

	public Joueur(String nom, int role, int vitesse) {
		this(nom, role, role*6+10, role*6+16, 'd', vitesse);
	}

	public Joueur(String nom, int role, int posX,
			int posY, char direction, int vitesse) {
		this.nom = nom;
		this.role = role;
		score = 0;
		couleur = Joueur.getColor((byte) role);
		this.posX = posX;
		this.posY = posY;
		this.direction = direction;
		this.vitesse = vitesse;
		isDead = false;
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	/*  Getters  */
	public char getDirection()
	{
		return direction;
	}
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
	
	public int getVitesse() {
		return vitesse;
	}

	/*  Setters  */
	public void setScore(int score) {
		this.score = score;
	}
	
	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}


	public void avance() {
		switch (direction) {
		case 'h':
			posY--;
			break;
		case 'b':
			posY++;
			break;
		case 'd':
			posX++;
			break;
		case 'g':
			posX--;
			break;
		}
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
