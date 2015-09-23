package Strobogrammatic_Number;

import java.util.HashMap;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		String num = "818";
		System.out.println(q.isStrobogrammatic(num));
	}

	/**
	 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
	 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
	 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
	 */
	
	public boolean isStrobogrammatic(String num) {
		if (num == null || num.length() == 0) {
			return true;
		}
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('0', '0');
		map.put('1', '1');
		map.put('6', '9');
		map.put('8', '8');
		map.put('9', '6');
		for (int i = 0; i < (num.length() + 1) / 2; i++) {
			if (!map.containsKey(num.charAt(i)) || map.get(num.charAt(i)) != num.charAt(num.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
}
