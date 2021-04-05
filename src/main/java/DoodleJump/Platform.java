package DoodleJump;

import gfx.Rectangle;
import gfx.Shape;

import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 * This is my platform class which describes my platforms and how new platforms generate semirandomly.
 * 
 * @author vduong
 *
 */
public class Platform {
	private Shape _platform;
	private JPanel _drawingPanel;
	private double _x, _y, _minX, _maxX;
	
	public Platform(JPanel drawingPanel) {
		_platform = new Rectangle(drawingPanel);
		_drawingPanel = drawingPanel;
	}
	
	public void paintOnMainPanel(Graphics2D brush) {
		_platform.setVisible(true);
		_platform.setSize(Constants.PLATFORM_WIDTH, Constants.PLATFORM_HEIGHT);
		_platform.setColor(Color.black);
		_platform.paint(brush);
	}
	
	public void setLocationBtwnRanges(double precedingPlatformX, double precedingPlatformY) {
		if (precedingPlatformX < 150/2) {
			_minX = 0;
			_maxX = 150;
		}
		else if (precedingPlatformX > 350 - 150/2) {
			_minX = precedingPlatformX - (150/2);
			_maxX = 300;
		}
		
		else {
			_minX = precedingPlatformX - (150/2);
			_maxX = precedingPlatformX + (150/2);
		}
		_x = Math.random()*(_maxX - _minX);
		_x = _minX + _x -1;

		_y = Math.random()*100;
		_y = precedingPlatformY - _y - 70; //platforms should only generate above its preceding platforms and at least about 70 pixels above its preceding platforms. This doesn't really happen because some platforms aren't constrained by its preceding platform to have more variance
		_platform.setLocation(_x, _y);
	}
	
	public void moveDown(double y) {
		_platform.setLocation(_platform.getX(), _platform.getY() + y);
	}
	
	public JPanel getPanel() {
		return _drawingPanel;
	}
	
	public void setLocation(double x, double y) {
		_platform.setLocation(x, y);
	}
	
	public double getX() {
		return _platform.getX();
	}
	
	public double getY() {
		return _platform.getY();
	}
}
