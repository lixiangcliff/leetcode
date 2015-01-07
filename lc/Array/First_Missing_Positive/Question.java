package First_Missing_Positive;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A =  {3,4,4,4,-1,1};
		Question q = new Question();
		//int[] A =  {3,4,-1,1};
		System.out.println(q.firstMissingPositive(A));
	}
	

	/**
	 * https://oj.leetcode.com/problems/first-missing-positive/ 
	 * Given an unsorted integer array, find the first missing positive integer. 
	 * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
	 * 
	 * Your algorithm should run in O(n) time and uses constant space.
	 */
	
	//目标是使: A[0] == 1, A[1] == 2...
	//中心思想：遍历array，通过swap让A[i]的值为i + 1(即把值A[i]放到i - 1的index上)；第二次遍历时哪个A[i] != i + 1 即是缺失的第一个正数
	//下面重点说如何swap
	//http://blog.csdn.net/linhuanmars/article/details/20884585
	//http://www.cnblogs.com/yuzhangcmu/p/4200096.html (【注】图例)
    public int firstMissingPositive(int[] A) {
    	if (A == null || A.length == 0){
    		return 1; // 返回的一定是正数
    	}
		for (int i = 0; i < A.length; i++) {
    		 //我们针对数组中每一位做处理（swap），直到这位彻底处理完（或者已经不满足swap条件）了才再往右挪一位
    		 //处理每位时，只有同时满足以下三种情况才做swap，否则就算处理完了这一位，可以向右挪了
    		 //1.A[i] > 0(负数或0不处理)
    		 //2.A[i] <= A.length(即A[i]的值要在A的长度range内，如果A[i] > A.length，则此A[i]值不能在数组中找到可以达到我们“目标”的index，可跳过之)
    		 //3.A[i] != A[A[i] - 1]（否则swap过来一个一样的数，会陷入死循环 ）
			while (A[i] > 0 && A[i] <= A.length && A[i] != A[A[i] - 1]) { // 处理完当前i，才跳出循环继续向右边处理
				swap(A, i, A[i] - 1);
				//下面的写法在input是[2,1]时会死循环，原因是(1)和(3)中的A[i]已经不同了（由于(2)的操作）。【注】所以一定要单独写swap方法。让其中的l和r来handle。
				//int tmp = A[i]; //(1)
				//A[i] = A[A[i] - 1]; //(2)
				//A[A[i] - 1] = tmp; //(3)
			}
		}
		for (int i = 0; i < A.length; i++) {
			if (A[i] != i + 1) {
				return i + 1;
			}
		}
    	//如果code能执行到这里，说明A[0] == 1, A[1] == 2 ...A[A.length-1] = A.length,所以下一个正数就是A.length+1
    	return A.length + 1; 
    }
    
    private void swap(int[] A, int l, int r) {
        int tmp = A[l];
        A[l] = A[r];
        A[r] = tmp;
    }

}
