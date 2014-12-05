package N_Queens;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://oj.leetcode.com/problems/n-queens/
	 * The n-queens puzzle is the problem of placing n queens on an n×n
	 * chessboard such that no two queens attack each other.
	 * 
	 * Given an integer n, return all distinct solutions to the n-queens puzzle.
	 * 
	 * Each solution contains a distinct board configuration of the n-queens'
	 * placement, where 'Q' and '.' both indicate a queen and an empty space
	 * respectively.
	 * 
	 * For example, There exist two distinct solutions to the 4-queens puzzle:
	 * 
	 * [
	 *  [".Q..",  // Solution 1
	 * 	 "...Q", 
	 *   "Q...", 
	 *   "..Q."],
	 * 
	 *  ["..Q.", // Solution 2 
	 *   "Q...", 
	 *   "...Q", 
	 *   ".Q.."] 
	 * ]
	 */
	
	//http://blog.csdn.net/linhuanmars/article/details/20667175
	//http://blog.csdn.net/zhong317/article/details/4586131
    public ArrayList<String[]> solveNQueens(int n) {
    	ArrayList<String[]> result = new ArrayList<String[]>();
    	//这个记录了所有n个Q所在的行和列（e.g. 比如columnForRow[0]==2，代表的意思是第0行第2列有一个Q）
    	int[] columnForRow = new int[n]; 
    	int row = 0; //row 代表当前处理第row行
    	helper(result, columnForRow, n, row);
    	return result;
    }
    
    private void helper(ArrayList<String[]> result, int[] columnForRow, int n, int row) { 
    	if(row == n){ // 说明已经找到一个方案了，接下来就是把该方案保存到result里
    		String[] item = new String[n]; // item 即为一种方案
    		for (int i = 0; i < n; i++) {
    			StringBuilder sb = new StringBuilder(); //表示item的一行
	    		for(int j = 0; j < n; j++) {
	    			if (j == columnForRow[i]){	//找到了在第i行queen所处于的列
	    				sb.append('Q');
	    			}else{
	    				sb.append('.');
	    			}
	    			item[i] = sb.toString(); // 完成一行，并加入item
	    		}
    		}
    		result.add(item); // 完成一个方案，并加入result
    		return;
    	}
    	// 在当前row中找到一个可以放置queen的valid列，
    	for (int j = 0; j < n; j++) {
    		columnForRow[row] = j;  
    		if (isValid(row, columnForRow)) { // 如果queen放在row和columnForRow[row]是valid的，则继续处理第row+1行;
    			helper(result, columnForRow, n, row + 1); 
    		}
    	}
    }
    
    //检查加入的queen如果放在，“第row行，第columnForRow[row]列”，是否还能保证棋盘valid
    private boolean isValid(int row, int[] columnForRow){
    	for(int i=0; i<row; i++){ //只需检查是否与row以上的行是否冲突就行了
    		//只需要检查，“列”和“对角线”，是否冲突（不需要检查行，因为我们以行来循环处理，所以行肯定不会冲突）
    		if(columnForRow[row] == columnForRow[i] || Math.abs(row - i) == Math.abs(columnForRow[row] - columnForRow[i])){
    			return false;
    		}
    	}
    	return true;
    }

}
