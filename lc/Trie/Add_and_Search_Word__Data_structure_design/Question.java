package Add_and_Search_Word__Data_structure_design;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		WordDictionary wordDictionary = new WordDictionary();
		
/*		wordDictionary.addWord("at");
		wordDictionary.addWord("and");
		wordDictionary.addWord("an");*/
		//wordDictionary.addWord("add");
		//System.out.println(wordDictionary.search("a"));
		//System.out.println(wordDictionary.search(".at"));
		wordDictionary.addWord("bat");
		System.out.println(wordDictionary.search(".at"));
	}
	
	/**
	 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
	 * Design a data structure that supports the following two operations:

		void addWord(word)
		bool search(word)
		search(word) can search a literal word or a regular expression string containing only letters a-z or '.' 
		A '.' means it can represent any one letter.
		
		For example:
		
		addWord("bad")
		addWord("dad")
		addWord("mad")
		search("pad") -> false
		search("bad") -> true
		search(".ad") -> true
		search("b..") -> true
		Note:
		You may assume that all words are consist of lowercase letters a-z.
		
		click to show hint.
		You should be familiar with how a Trie works. If not, please work on this problem: Implement Trie (Prefix Tree) first.
	 */

}

//similar to Implement_Trie_Prefix_Tree
class WordDictionary {
	
	private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    //完全copy
    public void addWord(String word) {
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

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter. 【注】特殊考虑'.'的情况
    public boolean search(String word) {
    	if (word == null || word.length() == 0) {
    		return false;
    	}
		TrieNode pre = root;
        int idx = 0;
        return dfs(word, idx, pre);
    }
    
    private boolean dfs (String word, int idx, TrieNode pre) {
    	if (idx == word.length()) {
    		return pre.isEnd;
    	}
    	char c = word.charAt(idx);
		boolean res = false;
		for (int i = 0; i < pre.next.length; i++) {
			if (c != '.') {
				int pos = c - 'a';
	    		if (pre.next[pos] != null) {
	    			return dfs(word, idx + 1, pre.next[pos]);
	    		} else {
	    			return false;
	    		}
			}	
			if (pre.next[i] != null) { // 说明当前c == '.'， 则pre.next[]里任何一个分支true，整个情况就是true了
				res |= dfs(word, idx + 1, pre.next[i]);
	    	}
		}
    	return res;
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
//Your WordDictionary object will be instantiated and called as such:
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("word");
//wordDictionary.search("pattern");