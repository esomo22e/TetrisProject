 //TetrisPiece.java

public  class TetrisPiece
{
    /** 3 dimensional array maintaining which grid squares are filled first dimension is rotation (index 0 -> 0 degrees, index 1 -> 90 degrees, index 2 -> 180 degrees, index 3 -> 270 degrees) second and third dimensions create 4x4 grid with true entries indicating a filled square**/
    protected boolean[][][] filledSquares;

   
    /**Maintains the current rotation**/
    protected int pieceRotation;


    public TetrisPiece()
	{
	    filledSquares = new boolean[4][4][4];
	    for( int i = 0; i< filledSquares.length; i++)
		{
		    for( int j = 0; j<filledSquares[i].length; j++)
			{
			    for( int k = 0; k< filledSquares[i][j].length; k++)
				{
				    filledSquares[i][j][k] = false;
				}
			}
		}
	    
	}
    public int getPieceRotation()
    {
	//Get the rotation of this piece.
	return pieceRotation;

    }
    	//rotate the piece clockwise by 90 degrees
    public void rotateCW()
    {
	
	  pieceRotation = ( pieceRotation +=1 )% 4;
	//meaning that it rotates 90 degrees
	
    }
	//Rotate the piece counter-clockwise by 90 degrees. or 270 degrees. 
    public void rotateCCW()
    {
    	if(pieceRotation == 0){	
    	pieceRotation = 3;
    	}
    	else
    		pieceRotation = pieceRotation -1;	
	//rotate 270 degrees or -90 degrees
	//return negative formation
	
    }
    //Checks if there is a TetrisBlock at the (row, col) position for the rotation rot, where rot is 0, 90, 180 or 270 degrees.
    public boolean isFilled(int rot, int row, int col)
    {
	//return depends on the degree index used and the row and columns
    //if filled square of any rotation
    //it will check if the filledSquares at a certain row and column is true/false -- that's the answer
    	//System.out.println(" square filled " + filledSquares[rot][row][col]);
	return filledSquares[rot][row][col];


	
    }
	public boolean[][][] getFilledSquares() {
		//this will fill the Squares 
		return filledSquares;
	}
    
    
	
}

