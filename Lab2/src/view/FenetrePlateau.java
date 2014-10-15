package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Grille;

public class FenetrePlateau extends JFrame {
	private static final long serialVersionUID = 1L;
	private int x, y, width, height;
	private JeuPanel jPan;
	

	public FenetrePlateau(int x, int y, int widht, int height) {
		this.x = x;
		this.y = y;
		this.width = widht;
		this.height = height;
	}

	public FenetrePlateau(Grille g) {
		this(200, 150, 700, 500);
		System.out.println("Cr�ation de la fen�tre principale");
		setTitle("Tron");
		setBounds(x, y, width, height);
		/* D�commenter pour ajouter la popup de fermeture
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new OnClosePlateau(this));*/
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		HeaderPanel hPan = new HeaderPanel();
		jPan = new JeuPanel(g);
		JPanel plateauPan = new JPanel(new BorderLayout());
		plateauPan.setBackground(Color.WHITE);
		plateauPan.add(hPan, BorderLayout.NORTH);
		plateauPan.add(jPan);
		add(plateauPan);
		
		setVisible(true);
	}
}
