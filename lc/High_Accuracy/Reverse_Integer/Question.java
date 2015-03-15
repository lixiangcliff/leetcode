package Reverse_Integer;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		System.out.println(q.reverse(1000000003));

	}
	
	/**
	 * https://oj.leetcode.com/problems/reverse-integer/
	 * Reverse digits of an integer.
	 * 
	 * Example1: x = 123, return 321 
	 * Example2: x = -123, return -321
	 * 
	 * click to show spoilers.
	 * Have you thought about this? Here are some good questions to ask before
	 * coding. Bonus points for you if you have already thought through this!
	 * If the integer's last digit is 0, what should the output be? ie, cases
	 * such as 10, 100.
	 * Did you notice that the reversed integer might overflow? Assume the input
	 * is a 32-bit integer, then the reverse of 1000000003 overflows. How should
	 * you handle such cases?
	 * For the purpose of this problem, assume that your function returns 0 when
	 * the reversed integer overflows.
	 */
	
	//http://blog.csdn.net/linhuanmars/article/details/20024837
	public int reverse(int x) {
		if (x == Integer.MIN_VALUE) { //【注】 Integer.MIN_VALUE的绝对值是比Integer.MAX_VALUE大1的，所以不能对MIN取反，否则会越界。
			return 0; // 越界，leetcode期待返回0
		}
		int sign = 1;
		if (x < 0) { //如果x为负数，先把x转为正数，等最后再恢复。这样做可以方便后面判断越界与否。
			sign = -1;
			x *= (-1);
		}
		int result = 0;
		while (x > 0) { //x每次减小一位，result每次增加一位
			int remainder = x % 10; // 取x最右边一位
			//判断这一轮新产生的result会不会越界（是否result * 10 + remainder > Integer.MAX_VALUE;但是不能这样写，否则如果不等式真的成立，那么“>”左边就已经越界了）
			if (result > (Integer.MAX_VALUE - remainder) / 10) { // 越界，leetcode期待返回0
				return 0;
			}
			result = result * 10 + remainder; //result“左移”一位（以十进制的方式），把x最右边一位加到结果上
			x /= 10;
		}
		return result * sign; // 恢复符号
	}

}
