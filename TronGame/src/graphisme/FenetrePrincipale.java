package graphisme;

import java.awt.Color;

import javax.swing.JFrame;

public class FenetrePrincipale extends JFrame {
	private static final long serialVersionUID = 1L;

	public FenetrePrincipale(int x0, int y0, int largeur, int hauteur) {
		setTitle("Tron Game - Younès & Gui");
		setBounds(x0, y0, largeur, hauteur);
		setBackground(new Color(92, 225, 245));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		FenetrePrincipale fp = new FenetrePrincipale(250, 150, 800, 500);

		fp.setVisible(true);
	}

}
