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
		plateau = new byte[hauteur][largeur];	// initialisé par défaut à -1
		for(int i=0; i<hauteur; i++)
			for(int j=0; j<largeur; j++)
				plateau[i][j] = -1;
/*		
		plateau[hauteur/2][largeur/2] = -1;		// BD
		plateau[hauteur/2][largeur/10] = 1;		// BG 
		plateau[hauteur/10][largeur/2] = 2;		// HD
		plateau[hauteur/10][largeur/10] = 3;	// HG*/
	}

	// Modifieur
	@Deprecated
	public boolean setPos(int x, int y, byte val) {
		if(x < plateau.length && y < plateau[x].length) {
			plateau[x][y] = val;
			return true;
		}
		return false;
	}
	
	public boolean setPos(Joueur j) {
		int X = j.getPosX(), Y = j.getPosY();
		
		// Vérif qu'on est dans la grille
		if(X >= 0 && Y >= 0 && X < plateau.length && Y < plateau[X].length) {
				plateau[X][Y] = (byte) j.getRole();
				return true;
		}
		return false;
	}
	
	// Accesseurs
	public byte getPos(int x, int y) {
		try {
			return plateau[y][x]; // a verifier
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println(" NAWAK !!!!!!!!!!!!" + e);
		}
		return 0;
	}
	
	public byte getPos(Joueur j)
	{
		int X = j.getPosX(), Y = j.getPosY();
		try {
			return plateau[X][Y]; // a verifier
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
