package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Joueur;

public class HeaderPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton debut;

	public HeaderPanel(Joueur[] tabJou) {
		setBackground(Color.DARK_GRAY);
		//setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		debut = new JButton("Commencer");
		debut.setEnabled(false);
		add(debut);
		
		
		for(Joueur j : tabJou) {
			JLabel lbl = new JLabel("     "+ j.getNom() +" : "+ j.getScore());
			lbl.setForeground(j.getCouleur());
			add(lbl);
		}
	}

}
