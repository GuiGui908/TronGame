package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import controller.ThreadJoueur;
import model.*;

public class FenetrePlateau extends JFrame {
	private static final long serialVersionUID = 1L;
	private Joueur humain;
	
	
	public FenetrePlateau(Joueur[] tabJou, ThreadJoueur[] tabThreadJou, Joueur humain) {
		System.out.println("Création de la fenêtre principale");
		this.humain = humain;
		setTitle("Tron");
		setMinimumSize(new Dimension(817, 596));
		setLocationRelativeTo(null);
		/* Décommenter pour ajouter la popup de fermeture de fenêtre
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new OnClosePlateau(this));*/
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		HeaderPanel hPan = new HeaderPanel(tabJou, tabThreadJou);
		JeuPanel jPan = new JeuPanel();
		getContentPane().add(hPan, BorderLayout.NORTH);
		getContentPane().add(jPan);

		addKeyListener(new ActionUser());
	}

	class ActionUser implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) { }

		@Override
		public void keyPressed(KeyEvent e) {
			if(!humain.isDead()) {
				if(e.getKeyCode() == KeyEvent.VK_UP){
					if(humain.getDirection() != 'b')	// évite de se retourner
						humain.setDirection('h');
					System.out.println("up");
				}
	
				if(e.getKeyCode() == KeyEvent.VK_DOWN){
					if(humain.getDirection() != 'h')	// évite de se retourner
						humain.setDirection('b');
					System.out.println("down");
				}
	
				if(e.getKeyCode() == KeyEvent.VK_LEFT){
					if(humain.getDirection() != 'd')	// évite de se retourner
						humain.setDirection('g');
					System.out.println("left");
				}
	
				if(e.getKeyCode() == KeyEvent.VK_RIGHT){
					if(humain.getDirection() != 'g')	// évite de se retourner
						humain.setDirection('d');
					System.out.println("right");
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent e) { }		
	}

}