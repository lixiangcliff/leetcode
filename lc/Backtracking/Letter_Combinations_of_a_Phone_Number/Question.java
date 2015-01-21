package Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.HashMap;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		ArrayList<String> result = q.letterCombinations("23");
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + ",");
		}
	}

	/**
	 * https://oj.leetcode.com/problems/letter-combinations-of-a-phone-number/
	 * Given a digit string, return all possible letter combinations that the
	 * number could represent.
	 * A mapping of digit to letters (just like on the telephone buttons) is
	 * given below.
	 * 
	 * http://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png
	 * 
	 * Input:Digit string "23" 
	 * Output: ["ad", "ae", "af", "bd", "be", "bf","cd", "ce", "cf"]. 
	 * 
	 * Note: Although the above answer is in lexicographical
	 * order, your answer could be in any order you want.
	 */
	//DFS
	//http://blog.csdn.net/linhuanmars/article/details/19743197
	public ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> result = new ArrayList<String>();
		if (digits == null) {
			return result;
		}
		HashMap<Character, char[]> num2LetterMap = new HashMap<Character, char[]>();
		num2LetterMap.put('0', new char[]{}); // 0和1 对应的为空字符数组
		num2LetterMap.put('1', new char[]{});
		num2LetterMap.put('2', new char[]{'a','b','c'}); //【注】记住字符数组初始化的方法
		num2LetterMap.put('3', new char[]{'d','e','f'});
		num2LetterMap.put('4', new char[]{'g','h','i'});
		num2LetterMap.put('5', new char[]{'j','k','l'});
		num2LetterMap.put('6', new char[]{'m','n','o'});
		num2LetterMap.put('7', new char[]{'p','q','r','s'});
		num2LetterMap.put('8', new char[]{'t','u','v'});
		num2LetterMap.put('9', new char[]{'w', 'x','y','z'});
		StringBuilder sb = new StringBuilder();
		helper(result, num2LetterMap, sb, digits);
		return result;
    }
	
	private void helper(ArrayList<String> result, HashMap<Character, char[]> num2LetterMap, StringBuilder sb, String digits) {
		if (sb.length() == digits.length()) {
			result.add(sb.toString());
			return;
		}
		//num2LetterMap.get(digits.charAt(sb.length()))这个要想明白：
		//举例说明比如digits==“23”，已经取到了第"1"位(设最左边位为第0位),要append到sb里的c应该是'd', 'e' 或者 'f'。
		//于是char c : sth，这个sth就是{'d','e','f'}, 即num2LetterMap.get('3')
		//又可以知道'3'的来源是digits.charAt(1), 而1的来源是此时sb的长度
		for (char c : num2LetterMap.get(digits.charAt(sb.length()))) {
			sb.append(c); // 找到一个符合的字符，append到sb后
			helper(result, num2LetterMap, sb, digits); // 递归
			sb.deleteCharAt(sb.length() - 1); // 回溯
		}
	}
}
