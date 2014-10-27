package Word_Search;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//http://blog.csdn.net/linhuanmars/article/details/24336987
    public boolean exist(char[][] board, String word) {
    	if(word == null || word.length() == 0){
    		return true;
    	}
    	if(board == null || board.length == 0){
    		return false;
    	}
    	boolean[][] used = new boolean[board.length][board[0].length];
    	for(int i=0;i<board.length;i++){
    		for(int j=0; j<board[0].length;j++){
    			if(helper(board, word, 0, i, j, used)){
    				return true;
    			}
    		}
    	}
        return false;
    }
    
    private boolean helper(char[][] board, String word, int index, int i, int j, boolean[][] used){
    	if(index == word.length()){
    		return true;
    	}
    	
    	if(i<0 || j<0 || i>=board.length || j>=board[0].length || used[i][j] || board[i][j] != word.charAt(index)){
    		return false;
    	}
    	used[i][j] = true;
    	boolean result = helper(board, word, index+1, i-1, j, used)
    			|| helper(board, word, index+1, i+1, j, used)
    			|| helper(board, word, index+1, i, j-1, used)
    			|| helper(board, word, index+1, i, j+1, used);
    	used[i][j] = false;
    	return result;
    }

}
