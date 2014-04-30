//TetrisS1.java

public class TetrisS1 extends TetrisPiece
{
	public TetrisS1()
	{
		/**An array for each index that will hold x**/
		filledSquares[0][0][1] = true;
		filledSquares[0][1][1] = true;
		filledSquares[0][1][2] = true;
		filledSquares[0][2][2] = true;
		
		filledSquares[1][0][2] = true;
		filledSquares[1][0][3] = true;
		filledSquares[1][1][1] = true;
		filledSquares[1][1][2] = true;
		
		filledSquares[2][1][1] = true;
		filledSquares[2][2][1] = true;
		filledSquares[2][2][2] = true;
		filledSquares[2][3][2] = true;
		
		filledSquares[3][1][2] = true;
		filledSquares[3][1][3] = true;
		filledSquares[3][2][1] = true;
		filledSquares[3][2][2] = true;

		
		
	}

   
     
 	
	
}