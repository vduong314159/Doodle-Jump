package DoodleJump;

import java.awt.event.*;

/**
 * Timer keeps track of time which is necessary to mimic physics. According to the laws of physics, specific things happen at particular times.
 * @author vduong
 *
 */

public class MyTimer extends javax.swing.Timer {
	private DrawingPanel _drawingPanel;
	
	public MyTimer(DrawingPanel drawingPanel){
		super( (int)Constants.TIMESTEP, null);
		this.addActionListener(new JumpListener());
		_drawingPanel = drawingPanel;
	}
	
	private class JumpListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			_drawingPanel.doodleJump();
		}	
	}
}
