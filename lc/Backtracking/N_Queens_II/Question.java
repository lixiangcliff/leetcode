package N_Queens_II;

import java.util.ArrayList;

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
	//DFS recursive
	//和N Queen类似：https://oj.leetcode.com/problems/n-queens/
	//http://blog.csdn.net/linhuanmars/article/details/20668017
    public int totalNQueens(int n) {
    	//和N-Queen的唯一区别就是结果是一个int数组，
    	//之所以用一个只有一个元素的数组而不是一个整数,是因为数组在递归调用时内容和以保留，而整数类型不能
		int[] result = { 0 }; //方案总数
    	ArrayList<Integer>columnForRow = new ArrayList<Integer>(); 
    	helper(result, columnForRow, n);
    	return result[0];
    }
    
    //DFS
    private void helper(int[] result, ArrayList<Integer> columnForRow, int n) {
    	if(columnForRow.size() == n){ 
    		result[0]++; // 完成一个方案，递增result[0]
    		return;
    	}
    	for (int col = 0; col < n; col++) {
    		if (!isValid(columnForRow, col)) { // 如果当前col不合法
    			continue; // 则什么也不做(相当于“剪枝”了)，继续试下一个col值
    		}
    		columnForRow.add(col); //当前col合法，则加入columnForRow中
    		helper(result, columnForRow, n); // 继续递归处理columnForRow
    		columnForRow.remove(columnForRow.size() - 1); // 回溯
    	}
    }
    
    //检查加入的queen如果放在，“第row行，第columnForRow[row]列”，是否还能保证棋盘valid
    private boolean isValid(ArrayList<Integer>columnForRow, int col){
    	int row = columnForRow.size(); 
    	for(int i = 0; i < row; i++){ 
    		if(columnForRow.get(i) == col || Math.abs(row - i) == Math.abs(col - columnForRow.get(i))){
    			return false;
    		}
    	}
    	return true;
    }
}
