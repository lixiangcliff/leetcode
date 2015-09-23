package Count_and_Say;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		System.out.println(q.countAndSay(5));
	}

	/**
	 * https://oj.leetcode.com/problems/count-and-say/
	 * The count-and-say sequence is the sequence of integers beginning as
	 * follows: 
	 * 1, 11, 21, 1211, 111221, ...
	 * 1 is read off as "one 1" or 11. 
	 * 11 is read off as "two 1s" or 21. 
	 * 21 is read off as "one 2, then one 1" or 1211. 
	 * Given an integer n, generate the nth sequence.
	 * Note: The sequence of integers will be represented as a string.
	 */
	
	//	
	public String countAndSay(int n) {
		if (n == 1) { // 终止条件
			return "1";
		}
		if (n == 2) { // 【注】这个必须要写！否则for循环里i == 1会越界
			return "11";
		}
		String str = countAndSay(n - 1); // 【注】拿到上一轮的res，只需将其读出，就可以得到这一轮的res
		StringBuilder sb = new StringBuilder();
		int pre = 0;
		for (int i = 1; i <= str.length(); i++) {
			if (i == str.length() || str.charAt(i) != str.charAt(pre)) {
				sb.append(i - pre); // 值为str.charAt(pre)的个数
				sb.append(str.charAt(pre)); // str.charAt(pre)值
				pre = i;
			}
		}
		return sb.toString();
	}
	
	// 手写
	public String countAndSay2(int n) {
		if (n <= 0) { // corner case
			return "";
		}
		if (n == 1) { // 终止条件
			return "1"; 
		}
		String str = countAndSay(n - 1); // 【注】拿到上一轮的res，只需将其读出，就可以得到这一轮的res
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length();) {
			char cur = str.charAt(i);
			int j = i + 1;
			if (j != str.length()) {
				for (; j < str.length(); j++) {
					if (str.charAt(j) != cur) {
						break;
					}
				}
			}
			sb.append(j - i); // 值为cur的个数
			sb.append(cur); // cur值
			i = j;
		}
		return sb.toString();
	}
	
	
	//  把第n个string读出来就得到了第n + 1个string，以此类推。重点在如何“读”一个string
	// http://www.cnblogs.com/yuzhangcmu/p/4118146.html
	public String countAndSay3(int n) {
		if (n <= 0) { // corner case
			return null;
		}
		if (n == 1) { // 终止条件
			return "1"; 
		}
		String s = countAndSay(n - 1); // 通过n - 1的“读法”来推出n的读法
		int len = s.length();
		int count = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) { // 依次处理n - 1中的字符。必须从i == 0开始（不能从i == 1开始），否则count对应不上
			count++; // 每遇到一个新的字符，置其出现次数为1; 如果是重复的则出现次数递增1个
			if (i == len - 1 || (i < len - 1 && s.charAt(i) != s.charAt(i + 1))) { // 两种情况需要读出当前数：1.如果i已经走到s的最后1位了；2.如果当前位和下一位是不同的数字。
				sb.append(count); // 连续出现的次数
				sb.append(s.charAt(i)); // 连续出现的字符内容
				count = 0; // 【注】记得count重置为1；
			}
		}
		return sb.toString();
	}
}
