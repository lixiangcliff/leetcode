package Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import java.util.HashMap;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://oj.leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
	 * Given preorder and inorder traversal of a tree, construct the binary
	 * tree.
	 * 
	 * Note: You may assume that duplicates do not exist in the tree.
	 */
	
	//http://blog.csdn.net/linhuanmars/article/details/24389549
	//【注】，这道题在解答时，一定要举类似下面例子来写！这样照实例来写，效率高，准确性高。
	// 例子：preorder遍历是12453687，inorder遍历是42516837
	// 						1
	// 				2				3
	// 			4	  5			  6			7
	// 								8
    public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null || preorder.length == 0 || preorder.length != inorder.length) {
			return null;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); // <inorder的元素值，该元素值对应的InRootIdx>
		for (int i = 0; i < inorder.length; i++) { //之所以map里存inorder的info，是因为通过从preorder中拿到根的值，然后可以到inorder来找其index
			map.put(inorder[i], i);
		}
		return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
	}
    
    // preorder: 先序数组（始终不变）
    // preL: 当前要处理的先序数组的起始InRootIdx
	// preR: 当前要处理的先序数组的终止InRootIdx
	// inorder: 中序数组（始终不变）
	// inL: 当前要处理的中序数组的起始InRootIdx
	// inR: 当前要处理的中序数组的终止InRootIdx
	// map: 保存inorder的<元素value，元素InRootIdx>（始终不变）
    private TreeNode helper(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR, HashMap<Integer, Integer> map){
		if (preL > preR || inL > inR) {
			return null;
		}
    	//preL表示当前preorder[preL, preR](preorder数组从preL位到preR位)中，根所在的位置
    	//于是preorder[preL]表示当前根的值，以此值构造一个TreeNode作为root
    	TreeNode root = new TreeNode(preorder[preL]);
    	//通过该root值，到map找到inorder中对应的InRootIdx；
    	//之后根据这个InRootIdx将inorder一分为二，InRootIdx左边的就为root左子树全部元素，InRootIdx右边的就为root右子树全部元素
    	int InRootIdx = map.get(root.val); // root在inorder中所在位置
    	// 对左子树做递归，更新下一次要处理的preL，R以及inL,R
    	// 根据例子，从preorder的角度说：左子树为245，下一轮
    	// 新preL比当前右移1位，所以：新preL=preL+1；
    	// 新preR=新preL+左子树元素个数-1，而左子树元素个数=InRootIdx-inL，所以有：新preR=(preL+1)+(InRootIdx-inL)-1 = preL+InRootIdx-inL
    	// 根据例子，从inorder的角度说：左子树为425，下一轮					
    	// 新inL不变，所以：  新inL=inL；
    	// 新inR为root在inorder中所在位置左挪1个，所以：  新inR=InRootIdx-1；				
    	root.left = helper(preorder, preL + 1, preL + InRootIdx - inL, inorder, inL, InRootIdx - 1, map); //root.left为当前root左子树的根
    	// 对右子树做递归，更新下一次要处理的preL，R以及inL,R
    	// 根据例子，从preorder的角度说：右子树为3687，下一轮
    	// 新preL为处理左子树时的新preR右边1位（即用到上一行的所得值），即新右子树preL=新左子树preR+1；所以preL=preL+InRootIdx-inL+1
    	// 新preR不变，所以：  新preR=preR；
    	// 根据例子，从inorder的角度说：右子树为6837，下一轮	
    	// 新inL为root在inorder中所在位置右挪1个，所以：  新inR=InRootIdx+1；				
    	// 新inR不变，所以：  新inR=inR；
    	root.right = helper(preorder, preL + InRootIdx - inL + 1, preR, inorder, InRootIdx + 1, inR, map); //root.right为当前root右子树的根
    	return root;
    }
}

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
    TreeNode(int x) { val = x; }
 }
