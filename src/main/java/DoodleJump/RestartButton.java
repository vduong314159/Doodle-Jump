package DoodleJump;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * EXTRA CREDIT
 * This is my restart button. It restarts the game.
 * 
 * @author vduong
 *
 */

public class RestartButton extends javax.swing.JButton {
	
	public RestartButton() {
		super("Restart Game");
		this.addActionListener(new RestartListener());
	}
	private class RestartListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new App();
		}
	}
}
