//TetrisBoardGUIView.java

import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JComponent;

public class TetrisBoardGUIView extends JComponent
{
	private TetrisBoard board;
	
	//Constructor requires the board to display.
	public TetrisBoardGUIView( TetrisBoard b)
	{
		board = b; 
			
		
	}
	
	 //Paint the game.
	public void paint(Graphics g)
	{

	    int blockSize = computeBlockSize();

	   
	    
	    for(int i = 0; i < TetrisBoard.NUM_ROWS; i++)
		{
		    for(int j = 0; j < TetrisBoard.NUM_COLS; j++)
			{
		    	//if the store blocks are filled
			    if(board.hasBlock(i, j) == true)
				{
			    	
				    //paint the block
				   paintBlock(g,j *blockSize , i * blockSize, blockSize);
				
				}
			    
			    
			}
		}
	}
	
	private void paintBoardOutline(Graphics g,int blockSize)
	{
		//draw rectangle 
	    g.drawRect(0,0,board.getNumCols()*blockSize,board.getNumRows()*blockSize);
	}
	   //Paint the block at grid row, grid col.						   
	private void paintBlock( Graphics g, int row, int col, int blockSize)
       {
	   g.setColor( Color.ORANGE);
	   g.fillRect(row, col, blockSize, blockSize);	

	   g.setColor( Color.BLACK );
	   g.drawRect(row, col, blockSize, blockSize);
	   
	   
	  
       }

	//Compute the best block size for the current width and height.
    private int computeBlockSize()
    {
    
    //this will get you the perfect size of the width and height
	int maxWidth = getWidth() / board.getNumCols();
	int maxHeight = getHeight() / board.getNumRows();
	
	return Math.min( maxWidth, maxHeight );

    }


}
