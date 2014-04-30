//TetrisBoard.java



/**The TetrisBoard class represents the model: a board on which Tetris is played; it maintains the grid and pieces on it.
 * @param <currentGridPosition>**/
public class TetrisBoard
{
    private boolean[][] board;// board array

    /**Static Variables**/
    public static int NUM_COLS = 10;
    public static int NUM_ROWS = 18;
    
    /**Instance Variable**/
    private int numCols;
    private int numRows;
    private int[] currentGridPosition;
    private TetrisPiece currentPiece;
    private int totalNumber;
    
    /**Array of Tetris Pieces**/
    private TetrisPiece[] tetrisPieces = { new TetrisL1(), new TetrisL2(), new TetrisS1(), new TetrisSquare(), new TetrisT(), new TetrisZ(), new TetrisStick()};

  //Constructor sets up the board.
    public TetrisBoard( ) 
	{
    	numCols = NUM_COLS;
    	
    	numRows = NUM_ROWS; 
	    //the board will have set Number of Rows and Number Columns    
	    board = new boolean[NUM_ROWS][NUM_COLS];
	   
	    //this will check every row in the array
	    for(int i = 0; i<board.length; i++)
	    {
	    	//this will check every column in the array 
	    	for( int j = 0; j<board[i].length; j++)
	    	{
	    		//this will start the board as a blank board which will be all false. 
	    		board[i][j] = false;
	    	}
	    }
	  	//call the current Grid Position of the piece  on Tetris Board
	    initCurrentGP();
	    //call the board in the constructor
	    initBoard(); 
	     
	    	    
	}
//Add a new random Tetris piece to the board at grid position
    public void addNewPiece()
    {
    	//generate a random number int he array that will give you a random tetrisPiece
     	int randomNumber = (int)(Math.floor(Math.random()*7));
    	
    	
    
    	//this will generate random piece
    	currentPiece = tetrisPieces[randomNumber] ;
    
    	
        //set the current grid position of the piece	
    	currentGridPosition[0] = 0;
     	currentGridPosition[1] = 3;
     	System.out.println("currentGridPosition is: ( " + currentGridPosition[0] + ", " + currentGridPosition[1] + " )");
     	
     	
    	
    
    }
    
  //Checks if placing the peice at grid position (row, col) with rotation rot (values can be 0, 90, 180, 270) would cause a collision( i.e., f there would be a block falling off the board).
    //gridRow = board grid
    //gridCol = board columns 
	private boolean detectCollision(TetrisPiece piece, int rot, int gridRow, int gridCol)
    {
		//check the row of the Tetris Piece
		for(int i = 0; i< 4; i++)
		{
			//check the column of the Tetris Piece 
			for(int j = 0; j<4; j++)
			{
				//if the piece is filled in a current Piece rotation
				if(piece.isFilled(currentPiece.getPieceRotation(), i, j))
				{
	    			
					board[i + currentGridPosition[0] ][j + currentGridPosition[1] ] = false; 
				}		
    			
			}
		}
		//check the row of the Tetris Piece
		for(int m = 0;  m< 4; m++ )
    	{
			//check the column of the Tetris Piece
    		for( int n = 0; n< 4; n++)
    		{
    			//if the pieces is filled in any rotation, row, and column it will show an X
    			if(piece.isFilled(rot,m, n) ){
    				//if the board encounters a stored piece than you should add or move up a row
    				//and move away a gridRow
    				if(!detectOutOfBounds(currentPiece, rot, gridRow, gridCol))
    				{
    					
    				if(board[m+ gridRow][n + gridCol] == true  ){
    				//when pieces are stored and find a space than land the piece
    				
    					
    					System.out.println("Cannot move"); 
    					return true;
    					
    				  }
    				}
    			}
    				
    		}
    		//foor loop ends 	
    	
		//(i + gridRow >= NUM_ROWS; j is the same in gridCols)
		//less than
    	}
		
	return false;
    }
		
    
  //Checks if placing the peice at grid position (row,col) with the rotation rot (values can be 0, 90, 180, 270) 
	//Cause bounds condition(i.e., if there would be a block falling off the board).
    private boolean detectOutOfBounds( TetrisPiece piece, int rot, int gridRow, int gridCol )
    {
    	//check the row of the grid
    	for(int i = 0;  i< 4; i++ )
    	{
    		//check the column of the grid
    		for( int j = 0; j< 4; j++)
    		{
    			//if the pieces is showing an X despite rotation, row, and column
    			if(piece.isFilled(rot,i, j) == true){
    				//if the row and column of the grid than the row and column of the board than it is out of bounds
    				if(i+ gridRow >= NUM_ROWS || j + gridCol >= NUM_COLS || j+gridCol< 0){
    					
    					return true;
    				}
    			}
    		}
    			
    	}
    	//than it is in bounds
	return false;
    }
    
     public boolean[ ][ ] getBoard()
    {
	return board;
    }

    public int[] getCurrentGridPosition()
    {
    	return currentGridPosition;
    }

    public TetrisPiece getCurrentPiece()
    {
	return currentPiece;
    }

    public int getNumCols()
    {
	return numCols;
    }
    
    public int getNumRows()
    {
	return numRows;
    }
    //Initialize an int array of length two to keep track of the grid position of the current piece (row, col)
    private void initCurrentGP()
    {
    	//it keeps track of both the row and the columns
    	currentGridPosition = new int[2];
    	currentGridPosition[0] = 0;
     	currentGridPosition[1] = 3;
     	
    }

    
  //Update the board array to reflect the newly landed piece's filled squares using the currentGridPosition values and the currentPiece's rotation value.
    public void landPiece()
    {
    	
        
    	//check the row of the grid
    	for(int i = 0;  i< 4; i++ )
    	{
    		//check the column of the grid
    		for( int j = 0; j< 4; j++)
    		{
    			if(currentPiece.isFilled(currentPiece.getPieceRotation(),i, j)){
    			
					board[i + currentGridPosition[0]][j + currentGridPosition[1]] = true; 
    				}
    		}
    	}
    	
    }

  public boolean hasBlock( int row, int col)
    {
    	for(int i = 0;  i< 4; i++ )
    	{
    		for( int j = 0; j< 4; j++)
    		{
    			if(currentPiece.isFilled(currentPiece.getPieceRotation(),i, j) == true){
    				if(row == currentGridPosition[0] + i &&  col == currentGridPosition[1] + j){
    				return true;
    				}
    			}
    		}
    	}
    	return board[row][col];
    		
	
    }

    private void initBoard()
    {
    	//check the rows less than Number of Rows
    	for(int i = 0; i < NUM_ROWS; i++)
    	{
    		//check the columns the columns less than Number of Columns
    		for(int j = 0; j < NUM_COLS; j++)
    		{
    			//the board will become blank
    			board[i][j] = false; 
    			
    		}
    			
    	}
    }
  
  //Check if move down is valid
    public boolean moveDown()
    {
    	System.out.println("move down");
    	if(validMove(currentPiece, currentPiece.getPieceRotation(), currentGridPosition[0]+1, currentGridPosition[1]))
    	{
    	System.out.println(currentGridPosition[0]);
    	//this will move the position down
    	currentGridPosition[0]++;
   
    	
    
    	return true;
    	}
		return false;
    	
   	}
    	
    
//Check if move left is valid
    public boolean moveLeft()
    {
    	if( validMove(currentPiece, currentPiece.getPieceRotation() , currentGridPosition[0], currentGridPosition[1]-1))
    	{
    	
    		//this will move the position left
    	   currentGridPosition[1]--;
    	   
    	   return true;
    	}
    		
        	return false;
    	   	 
    }
    //check if move right is valid
    public boolean moveRight()
    {
    	
    	if(validMove(currentPiece, currentPiece.getPieceRotation() , currentGridPosition[0], currentGridPosition[1]+1))
    	{
    		System.out.println( "move right");
    	
    	//this will add one to the right
    	currentGridPosition[1]++;
    	
          	return true; 
    	     	
    	}
    	return false; 
    }
  //Detect and remove any lines formed
    public int numberOfFormedLines()
    {
    	for(int i = NUM_ROWS-1; i >= 0; i--)
    	{
    		if(fullLine(i) == true)
    		{
    			removeLine(i);
    		}
    	}
	
	return totalNumber;
    }
    private boolean fullLine( int row ){
    	for( int i = 0; i < NUM_COLS; i++)
    	{
    		if(!hasBlock(row, i))
    		{
    			//System.out.println("line is not formed");
			return false; 
    		}
    	}
    	//System.out.println("line is formed");
       	return true;
    }
    
    private void removeLine( int row)
    {
    	for(int i = row ; i >=0; i--)
    	{
    		for(int j = 0; j < NUM_COLS; j++)
    		{
    			if(i == 0)
    			{
    				board[i][j] = false;
    			}
    			else
    			{
    				System.out.println("something");
    				
    				board[i][j] = board[i -1][j];
    			}
    		}
    	}
    }
  //Check if rotating clockwise is valid
      public boolean rotateCW()
    {
         	
 	if(validMove(currentPiece, (currentPiece.getPieceRotation()+1)%4 , currentGridPosition[0], currentGridPosition[1]))
    	{
 		System.out.println("rotate to the piece CW");
 		//	undoPosition(); 
 			currentPiece.rotateCW();
 			//updatePosition();
 			return true;
    	} 
       return false;  	
    	
    }
   //check counterclockwise is valid
    public boolean rotateCCW()
    {
    	//if current piece is able to move 270 degrees over the rows and columns in the baord
    	if(validMove(currentPiece, (currentPiece.getPieceRotation()+3)%4, currentGridPosition[0], currentGridPosition[1]))
    	{
	
	
    		//call on rotate CCW method
    	currentPiece.rotateCCW();

    	return true;
    	} 
	return false; 
    }

  //Check if placing the piece at grid position ( row, col ) with the rotation rot( values can be 0, 90 180, 270) is a valid move  
  private boolean validMove(TetrisPiece piece, int rot, int gridRow, int gridCol)
    {
	  System.out.println("detectCollision " + detectCollision(piece, rot, gridRow,  gridCol));
	  System.out.println("detectOutOfBounds " +detectOutOfBounds(piece, rot, gridRow, gridCol));
	  //if the piece is not out of bounds and don't collide with any pieces
 	if((!detectCollision(piece, rot, gridRow,  gridCol)) && (!detectOutOfBounds(piece, rot, gridRow, gridCol)) )
    	{
 		
 			//than it is a valid move
    		return true;
    	}
    	else
    	//it is out of bounds and/or collides
    	return false;
    	
    	
    }
  
}
	