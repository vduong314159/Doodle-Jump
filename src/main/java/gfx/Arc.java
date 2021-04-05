package gfx;
/**
 * This class represents an Arc shape.
 */
import java.awt.geom.*;

public class Arc extends Shape {

	public Arc(javax.swing.JPanel container) {
		super(container, new Arc2D.Double(new Rectangle2D.Double(), 0, 180, Arc2D.CHORD)); // Call the superclass's constructor, Shape(javax.swing.Jpanel container, java.awt.geom.RectangularShape s) with the appropriate parameters
	}	

	
}