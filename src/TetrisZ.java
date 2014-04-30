//TetrisS2.java

public class TetrisZ extends TetrisPiece
{
	public TetrisZ()
	{
		filledSquares[0][0][1] = true;
		filledSquares[0][0][2] = true;
		filledSquares[0][1][2] = true;
		filledSquares[0][1][3] = true;
		
		filledSquares[1][0][3] = true;
		filledSquares[1][1][2] = true;
		filledSquares[1][1][3] = true;
		filledSquares[1][2][2] = true;

		filledSquares[2][1][1] = true;
		filledSquares[2][1][2] = true;
		filledSquares[2][2][2] = true;
		filledSquares[2][2][3] = true;

		filledSquares[3][0][2] = true;
		filledSquares[3][1][1] = true;
		filledSquares[3][1][2] = true;
		filledSquares[3][2][1] = true;
		
		
		
				
	}
   
}