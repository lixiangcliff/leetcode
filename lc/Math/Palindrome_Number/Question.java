package Palindrome_Number;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		int a = 12033021;
		//int a = -1881;
		System.out.print(q.isPalindrome(a));
		//System.out.print((a));

	}
	
	/**
	 * https://oj.leetcode.com/problems/palindrome-number/
	 * Determine whether an integer is a palindrome. Do this without extra
	 * space.
	 * 
	 * click to show spoilers.
	 * Some hints: Could negative integers be palindromes? (ie, -1)
	 * If you are thinking of converting the integer to string, note the
	 * restriction of using extra space.
	 * You could also try reversing an integer. However, if you have solved the
	 * problem "Reverse Integer", you know that the reversed integer might
	 * overflow. How would you handle such case?
	 * There is a more generic way of solving this problem.
	 */
    
	//http://blog.csdn.net/linhuanmars/article/details/21145231
	//思想：每次取第一位和最后一位，如果不相同则返回false，否则继续直到位数为0
    public boolean isPalindrome(int x) {   
		if (x < 0){
			return false;
		}
		int div = 1; // div表示跟x位数相同的10的正整数次幂（目的是为了x / div时可以得到x的最高位数值）
		while (div <= x / 10) { //【注】，此处一定要用除法，以防越界。
			div *= 10;
		}
		while (x > 0) {
			if (x / div != x % 10) {
				return false;
			}
			x = ( x % div ) / 10; // 【注】技巧: “x % div” 去掉了x的首位，再 “/10”又去掉了末位
			div /= 100; // x被减少了2位，所以div也要相应减少2位
		}
		return true;
	}

}
