//TetrisL1.java

public class TetrisL1 extends TetrisPiece
{
	public TetrisL1( )
	{
		filledSquares[0][0][2] = true;
		filledSquares[0][1][2] = true;
		filledSquares[0][2][2] = true;
		filledSquares[0][2][3] = true;
		
		filledSquares[1][0][0] = true;
		filledSquares[1][0][1] = true;
		filledSquares[1][0][2] = true;
		filledSquares[1][1][0] = true;

		filledSquares[2][0][0] = true;
		filledSquares[2][0][1] = true;
		filledSquares[2][1][1] = true;
		filledSquares[2][2][1] = true;

		filledSquares[3][2][3] = true;
		filledSquares[3][3][1] = true;
		filledSquares[3][3][2] = true;
		filledSquares[3][3][3] = true;
		
		
	}
	
		 
}
	