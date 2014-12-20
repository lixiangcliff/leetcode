package Gray_Code;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		ArrayList<Integer> result = q.grayCode(1);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(Integer.toBinaryString(result.get(i)));
		}
	}
	
	/**
	 * https://oj.leetcode.com/problems/gray-code/
	 * The gray code is a binary numeral system where two successive values
	 * differ in only one bit.
	 * Given a non-negative integer n representing the total number of bits in
	 * the code, print the sequence of gray code. A gray code sequence must
	 * begin with 0.
	 * 
	 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
	 * 00 - 0 
	 * 01 - 1 
	 * 11 - 3 
	 * 10 - 2 
	 * 
	 * Note: For a given n, a gray code sequence is
	 * not uniquely defined.
	 * For example, [0,2,3,1] is also a valid gray code sequence according to
	 * the above definition.
	 * For now, the judge is able to judge based on one instance of gray code
	 * sequence. Sorry about that.
	 */
	//http://fisherlei.blogspot.com/2012/12/leetcode-gray-code.html
	//http://blog.csdn.net/linhuanmars/article/details/24511221
    public ArrayList<Integer> grayCode(int n) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	if (n < 0) {
    		return result;
    	}
		result.add(0); // 如果n为0，则跳过下面的循环直接返回结果集为{0}。
		for (int i = 1; i <= n; i++) {
			int size = result.size();
			int highBit = 1 << i - 1;
			//把当前结果集中的数，按倒序的方式在前面加1，然后存入结果集
			for (int j = size - 1; j >= 0; j--) {
				result.add(highBit + result.get(j));
			}
		}
    	return result;
    }
}
