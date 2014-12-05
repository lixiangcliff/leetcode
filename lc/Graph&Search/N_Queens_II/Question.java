package N_Queens_II;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		System.out.println(q.totalNQueens(8));

	}
	
	/**
	 * https://oj.leetcode.com/problems/n-queens-ii/
	 * Follow up for N-Queens problem.
	 * 
	 * Now, instead outputting board configurations, return the total number of
	 * distinct solutions.
	 */
	//和N Queen类似：https://oj.leetcode.com/problems/n-queens/
	//http://blog.csdn.net/linhuanmars/article/details/20668017
    public int totalNQueens(int n) {
    	//和N-Queen的唯一区别就是结果是一个int数组，
    	//之所以用一个只有一个元素的数组而不是一个整数,是因为数组在递归调用时内容和以保留，而整数类型不能
		int[] result = { 0 }; //方案总数
    	int[] columnForRow = new int[n];
    	int row = 0;
    	helper(result, columnForRow, n, row);
    	return result[0];
    }
    
    private void helper(int[] result, int[] columnForRow, int n, int row) {
    	if (row == n) {
    		result[0]++;
    		return;
    	}
    	// 在当前row中找到一个可以放置queen的valid列，
    	for (int i = 0; i < n; i++) {
    		columnForRow[row] = i;  
    		if(isValid(row, columnForRow)){
    			helper(result, columnForRow, n, row + 1); 
    		}
    	}
    }
    
    //检查加入的queen如果放在，“第row行，第columnForRow[row]列”，是否还能保证棋盘valid
	private boolean isValid(int row, int[] columnForRow) {
		for (int i = 0; i < row; i++) {
			if (columnForRow[row] == columnForRow[i] || Math.abs(row - i) == Math.abs(columnForRow[row] - columnForRow[i])) {
				return false;
			}
		}
    	return true;
    }

}
