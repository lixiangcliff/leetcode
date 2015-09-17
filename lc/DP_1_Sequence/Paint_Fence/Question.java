package Paint_Fence;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		int n = 15;
		int k = 4;
		System.out.println(q.numWays(n, k));
	}
	
	/**
	 * There is a fence with n posts, each post can be painted with one of the k colors.
	 * You have to paint all the posts such that no more than two adjacent fence posts have the same color.
	 * Return the total number of ways you can paint the fence.
	 * 
	 * Note:
	 * n and k are non-negative integers.
	 */
	
	//https://aquahillcf.wordpress.com/2015/09/06/leetcode-paint-fence/
	public int numWays(int n, int k) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return k;
		}
		int same = k;
		int diff = k * (k - 1);
		for (int i = 3; i <= n; i++) {
			int tmp = same;
			same = diff;
			diff = (diff + tmp) * (k - 1);
		}
		return same + diff;
	}
}
