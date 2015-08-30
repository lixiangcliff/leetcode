package Sqrt_x;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		System.out.println(q.mySqrt(2147395599));

	}
	
	/**
	 * https://oj.leetcode.com/problems/sqrtx/
	 * Implement int sqrt(int x). 
	 * Compute and return the square root of x.
	 */
	
	//【注】l <= sqrt(x) < (l+1),展开 即为下面的【注】
	//using BS template
	//http://www.cnblogs.com/yuzhangcmu/p/4198959.html
    public int mySqrt(int x) {
        if (x < 0) {
			return -1;
		}
		if (x <= 1) {
			return x;
		}
		int l = 1; // sqrt(x) 下界
		int r = x / 2; // sqrt(x) 上界
		while (l + 1 < r) {
			int m = l + (r - l) / 2;
			int quo = x / m;
			if (quo == m) {
				return m;
			} else if (quo < m) {
				r = m;
			} else {
				l = m;
			}
		}
		if (x / l >= l && x / (l + 1) < l + 1) { //【注】
			return l;
		} else {
			return r;
		}
    }
}
