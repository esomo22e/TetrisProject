//TetrisGameGUIController.java
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;
import javax.swing.JComponent;
import javax.swing.JLabel; 
import javax.swing.JPanel; 
import java.awt.BorderLayout;
import java.awt.GridLayout;




public class TetrisGameGUIController extends JPanel implements KeyListener
{
	public static final int DEFAULT_DROP_RATE = 1000;
	
	/**Instance Variables**/
    private TetrisGame game;
    private TetrisBoardGUIView view;
    private JLabel linesLabel;
    private JLabel tetrisLabel;
    private Timer gameTimer;
    private int dropRate;
    private int numTetrises;
    private int numLines;

    public TetrisGameGUIController( boolean keysFromApplet)
	{
    	
	    super(new BorderLayout()); 
	     game = new TetrisGame();
	     add(createView(),BorderLayout.NORTH);
	     createScore();
	     view = new TetrisBoardGUIView( game.getTetrisBoard() );
	     add(view, BorderLayout.CENTER);
  
	   
	    
	   //addKeyListener(this);
    	
    	refreshDisplay();
    	
    	if(!keysFromApplet)
    	{
    		setFocusable(true);
    		addKeyListener(this);
    	}
    	setupTimer();
	}

    private void setupTimer()
    {
	dropRate = 800;

	final TetrisGameGUIController controller;
	
    	// create a timer to advance the physics engine
		gameTimer = new Timer(dropRate, new ActionListener()
		{
	
			

			/**
			 * Invoked every time the timer finishes.
			 */
			public void actionPerformed(ActionEvent e)
			{
				// advance the physics world
				game.attemptMove(2);
 
				// update the view
				repaint();
			}
		});
 
		
			controller = TetrisGameGUIController.this; 
		
		// start the simulation
		gameTimer.start();
    }

    private void refreshDisplay()
    {
	createScore();
	repaint();
    	
    }
    private JPanel createView()
    {
 	JPanel jpanel = new JPanel(new GridLayout(1,1));
	linesLabel = new JLabel("Number of lines:");
	jpanel.add(linesLabel);
	tetrisLabel = new JLabel("Number of tetrises:");
	jpanel.add(tetrisLabel);
	return jpanel;
	
	
    }
    
    private void createScore()
    {
	numTetrises = game.getNumLines();
	numLines = game.getNumTetrises();
	linesLabel.setText((new StringBuilder()).append("Number of lines ").append(numLines).toString());
	tetrisLabel.setText((new StringBuilder()).append("Number of tetrises ").append(numTetrises).toString());
    	
    }
    //handle the keyTyped event
    public void keyTyped(KeyEvent e)
    {
    }
    //Handled the key-pressed event
    public void keyPressed(KeyEvent e)
    {

	System.out.println(e.getKeyCode());
	
    	//different behavior depending which key was released
    	switch(e.getKeyCode())
    	{
    	// if it's the right key

        case 39:
        	// apply an impulse to the ball
        	game.getTetrisBoard().moveRight();
        	break;
        //if it's the left key
        case 37:
        	//the piece will move tot he left
        	game.getTetrisBoard().moveLeft();
        	break;
        //if its the down key 	
        case 40:
        	//the move will move t the right
        	game.getTetrisBoard().moveDown();
        	break;
        //if its the z key	
        case 90:
        	//the peice will rotate clockwise
        	game.getTetrisBoard().rotateCW();
		break;
		//if the x key
        case 88:
        	// the peice will rotate counterclockwise
        	game.getTetrisBoard().rotateCCW();
		break;
		
        default:
            System.out.println("KEY RELEASED: " + e.getKeyCode() );
    		
    	}
	
    }
   
	//Handled the key typed event
	public void keyReleased(KeyEvent e) 
	{
	

	}
}
	