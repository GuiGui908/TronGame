package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		//debut.addActionListener(new ClicCommencer());
		add(debut);

		for(Joueur j : tabJou) {
			JLabel lbl = new JLabel("     "+ j.getNom() +" : "+ j.getScore());
			lbl.setForeground(j.getCouleur());
			add(lbl);
		}
	}
	
	class ClicCommencer implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO MARCHE PAS !!!!!!
			// J'avais mis plein de parametres pr avoir accès d'ici au tableau de Threads déclaré dans le main.... Ct pas la bonne solution
		}
	}

}
