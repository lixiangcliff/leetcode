package Roman_to_Integer;
import java.util.HashMap;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		System.out.println(q.romanToInt("MMXIV"));

	}
	
	/**
	 * https://oj.leetcode.com/problems/roman-to-integer/
	 * Given a roman numeral, convert it to an integer.
	 * 
	 * Input is guaranteed to be within the range from 1 to 3999.
	 */
	
	//思路： 从前往后遍历罗马数字，如果当前数比右边一个数小，则把当前数在结果中减掉； 反之，则在结果中加上当前这个数；
	// http://www.ninechapter.com/solutions/roman-to-integer/
	public int romanToInt(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>(); // <Roman Char, int value>
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int result = 0;
		for (int i = 0; i < s.length() - 1; i++) { // 一直处理到倒数第二个数
			if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
				result += map.get(s.charAt(i));
			} else {
				result -= map.get(s.charAt(i));
			}
		}
		result += map.get(s.charAt(s.length() - 1)); // 处理最后一个数
		return result;
    }

}
