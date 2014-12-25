package Single_Number_II;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {1, 6,2,3,2,1,3,6,1,2,3,7,6};
		Question q = new Question();
		System.out.println(q.singleNumber(A));

	}
	
	/**
	 * https://oj.leetcode.com/problems/single-number-ii/
	 * Given an array of integers, every element appears three times except for
	 * one. Find that single one.
	 * Note: Your algorithm should have a linear runtime complexity. Could you
	 * implement it without using extra memory?
	 */
	//http://answer.ninechapter.com/solutions/single-number-ii/
	//http://blog.csdn.net/linhuanmars/article/details/22645599
	//"如果每个元素重复出现三次，那么每一位出现1的次数也会是3的倍数，如果我们统计完对每一位进行取余3，那么结果中就只剩下那个出现一次的元素。"
	public int singleNumber(int[] A) {
		if (A == null || A.length == 0) {
			return -1;
		}
		int result = 0;
		int[] bits = new int[32];
		for (int i = 0; i < 32; i++) { // 对每一个bit遍历所有元素，累积所有元素对这一位造成的加和
			for (int j = 0; j < A.length; j++) {
				bits[i] += (A[j] >> i) & 1; //【注】(A[j] >> i)表示A[j]从右往左“砍掉”i位；“& 1”表示取末位的值
				bits[i] %= 3; // 累积完A[j]对这一位的加和之后，结果可能大于3，所以要% 3。
			}
			result += (bits[i] << i); // 处理完这一位，把最后的“加和”左移对应的位数，加到result中
		}
		return result;
	}
}
