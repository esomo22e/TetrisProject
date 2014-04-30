//TetrisGameGUIApplication.java

//swing
import javax.swing.JFrame; 

public class TetrisGameGUIApplication
{
	public TetrisGameGUIApplication()
	{

	}
	//Start the game!
       public static void main(String[] args)
       {
    	     		// create a new JFrame to hold TreePanel
    			JFrame tetrisFrame = new JFrame();
    			
    			// set size
    			tetrisFrame.setSize( 500, 1200 );

    			// create a TreePanel and add it
    			tetrisFrame.add( new TetrisGameGUIController(false) );

    			// exit normally on closing the window
    			tetrisFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    			// show frame
    			tetrisFrame.setVisible( true );
    			
    		
    		}
    
}