package Implement_Trie_Prefix_Tree;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://leetcode.com/problems/implement-trie-prefix-tree/
	 * Implement a trie with insert, search, and startsWith methods.
	 * Note:
	 * You may assume that all inputs are consist of lowercase letters a-z.
	 */
	
	

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
