//TetrisL2.java

public class TetrisL2 extends TetrisPiece
 {
	public TetrisL2( )
	{
		filledSquares[0][0][2] = true;
		filledSquares[0][0][3] = true;
		filledSquares[0][1][2] = true;
		filledSquares[0][2][2] = true;
		
		filledSquares[1][1][1] = true;
		filledSquares[1][1][2] = true;
		filledSquares[1][1][3] = true;
		filledSquares[1][2][3] = true;

		filledSquares[2][0][2] = true;
		filledSquares[2][1][2] = true;
		filledSquares[2][2][2] = true;
		filledSquares[2][2][1] = true;

		filledSquares[3][1][1] = true;
		filledSquares[3][2][1] = true;
		filledSquares[3][2][2] = true;
		filledSquares[3][2][3] = true;
		
		
	}
	
	
}