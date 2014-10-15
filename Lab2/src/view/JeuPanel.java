package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import model.Grille;

public class JeuPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	public static final int TAILLE_CASE = 8;
	private Grille grille;
	private int H , L;

	public JeuPanel(Grille grille) {
		this.grille = grille;
		H = grille.getHauteur();
		L = grille.getLargeur();
		setBackground(new Color(120, 222, 245));
	}


	@Override
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		for(int x=0; x<L; x++) {
			for(int y=0; y<H; y++) {
				Rectangle2D carre = new Rectangle2D.Double(
						x*TAILLE_CASE,	// X coin supérieur gauche
						y*TAILLE_CASE,	// Y coin supérieur gauche
						TAILLE_CASE-1,	// largeur (-1 permet un espacement entre cases)
						TAILLE_CASE-1);	// hauteur

				// On sélectionne la couleur en fonction de la grille
				switch(grille.getPos(x, y)) {
				case -1:
					g2.setPaint(Color.GREEN);
					break;
				case 0:
					g2.setPaint(Color.LIGHT_GRAY);
					break;
				case 1:
					g2.setPaint(Color.YELLOW);
					break;
				case 2:
					g2.setPaint(Color.BLUE);
					break;
				case 3:
					g2.setPaint(Color.RED);
					break;
				default:
					g2.setPaint(Color.WHITE);
				}
				g2.fill(carre);
			}
		}
	}

}
