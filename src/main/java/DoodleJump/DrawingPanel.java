package DoodleJump;


//import gfx.Ellipse;
//import javax.swing.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/** This is my drawing panel where the game happens. I instantiate my doodle, platforms, timer to keep track of time which is necessary to mimic physics,
 * and game over label which "appears" at the end of the game, in here. 
 * It implements KeyListener and performs methods on the doodle according to the key listener.
 * 
 * @author vduong_isItDaytime
 *
 */

public class DrawingPanel extends JPanel implements KeyListener {
	private JLabel _gameOverLabel; //this tells the player when the game's over and the score 
	private Doodle _doodle;
	private MyTimer _timer;
	private double _x, _y, _v, _a, _changeY;
	private int _score;
	private ArrayList<Platform> _platforms;
	private Platform _replacingPlatform, _lowestPlatform, _highestPlatform, _intersectingPlatform;
	
	public DrawingPanel() {
		super();
		Dimension size = new Dimension(390, 790);
		this.setPreferredSize(size);
		this.setSize(size);
		this.setBackground(Color.cyan);
		
		_gameOverLabel = new JLabel("");
		_doodle = new Doodle(this);
		
		_platforms = new ArrayList<Platform>();
		_platforms.add(new Platform(this)); //add first platform
		
		_platforms.get(0).setLocation(Constants.First_PLATFORM_X, Constants.First_PLATFORM_Y); //game starts and doodle starts in same position and the first platform is always in the same position, right under the doodle
		
		for (int i = 1; i < 20; i++) { //create 2nd,..., last platforms that doodle isn't under. I made sure to have enough platform so that some of them are off panel view and move into view rather than generated in the panel.
			_platforms.add(new Platform(this));
			_platforms.get(i).setLocationBtwnRanges(_platforms.get(i-1).getX(), _platforms.get(i-1).getY()); //platforms have semi-random positions
		}
		
		this.setFocusable(true); //make it so that KeyListner works
		this.grabFocus();
		this.addKeyListener(this);
		
		_timer = new MyTimer(this);
		_timer.start();
	}	
	
	public void paintComponent(Graphics brush) {
		super.paintComponent(brush);//partial override. the superclass' method calls paint on Swing elements that I included in my drawing panel;	
		this.add(_gameOverLabel);
		
		for (int i = 0; i < 20; i++) { //all platforms except some of the first platforms are initial locations are in thepanel
			_platforms.get(i).paintOnMainPanel((Graphics2D) brush);
		}
		_doodle.paintOnMainPanel((Graphics2D) brush);
	} 
	
	public void keyPressed(KeyEvent e) {
		int keyPressed = e.getKeyCode();
		_x = _doodle.getX();
		if (keyPressed == KeyEvent.VK_LEFT) {
			_doodle.moveLeft(10);
		}
		else if (keyPressed == KeyEvent.VK_RIGHT) {
			_doodle.moveRight(10);
		}
		this.repaint();
	}
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {} //nothing happens, ie stop calling methods called when keys are pressed
		

	public void doodleJump() {
		if (_doodle.getY() > 790) { //check if doodle has fallen off the drawing panel and the game is over
			_gameOverLabel.setText("Game Over!"); //don't repaint because repainting would be unnecessary
		}
		else {
			_doodle.JumpOrFall(_platforms); //doodle jumps and obeys the laws of physics
			if (_doodle.getVelocity() == 0) { //doodle's "velocity" = 0, "doesn't move", when it intersects a platform not at a lower position on panel and platforms need to move down. This looks like the doodle is jumping up but the the platforms are really moving down the panel.
				_intersectingPlatform = _doodle.getIntersectingPlatform();
				_changeY = Constants.First_PLATFORM_Y - _intersectingPlatform.getY();
				_score = (int) _changeY + _score;
				_gameOverLabel.setText(Integer.toString(_score));
				if ( Constants.First_PLATFORM_Y - _intersectingPlatform.getY() >= 10) { 
					for (Platform thisPlatform : _platforms) {
						thisPlatform.moveDown(10); //the platforms move down 10 pixels per tick to give the impression of continuity
					}
				}
				if (Constants.First_PLATFORM_Y - _intersectingPlatform.getY() < 10) // when the platforms need to move down less than 10 pixels, they move down as much as they need to, not 10 pixels at the last tick
					for (Platform thisPlatform : _platforms) {
						thisPlatform.moveDown(Constants.First_PLATFORM_Y - _intersectingPlatform.getY());
					}
				for (int i = 0; i < _platforms.size(); i++) {
					if (_platforms.get(i).getY() > 780) { //if a platform moves down, off screen, the platform changes location to a semirandom location bounded by the platform that precedes it
						if (i == 0) { //can not index -1
							_platforms.get(i).setLocationBtwnRanges(_platforms.get(19).getX(),_platforms.get(19).getY());
						}
						else if (i == 3) {
							_platforms.get(i).setLocationBtwnRanges(_platforms.get(10).getX(), _platforms.get(10).getY());//at some height, this makes it so that there are more platforms at varying x's.	
						}
						else {
							_platforms.get(i).setLocationBtwnRanges(_platforms.get(i-1).getX(), _platforms.get(i-1).getY()); //platforms are generated close enough to eachother that doodle can jump from one platform to another. The doodle should always be able to move from one platform to another.
						}
					}
				}
			}
			this.repaint();
		}
	}
}