package module5;

public class SquareMatrix {
	//Member variables
	private int rows;
	private int columns;
	private double [][] elements;


	/**
	 * Square matrix constructor, that throws an exception if the defined columns does not equal the defined rows
	 * and throws an exception if the number of columns is inconsistent
	 * @param elements
	 * @throws Exception
	 */

	public SquareMatrix(double[][]elements) throws Exception{
		this.elements = elements;
		int rows = elements.length;//number of rows
		int columns = elements[0].length;//number of columns in row 0

		int i = 0; //initialises the counter
		//while loop, that checks the number of columns in each row
		while(i < rows ) {
			this.columns = elements[i].length;//checks the number of columns in row i
			if (this.columns != columns) {//checks the number of columns in row 0 against the number of columns in row i
				throw new Exception("The number of columns in each row is not equal. Not a valid matrix.");
			}
			i++;//increments counter
		}
		if(rows != columns) {//checks the number of rows against the number of columns
			throw new Exception("The number of rows is not equal to the number of columns. Not a square matrix");
		}

	}

	/**
	 * This method returns the dimension of a matrix
	 * @param sq
	 * @return
	 */
	public static int dimension(SquareMatrix sq) {
		int N = sq.elements.length;
		return N;
	}

	/**
	 * This method creates a N by N unit matrix
	 * @param N
	 * @return
	 * @throws Exception
	 */
	public static SquareMatrix unitMatrix(int N) throws Exception {
		double [][] I = new double [N][N];
		for (int i = 0; i < N; i++)//loop over rows and columns
			I[i][i] = 1;//makes the diagonal elements equal to 1
		SquareMatrix unit = new SquareMatrix(I);//converts the array to a square matrix
		return unit;
	}


	//Allows to print matrices to screen
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int i=0; i < elements.length; i++) {
			for(int j =0; j < elements.length; j++) {
				sb.append("\t");
				sb.append(this.elements[i][j]);

				if(j == elements.length-1)
				{
					sb.append("\n");

				}
			}
		}
		sb.append("\n");
		return sb.toString();
	}

	/**
	 * This method checks whether to matrices exactly equal each other
	 * @param B
	 * @return
	 */
	public boolean equals(SquareMatrix B) {
		SquareMatrix A = this;
		for (int i = 0; i < elements.length; i++) {//loop over rows
			for (int j = 0; j < elements.length; j++) {//loop over columns
				if (A.elements[i][j] != B.elements[i][j]) {
					return false;//checks each element of matrix A with each element of matrix B
				}
			}
		}
		return true;
	}

}

