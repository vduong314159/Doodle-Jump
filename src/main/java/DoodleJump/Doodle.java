package DoodleJump;

import gfx.Ellipse;
import gfx.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * This is my doodle class. My doodle is a ball with black dots. I made it a composite shape for extra credit.
 * 
 * @author vduong
 *
 */

public class Doodle {
	private Shape _doodle, _dot1, _dot2;
	private JLabel _label;
	private double _velocity, _acceleration, _initialX, _initialY, _changeY;
	private boolean _doodleIntersectsAPlatform, _doodleAtHeight;
	private Platform _intersectingPlatform;

	public Doodle(javax.swing.JPanel mainPanel) {
		_doodle = new Ellipse(mainPanel);
		_dot1 = new Ellipse(mainPanel);
		_dot2 = new Ellipse(mainPanel);
		
		_doodle.setColor(Color.RED);
		_dot1.setColor(Color.WHITE);
		_dot2.setColor(Color.WHITE);
		
		_initialX = Constants.First_DOODLE_X;
		_initialY = Constants.First_DOODLE_Y;
		_doodle.setLocation(_initialX, _initialY);
		_doodle.setSize(Constants.DOODLE_WIDTH, Constants.DOODLE_HEIGHT);//doodle width = 20 pixels, doodle height = 40 pixels
		
		_dot1.setLocation(_initialX + 7, _initialY + 7);
		_dot1.setSize(3, 3);
		
		_dot2.setLocation(_initialX + 13, _initialY + 13);
		_dot2.setSize(3, 3);
	}
	
	public void paintOnMainPanel(Graphics2D brush) {
		_doodle.setVisible(true);

		_doodle.paint(brush);
		
		_dot1.setVisible(true);
		_dot1.setColor(Color.BLACK);
		_dot1.paint(brush);
		
		_dot2.setVisible(true);
		_dot2.setColor(Color.BLACK);
		_dot2.paint(brush);
	}
	
	public void setLocation(double x, double y) {
		_doodle.setLocation(x, y);
		_dot1.setLocation(x +7, y + 7);
		_dot2.setLocation(x+4, y+4);
	}
	
	public void moveLeft(double x){
		double _newX = _doodle.getX() - x;
		
		if (_newX < 0) { //doodle doesn't move off the panel
			_newX = 390 + _newX;
		}
		_doodle.setLocation(_newX, _doodle.getY());
		_dot1.setLocation(_newX + 7, _dot1.getY());
		_dot2.setLocation(_newX+15, _dot2.getY());
		
	}
	
	public void moveRight(double x) {
		double _newX = _doodle.getX() + x;
		if (_newX > 390) { //set wrapping, doodle doesn't move off the panel
			_newX = 390 - _newX;
		}
		_doodle.setLocation(_newX, _doodle.getY());
		_dot1.setLocation(_newX + 7, _dot1.getY());
		_dot2.setLocation(_newX + 15, _dot2.getY());
	}
	
	public double getX() {
		return _doodle.getX();
	}

	public double getY() {
		return _doodle.getY();
	}
	
	public void JumpOrFall(ArrayList<Platform> platform) {
		for (Platform thisPlatform : platform){ //checks if doodle is intersecting a platform by checking all platforms
			if (_doodle.intersects(thisPlatform.getX(), thisPlatform.getY(), Constants.PLATFORM_WIDTH, Constants.PLATFORM_HEIGHT)) { //if this is false, _doodleIntersectsAPlatform is not affected b/c if one platform doesn't intersect the doodle doesn't mean no platform intersects doodle
				_doodleIntersectsAPlatform = true;
				_intersectingPlatform = thisPlatform;
			}
			if (thisPlatform.getY() == Constants.First_PLATFORM_Y) { // if any platform is at the bottom of the screen, the doodle is at its height of its jump, not jumping any higher
				_doodleAtHeight = true;
			}
		}
		if (_doodleIntersectsAPlatform){
			if (_intersectingPlatform.getY() == Constants.First_PLATFORM_Y) { //doodle is intercepting a platform and the platform is at bottom of screen
				_velocity = Constants.REBOUND_VELOCITY * Constants.TIMESTEP/1000;
			}
			else {
				_velocity = 0; //doodle stops moving and platform moves down (in DrawingPanel) to give illusion of doodle jumping up
			}
			_doodleIntersectsAPlatform = false; //after the doodle jumps up, velocity = rebound velocity, doodle is not longer intercepting a platform
		}
		else {
			if (_doodleAtHeight){ //doodle isn't intercepting a platform and none of the platforms need to move down the screen to give illusion of doodle jumping up, so the doodle actually moves up
				_acceleration = Constants.GRAVITY * Constants.TIMESTEP/1000;
				_velocity = _velocity + _acceleration;
				_doodleAtHeight = false;
			}
			else { //platforms need to move down to give illusion of doodle jumping (moving) up
				_velocity = 0;
			}
		}		
		_initialY = _initialY + _velocity;
		_doodle.setLocation(_doodle.getX(), _initialY); //doodle moves up or down
		_dot1.setLocation(_dot1.getX(), _initialY + 7);
		_dot2.setLocation(_dot2.getX(), _initialY+15);
	}
	
	public Platform getIntersectingPlatform() {
		return _intersectingPlatform;
	}
	
	public double getVelocity() {
		return _velocity;
	}
}
