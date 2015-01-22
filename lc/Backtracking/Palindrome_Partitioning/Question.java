package Palindrome_Partitioning;

import java.util.ArrayList;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aabccb";
		Question q = new Question();
		
		ArrayList<ArrayList<String>> result = q.partition(s);
		for (int i = 0; i < result.size(); i++) {
			ArrayList<String> item = result.get(i);
			for (int j = 0; j < item.size(); j++) {
				System.out.print(item.get(j)+ ",");
			}
			System.out.println("");
		}
	}

	/**
	 * https://oj.leetcode.com/problems/palindrome-partitioning/
	 * Given a string s, partition s such that every substring of the partition
	 * is a palindrome.
	 * Return all possible palindrome partitioning of s.
	 * 
	 * For example, given s = "aab", 
	 * Return
	 * [ 
	 * 	["aa","b"], 
	 * 	["a","a","b"] 
	 * ]
	 */
	
	//using DFS
	//http://blog.csdn.net/linhuanmars/article/details/22777711
    public ArrayList<ArrayList<String>> partition(String s) {
    	ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if(s == null | s.length() == 0){
        	return result;
        }
        ArrayList<String> item = new ArrayList<String>();
        boolean[][] isPalindrome = getIsPalindrome(s);
        int pos = 0;
        helper(result, item, isPalindrome, s, pos);
        return result;
    }
    
    //DFS
    private void helper(ArrayList<ArrayList<String>>result, ArrayList<String> item, boolean[][] isPalindrome, String s, int pos){
    	if (pos == s.length()) { //s的最后一个字符都处理完了，则得到一个方案。
    		result.add(new ArrayList<String>(item));
    		return;
		}
		for (int i = pos; i < s.length(); i++) { //【注】i要从当前pos开始（pos之前都是处理好了的）
			if (isPalindrome[pos][i]) { //只要找到一段新的子串（s.substring(pos, i + 1)）也是palindrome，
				item.add(s.substring(pos, i + 1));//就把这段加入item中
				helper(result, item, isPalindrome, s, i + 1); //然后pos置为i+1，继续对i+1后边的进行递归
				item.remove(item.size() - 1); //回溯 backtracking
			}
    	}
    }
    
	//isPalindrome[i][j]表示从在字符串s中，从i到j是不是palindrome
	//此矩阵只有右上三角为有效数据，具体看图。
	private boolean[][]	getIsPalindrome(String s) {
		int len = s.length();
		boolean[][] isPalindrome = new boolean[len][len];
		//【注】需要从最底层往最顶层计算，因为等号右边的isPalindrome[i + 1][j - 1]在所求的isPalindrome[i][j]的下方。
		for (int i = len - 1; i >= 0; i--) {
			for (int j = i; j <= len - 1; j++) {
				if (j == i) { //初始化对角线
					isPalindrome[i][j] = true;
				} else if (j == i + 1) { //初始化对角线右边一个
					isPalindrome[i][j] = s.charAt(i) == s.charAt(i + 1);
				} else { //推导右上三角剩余数据
					isPalindrome[i][j] = s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1];
				}
			}
		}
		return isPalindrome;
	}
}
