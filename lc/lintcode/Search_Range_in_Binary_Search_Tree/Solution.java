package Search_Range_in_Binary_Search_Tree;

import java.util.ArrayList;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree. Find all the keys of tree in range k1 to k2. i.e. print all x such that k1<=x<=k2 and x is a key of given BST. Return all the keys in ascending order.
		Example
		For example, if k1 = 10 and k2 = 22, then your function should print 12, 20 and 22.
		         20
		        /  \
		       8   22
		      / \
		     4  12
	 */
	
	public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		helper(result, root, k1, k2);
		return result;
	}

	// 返回升序，所以需要中序遍历tree
	private void helper(ArrayList<Integer> result, TreeNode root, int k1, int k2) {
		if (root == null) {
			return;
		}
		if (root.val > k1) { // 【左】 只要当root.val > k1 说明左子树里肯定还有符合的node，就递归给左子树
			helper(result, root.left, k1, k2);
		}
		if (k1 <= root.val && root.val <= k2) { // 【根】添加根到result
			result.add(root.val);
		}
		if (root.val < k2) { // 【右】
			helper(result, root.right, k1, k2);
		}
	}
    
    //divide and conquer
    public ArrayList<Integer> searchRange2(TreeNode root, int k1, int k2) {
       ArrayList<Integer> res = new ArrayList<Integer>();
       ArrayList<Integer> left = new ArrayList<Integer>();
       ArrayList<Integer> right = new ArrayList<Integer>();
       if (root == null) {
           return res;
       }
       //divide 
       if (root.val > k1) { // 【注】小优化，如果当前根值已经小于k1，则左子树中的node都不满足，则left直接为空
           left = searchRange(root.left, k1, k2);
       }
       if (root.val < k2) {
           right = searchRange(root.right, k1, k2);
       }
       //conquer
       res.addAll(left);//【左】
       if (root.val >= k1 && root.val <= k2) { //【根】
           res.add(root.val);
       }
       res.addAll(right); //【右】
       return res;
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
