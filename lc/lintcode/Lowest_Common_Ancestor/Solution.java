package Lowest_Common_Ancestor;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		TreeNode n4 = new TreeNode(4);
		TreeNode n3 = new TreeNode(3);
		TreeNode n7 = new TreeNode(7);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		n4.left = n3;
		n4.right = n7;
		n7.left = n5;
		n5.left = n6;
		System.out.println(s.lowestCommonAncestor(n4, n3, n6).val);
		
	}
	
    /**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
	/*
	 * 
	 * Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
		The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
		Example
		        4
		       /  \
		      3    7
		          / \
		        5    6
		
		For 3 and 5, the LCA is 4.
		For 5 and 6, the LCA is 7.
		For 6 and 7, the LCA is 7.
	 */
	
	//http://blog.csdn.net/v_july_v/article/details/18312089
	//返回值即为最小公共祖先
	//【注】返回值为四种情况之一： 
	//(1)A和B的LCA (2)A (3)B (4)null
	//【注】返回值定义：如果找到AB的LCA的node，则返回该node；如果遇到A或B，则返回A或B；若前两者都没遇到，则返回null
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
    	if (root == null || root == A || root == B) { // base case。root已经 为null或者碰到了A，B其中某一个点
    		return root;
    	}
    	//divide
    	TreeNode left = lowestCommonAncestor(root.left, A, B);
    	TreeNode right = lowestCommonAncestor(root.right, A, B);
    	//conquer
    	if (left != null && right != null) { //【注】说明left和right分别遇到的是A和B(或者B和A)，则root即为LCA
    		return root;
    	}
    	if (left != null) { //即AB都在左子树（即right == null）
    		return left;
    	}
    	if (right != null) { //即AB都在右子树（即left == null）
    		return right;
    	} 
    	return null; // 两个子树都没有 A和B的LCA，则返回null
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
