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
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
	
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	if (root == null) {
    		return result;
    	}
    	helper(result, root, k1, k2);
    	return result;
    }
    
    //返回升序，所以需要中序遍历tree
    private void helper (ArrayList<Integer> result, TreeNode root, int k1, int k2) {
    	if (root == null) {
    		return;
    	}
    	if (root.val > k1) {//只要root.val > k1 说明左子树里肯定还有符合的node，就递归给左子树
    		helper(result, root.left, k1, k2);
    	}
    	if (k1 <= root.val && root.val <= k2) {
    		result.add(root.val);
    	}
    	if (root.val < k2) {
    		helper(result, root.right, k1, k2);
    	}
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
