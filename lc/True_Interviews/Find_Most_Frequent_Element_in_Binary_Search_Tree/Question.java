package Find_Most_Frequent_Element_in_Binary_Search_Tree;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 			3(1)
		 * 		  /   \
		 * 		2(1)   3(3)
		 * 	  /  \     /   \
		 *  1   2(2)  3(2)  4 
		 */ 
		Question q = new Question();
		// TODO Auto-generated method stub
		TreeNode t11 = new TreeNode(1);
		TreeNode t21 = new TreeNode(2);
		TreeNode t22 = new TreeNode(2);
		TreeNode t31 = new TreeNode(3);
		TreeNode t32 = new TreeNode(3);
		TreeNode t33 = new TreeNode(3);
		TreeNode t41 = new TreeNode(4);
		t21.left = t11;
		t21.right = t22;
		t31.left = t21;
		t31.right = t33;
		t33.left = t32;
		t33.right = t41;
		System.out.println(q.findMostFrequentInBST(t31));
		

	}
	
	/**
	 * http://www.glassdoor.com/Interview/Given-a-binary-search-tree-where-there-may-contain-duplicates-but-all-other-logic-of-the-BST-is-intact-determine-the-most-QTN_886548.htm
	 * Given a binary search tree where there may contain   duplicates, 
	 * but all other logic of the BST is intact, determine the most frequently occurring element
	 */
	
	//discuss with Zhe whether it is eligible doing it within one single traverse ???
	public int findMostFrequentInBST(TreeNode root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		ArrayList<Integer> elements = new ArrayList<Integer>();
		helper(root, elements);
		if (elements.size() == 1) {
			return elements.get(0);
		}
		int res = elements.get(0);
		int maxCnt = 1;
		int curCnt = 1;
		for (int i = 1; i < elements.size(); i++) {
			if (elements.get(i) != elements.get(i - 1)) {
				if (curCnt > maxCnt) {
					res = elements.get(i - 1);
					maxCnt = curCnt;
				}
				curCnt = 0;
			} else {
				curCnt++;
			}
		}
		return res;
	}
	
	private void helper(TreeNode root, ArrayList<Integer> elements) {
		if (root == null) {
			return;
		}
		helper(root.left, elements);
		elements.add(root.val);
		helper(root.right, elements);
	}
	
	
	//inorder traverser
/*	public int findMostFrequentInBST(TreeNode root) {
		int[] val = new int[1];
		int[] curCnt = new int[1];
		int[] res = new int[1];
		int[] resCnt = new int[1];
		helper(root, val, curCnt, res, resCnt);
		return res[0];
	}*/
	
	//inorder
/*	private void helper(TreeNode root, int[] val, int[] curCnt, int[] res, int[] resCnt) {
		if (root == null) {
			return;
		}
		helper(root.left, val, curCnt, res, resCnt);
		if (root.val != val[0]) {
			if (curCnt[0] > resCnt[0]) {
				resCnt[0] = curCnt[0];
				res[0] = val[0];
			} 
			val[0] = root.val;
			curCnt[0] = 0;
		} else {
			curCnt[0]++;
		}
		helper(root.right, val, curCnt, res, resCnt);
	}*/

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
