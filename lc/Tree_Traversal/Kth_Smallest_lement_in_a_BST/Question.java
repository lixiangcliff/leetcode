package Kth_Smallest_lement_in_a_BST;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		TreeNode t1 = new TreeNode(2);
		TreeNode t2 = new TreeNode(1);
		t1.left = t2;
		int k = 1;
		System.out.println(q.kthSmallest(t1, k));
	}
	
	/**
	 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
	 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
	 * Note: 
	 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
	 * Follow up:
	 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? 
	 * How would you optimize the kthSmallest routine?
	 */
	
	//bst in order traversal is ascending order
    public int kthSmallest(TreeNode root, int k) {
    	int[] count = {1};
    	int[] res = {0};
    	inorder(root, count, res, k);
        return res[0];
    }
    
    private void inorder(TreeNode root, int[] count, int[] res, int k) {
    	if (root == null) {
    		return;
    	}
    	if (count[0] > k) {
    		return;
    	}
    	inorder(root.left, count, res, k);
    	if (count[0] == k) {
    		res[0] = root.val;
    		count[0]++;
    		return;
    	}
    	count[0]++;
    	inorder(root.right, count, res, k);
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
