package edu.bu.cs526.hw10;

/**
 * 
 * @author zzhang
 *	produces a 7 by 7 matrix of winning possibilities with dynamic programming
 */
public class WorldSerisDP {

	/**
	 * 
	 * @param matrix possibilities of winning
	 * @param i row index
	 * @param j colomn index
	 * @return possibility for cell matrix[j][j]
	 */
	private static double getP(double[][] matrix, int i, int j) {
		return (matrix[i+1][j] + matrix[i][j+1]) / 2;
	}
	
	/**
	 * 
	 * @param matrix matrix to print
	 * prints the matrix
	 */
	private static void printMatrix(double[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// print only 2 decimal places
				System.out.printf("%.2f\t", matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// initialize new matrix
		double[][] matrix = new double[7][7];
		for (int i = 0; i < 6; i++) {
			matrix[i][6] = 1.0;
		}
		
		// calculating each cell with dynamic programming
		int k = 10;
		int i, j;
		
		// k is the sum of i and j
		while (k >= 0) {
			// when k >= 5, i or j can only go up to 5
			if (k >= 5) {
				i = 5;
				j = k-i;
				// iterate through the whole diagnal
				while (j <= 5) {
					// get current cell
					matrix[i][j] = getP(matrix, i, j);
					i--;
					j++;
				}
			} else { // if k < 5, i or j can only go up to k
				i = k;
				j = 0;
				while (j <= k) {
					matrix[i][j] = getP(matrix, i, j);
					i--;
					j++;
				}
			}
			// decrement k to move left and up
			k--;
		}
		
		// print with 2 decimal places
		printMatrix(matrix);
	}

}
