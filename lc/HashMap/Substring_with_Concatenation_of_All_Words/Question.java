package Substring_with_Concatenation_of_All_Words;

import java.util.ArrayList;
import java.util.HashMap;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		String S = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
		String[] L = {"fooo","barr","wing","ding","wing"};
/*		String S = "aaaaaaaa";
		String[] L = {"aa", "aa", "aa"};*/
		ArrayList result = q.findSubstring(S, L);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
		
	}
	
	
	/**
	 * https://oj.leetcode.com/problems/substring-with-concatenation-of-all-words/
	 * You are given a string, S, and a list of words, L, that are all of the
	 * same length. Find all starting indices of substring(s) in S that is a
	 * concatenation of each word in L exactly once and without any intervening
	 * characters.
	 * 
	 * For example, given: 
	 * S: "barfoothefoobarman" 
	 * L: ["foo", "bar"]
	 * 
	 * You should return the indices: [0,9]. (order does not matter).
	 */
	
	
	//【注】当前方法效率低下，时间复杂度为O(wordLen * L.length * S.length())
	//有时间重写，可参考：http://blog.csdn.net/linhuanmars/article/details/20342851  时间复杂度为O(S.length())
	//手写
	public ArrayList<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (S == null || S.length() == 0 || L == null || L.length == 0) {
			return result;
		}
		// 把L里面所有string都放入map中，<string, 该string在L中出现的次数>
		HashMap<String, Integer> aimMap = new HashMap<String, Integer>();
		int wordLen = L[0].length();
		for (String word: L) {
			if (aimMap.containsKey(word)) {
				aimMap.put(word, aimMap.get(word) + 1);
			} else {
				aimMap.put(word, 1);
			}
		}
		for (int i = 0; i <= S.length() - wordLen * L.length; i++) { // i的边界，举例最清晰
			HashMap<String, Integer> matchMap = new HashMap<String, Integer>(aimMap); // 从matchMap中依次减去
			for (int j = i; j <= S.length() - wordLen; j += wordLen) { // j标记当前word的起始index, j的边界也要画图为好
				String curWord = S.substring(j, j + wordLen);
				if (!matchMap.containsKey(curWord)) {
					break;
				}
				if (matchMap.get(curWord) > 0) {
					matchMap.put(curWord, matchMap.get(curWord) - 1);
				}
				if (matchMap.get(curWord) == 0) {
					matchMap.remove(curWord);
				} 
				if (matchMap.isEmpty()) { // matchMap里的元素已经被一一剔除了，则说明i是一个合法的起始index
					result.add(i);
					break;
				}
			}
		}
    	return result;
	 }
	
	//http://www.cnblogs.com/yuzhangcmu/p/4114656.html
	//"每次复制一个HashMap，找到一个单词，即减少此单词的计数，直到HashMap为空，表示我们找到一个解。"
	public ArrayList<Integer> findSubstring2(String S, String[] L) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (S == null || S.length() == 0 || L == null || L.length == 0) {
			return result;
		}
		// 把L里面所有string都放入map中，<string, 该string在L中出现的次数>
		HashMap<String, Integer> aimMap = new HashMap<String, Integer>();
		int wordLen = L[0].length();
		for (String word: L) {
			if (aimMap.containsKey(word)) {
				aimMap.put(word, aimMap.get(word) + 1);
			} else {
				aimMap.put(word, 1);
			}
		}
		for (int i = 0; i <= S.length() - wordLen * L.length; i++) { // i的边界，举例最清晰
			HashMap<String, Integer> matchMap = new HashMap<String, Integer>(aimMap); // 从matchMap中依次减去
			for (int j = i; j <= S.length() - wordLen; j += wordLen) { // j标记当前word的起始index, j的边界也要画图为好
				String curWord = S.substring(j, j + wordLen);
				if (matchMap.containsKey(curWord)) {
					matchMap.put(curWord, matchMap.get(curWord) - 1);
					if (matchMap.get(curWord) == 0) { //【注】如果此时curWord的数量已经为0了，则从matchMap中删去，以避免之后的混淆
						matchMap.remove(curWord);
					}
				} else {
					break;
				}
				if (matchMap.isEmpty()) { // matchMap里的元素已经被一一剔除了，则说明i是一个合法的起始index
					result.add(i);
				}
			}
		}
    	return result;
	 }
}
