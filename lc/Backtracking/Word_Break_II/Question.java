package Word_Break_II;

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
		Question q = new Question();
		String s = "catsanddog";
		Set<String> dict = new HashSet<String>();
		String[] dictStrs = {"cat", "cats", "and", "sand", "dog"}; 
		for (String str : dictStrs) {
			dict.add(str);
		}
		List<String> result = q.wordBreak(s, dict);
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
	//http://www.cnblogs.com/yuzhangcmu/p/4037299.html
	//http://blog.csdn.net/linhuanmars/article/details/22452163
	List<String> wordBreak(String s, Set<String> dict){ // 【注1】必须用Set而不是HashSet来通过leetcode
		List<String> result = new ArrayList<String>();
		if (s == null || s.length() == 0 || !isWordBreakable(s, dict)) { // 如果s不能wordbreak则直接返回result，避免输入字符串过长，导致回溯超时。
			return result;
		}
		List<String> item = new ArrayList<String>(); // 以ArrayList<String>的形式存一组合法的解
		int maxLen = getMaxLen(dict);
		helper(result, item, s, dict, maxLen, 0);
		return result;
	}
	
	private void helper(List<String> result, List<String> item, String s, Set<String> dict, int maxLen, int start){
		if (start == s.length()) { // 结束了。start到了末尾
            StringBuilder sb = new StringBuilder();
            for (String str: item) {
                sb.append(str);
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length() - 1); // remove the last " "
            result.add(sb.toString());
            return;
		}
		for (int i = start; i < start + maxLen && i < s.length(); i++) {
			String temp = s.substring(start, i + 1);
			if (!dict.contains(temp)) {// 如果sb不是dict中的一个单词，则不需要递归了 
				continue;
			}
            item.add(temp); // 添加
            helper(result, item, s, dict, maxLen, i + 1); // 递归
            item.remove(item.size() - 1); // 回溯
		}
	}
	
	private int getMaxLen(Set<String> dict) {
		int max = 0;
		for (String str : dict) {
			max = Math.max(max, str.length());
		}
		return max;
	}
	
	//【注2】加上这个函数纯粹只是为了pass leetcode上下面这个test case
	//"Last executed input:	"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", 
	//["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]"
	//函数重用: https://oj.leetcode.com/problems/word-break/	
	private boolean isWordBreakable(String s, Set<String> dict) {
		if (s == null || s.length() == 0)
			return true;
		boolean[] result = new boolean[s.length() + 1];
		result[0] = true;
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j <= i; j++) {
				String sub = s.substring(j, i + 1);
				if (result[j] && dict.contains(sub)) {
					result[i + 1] = true;
					break;
				}
			}
		}
		return result[s.length()];
	}
}
