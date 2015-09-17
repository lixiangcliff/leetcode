package Word_Search;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://oj.leetcode.com/problems/word-search/
	 * Given a 2D board and a word, find if the word exists in the grid.
	 * 
	 * The word can be constructed from letters of sequentially adjacent cell,
	 * where "adjacent" cells are those horizontally or vertically neighboring.
	 * The same letter cell may not be used more than once.
	 * 
	 * For example, 
	 * Given board =
	 * [ 
	 * 	["ABCE"], 
	 * 	["SFCS"], 	
	 * 	["ADEE"] 
	 * ] 
	 * word = "ABCCED", -> returns true, 
	 * word = "SEE", -> returns true, 
	 * word = "ABCB", -> returns false.
	 */
	
	//DFS
	//http://blog.csdn.net/linhuanmars/article/details/24336987
    public boolean exist(char[][] board, String word) {
		if (word == null || word.length() == 0) { // word内容为空，则true
			return true;
		}
		if (board == null || board.length == 0) { // board内容为空，则false
			return false;
		}
		boolean[][] used = new boolean[board.length][board[0].length]; // 标记board各个位置是否访问过，初始化时都为false
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				int start = 0;
				if (helper(board, word, start, i, j, used)) { // 只要遇到任意位置[i][j]，能找到word，则true
					return true;
				}
			}
		}
		return false;
	}
    
    private boolean helper(char[][] board, String word, int start, int i, int j, boolean[][] used){
    	if (start == word.length()){
    		return true;
    	}
    	//如果i，j越界，或者[i][j]的位置已经访问过，或者board上[i][j]位置的字符和word上start位置上的字符不相等，则false
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || used[i][j] || board[i][j] != word.charAt(start)) {
			return false;
    	}
		//进行到这里说明[i][j]位置上的字符符合可以继续搜索下去的条件
    	used[i][j] = true; // 把当前board位置纳入word中的一个位置，即标记[i][j]为访问过
    	//继续递归：word向右走一位，board分别尝试上下左右四个可能的方向。其中有任何一个为true，则为true。【注】技巧是set一个result作为返回值
		boolean result = helper(board, word, start + 1, i - 1, j, used) 
				|| helper(board, word, start + 1, i + 1, j, used)
				|| helper(board, word, start + 1, i, j - 1, used)
				|| helper(board, word, start + 1, i, j + 1, used);
    	used[i][j] = false; // 回溯，把[i][j]标为未访问
    	return result;
    }

}
