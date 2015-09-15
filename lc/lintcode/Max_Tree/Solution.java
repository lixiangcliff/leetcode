package Max_Tree;

import java.util.LinkedList;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] A = {2, 5, 6, 0, 3, 1};
		TreeNode root = s.maxTree(A);
		System.out.println(root.val);
	}
	
	/**
	 * http://lintcode.com/en/problem/max-tree/
	 * Given an integer array with no duplicates. A max tree building on this
	 * array is defined as follow: The root is the maximum number in the array
	 * The left subtree and right subtree are the max trees of the subarray
	 * divided by the root number. Construct the max tree by the given array.
	 * 
	 * Example 
	 * Given [2, 5, 6, 0, 3, 1], the max tree is 
	 * 		6 
	 * 	   / \ 
	 *    5   3 
	 *   /   / \ 
	 *  2   0   1
	 */
	
	//Using stack
	//类似Largest rectangle in histogram
	//对每个元素，找到左边和右边第一个比它大的，以其中较小的那个作为它的根（通过画图举例可以证明之）。自底向上建立树
	//以下为ma老师答案
	public TreeNode maxTree(int[] A) {
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>(); //从栈顶到栈底是升序的
		for (int i = 0; i <= A.length; i++) {
			TreeNode rightNode = i == A.length ? new TreeNode(Integer.MAX_VALUE) : new TreeNode(A[i]); // 表示当前node右边，第一个比它值大的node
			while (!stack.isEmpty()) {
				if (rightNode.val > stack.peek().val) {
					TreeNode childNode = stack.pop();
					if (stack.isEmpty()) { // 【这里1】如果childNode已经是stack里剩下的唯一node，则向上接右边比它大的那个（原因可以想象成此时左边是极大值）
						rightNode.left = childNode;
					} else {
						//基本思想是childNode向上接上左边和右边值较小的那一个
						TreeNode leftNode = stack.peek(); // 表示当前node左边，第一个比它值大的node
						if (leftNode.val > rightNode.val) {
							rightNode.left = childNode;
						} else {
							leftNode.right = childNode;
						}
					}
				} else {
					break;
				}
			}
			stack.push(rightNode); // 【这里2】
		}
		// 此时stack里装的唯一node：是极大值的node。（可以将其理解为dummy node，它的left为最终真正的root）原因为上面的【这里2】。
		// 而最终真正的root之所以为dummy node的左子树，原因为上面的【这里1】
		return stack.peek().left; 
	}
	
	// Divide and conquer
	//14 / 16 test cases passed in lintcode.
	//如果testcase是升序的，则会导致时间复杂度为O(n^2)
    public TreeNode maxTreeDivideAndConquer(int[] A) {
    	if (A == null || A.length == 0) {
    		return null;
    	}
    	return helper(A, 0, A.length - 1);
    }
    
    TreeNode helper(int[] A, int start, int end) {
    	if (start > end) { // 勿忘结束条件，否则会栈溢出
    		return null;
    	}
    	int max = A[start];
    	int maxIndex = start;
    	for (int i = start; i <= end; i++) {
    		if (A[i] > max) {
    			max = A[i];
    			maxIndex = i; //one pass找到值最大的index
    		}
    	}
    	TreeNode root = new TreeNode(max);
    	root.left = helper(A, start, maxIndex - 1);
    	root.right = helper(A, maxIndex + 1, end);
    	return root;
    }
}

class TreeNode {
     public int val;
     public TreeNode left, right;
     public TreeNode(int val) {
         this.val = val;
         this.left = this.right = null;
     }
 }
