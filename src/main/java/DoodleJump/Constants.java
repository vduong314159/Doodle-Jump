package DoodleJump;

/**
 * This is your Constants class. It defines some constants you will need
 * in DoodleJump, using the default values from the demo-- you shouldn't
 * need to change any of these values unless you want to experiment. You 
 * will, however, need to use them.
 *
 * A NOTE ON THE GRAVITY CONSTANT: 
 *   Because our y-position is in pixels rather than meters, we'll need our 
 *   gravity to be in units of pixels/sec 2 rather than the usual 9.8m/sec2. 
 *   There's not an exact conversion from pixels to meters since different 
 *   monitors have varying numbers of pixels per inch, but assuming a fairly 
 *   standard 72 pixels per inch, that means that one meter is roughly 2800 
 *   pixels. However, a gravity of 2800 pixels/sec2 might feel a bit fast. We
 *   suggest you use a gravity of about 1000 pixels/sec2. Feel free to change 
 *   this value, but make sure your game is playable with the value you choose.
 */

public class Constants {
	
public static final double GRAVITY = 30; // acceleration constant (UNITS: pixels/s^2)
public static final double REBOUND_VELOCITY = -900; // initial jump velocity (UNITS: pixels/s^2)
public static final double TIMESTEP = 16; // timer delay (UNITS: ms)

public static final double First_DOODLE_X = 200;//doodle must start in the same position just below platform at beginning of game
public static final double First_DOODLE_Y = 540;

public static final double First_PLATFORM_X = 189;// x-coordinate of first platform
public static final double First_PLATFORM_Y = 579; // y-coordinate of first platform, must be below doodle at start of game
public static final int PLATFORM_WIDTH = 40; // platform width (UNITS: pixels)
public static final int PLATFORM_HEIGHT = 10; // platform height (UNITS: pixels)
public static final int DOODLE_WIDTH = 40; // doodle width (UNITS: pixels)
public static final int DOODLE_HEIGHT = 40; // doodle height (UNITS: pixels)

}
