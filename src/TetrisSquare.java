//TetrisSquare.java

public class TetrisSquare extends TetrisPiece
{
	public TetrisSquare()
	{
	    for( int i = 0; i<filledSquares.length; i++)
		{
	    	
		    filledSquares[i][0][1] = true;
		    filledSquares[i][0][2] = true;
		    filledSquares[i][1][1] = true;
		    filledSquares[i][1][2] = true;
		}
	   
	}
   
    
}