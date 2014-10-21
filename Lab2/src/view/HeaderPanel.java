package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import controller.ThreadJoueur;
import model.Joueur;

public class HeaderPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton debut;
	private ThreadJoueur[] tabThreadJou;
	private Joueur[] tabJou;
	private JLabel[] lblJoueur;

	// Constructeur
	public HeaderPanel(Joueur[] tabJou, ThreadJoueur[] tabThreadJou) {
		this.tabThreadJou = tabThreadJou;
		this.tabJou = tabJou;
		lblJoueur = new JLabel[tabJou.length]; 
		
		setBackground(Color.DARK_GRAY);
		setLayout(new FlowLayout(FlowLayout.CENTER));

		debut = new JButton("Commencer");
		debut.setFocusable(false);		// Sinon le focus est sur le bouton et non sur la fenêtre...
										// et donc le listenner sur les flèches du clavier est HS
		debut.addActionListener(new ClicCommencerListener());
		add(debut);

		for(int i = 0; i< lblJoueur.length; i++) {
			lblJoueur[i] = new JLabel("     "+ tabJou[i].getNom() +" : "+ tabJou[i].getScore());
			lblJoueur[i].setForeground(tabJou[i].getCouleur());
			add(lblJoueur[i]);
		}
		
		// Rafraîchissement des scores toutes les demi-secondes
		Timer refreshScores = new Timer(500, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i< lblJoueur.length; i++) {
					// Ci-dessous, HeaderPanel.this.tabJou fait référence à l'attribut de la classe HeaderPanel !!
					lblJoueur[i].setText("     "+ HeaderPanel.this.tabJou[i].getNom() +
								" : " + HeaderPanel.this.tabJou[i].getScore() );
				}
			}
		});
		refreshScores.start();
	}
	
	public void setCommencerTrue() {
		debut.setEnabled(true);
	}
	
	// Listenner du bouton
	class ClicCommencerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Clic commencer !!");
			debut.setEnabled(false);
			ThreadJoueur.grille.initGrille();	// Réinitialise la grille
			
			// Lance tous les Threads des joueurs
			for(ThreadJoueur thj : tabThreadJou) {
				if(!thj.isAlive())
					thj.start();	// start
				else
					thj.notify();	// ou réveille
			}
		}
	}
}
