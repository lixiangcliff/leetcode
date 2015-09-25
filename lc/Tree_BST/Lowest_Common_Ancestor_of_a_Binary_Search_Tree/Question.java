package Lowest_Common_Ancestor_of_a_Binary_Search_Tree;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t6 = new TreeNode(6);
		TreeNode t2 = new TreeNode(2);
		TreeNode t4 = new TreeNode(4);
		TreeNode t3 = new TreeNode(3);
		TreeNode t5 = new TreeNode(5);
		TreeNode t1 = new TreeNode(1);
		TreeNode t50 = new TreeNode(50);
		TreeNode t100 = new TreeNode(100);
		t6.left = t2;
		t2.right =t4;
		t4.left = t3;
		t4.right = t5;
		Question q = new Question();
		//System.out.println(q.lowestCommonAncestor(t6, t50, t100));
		System.out.println(q.lowestCommonAncestor(t6, t1, t100).val);
	}
	
	/**
	 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
	 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
		According to the definition of LCA on Wikipedia: 
		“The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants 
		(where we allow a node to be a descendant of itself).”
		
		        _______6______
		       /              \
		    ___2__          ___8__
		   /      \        /      \
		   0      _4       7       9
		         /  \
		         3   5
		For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. 
		Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
	 */

	//【注】怀疑是不是要先判断p和q在不在root所形成的BST里，如果不在应该直接返回null？
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
        	return null;
        }
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        while (root != null) {
        	if (min <= root.val && root.val <= max) {
        		return root;
        	} else if (root.val < min) {
        		root = root.right;
        	} else {
        		root = root.left;
        	}
        }
        return null;
    }
	
	//other's solution for testing: https://leetcode.com/discuss/44959/3-lines-with-o-1-space-1-liners-alternatives
/*	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	    while ((root.val - p.val) * (root.val - q.val) > 0)
	        root = p.val < root.val ? root.left : root.right;
	    return root;
	}*/
}


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}