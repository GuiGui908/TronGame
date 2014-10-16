package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import model.Grille;
import model.Joueur;

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
		
		// Thread qui redessine le dessin 60x par sec
		Thread refresh = new Thread() {
	        public void run() {
	        	while(true) {
	        		try {
						sleep(16);		// 16ms*60 = 960ms (~1s) ==> 60fps
						repaint();
					} catch (InterruptedException e) {
					}
	        	}
	        }
	      };
	      refresh.start();
	}


	@Override
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		// Dessine un rectangle pour chaque case de la grille
		for(int x=0; x<L; x++) {
			for(int y=0; y<H; y++) {
				Rectangle2D carre = new Rectangle2D.Double(
						x*TAILLE_CASE,	// X coin supérieur gauche
						y*TAILLE_CASE,	// Y coin supérieur gauche
						TAILLE_CASE-1,	// largeur (-1 permet un espacement entre cases)
						TAILLE_CASE-1);	// hauteur (idem)
				g2.setPaint(Joueur.getColor(grille.getPos(x, y))); 
				g2.fill(carre);
			}
		}
	}

}
