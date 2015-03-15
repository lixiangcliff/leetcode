package Single_Number;

public class SingleNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = {1,2,3,4,12,-5, -1657, 13,12,6,2, -1657, -5673,3,1,4,6,13, -5, 0 , 0, -5673, -32768};
		SingleNumber s = new SingleNumber();
		System.out.println(s.singleNumber(A));
	}
	
	/**
	 * https://oj.leetcode.com/problems/single-number/ 
	 * Given an array of integers, every element appears twice except for one.
	 * Find that single one.
	 * Note: Your algorithm should have a linear runtime complexity. Could you
	 * implement it without using extra memory?
	 */
	
    //通用做法
	public int singleNumber(int[] A) {
		if (A == null || A.length == 0) {
			return -1;
		}
		int result = 0;
		int[] bits = new int[32];
		for (int i = 0; i < 32; i++) { // 对每一个bit遍历所有元素，累积所有元素对这一位造成的加和
			for (int j = 0; j < A.length; j++) {
				bits[i] += (A[j] >> i) & 1; //【注】(A[j] >> i)表示A[j]从右往左“砍掉”i位；“& 1”表示取末位的值
			}
			bits[i] %= 2; // 累积完所有元素对这一位的加和之后，结果可能大于2，所以要% 2。
			result += (bits[i] << i); // 处理完这一位，把最后的“加和”左移对应的位数，加到result中
		}
		return result;
	}
	
	//取巧做法
	//O(1) 空间复杂度
	//应用性质:
	//1. a ^ 0 == a
	//2. a ^ a == 0
	//3. (a ^ b) ^ c == a ^ (b ^ c)
	public int singleNumber2(int[] A) {
        if (A == null || A.length == 0) {
            return Integer.MAX_VALUE;
        }
		int result = 0;
		for (int i : A) {
			result ^= i;
		}
		return result;
	}
	    


}

   