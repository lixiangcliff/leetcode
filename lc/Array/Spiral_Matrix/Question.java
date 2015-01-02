package Spiral_Matrix;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		int[][] matrix = {
							{ 1, 2, 3 },
							{ 4, 5, 6 },
							{ 7, 8, 9 }
						};
		ArrayList<Integer> result  = q.spiralOrder(matrix);
		for (int i : result){
			System.out.print(i + ",");
		}
	}
	
	/**
	 * https://oj.leetcode.com/problems/spiral-matrix/
	 * Given a matrix of m x n elements (m rows, n columns), return all elements
	 * of the matrix in spiral order.
	 * 
	 * For example, Given the following matrix:
	 * [ 
	 * 	[ 1, 2, 3 ], 
	 * 	[ 4, 5, 6 ], 
	 * 	[ 7, 8, 9 ] 
	 * ] 
	 * You should return [1,2,3,6,9,8,7,4,5].
	 */
	
	//http://www.cnblogs.com/yuzhangcmu/p/4046543.html
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
    		return result;
    	}
    	//l, r, u, d分别表示当前的左右上下界
        int l = 0;
        int r = matrix[0].length - 1;
        int u = 0;
        int d = matrix.length - 1;
        int size = matrix.length * matrix[0].length;
		while (true) {
			//【注】对于每个方向遍历的时候都必须“走到底”，否则最后走到中间可能会有剩余永远无法遍历到。
			// rightward
			for (int j = l; j <= r; j++) { // j <= r; 边界处理的最好办法就是画图举例
				result.add(matrix[u][j]);
			}
			if (result.size() == size) { // 表明已经遍历了matrix中所有元素
				break;
			}
			// downward
			for (int i = u + 1; i <= d; i++) {
				result.add(matrix[i][r]);
			}
			if (result.size() == size) {
				break;
			}
			// leftward
			for (int j = r - 1; j >= l; j--) {
				result.add(matrix[d][j]);
			}
			if (result.size() == size) {
				break;
			}
			// upward
			for (int i = d - 1; i > u; i--) {
				result.add(matrix[i][l]);
			}
			if (result.size() == size) {
				break;
			}
			// 更新边界
			l++;
			r--;
			u++;
			d--;
		}
        return result;
    }
}
