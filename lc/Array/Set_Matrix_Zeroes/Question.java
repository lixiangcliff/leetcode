package Set_Matrix_Zeroes;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * https://oj.leetcode.com/problems/set-matrix-zeroes/
	 * Given a m x n matrix, if an element is 0, set its entire row and column
	 * to 0. Do it in place.
	 * 
	 * click to show follow up.
	 * Follow up: Did you use extra space? A straight forward solution using
	 * O(mn) space is probably a bad idea. A simple improvement uses O(m + n)
	 * space, but still not the best solution. Could you devise a constant space
	 * solution?
	 */
    
	//题目要求O(1)的空间消耗(in place)。
	//1. 我们可以使用首行，首列来作为Flag，记录某一行，某一列是否应该被设置为0.
	//3. 先扫描首行，首列。用两个值row0has0， col0has0来记录首行首列是否含0。
	//4. 扫描其他的矩阵，将每一个是0的[i][j]都反映在首行和首列上。
	//5. 设置矩阵中除了首行首列的cells.
	//6. 设置首行，设置首列。
	//http://www.cnblogs.com/yuzhangcmu/p/4047507.html
    //http://answer.ninechapter.com/solutions/set-matrix-zeroes/
	//http://blog.csdn.net/linhuanmars/article/details/24066199
	public void setZeroes(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
		boolean row0has0 = false;
		boolean col0has0 = false;
		int row = matrix.length;
		int col = matrix[0].length;
		// check whether row0 has "0"
		for (int j = 0; j < col; j++) {
			if (matrix[0][j] == 0) {
				row0has0 = true;
				break;
			}
		}
		// check whether col0 has "0"
		for (int i = 0; i < row; i++) {
			if (matrix[i][0] == 0) {
				col0has0 = true;
				break;
			}
		}
		// use row0 and col0 to mark all the coordinates that are "0"
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		// assign zero to all satisfied position except row0 and col0
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (matrix[0][j] == 0 || matrix[i][0] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		// if row0 has 0, set all element in row0 to be "0"
		if (row0has0) {
			for (int j = 0; j < col; j++) {
				matrix[0][j] = 0;
			}
		}
		// if col0 has 0, set all element in col0 to be "0"
		if (col0has0) {
			for (int i = 0; i < row; i++) {
				matrix[i][0] = 0;
			}
		}
	}
    
}
