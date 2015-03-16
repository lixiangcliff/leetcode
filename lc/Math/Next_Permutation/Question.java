package Next_Permutation;

import java.util.Arrays;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		int[] num = {2,3,6,5,4,1};
		q.nextPermutation(num);
		for(int i=0;i<num.length;i++){
			System.out.print(num[i] + ",");
		}
	}
	
	/**
	 * https://oj.leetcode.com/problems/next-permutation/
	 * Implement next permutation, which rearranges numbers into the
	 * lexicographically next greater permutation of numbers.
	 * 
	 * If such arrangement is not possible, it must rearrange it as the lowest
	 * possible order (ie, sorted in ascending order).
	 * 
	 * The replacement must be in-place, do not allocate extra memory.
	 * 
	 * Here are some examples. Inputs are in the left-hand column and its
	 * corresponding outputs are in the right-hand column. 
	 * 1,2,3 → 1,3,2 
	 * 3,2,1 → 1,2,3 
	 * 1,1,5 → 1,5,1
	 */
	
	//思想，两大情况：1. num已经为降序，2. num不为降序
	//1.是降序，则要做的操作就是变为升序
	//2.不是降序，则
	//1).从右往左找到第一个下降的位置i, 
	//2).再从右往左找到第一个比num[i]值大的位置j
	//3).交换i，j位置上的数
	//4).升序排列num中从i + 1到末位
	//http://www.ninechapter.com/solutions/next-permutation/
	//http://blog.csdn.net/linhuanmars/article/details/20434115
	public void nextPermutation(int[] num) {
		if (num == null || num.length <= 1) {
			return;
		}
		int len = num.length;
		for (int i = len - 2; i >= 0; i--) {
			if (num[i + 1] > num[i]) { // 找到i是从右往左看第一个下降的数
				for (int j = len - 1; j > i; j--) {
                    if (num[j] > num[i]) {
        				int temp = num[i];
        				num[i] = num[j];
        				num[j] = temp;
        				Arrays.sort(num, i + 1, len); // 把num中从第i + 1位到末位升序排列
        				return;
                    }
                }
			}
		}
		Arrays.sort(num); // 如果能走到这一步，说明num原来是降序的，现在把它再升序排列下就行了。
		return;
	}
}
