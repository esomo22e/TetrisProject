//TetrisT.java

public class TetrisT extends TetrisPiece
{
	public TetrisT()
	{
		filledSquares[0][0][1] = true;
		filledSquares[0][0][2] = true;
		filledSquares[0][0][3] = true;
		filledSquares[0][1][2] = true;
		
		filledSquares[1][0][3] = true;
		filledSquares[1][1][2] = true;
		filledSquares[1][1][3] = true;
		filledSquares[1][2][3] = true;

		filledSquares[2][2][1] = true;
		filledSquares[2][1][2] = true;
		filledSquares[2][2][2] = true;
		filledSquares[2][2][3] = true;

		filledSquares[3][0][1] = true;
		filledSquares[3][1][1] = true;
		filledSquares[3][1][2] = true;
		filledSquares[3][2][1] = true;
		
		
	}

	  //public void test4(int i){

		//	for( int j = 0; j< filledSquares[i].length; j++)
			//    {
				//for(int k = 0; k< filledSquares[i][j].length; k++)
				  //  {
					//System.out.print(filledSquares[i][j][k]);
					//System.out.print( " " );

					//if( k == 3)
					  //  {
						//System.out.print("\n");
					  //  }
				    //}
			   // }
		     //}
}