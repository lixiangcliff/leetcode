package Integer_to_Roman;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		System.out.println(q.intToRoman(1990));
		
	}
	
	/**
	 * https://oj.leetcode.com/problems/integer-to-roman/
	 * Given an integer, convert it to a roman numeral.
	 * 
	 * Input is guaranteed to be within the range from 1 to 3999.
	 */
	
	//思想：从大到小的贪心写法。从大到小匹配，尽量多地匹配当前的字符。
	//I = 1;
	//V = 5;
	//X = 10;
	//L = 50;
	//C = 100;
	//D = 500;
	//M = 1000;
	//把所有可能的减法，都变成加法，即"其中每两个阶段的之间有一个减法的表示，比如900=CM"（所以base为1,4,5,9；10,40,50,90...）
	//http://blog.csdn.net/havenoidea/article/details/11848921
	// http://www.cnblogs.com/yuzhangcmu/p/4116797.html
	public String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		int[] values =	   { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 }; // value中整数降序排列
		String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" }; // symbols中字符串与value中按顺序对应（其实相当于做了个hashmap）
		for (int i = 0; i < values.length; i++) {
			if (num == 0) {
				return sb.toString();
			}
			while (num >= values[i]) { // 尽量多的用当前元素，知道num里已经不足一个values[i]
				num -= values[i];
				sb.append(symbols[i]);
			}
		}
		return sb.toString();
	}

}
