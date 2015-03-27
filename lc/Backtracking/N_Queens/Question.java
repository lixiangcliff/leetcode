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
	
	//DFS recursive (类似permutations)
	//http://www.ninechapter.com/solutions/n-queens/
	//http://blog.csdn.net/linhuanmars/article/details/20667175
	//http://blog.csdn.net/zhong317/article/details/4586131
    public ArrayList<String[]> solveNQueens(int n) {
    	ArrayList<String[]> result = new ArrayList<String[]>();
    	//这个记录了所有n个Q所在的行和列（比如columnForRow.get(0)==2，代表的意思是第0行第2列有一个Q）其实columnForRow用int[]表示也可以，但是相比于ArrayList，后者更方便进行add和remove。
    	ArrayList<Integer> columnForRow = new ArrayList<Integer>(); 
    	helper(result, columnForRow, n);
    	return result;
    }
    
    private void helper(ArrayList<String[]> result, ArrayList<Integer> columnForRow, int n) { 
    	if (columnForRow.size() == n) { // 说明已经找到一个方案了，接下来就是把该方案保存到result里
    		result.add(drawBoard(columnForRow)); // 完成一个方案，并加入result
    		return;
    	}
    	// 在当前row中找到一个可以放置queen的valid列col，(col 从0开始试到n - 1)
    	for (int col = 0; col < n; col++) {
    		if (!isValid(columnForRow, col)) { // 如果当前col不合法
    			continue; // 则什么也不做(相当于“剪枝”了)，继续试下一个col值
    		}
    		columnForRow.add(col); //当前col合法，则加入columnForRow中
    		helper(result, columnForRow, n); // 继续递归处理columnForRow
    		columnForRow.remove(columnForRow.size() - 1); // 回溯
    	}
    }

    //根据一个合法的columnForRow来画出用String[]表示的棋盘
	private String[] drawBoard(ArrayList<Integer> columnForRow) {
		int size = columnForRow.size();
		String[] item = new String[size]; // item 即为一种方案
		for (int i = 0; i < size; i++) {
			StringBuilder sb = new StringBuilder(); //表示item的一行
			for(int j = 0; j < size; j++) {
				if (j == columnForRow.get(i)) {	//找到了在第i行queen所处于的列
					sb.append('Q');
				} else {
					sb.append('.');
				}
			}
			item[i] = sb.toString(); // 完成一行，并加入item
		}
		return item;
	}
    
    //检查加入的queen如果放在，“当前columnForRow的下一行”和“第col列”，是否还能保证棋盘valid
    private boolean isValid(ArrayList<Integer>columnForRow, int col) {
    	int row = columnForRow.size(); // row既表示当前columnForRow的size，同时也表示当前处理的col是在第几行
    	for (int i = 0; i < row; i++) { //只需检查与row以上的行是否冲突就行了
    		//只需要检查，“列”和“对角线”，是否冲突（不需要检查行，因为我们以行来循环处理，所以行肯定不会冲突）
    		if (columnForRow.get(i) == col || Math.abs(row - i) == Math.abs(col - columnForRow.get(i))) {
    			return false;
    		}
    	}
    	return true;
    }

}
