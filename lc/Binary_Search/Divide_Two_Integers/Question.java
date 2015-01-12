package Divide_Two_Integers;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		System.out.println(q.divide(-2147483648, -1));
		//System.out.println(Integer.MIN_VALUE);
		//System.out.println(Math.abs((long)Integer.MIN_VALUE));
		//System.out.println((long)Math.abs(Integer.MIN_VALUE));

		
	}
	
	/**
	 * https://oj.leetcode.com/problems/divide-two-integers/ 
	 * Divide two integers  without using multiplication, division and mod operator.
	 * If it is overflow, return MAX_INT.
	 */
	
	//http://www.cnblogs.com/yuzhangcmu/p/4049170.html
	//http://blog.csdn.net/linhuanmars/article/details/20024907
	public int divide(int dividend, int divisor) {
		long a = Math.abs((long)dividend); // 【注】在这里必须先取long再abs，否则int的最小值abs后也是原值
		long b = Math.abs((long)divisor);
		long result = 0; // result不能用int 否则当输入为(-2147483648, -1)时，result += count累加到最后一次时会溢出。（result初值为0，因为不确定被除数是否比除数绝对值大）
		long deduct = b;
		long count = 1; // count也要用long 道理同result
		while (a >= deduct << 1) { // 找到<=a的最大的，b的2的n次幂倍数的数
			deduct <<= 1;
			count <<= 1;
		}
		while (deduct >= b && a > 0) { // 从被除数中减去除数，并成倍的减小除数，同时累加一共减去过多少个除数（当deduct == b时，做最后 的一次除法）
			if (a >= deduct) { // 只要当前被除数里还含有一个除数，就把当前被除数里有多少个除数(count)累加至result中
				a -= deduct;
				result += count;
			}
			count >>= 1;
			deduct >>= 1;
		} 
		result = (((dividend ^ divisor) >> 31) & 1) == 1 ? -result : result; // 通过判断dividend和divisor符号位是否相同，来判断商的正负
		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
			return Integer.MAX_VALUE;
		}
		return (int)result;
	}
}
