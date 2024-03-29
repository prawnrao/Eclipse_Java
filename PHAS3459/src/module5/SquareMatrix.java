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
		while(i < rows) {
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
	 * This constructor takes an integer N and creates a N by N matrix of 0s.
	 * @param rows
	 * @param columns
	 */
	public SquareMatrix(int N) {
		this.rows = N;
		this.columns = N;
		elements = new double[rows][columns];
	}

	//This method gives the dimension of a square matrix
	public int dimension() {
		int N = this.elements.length;
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

		for (int i=0; i < elements.length; i++) {//loops over rows
			for(int j =0; j < elements.length; j++) {//loops over columns
				sb.append("\t");
				sb.append(this.elements[i][j]);

				if(j == elements.length-1)
				{
					sb.append("\n");
				}
			}
		}
		return sb.toString();//converts Stringbuilder to string and returns
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


	/**
	 * This method is a static addition of two square matrices 
	 * @param A
	 * @param B
	 * @return
	 */
	public static SquareMatrix add(SquareMatrix A, SquareMatrix B) throws Exception {
		if (A.dimension() != B.dimension()) throw new Exception(A+" and "+B+" are of different dimensions.");
		SquareMatrix Add = new SquareMatrix(A.dimension());
		for (int i = 0; i < A.dimension(); i++)
			for (int j = 0; j < A.dimension(); j++)
				Add.elements[i][j] = A.elements[i][j] + B.elements[i][j];
		return Add;
	}
	/**
	 * This method is a non-static addition of two matrices
	 * @param B
	 * @return
	 * @throws Exception
	 */
	public SquareMatrix add(SquareMatrix B) throws Exception {
		return add(this,B);

	}


	/**
	 * This method is a static subtraction of two square matrices
	 * @param A
	 * @param B
	 * @return
	 */
	public static SquareMatrix minus(SquareMatrix A, SquareMatrix B) throws Exception {
		if (A.dimension() != B.dimension()) throw new Exception(A+" and "+B+" are of different dimensions.");
		SquareMatrix Minus = new SquareMatrix(A.dimension());
		for (int i = 0; i < A.dimension(); i++)
			for (int j = 0; j < A.dimension(); j++)
				Minus.elements[i][j] = A.elements[i][j] - B.elements[i][j];
		return Minus;
	}
	/**
	 * This method is a non-static subtraction of two square matrices
	 * @param B
	 * @return
	 * @throws Exception
	 */
	public SquareMatrix minus(SquareMatrix B) throws Exception {
		return minus(this,B);
	}


	/**
	 * This method is a static multiplication of two square matrices 
	 * @param A
	 * @param B
	 * @return
	 * @throws Exception
	 */
	public static SquareMatrix multiply(SquareMatrix A,SquareMatrix B) throws Exception{
		if (A.dimension() != B.dimension()) throw new Exception(A+"and "+B+" are of different dimensions.");
		SquareMatrix product = new SquareMatrix(A.dimension());
		for (int i = 0; i < product.dimension(); i++)
			for (int j = 0; j < product.dimension(); j++)
				for (int k = 0; k < A.dimension(); k++)
					product.elements[i][j] += (A.elements[i][k] * B.elements[k][j]);
		return product;
	}
	/**
	 * This method is a non-static multiplication of two square matrices
	 * @param B
	 * @return
	 * @throws Exception
	 */
	public SquareMatrix multiply(SquareMatrix B) throws Exception {
		return multiply(this,B);
	}
}

