package DoodleJump;
/**
 * EXTRA CREDIT
 * I am putting my restart button in this panel.
 */


import javax.swing.JButton;
import javax.swing.JPanel;

public class RestartButtonPanel extends javax.swing.JPanel {
	
	public RestartButtonPanel() {
		super();
				
		JButton restart = new RestartButton();
		//place it in its container and display
		this.add(restart);
	}
}