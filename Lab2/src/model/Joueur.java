package model;

public class Joueur {
	private String nom;

	/* -1 = humain
	 * 1 = ordinateur d'IA 1 
	 * 2 = ordinateur d'IA 2 
	 * 3 = ordinateur d'IA 3 */
	private int role;
	private int couleur;
	private int score;
	private int posX, posY;
	private int direction;
	private int vitesse;
	
	
	/*  Constructeurs  */
	public Joueur() {
		this("Joueur par défaut", 0);
	}

	public Joueur(String nom, int role) {
		this(nom, role, role, role*10, role*10, 0, 50);
	}

	public Joueur(String nom, int role, int couleur, int posX,
			int posY, int direction, int vitesse) {
		this.nom = nom;
		this.role = role;
		this.couleur = couleur;
		score = 0;
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

	public int getCouleur() {
		return couleur;
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

	public int getDirection() {
		return direction;
	}

	public int getVitesse() {
		return vitesse;
	}

	/*  Setters  */
	public void setScore(int score) {
		this.score = score;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	
}
