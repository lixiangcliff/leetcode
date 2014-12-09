package Unique_Binary_Search_Trees;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		System.out.println(q.numTrees(3));

	}
	/**
	 * https://oj.leetcode.com/problems/unique-binary-search-trees/
	 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
		For example,
		Given n = 3, there are a total of 5 unique BST's.
		
		   1         3     3      2      1
		    \       /     /      / \      \
		     3     2     1      1   3      2
		    /     /       \                 \
		   2     1         2                 3
	 */
	//DP 1Seq
	//http://blog.csdn.net/linhuanmars/article/details/24761459
	//http://www.ninechapter.com/solutions/unique-binary-search-trees/
	//1.state: result[i]表示当有i个node时 一共有多少独立的BST
	//2.function: 则result[i] = result[0] * result[i - 1] + result[1] * result[i - 2] + ... + result[n - 1] * result[0]
	//（即，如果有i个node，根占用了1个node，还剩i - 1个node；可以左子树分0个，右子树分i - 1，这种情况左右子树的所有可能组合个数为：result[0] * result[i - 1]
	// 同理，还可以左子树分1个，右子树分i - 2个，这种情况左右子树的所有可能组合个数为：result[1] * result[i - 2]；etc，把这些所有可能加和起来就可以得到result[i]了）
	//3.initialize: result[0] = 1; result[1] = 1
	//4.answer: result[n]
	public int numTrees(int n) {
		if (n < 0) {
			return Integer.MIN_VALUE;
		}
		if (n == 0) {
			return 1;
		}
		int[] result = new int[n + 1];
		result[0] = 1;
		result[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= i - 1; j++) {
				result[i] += result[j] * result[i - 1 - j];
			}
		}
		return result[n];
	}
}
