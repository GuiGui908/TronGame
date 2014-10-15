package model;

/**			GRILLE
 j(y)  ^
	   |
  	   | 0  1  2  3 
	  0|-------------->
	  1|    		 i(x)
	  2|
	  3|
	    
 */
public class Grille {
	private int largeur = 70, hauteur = 40;
	private byte[][] plateau;

	// Constructeur
	public Grille() {
		plateau = new byte[hauteur][largeur];	// initialisé par défaut à 0
		plateau[hauteur/2][largeur/2] = -1;		// BD
		plateau[hauteur/2][largeur/10] = 1;		// BG 
		plateau[hauteur/10][largeur/2] = 2;		// HD
		plateau[hauteur/10][largeur/10] = 3;	// HG
	}

	// Modifieur
	public void setPos(int x, int y, byte val) {
		if(x < plateau.length && y < plateau[x].length) {
			plateau[x][y] = val;
		}
	}
	
	// Accesseurs
	public byte getPos(int x, int y) {
		try {
			return plateau[y][x];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println(" NAWAK !!!!!!!!!!!!" + e);
		}
		return 0;
	}
	
	public int getLargeur() {
		return largeur;
	}

	public int getHauteur() {
		return hauteur;
	}

	@Override
	public String toString() {
		String str = "<===  Grille  ===>\n";
		for(int y=0; y<hauteur; y++) {
			for(int x=0; x<largeur; x++) {
				str += "  " + plateau[y][x];
			}
			str += "\n";
		}
		return str;
	}
}
