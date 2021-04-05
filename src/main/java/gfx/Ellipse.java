package gfx;

/**
 * This class represents an Ellipse shape.
 */
public class Ellipse extends Shape {

	public Ellipse(javax.swing.JPanel container) {
		super(container, new java.awt.geom.Ellipse2D.Double()); // Call the superclass's constructor, Shape(javax.swing.Jpanel container, java.awt.geom.RectangularShape s) with the appropriate parameters
	}	

	
}
