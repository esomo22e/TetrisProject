//TetrisGUIApplet.java

//swing
import java.applet.Applet; 

import java.awt.BorderLayout;

public class TetrisGUIApplet extends Applet
{
	public TetrisGUIApplet()
	{
		//call super constructor
		super();  
		
	}
	
	// special method that will be invoked when applet is created
   public void start()
    {
		// so the controller stretches
		setLayout( new BorderLayout() );

		// create an TetrisGameGUIController 
		TetrisGameGUIController controller = new TetrisGameGUIController( true );

		// and add it 
		add( controller, BorderLayout.CENTER );

		// allow key events
		setFocusable(true);
		requestFocusInWindow();		

		// add the controller for key events
		//addKeyListener( controller );
    }
}