package module5;

public class SquareMatrix {
	//Member variables
	private int rows;
	private int columns;
	private double [][] elements;


	//Square matrix constructor, that throws an exception if the defined columns does not equal the defined rows
	//and throws an exception if the number of columns is inconsistent
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
	
	//Prints matrix to screen
	//TODO 
	//ASK IF YOU CAN DO THIS INSTEAD OF TOSTRING
	public void show() {
		System.out.println();
		for (int i = 0; i < elements.length; i++) {
			for (int j = 0; j < elements.length; j++) 
				System.out.printf("%10.1f", elements[i][j]);
			System.out.println();
		}
		System.out.println();
		System.out.println();
		
	}

}
