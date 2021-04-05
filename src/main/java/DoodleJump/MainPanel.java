package DoodleJump;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
	
	public MainPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); //I chose Box Layout over the initial Flow Layout so the quit button is below the drawing panel and not next to it. The frame looks better this way.
		
		this.add(new DrawingPanel());
		this.add(new RestartButtonPanel());
	}
}
