package Spiral_Matrix_II;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Question q = new Question();
		int n = 3;
		int[][] result = q.generateMatrix(3);
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(result[i][j] + ",");
			}
			System.out.println();
		}
	}
	
	/**
	 * https://oj.leetcode.com/problems/spiral-matrix-ii/
	 * Given an integer n, generate a square matrix filled with elements from 1
	 * to n2 in spiral order.
	 * 
	 * For example, 
	 * Given n = 3,
	 * You should return the following matrix: 
	 * [ 
	 * [ 1, 2, 3 ], 
	 * [ 8, 9, 4 ], 
	 * [ 7, 6, 5 ] 
	 * ]
	 */
	
	//类似  Spiral_Matrix，只是多了一步边走边赋值，result填满了就说明走完了，便返回。
	//http://www.cnblogs.com/yuzhangcmu/p/4047789.html
	public int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];
		int l = 0;
		int u = 0;
		int r = n - 1;
		int d = n - 1;
		int num = 1;
		int end = n * n + 1; //【注】，因为最后一次num++导致 end需要等于matrix.size()+ 1才符合判断条件
		while (true) {
			// rightward
			for (int j = l; j <= r; j++) {
				result[u][j] = num++; // 先把num存入result，然后num自增
			}
			if (num == end) {
				break;
			}
			// downward
			for (int i = u + 1; i <= d; i++) {
				result[i][r] = num++; 
			}
			if (num == end) {
				break;
			}
			// leftward
			for (int j = r - 1; j >= l; j--) {
				result[d][j] = num++;
			}
			if (num == end) {
				break;
			}
			// upward
			for (int i = d - 1; i > u; i--) {
				result[i][l] = num++;
			}
			if (num == end) {
				break;
			}
			//左右上下边界都向中间生长
			l++;
			r--;
			u++;
			d--;
		}
		return result;
    }

}
