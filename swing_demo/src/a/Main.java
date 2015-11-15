package a;

public class Main {

	
	
    public static Drawing mDrawing;
	private static Controls mControls;
	public static Life x;

    public static void main(String[] args) {
    	
    	x =  new Life(10,10);
    	
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	// create the controls and drawing windows
            	mControls = new Controls();
            	
            	// number of rows and columns in the Life grid
            	mDrawing = new Drawing(20, 20);
            }
        });
    }
}
