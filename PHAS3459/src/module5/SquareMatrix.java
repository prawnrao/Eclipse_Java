package module5;

public class SquareMatrix {
	private int rows;
	private int columns;
	private double [][] elements;


	//Square matrix constructor, that throws an exception if the defined columns does not equal the defined rows
	//and throws an exception if the number of columns is inconsistent
	public SquareMatrix(double[][]elements) throws Exception{
		this.elements = elements;
		this.rows = elements.length;

		this.columns = elements[0].length;
		int i = 0;
		//while loop, that checks the number of columns in each row
		while(i < this.rows ) {
			int columns = elements[i].length;//checks the number of columns in row i
			if (this.columns != columns) {
				throw new Exception("The number of columns in each row is not equal. Not a physical matrix.");
			}
			i++;
		}
		if(rows != columns) {
			throw new Exception("The number of rows is not equal to the number of columns. Not a square matrix");
		}

	}


}
