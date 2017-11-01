package module5;

public class TestSquareMatrix {

	public static void main (String[] args) {
		double[][] a  = {{1,2,0},{0,2,0},{-2,0,1}};
		double[][] b  = {{2,1,0},{0,1,0},{-1,0,1}};
		double[][] c  = {{4,3},{3,2}};
		double[][] d  = {{-2,3},{3,-4}};

		SquareMatrix A = null;
		try {
			A = new SquareMatrix(a);
		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println("Matrix A:");
		A.show();

		SquareMatrix B = null;
		try {
			B = new SquareMatrix(b);
		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println("Matrix B:");
		B.show();

		SquareMatrix C = null;
		try {
			C = new SquareMatrix(c);
		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println("Matrix C:");
		C.show();

		SquareMatrix D = null;
		try {
			D = new SquareMatrix(d);
		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println("Matrix D:");
		D.show();
	}
}