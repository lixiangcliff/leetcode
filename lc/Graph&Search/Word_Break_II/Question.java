package Word_Break_II;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		String s = "catsanddog";
		Set<String> dict = new HashSet<String>();
		String[] dictStrs = {"cat", "cats", "and", "sand", "dog"}; 
		for (String str : dictStrs) {
			dict.add(str);
		}
		ArrayList<String> result = q.wordBreak(s, dict);
		for (String item : result) {
			System.out.println(item);
		}
	}
	

	/**
	 * https://oj.leetcode.com/problems/word-break-ii/
	 * Given a string s and a dictionary of words dict, add spaces in s to
	 * construct a sentence where each word is a valid dictionary word.
	 * Return all such possible sentences.
	 * 
	 * For example, given 
	 * s = "catsanddog", 
	 * dict = ["cat", "cats", "and", "sand", "dog"].
	 * A solution is ["cats and dog", "cat sand dog"].
	 */
	//DFS
	//http://blog.csdn.net/linhuanmars/article/details/22452163
	ArrayList<String> wordBreak(String s, Set<String> dict){ // 【注1】必须用Set而不是HashSet来通过leetcode
		ArrayList<String> result = new ArrayList<String>();
		if (s == null || s.length() == 0 || !isWordBreakable(s, dict)) { // 如果s不能wordbreak则直接返回result，避免输入字符串过长，导致回溯超时。
			return result;
		}
		String item = "";
		helper(result, item, s, dict, 0);
		return result;
	}
	
	private void helper(ArrayList<String> result, String item, String s, Set<String> dict, int start){
		if (start == s.length()) {
			result.add(item);
			return;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = start; i < s.length(); i++) {
			sb.append(s.charAt(i)); // 每次增加一个s中的字符加到sb中，看sb是否为dict中的一个单词
			if (dict.contains(sb.toString())) { // 如果是sb是否dict中的一个单词，就在后面进行递归 
				String newItem = "";
				if (item.length() == 0) {
					newItem = sb.toString();
				} else {
					newItem = item + " " + sb.toString();
				}
				helper(result, newItem, s, dict, i + 1); // 用item置为newItem，start置为i + 1，继续递归
			}
		}
	}
	
	//【注2】加上这个函数纯粹只是为了pass leetcode上下面这个test case
	//"Last executed input:	"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", 
	//["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]"
	//函数重用: https://oj.leetcode.com/problems/word-break/	
	private boolean isWordBreakable(String s, Set<String> dict) {  
	    if(s==null || s.length()==0)  
	        return true;  
	    boolean[] result = new boolean[s.length()+1];  
	    result[0] = true;  
	    for(int i=0;i<s.length();i++)  
	    {  
	        for(int j=0;j<=i;j++)  
	        {  
	        	String sub = s.substring(j,i+1); 
	            if(result[j] && dict.contains(sub))  
	            {  
	                result[i+1] = true;  
	                break;  
	            }  
	        }  
	    }  
	    return result[s.length()];  
	}
	
}
