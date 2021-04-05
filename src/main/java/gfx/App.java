package gfx;

/**
 * The purpose of this class is so that you have 
 * something to test your shape with.
 * When you run cs015_runDemo gfx, this is what you see.
 * Instructions for its use are below.
 */

public class App extends cs015.prj.Shape.ViewerFrame {
    public App(String s){
	super(s);
	/*
	 * Pass in one of your Shape subclasses here. You might be wondering
	 * where your shapes will get their container from. For a container,
	 * cs015.prj.Shape.ViewerFrame has a protected drawing panel. It is 
	 * named _drawingPanel.
	 * 
	 * Since this class is a subclass of cs015.prj.Shape.ViewerFrame, 
	 * you have access to the _drawingPanel instance variable from within 
	 * this class. 
	 * 
	 * Below, we've written the code to set the GUI's shape to an instance
	 * of Rectangle. Remember that you'll need to fill in the Rectangle's
	 * constructor and some methods of the Shape class for this to work.
	**/ this.setShape(new Arc(_drawingPanel));
    }

    /* Still don't need to worry about this. It just starts the App. */
    public static void main(String[] argv){
	new App("Shape Viewer");
    }

}
