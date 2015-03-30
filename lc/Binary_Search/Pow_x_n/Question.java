package Pow_x_n;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		System.out.println(q.pow(0.00001, 2147483647));
		//System.out.println(Integer.MAX_VALUE);

	}
	
	/**
	 * https://oj.leetcode.com/problems/powx-n/
	 * Implement pow(x, n).
	 */
	
	//手写
	public double pow(double x, int n) {
		if (x == 0) { // 这一步可有可无
			return 0;
		}
		if (n == 0) { // base case
			return 1;
		}
		boolean negative = n < 0 ? true : false;
		if (negative) {
			return 1 / (helper(x, -(n + 1)) * x); // MIN比MAX绝对值大1，防止取“-n”会溢出
		} else {
			return helper(x, n);
		}
	}
	
	private double helper(double x, int n) {
		if (n == 0) {
			return 1;
		}
		double half = (double) helper(x, n / 2);
		if (n % 2 == 0) {
			return half * half;
		} else {
			return half * half * x;
		}
	}
	
	//下面这样写会有大量重复计算helper(x, n / 2)，导致超时！
/*	private double helper(double x, int n) {
		if (n == 0) {
			return 1;
		}
		if (n % 2 == 0) {
			return helper(x, n / 2) * helper(x, n / 2);
		} else {
			return helper(x, n / 2) * helper(x, n / 2) * x;
		}
	}*/
	
	//http://www.cnblogs.com/yuzhangcmu/p/4174683.html
	//n < 0时，转化为n > 0的处理，要注意可能的越界的问题。(Interger.MIN_VALUE的绝对值比Interger.MAX_VALUE大1，所以Interger.MIN_VALUE取反会越界)
/*	public double pow(double x, int n) {
		if (x == 0) { // 这一步可有可无
			return 0;
		}
		if (n == 0) { // base case
			return 1;
		}
		if (n < 0) { //【注】n + 1防止越界；再取反转化为计算次方数为正的运算（即下面的二分递归）；再多乘一个x，恢复数值
			double reciprocal = pow(x, -(n + 1)) * x ;
			return 1 / reciprocal; // 取倒数，返回真实值
		}
		double result = pow(x , n / 2); // 下面是n > 0， 二分递归，再将结果相乘
		result *= result;
		if (n % 2 == 1) { // 如果有余数，则再补乘一个x
			result *= x;
		}
		return result;
	}*/
}
