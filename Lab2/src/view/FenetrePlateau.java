package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Grille;
import model.Joueur;

public class FenetrePlateau extends JFrame {
	private static final long serialVersionUID = 1L;
	private int x, y, width, height;
	
	
	public FenetrePlateau(int x, int y, int widht, int height) {
		this.x = x;
		this.y = y;
		this.width = widht;
		this.height = height;
	}

	public FenetrePlateau(Grille g, Joueur[] tabJou) {
		this(200, 150, 700, 500);
		System.out.println("Création de la fenêtre principale");
		setTitle("Tron");
		setBounds(x, y, width, height);
		/* Décommenter pour ajouter la popup de fermeture de fenêtre
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new OnClosePlateau(this));*/
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		HeaderPanel hPan = new HeaderPanel(tabJou);
		JeuPanel jPan = new JeuPanel(g);
		JPanel plateauPan = new JPanel(new BorderLayout());
		plateauPan.setBackground(Color.WHITE);
		plateauPan.add(hPan, BorderLayout.NORTH);
		plateauPan.add(jPan);
		add(plateauPan);
	}
}
