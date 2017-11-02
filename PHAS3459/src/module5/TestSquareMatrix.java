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
		
		System.out.println("Matrix A:\n"+A);


		SquareMatrix B = null;
		try {
			B = new SquareMatrix(b);
		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println("Matrix B:\n"+B);


		SquareMatrix C = null;
		try {
			C = new SquareMatrix(c);
		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println("Matrix C:\n"+C);

		SquareMatrix D = null;
		try {
			D = new SquareMatrix(d);
		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println("Matrix D:\n"+D);


		SquareMatrix unit = null;
		try {
			unit = SquareMatrix.unitMatrix(4);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Unit matrix of dimension " +unit.dimension()+":\n"+unit);


		System.out.println("Does A equal B?: \n"+A.equals(B));
		
		try {
			
			System.out.println("\nA + B:\n"+SquareMatrix.add(A, B));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			System.out.println("\nA - B:\n"+SquareMatrix.minus(A, B));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}