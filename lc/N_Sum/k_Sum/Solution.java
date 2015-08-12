package k_Sum;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,3,4};
		int k = 2;
		int target = 5;
		Solution s = new Solution();
		System.out.println(s.kSum(A, k, target));
	}
	/**
	 * http://lintcode.com/en/problem/k-sum/
	 * Given n distinct positive integers, integer k (k <= n) and a number
	 * target.
	 * Find k numbers where sum is target. Calculate how many solutions there
	 * are?
	 * 
	 * Example 
	 * Given [1,2,3,4], k=2, target=5. There are 2 solutions:
	 * [1,4] and [2,3], return 2.
	 */
	//DP_1Seq（需要三维数组解决；但是经过优化可以变为“准二维”数组）
	//1.state: result[i][j][t]表示前i个数取j个，组成和为t的方案总数
	//2.function: 则result[i][j][t] = result[i - 1][j][t]（该方案中不取第i个数） + result[i - 1][j - 1][t - A[i]]（该方案中取第i个数）
	//3.initialize: result[0~i][0][0] = 1; （不管从前几个数中取，只要取0个，组成target为0的方案总数一定为1）
	//4.answer: result[n][k][target]
	public int kSum(int A[], int k, int target) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int len = A.length;
		int[][][] result = new int[len + 1][k + 1][target + 1];
		for (int i = 0; i <= len; i++) {
			result[i][0][0] = 1;
		}
		for (int i = 1; i <= len; i++) {
			for (int j = 1; j <= i && j <= k; j++) {
				for(int t = 1; t <= target; t++) { // 位差
					if (t >= A[i - 1]){
						result[i][j][t] = result[i - 1][j][t] + result[i - 1][j - 1][t - A[i - 1]];
					} else { //即， 如果t < A[i - 1],那A[i - 1]肯定不能取
						result[i][j][t] = result[i - 1][j][t]; 
					}
				}
			}
		}
		return result[len][k][target];
	}
    
    //answer from teacher
    public int kSumTeacher(int A[], int k, int target) {
        int[][] f = new int[k + 1][target + 1];
        f[0][0] = 1;
        for (int i = 0; i < A.length; i++) {
            for (int j = target; j >= A[i]; j--) {
                for (int select = 1; select <= k; select++) {
                    f[select][j] += f[select - 1][j - A[i]];
                }
            }
        }
        return f[k][target];
    }


}
