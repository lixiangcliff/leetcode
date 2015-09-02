package Word_Search_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://leetcode.com/problems/word-search-ii/
	 * Given a 2D board and a list of words from the dictionary, find all words in the board.

		Each word must be constructed from letters of sequentially adjacent cell, 
		where "adjacent" cells are those horizontally or vertically neighboring. 
		The same letter cell may not be used more than once in a word.
		
		For example,
		Given words = ["oath","pea","eat","rain"] and board =
		
		[
		  ['o','a','a','n'],
		  ['e','t','a','e'],
		  ['i','h','k','r'],
		  ['i','f','l','v']
		]
		Return ["eat","oath"].
		Note:
		You may assume that all inputs are consist of lowercase letters a-z.
		
		click to show hint.
		You would need to optimize your backtracking to pass the larger test. Could you stop backtracking earlier?
		If the current candidate does not exist in all words' prefix, you could stop backtracking immediately. 
		What kind of data structure could answer such query efficiently? Does a hash table work? Why or why not? 
		How about a Trie? If you would like to learn how to implement a basic trie, please work on this problem: Implement Trie (Prefix Tree) first.
	 */
	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<String>();
    	if (board == null || words == null || board.length == 0 || board[0].length == 0 || words.length == 0) {
    		return res;
    	}
    	Arrays.sort(words);
    	Trie trie = new Trie();
		for (String word : words) {
			trie.insert(word);
		}
    	for (int idx = 1; idx < words.length; idx++) {
    		if (words[idx].equals(words[idx - 1])) {
    			continue;
    		}
    		String word = words[idx];
    		int row = words.length;
        	int col = words[0].length();
        	for (int i = 0; i < row; i++) {
        		for (int j = 0; j < col; j++) {
        			int pos = 0;
        			/*if (helper(board, used, i, j, word, pos)) {
        				res.add(word);
        			}*/
        		}
        	}
    	}
    	return res;
		
		
	}
	
    private boolean helper(char[][] board, boolean used[][], int i, int j, String word, int pos) {
    	if (pos == word.length()) {
    		return true;
    	}
    	//如果i，j越界，或者[i][j]的位置已经访问过，或者board上[i][j]位置的字符和word上start位置上的字符不相等，则false
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || used[i][j] || board[i][j] != word.charAt(pos)) {
			return false;
    	}
		boolean res = false;
    	used[i][j] = true;
		res = helper(board, used, i - 1, j, word, pos + 1)
				|| helper(board, used, i + 1, j, word, pos + 1)
				|| helper(board, used, i, j - 1, word, pos + 1)
				|| helper(board, used, i, j + 1, word, pos + 1);
    	used[i][j] = false;
    	return res;
    }
	
	
	
	
	//will not pass large test cases
    public List<String> findWords2(char[][] board, String[] words) {
    	List<String> res = new ArrayList<String>();
    	if (board == null || words == null || board.length == 0 || board[0].length == 0 || words.length == 0) {
    		return res;
    	}
    	Arrays.sort(words);
    	boolean used[][] = new boolean[board.length][board[0].length];
    	for (int idx = 1; idx < words.length; idx++) {
    		if (words[idx].equals(words[idx - 1])) {
    			continue;
    		}
    		String word = words[idx];
    		int row = words.length;
        	int col = words[0].length();
        	for (int i = 0; i < row; i++) {
        		for (int j = 0; j < col; j++) {
        			int pos = 0;
        			if (helper(board, used, i, j, word, pos)) {
        				res.add(word);
        			}
        		}
        	}
    	}
    	return res;
    }
    
    //参考 "Word_Search"
/*    private boolean helper(char[][] board, boolean used[][], int i, int j, String word, int pos) {
    	if (pos == word.length()) {
    		return true;
    	}
    	//如果i，j越界，或者[i][j]的位置已经访问过，或者board上[i][j]位置的字符和word上start位置上的字符不相等，则false
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || used[i][j] || board[i][j] != word.charAt(pos)) {
			return false;
    	}
		boolean res = false;
    	used[i][j] = true;
		res = helper(board, used, i - 1, j, word, pos + 1)
				|| helper(board, used, i + 1, j, word, pos + 1)
				|| helper(board, used, i, j - 1, word, pos + 1)
				|| helper(board, used, i, j + 1, word, pos + 1);
    	used[i][j] = false;
    	return res;
    }*/

}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
    	if (word == null || word.length() == 0) {
    		return;
    	}
        TrieNode pre = root;
        for (int i = 0; i < word.length(); i++) {
        	char c = word.charAt(i);
        	boolean flag = i == word.length() - 1 ? true : false;
        	int pos = c - 'a';
        	if (pre.next[pos] == null) {
        		TrieNode cur = new TrieNode(c, flag);
        		pre.next[pos] = cur;
        	} else if (!pre.next[pos].isEnd && flag) {
        		pre.next[pos].isEnd = flag;
        	}
        	pre = pre.next[pos];
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
    	if (word == null || word.length() == 0) {
    		return false;
    	}
		TrieNode pre = root;
        for (int i = 0; i < word.length(); i++) {
        	char c = word.charAt(i);
        	int pos = c - 'a';
        	if (pre.next[pos] == null || pre.next[pos].c != c) {
        		return false;
        	} else if (i == word.length() - 1 && pre.next[pos].isEnd) {
        		return true;
        	}
        	pre = pre.next[pos];
        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	if (prefix == null || prefix.length() == 0) {
    		return false;
    	}
		TrieNode pre = root;
        for (int i = 0; i < prefix.length(); i++) {
        	char c = prefix.charAt(i);
        	int pos = c - 'a';
        	if (pre.next[pos] == null || pre.next[pos].c != c) {
        		return false;
        	} 
        	pre = pre.next[pos];
        }
        return true;
    }
}

class TrieNode {
    // Initialize your data structure here.
	char c;
	boolean isEnd;
	TrieNode[] next;
    public TrieNode() {
        this.c = ' ';
        this.isEnd = false;
        next = new TrieNode[26];
    }
    
    public TrieNode(char c, boolean isEnd) {
        this.c = c;
        this.isEnd = isEnd;
        next = new TrieNode[26];
    }
}
