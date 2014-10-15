package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HeaderPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel scoreMoi = new JLabel();
	private JLabel scoreIA1 = new JLabel();
	private JLabel scoreIA2 = new JLabel();
	private JLabel scoreIA3 = new JLabel();
	private JButton debut;

	public HeaderPanel() {
		setBackground(Color.DARK_GRAY);
		//setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		debut = new JButton();
		debut.setText("Commencer");
		add(debut);
		
		JLabel scMoi = new JLabel();
		scMoi.setForeground(Color.GREEN);
		scMoi.setText("                    Moi :");
		add(scMoi);
		
		scoreMoi.setForeground(Color.GREEN);
		scoreMoi.setText("0");
		add(scoreMoi);

		JLabel scIA1 = new JLabel();
		scIA1.setForeground(Color.YELLOW);
		scIA1.setText("     IA 1 :");
		add(scIA1);
		
		scoreIA1.setForeground(Color.YELLOW);
		scoreIA1.setText("11");
		add(scoreIA1);

		JLabel scIA2 = new JLabel();
		scIA2.setForeground(Color.BLUE);
		scIA2.setText("     IA 2 :");
		add(scIA2);
		
		scoreIA2.setForeground(Color.BLUE);
		scoreIA2.setText("22");
		add(scoreIA2);

		JLabel scIA3 = new JLabel();
		scIA3.setForeground(Color.RED);
		scIA3.setText("     IA 3 :");
		add(scIA3);
		
		scoreIA3.setForeground(Color.RED);
		scoreIA3.setText("33");
		add(scoreIA3);
	}

}
