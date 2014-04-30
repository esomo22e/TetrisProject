//TetrisGame.java

public class TetrisGame
{
 
    public static final int RIGHT = 0;
    public static final int LEFT = 1;
    public static final int DOWN = 2;
    public static final int CW = 3;
    public static final int CCW = 4;
    
    private int numLines;
    private int numTetrises;
    private TetrisBoard tetrisBoard;
   
    //Performed when a piece cannot move down anymore. Ends the round by checking for newly formed lines and adding a new piece.  
   public TetrisGame()
   {
       numLines = 0;
	   
	   numTetrises = 0;
	   
	   tetrisBoard = new TetrisBoard();
	   tetrisBoard.addNewPiece();
	   
	 	   
   }
   //Performed when a piece cannot move down anymore. Ends the round by checking for newly formed lines and adding a new piece.
    private void endRound()
    {
   
    	
    }
    
  //Try to move the current piece with RIGHT, LEFT, DOWN, CW, CCW.
    public void attemptMove(int moveType)
    {
    	
    	//if moveType is Right than move right
    	if(moveType == RIGHT)
    	{
    		 //move the piece to the right
    		tetrisBoard.moveRight();
    	}
    	//if moveType is Left than move tot he left
    	if(moveType == LEFT)
    	{
    		//move to the left
    		tetrisBoard.moveLeft();
    	}
    	//if moveType is Down than move down
    	if(moveType == DOWN)
    	{
    		//if you cannot move down anymore
    		if(tetrisBoard.moveDown() == false)
    		{
    			//landPiece
    			tetrisBoard.landPiece();
    			//add new Piece
    			tetrisBoard.addNewPiece(); 
    			//and see if there is any lines are formed
        		tetrisBoard.numberOfFormedLines();
    		}
    	}
    	//if moveType is CW
    	if(moveType == CW)
    	{
    		//rotate clockwise
    		tetrisBoard.rotateCW();
    	}
    	//if moveType is CCW
    	if(moveType == CCW)
    	{
    		//rotate counterclockwise
    		tetrisBoard.rotateCCW();
    	}
    }
    
    public int getNumLines()
    {
	return numLines;
    }
    public int getNumTetrises()
    {
	return numTetrises;
    }
 
	
	public TetrisBoard getTetrisBoard() {
		
		return tetrisBoard;
	}
    
}