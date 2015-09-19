package Perfect_Squares;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		int n = 25;
		for (int i = 1; i <= n; i++) {
			System.out.println("value: " + i + "; count:" + q.numSquares(i));
		}
	}
	
	/**
	 * https://leetcode.com/problems/perfect-squares/
	 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
	 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
	 */
	
	/**
	 * http://www.1point3acres.com/bbs/thread-109586-1-1.html
	 * 找出一个数由最少几个平方的和的组成
		例子：
		input： 14    output:  9 ,4 , 1  return 3 (虽然也能由1 +1 +....+1组成 但长度是14 不是最优解)
		input:   50     ouput :  25, 25 return 2
	 */
	
	//f[i]表示值为i的数字最少需要用几个square number来表示
	public int numSquares(int n) {
		int[] f = new int[n + 1];
		f[1] = 1;
		for (int i = 2; i <= n; i++) {
			int min = i; // min表示i之前的数(设为k)，和i差值为square number的最小f[k]值
			for (int j = 1; j <= i / j; i++) { //尝试所有pre + j^2可以使得i为square sum的可行组合
				min = Math.min(min, f[i - j * j]);
			}
			f[i] = min + 1;
		}
		return f[n];
	}

}
