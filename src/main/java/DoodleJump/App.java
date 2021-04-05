package DoodleJump;

import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * This is the  main class where your DoodleJump game will start.
 * The main method of this application calls the App constructor. You 
 * will need to fill in the constructor to instantiate your game.
 *
 * Class comments here...
 *
 * @author vduong
 * Did you discuss your design with another student?
 * If so, list their login here:
 *
 */

public class App extends JFrame {

	public App() {
		super("Doodle Jump");// JFrame takes in a string as a parameter to set the title
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.add(new MainPanel());
		this.setPreferredSize(new Dimension(400, 700));
		this.setVisible(true);
		this.pack();
	}

	/*Here's the mainline!*/
	public static void main(String[] argv) {
		new App();
	}

}
