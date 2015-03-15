package Recover_Binary_Search_Tree;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Question q = new Question();
		// TODO Auto-generated method stub
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		t4.left = t2;
		t4.right = t6;
		t2.left = t5;
		t2.right = t3;
		t6.left = t1;
		t6.right = t7;
		q.inorder(t4);
		System.out.println("");
		q.recoverTree(t4);
		q.inorder(t4);
		System.out.println("");
		

	}
	
	/**
	 * https://oj.leetcode.com/problems/recover-binary-search-tree/
	 * Two elements of a binary search tree (BST) are swapped by mistake.
	 * Recover the tree without changing its structure.
	 * 
	 * Note: A solution using O(n) space is pretty straight forward. Could you
	 * devise a constant space solution?
	 */
	//思想：BST中两个元素交换位置后，再做中序遍历时会产生两种情况:
	//1.如果是相邻的两个元素被调换了，只会出现一次逆序情况，只需要把这个两个节点记录下来最后调换值就可以；
	//2.如果是不相邻的两个元素被调换了,会发生两次逆序的情况，那么这时候需要调换的元素是第一次逆序前面的元素，和第二次逆序后面的元素。
	//情况2举例: 如1234567,1和5调换了，会得到5234167，逆序发生在52和41，我们需要把5和1调过来，那么就是52的第一个元素，41的第二个元素调换即可。
	//http://blog.csdn.net/linhuanmars/article/details/24566995
	public void recoverTree(TreeNode root) {
		if (root == null) {
			return;
		}
		ArrayList<TreeNode> swappedNodes = new ArrayList<TreeNode>(); // 里面存有待恢复的两个node
		ArrayList<TreeNode> pre = new ArrayList<TreeNode>(); // 标记以inorder遍历时当前node之前的那个node（作为一个指针在递归不同层之间传递）
		pre.add(null); // pre初始内容为null
		helper(root, pre, swappedNodes);
		if (swappedNodes.size() > 0) { // 只要找到有逆序存在
			int temp = swappedNodes.get(0).val;
			swappedNodes.get(0).val = swappedNodes.get(1).val;
			swappedNodes.get(1).val = temp;
		}
	}

	// DFS -- inorder
	private void helper(TreeNode root, ArrayList<TreeNode> pre, ArrayList<TreeNode> swappedNodes) {
		if (root == null) {
			return;
		}
		helper(root.left, pre, swappedNodes); // 递归左子树
		if (pre.get(0) != null && root.val < pre.get(0).val) { // 找到了一个逆序的node
			if (swappedNodes.size() == 0) { // 通过swappedNodes.size()的大小，知道这是第一个逆序的node
				swappedNodes.add(pre.get(0)); // swappedNodes[0]装的是第一次逆序前面的元素
				swappedNodes.add(root); // swappedNodes[1]装的是第一次逆序后面的元素
			} else { // 如果已经不是第一次逆序
				swappedNodes.set(1, root); // swappedNodes[1]更新为第二次逆序后面的元素
			}
		}
		pre.set(0, root);// update pre
		helper(root.right, pre, swappedNodes); // 递归右子树
	}
    
	//测试用（与recoverTree无关）
	public void inorder(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			inorder(root.left);
		}
		System.out.print(root.val + ",");
		if (root.right != null) {
			inorder(root.right);
		}
	}
}


 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }