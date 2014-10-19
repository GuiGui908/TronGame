package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.*;

public class FenetrePlateau extends JFrame {
	private static final long serialVersionUID = 1L;
	private int x, y, width, height;
	private Joueur humain;
	
	
	public FenetrePlateau(int x, int y, int widht, int height) {
		this.x = x;
		this.y = y;
		this.width = widht;
		this.height = height;
	}

	public FenetrePlateau(Grille g, Joueur[] tabJou, Joueur humain) {
		this(200, 150, 617, 436);
		this.humain = humain;
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
		this.addKeyListener(new ActionUser());
	}
	
//	public void setCtrl(ThreadHumain ThJ) {
//		this.Thj = ThJ;
//	}
	
	
	class ActionUser implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) { }

		@Override
		public void keyPressed(KeyEvent e) {
			if(!humain.isDead())
			if(e.getKeyCode() == KeyEvent.VK_UP){
				if(humain.getDirection() != 'b')
					humain.setDirection('h');
				System.out.println("up");
			}

			if(e.getKeyCode() == KeyEvent.VK_DOWN){
				if(humain.getDirection() != 'h')
					humain.setDirection('b');
				System.out.println("down");
			}

			if(e.getKeyCode() == KeyEvent.VK_LEFT){
				if(humain.getDirection() != 'd')
					humain.setDirection('g');
				System.out.println("left");
			}

			if(e.getKeyCode() == KeyEvent.VK_RIGHT){
				if(humain.getDirection() != 'g')
					humain.setDirection('d');
				System.out.println("right");
			}
		}

		@Override
		public void keyReleased(KeyEvent e) { }		
	}

	
}





