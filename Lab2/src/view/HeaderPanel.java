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

	public HeaderPanel(Joueur[] tabJou, ThreadJoueur[] tabThreadJou) {
		this.tabThreadJou = tabThreadJou;
		this.tabJou = tabJou;
		lblJoueur = new JLabel[tabJou.length]; 
		
		setBackground(Color.DARK_GRAY);
		setLayout(new FlowLayout(FlowLayout.CENTER));

		debut = new JButton("Commencer");
		debut.setFocusable(false);
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
	
	class ClicCommencerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Clic commencer !!");
			debut.setEnabled(false);
			for(ThreadJoueur thj : tabThreadJou) {
				if(!thj.isAlive())
					thj.start();
			}
		}
	}
}
