package androidLockScreen;

import java.util.ArrayList;
import java.util.List;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		int [][] board = {
							{1,2,3},
							{4,5,6},
							{7,8,9},
							//{10,11,12},
							};
		int len = 5;
		List<List<Integer>> result = q.generateLocks(board, len);
		
		for (int i = 0; i < result.size(); i++) {
			ArrayList<Integer> item = (ArrayList<Integer>) result.get(i);
			for (int j = 0; j < item.size(); j++) {
				System.out.print(item.get(j)+ ",");
			}
			System.out.println("");
		}
		System.out.println("result size:" + result.size());
	}
	
	
	//http://www.glassdoor.com/Interview/C3-Energy-Interview-Questions-E312703.htm
	
	/**
	 * Generate all possible lock combinations on an android lock screen of length 5 
	 * such that each numbers are adjacent to each other and no repetitions within a combination.  
	 */
	
	public List<List<Integer>> generateLocks(int board[][], int len) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> item = new ArrayList<Integer>();
		if (board == null) {
			return res;
		}
		boolean used[][] = new boolean[board.length][board[0].length];
		int pos = 0;
		helper(res, item, board, pos, used, len);
		return res;
	}
	
	
	
	private void helper(List<List<Integer>> res, List<Integer> item, int board[][], int pos, boolean used[][], int len) {
		if (item.size() > len) {
			return;
		}
		if (item.size() == len) {
			res.add(new ArrayList<Integer>(item));
			return;
		}
		int m = board.length;
		int n = board[0].length;
		int i = pos / n;
		int j = pos % n;
		
		used[i][j] = true;
		item.add(board[i][j]);
		if (i > 0 && !used[i - 1][j]) { // go up
			helper(res, item, board, pos - n, used, len);
		}
		if (i < m - 1 && !used[i + 1][j]) { // go down
			helper(res, item, board, pos + n, used, len);
		}
		if (j > 0 && !used[i][j - 1]) { // go left
			helper(res, item, board, pos - 1, used, len);
		}
		if (j < n - 1 && !used[i][j + 1]) { // go right
			helper(res, item, board, pos + 1, used, len);
		}
		item.remove(item.size() - 1);
		used[i][j] = false;

		
		
/*		if (i > 0 && !used[i - 1][j]) { // go up
			used[i - 1][j] = true;
			item.add(board[i][j]);
			helper(res, item, board, pos - n, used, len);
			item.remove(item.size() - 1);
			used[i - 1][j] = false;
		}
		if (i < m - 1 && !used[i + 1][j]) { // go down
			used[i + 1][j] = true;
			item.add(board[i][j]);
			helper(res, item, board, pos + n, used, len);
			item.remove(item.size() - 1);
			used[i + 1][j] = false;
		}
		if (j > 0 && !used[i][j - 1]) { // go left
			used[i][j - 1] = true;
			item.add(board[i][j]);
			helper(res, item, board, pos - 1, used, len);
			item.remove(item.size() - 1);
			used[i][j - 1] = false;
		}
		if (j < n - 1 && !used[i][j + 1]) { // go right
			used[i][j + 1] = true;
			item.add(board[i][j]);
			helper(res, item, board, pos + 1, used, len);
			item.remove(item.size() - 1);
			used[i][j + 1] = false;
		}*/
	}

}
