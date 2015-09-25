package Word_Search_II;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
	
	//https://leetcode.com/discuss/36337/my-simple-and-clean-java-code-using-dfs-and-trie
	public List<String> findWords(char[][] board, String[] words) {
		Set<String> res = new HashSet<String>();//【注】res里的内容不能重复
    	if (board == null || words == null || board.length == 0 || board[0].length == 0 || words.length == 0) {
    		return new ArrayList<String>();
    	}
    	Trie trie = new Trie();
		for (String word : words) {
			trie.insert(word);
		}
		int row = board.length;
    	int col = board[0].length;
    	boolean used[][] = new boolean[row][col];
    	for (int i = 0; i < row; i++) {
    		for (int j = 0; j < col; j++) {
    			String str = "";
    			helper(res, board, used, str, i, j, trie);
    		}
    	}
    	return new ArrayList<String>(res); //cast HashSet into ArrayList	
	}
	
	private void helper(Set<String> res, char[][] board, boolean used[][], String str, int i, int j, Trie trie) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || used[i][j]) {
			return;
		}
		str += board[i][j];
		if (!trie.startsWith(str)) { // tire 里不包含当前的str
			return;
		}
		if (trie.search(str)) {
			res.add(str);
		}
		//四个方向继续试
		used[i][j] = true;
		helper(res, board, used, str, i - 1, j, trie);
		helper(res, board, used, str, i + 1, j, trie);
		helper(res, board, used, str, i, j - 1 , trie);
		helper(res, board, used, str, i, j + 1, trie);
		used[i][j] = false;//backtrack
	}
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
        	int pos = c - 'a';
        	if (pre.next[pos] == null) {
        		pre.next[pos] = new TrieNode(c);
        	} 
        	pre = pre.next[pos];
        }
        pre.isEnd = true;
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
        	} else if (i == word.length() - 1 && pre.next[pos].isEnd) { //已经走到word最后一位，并且该位确实是word的结尾
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
    
    public TrieNode(char c) {
        this.c = c;
        this.isEnd = false;
        next = new TrieNode[26];
    }
    
    public TrieNode(char c, boolean isEnd) {
        this.c = c;
        this.isEnd = isEnd;
        next = new TrieNode[26];
    }
}
