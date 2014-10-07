package Convert_Sorted_Array_to_Binary_Search_Tree;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,2,3,4,5,6,7,8,9};
		

	}
	//http://answer.ninechapter.com/solutions/convert-sorted-array-to-binary-search-tree/
	public TreeNode sortedArrayToBST(int[] num) {
		if(num ==null){
			return null;
		}
		return buildTree(num, 0, num.length-1);
    }
	
	private TreeNode buildTree(int[] num, int start, int end) {
		if(start > end){
			return null;
		}
		TreeNode node = new TreeNode(num[(start+end)/2]);
		node.left = buildTree(num, start, (start+end)/2-1);
		node.right = buildTree(num, (start+end)/2+1,end);
		return node;
	}
}

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
