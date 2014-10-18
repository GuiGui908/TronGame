package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.*;
import controller.*;

public class FenetrePlateau extends JFrame {
	private static final long serialVersionUID = 1L;
	private int x, y, width, height;
	private ThreadHumain Thj;
	
	
	public FenetrePlateau(int x, int y, int widht, int height) {
		this.x = x;
		this.y = y;
		this.width = widht;
		this.height = height;
		this.Thj = null;
	}

	public FenetrePlateau(Grille g, Joueur[] tabJou) {
		this(200, 150, 576, 395);
		System.out.println("Cr�ation de la fen�tre principale");
		setTitle("Tron");
		setBounds(x, y, width, height);
		/* D�commenter pour ajouter la popup de fermeture de fen�tre
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
	
	public void setCtrl(ThreadHumain ThJ)
	{
		this.Thj = ThJ;
	}
	
	
	class ActionUser implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyCode() == KeyEvent.VK_UP){
				
				Thj.setDirection('h');
				System.out.println("up");
			}

			if(e.getKeyCode() == KeyEvent.VK_DOWN){
				Thj.setDirection('b');
				System.out.println("down");
			}

			if(e.getKeyCode() == KeyEvent.VK_LEFT){
				Thj.setDirection('g');
				System.out.println("left");
			}

			if(e.getKeyCode() == KeyEvent.VK_RIGHT){
				Thj.setDirection('d');
				System.out.println("right");
			}

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	
}





